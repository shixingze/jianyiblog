import request from "./request"

//获取token
export let getToken = ({ username, password }) => {
    return request({
      url: "/auth/login",
      method: "post",
      data: {
        username,
        password,
      },
    });
  };
//获取验证码
export let getyzCode = ({ email }) => {
  return request({
    url: "/auth/getCode",
    method: "post",
    data: {
      email
    },
  });
};
//注册
export let register = ({ data }) => {
  return request({
    url: "/auth/register",
    method: "post",
    data: data,
  });
};
//获取用户信息
export let getUserInfo = () => {
  return request({
    url: "/auth/userInfo",
    method: "get",
    
  });
};
