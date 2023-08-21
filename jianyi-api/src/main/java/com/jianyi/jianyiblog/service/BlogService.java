package com.jianyi.jianyiblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jianyi.auth.TokenInfo;
import com.jianyi.auth.entity.SysUser;
import com.jianyi.auth.entity.SysUserEntity;
import com.jianyi.jianyiblog.common.AjaxResult;
import com.jianyi.jianyiblog.common.utils.FileUploadUtils;
import com.jianyi.jianyiblog.entity.*;
import com.jianyi.jianyiblog.entity.dto.BlogDto;
import com.jianyi.jianyiblog.entity.dto.CategoryDto;
import com.jianyi.jianyiblog.mapper.BlogCategoryMapper;
import com.jianyi.jianyiblog.mapper.BlogMapper;
import com.jianyi.jianyiblog.mapper.BlogStartMapper;
import com.jianyi.utils.AuthUtils;
import com.jianyi.utils.JWTUtils;
import com.jianyi.utils.ServletUtils;
import com.jianyi.utils.page.PageUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BlogService {
   @Value("${file.upload-path}")
   private  String path;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private BlogCategoryMapper blogCategoryMapper;

    @Resource
    private BlogLookService blogLookService;

    @Resource
    private BlogStartMapper blogStartMapper;

    /**
     * 获取首页六条热度数据
     * @return
     */
    public AjaxResult getHotSix(){

       return AjaxResult.success(blogMapper.selectHotSix());
    }

    public List<Blog> blogList(){
        BlogExample example = new BlogExample();
        return  blogMapper.selectByExample(example);
    }

    /**
     * 根据条件查询
     * @return
     */
    public AjaxResult list(Blog blog,int goPage,int pageSize){
        if (ObjectUtils.isNotEmpty(blog.getCates())){
            blog.setCates(blog.getCates()+",");
        }
        Page<Object> pag =new Page<>();
        pag =  PageHelper.startPage(goPage,pageSize);
        List<Blog> list = blogMapper.selectByBlog(blog);
        return AjaxResult.success(PageUtils.setPageInfo(pag,list));
    }

    /**
     * 根据id查询单条 预览方法
     * @return
     */
    public AjaxResult getOne(Blog blog) throws ParseException {
            if (blog.getBlogId() != null && blog.getBlogId() > 0){
                BlogDto blog1 = blogMapper.selectByPrimaryKey(blog.getBlogId());
                //添加预览数据
                    if (AuthUtils.getUser() != null){
                        String now  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
                        BlogLook blogLook = new BlogLook(AuthUtils.getUser().getUserId(),blog1.getBlogId(),now);
                        blogLookService.insert(blogLook);
                        blogMapper.updateAddblogBrowsingNum(1,blog1.getBlogId());
                    }else {
                        blogMapper.updateAddblogBrowsingNum(1,blog1.getBlogId());
                    }

                //获取文章的所有标签
                List<CategoryDto> categoryDtoList =  blogCategoryMapper.selectByIds(blog1.getCates());
                blog1.setCategoryList(categoryDtoList);
                return AjaxResult.success(blog1);
            }else {
                return AjaxResult.error("未传入文章id，或该文章已经被删除。");
            }
    }

    /**
     *  获取文章的统计数据
     * @return
     */
    public AjaxResult getBlogStatisticalData(Blog blog) throws ParseException {
            if (blog.getBlogId() != null){
                BlogDto blogDto = blogMapper.selectblogNumByPrimaryKey(blog.getBlogId());
                try {
                    String token  = ServletUtils.getToken();
                    if (StringUtils.isNotEmpty(token)){
                        TokenInfo info = JWTUtils.tokenInfoByToken(ServletUtils.getToken());
                        //查询是否存在点赞
                        BlogStartExample startExample = new BlogStartExample();
                        BlogStartExample.Criteria criteria =startExample.createCriteria();
                        criteria.andUserIdEqualTo(info.getUserId())
                                .andBlogIdEqualTo(Long.valueOf(blog.getBlogId()));
                        long num  = blogStartMapper.countByExample(startExample);
                        if (num > 0){
                            blogDto.setCheckStart("startOK");
                        }
                    }

                }catch (Exception e){
                    System.out.println(e);
                }

                return AjaxResult.success(blogDto);
            }else {
                return AjaxResult.error("未传入文章id，或该文章已经被删除。");
            }


    }
    /**
     * 新增
     * @return
     */
    public AjaxResult save(Blog blog){
        String now  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        //新增
        if (ObjectUtils.isNotEmpty(blog.getCheckCateList())){
            StringBuilder builder = new StringBuilder();
            StringBuilder pidStr = new StringBuilder();
            for (BlogCategory blogCategory :blog.getCheckCateList()){
                if (blogCategory.getCategoryPid() != 0 && !pidStr.toString().contains(blogCategory.getCategoryPid()+",")){
                    pidStr.append(blogCategory.getCategoryPid()).append(",");
                }
                builder.append(blogCategory.getCategoryId()).append(",");
            }
            builder.append(pidStr);
            blog.setCates(builder.toString());
        }
        if (ObjectUtils.isEmpty(blog.getBlogId())){
            blog.setBlogLike(0L);
            blog.setBlogBrowsing(0L);
            blog.setBlogComments(0L);
            blog.setCreatedBy("admin");
            blog.setUpdatedBy("admin");
            blog.setUpdatedTime(now);
            blog.setCreatedTime(now);
            int pan =  blogMapper.insertSelective(blog);
            if (pan > 0){
                return AjaxResult.success("新增成功");
            }
            return AjaxResult.error("新增失败");
        }else {
            //修改
            blog.setUpdatedTime(now);
            blog.setUpdatedBy("root");
            int pan =  blogMapper.updateByPrimaryKey(blog);
            if (pan > 0){
                return  AjaxResult.success("修改成功");
            }
            return AjaxResult.error("修改失败");
        }

    }


    /**
     * 图片
     * @return
     * @param file
     */
    public AjaxResult coverUpload(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis()+ file.getOriginalFilename();
        String filePath = path +"cover/";
        boolean pan =   FileUploadUtils.upload(fileName,filePath,file.getInputStream());
        if (pan){
            return AjaxResult.success("上传成功","cover/" + fileName);
        }
        return AjaxResult.success("上传失败");
    }


    public AjaxResult mouthHot(){
    return  AjaxResult.success(blogMapper.selectMouthBlogHot());
    }
}
