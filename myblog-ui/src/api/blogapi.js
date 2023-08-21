import request from "./request"


//博客板块 --获取单个信息
export let getOneBlog = ({blogId}) => {
  return request({
    url: "/blog/getOne",
    method: "post",
    data:{
      blogId
    }
  });
};

export let getOneblogNum = ({blogId}) => {
  return request({
    url: "/blog/getOneNum",
    method: "post",
    data:{
      blogId
    }
  });
};

//博客板块 --获取单个基本信息
export let getBasicBy = ({username}) => {
  return request({
    url: "/user/getUser",
    method: "post",
    data:{
      username
    }
  });
};






//博客板块 --当页列表
export let blogListApi = (pageSize) => {
    return request({
      url: "/blog/list/1/"+pageSize,
      method: "post",
      data:{}
    });
};



//博客列表  通过点击分组查询
export let blogBycategory = ({cates,pageSize}) => {
  return request({
    url: "/blog/list/1/"+pageSize,
    method: "post",
    data:{
      cates
    }
  });
};



//标签板块接口

export let FirstcategoryList = () => {
    return request({
      url: "/blog/category/firstCate",
      method: "get"
    });
};
//标签  通过上级id 获取子集
export let categoryListByPid = ({categoryId}) => {
  return request({
    url: "/blog/category/childCate",
    method: "post",
    data:{
      categoryId
    }
  });
};



//贡献博主
export let ContributBlogger = () => {
  return request({
    url: "/user/gethotusers",
    method: "get"
  });
};
