import request from "./request"


//下载
export let down = ({URL}) => {
  return request({
    url: "/bili/download",
    method: "post",
    responseType: "blob",
    data:{
        URL
    }
  });
};