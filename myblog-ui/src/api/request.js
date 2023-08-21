//导入axios
import { t } from "@wangeditor/editor";
import axios from "axios";
import Cookies from 'js-cookie'
import {LoginBox} from '@/components/login/test'
//创建实例
const instance = axios.create({
  baseURL: '/api',
  // 定义统一的请求头部
  headers: {
 },
 // 配置请求超时时间
 timeout: 10000, 
 // 如果用的JSONP，可以配置此参数带上cookie凭证，如果是代理和CORS不用设置
 withCredentials: true
});

// axios.defaults.withCredentials = true
// export const request = (config) => {
//   return axios(config)
// }

  // 添加请求拦截器
  instance.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  // 判断是否存在token,如果存在将每个页面header添加token
  const token = Cookies.get("token");
  if (token ) {
    config.headers.authorization = token;
  }else{
    return config;
    this.$Login();
  }
  return config;
})

// 返回拦截
instance.interceptors.response.use(
  response => {
    if(response.headers['content-disposition']){
      return response;
    }
    return response.data;
  },
  error => {
    // return error
    console.log(error.response)
    if (!error.response) {
      if (document.getElementsByClassName('el-message').length === 0) {
//alert(error.message);
      }
      router.currentRoute.path !== '/home/firstpage/homepage' && router.replace('/home/firstpage/homepage');
      //  console.log(router.currentRoute)
    } else {
      if (error.response.status === 401) {
        if (document.getElementsByClassName('el-message').length === 0) {
          
         // alert('token过期,请重新登陆');
        }
        router.currentRoute.path !== '/home/firstpage/homepage' && router.replace('/home/firstpage/homepage');
      } else if (error.response.status === 404) {
        if (document.getElementsByClassName('el-message').length === 0) {
         // alert('请求资源未找到');
        }
      } else {
        if (document.getElementsByClassName('el-message').length === 0) {
         // alert('请填写完整再提交!');
        }
      }
    }
    return new Promise(() => { });
  }
);



// 这句一定要写

export default instance;

