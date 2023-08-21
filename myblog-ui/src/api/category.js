import request from "./request"


//编辑器--获取一级标签
export let getfirstCate = () => {
  return request({
    url: "/blog/category/firstCate",
    method: "get"
  });
};

//编辑器--获取子集标签
export let getChildCate = ({categoryId}) => {
    return request({
      url: "/blog/category/childCate",
      method: "post",
      data:{
        categoryId,
      }
    });
  };

//编辑器--新增博客
export let addBlog = ({blogTitle,blogAbstract,blogContent,blogCover,checkCateList}) => {
    return request({
      url: "/blog/save",
      method: "post",
      data:{
        blogTitle,
        blogAbstract,
        blogContent,
        blogCover,
        checkCateList,
      }
    });
  };
  //编辑器--图片上传
export let imgupload = ({mf}) => {
    return request({
      url: "/blog/cover/upload",
      method: "post",
      headers: {
        "Content-Type":
          "multipart/form-data; boundary=----WebKitFormBoundaryn8D9asOnAnEU4Js0",
      },
      data:mf,
    });
  };