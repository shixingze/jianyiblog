import Cookies from 'js-cookie';


var havetoken = function(){
   var tkr = Cookies.get("token");
   if(tkr){
     return true;
   }
  return false;
}
export default havetoken;