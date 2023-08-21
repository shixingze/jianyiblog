//点赞接口
import request from "./request"


//点赞接口
export let startCheck = ({blogId}) => {
  return request({
    url: "/start/blog",
    method: "post",
    data:{
      blogId
    }
  });
};