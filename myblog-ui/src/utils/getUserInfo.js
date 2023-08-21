/*
存储登录后用户信息
*/
const  userData = {}

// 定义方法
userData.setUserData= function (user) {
   this.userData =user;
}
userData.getUserData = function(){
   return this.userData;
}

export default userData