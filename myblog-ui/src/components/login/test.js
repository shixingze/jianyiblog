import Vue from 'vue'
import Login from './logindialog.vue'

const LoginBox = Vue.extend(Login)

LoginBox.install = function () {
  let instance = new LoginBox({
  }).$mount();
  document.body.appendChild(instance.$el);
  Vue.nextTick(() => {
    instance.showlogin();
  })
}

export { LoginBox }
