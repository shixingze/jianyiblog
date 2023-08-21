import request from "./request"


//评论根据博客id获取评论树
export let getCommtree = (param) => {
  return request({
    url: `/blog/comment/tree?blogId=${param}`,
    method: "get"
  });
};

//新增评论
export let addCommentOne = ({blogId, commentText, commentPid}) => {
  return request({
    url: `/blog/comment/add`,
    method: "post",
    data:{
      blogId,
      commentText,
      commentPid
    }
  });
};