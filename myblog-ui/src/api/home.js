import request from "./request"

//获取热门的七条博客数据
export let blogHotSix = () => {
    return request({
      url: "/blog/hotsix",
      method: "get"
    });
  };


