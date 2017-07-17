<template>
<section class="entry_container">
  <img src="../../assets/logo.png" alt="LOGO" class="header logo">

  <div class="form">
    <div class="input_box">
      <input type="text" class="input" v-model.trim="username" placeholder="手机号 / 邮箱" />
    </div>

    <div class="input_box">
      <input type="password" class="input" v-model.trim="password" placeholder="请输入密码" />
    </div>

    <mt-button class="btn submit" @click="onLogin" size="large" type="primary">登录</mt-button>
  </div>

  <div class="divide">
    <hr class="hr" />
    <p class="divide_text">其他登录方式</p>
  </div>

  <mt-button class="btn wexin" @click="wxLogin" size="large" type="primary">微信登录</mt-button>

  <footer class="footer">
    <router-link class="forget_pd" to="/change_pd">忘记密码？</router-link>
    <div class="fr">
      <router-link to="/register">尚未注册？现在去注册</router-link>
    </div>
  </footer>
</section>

</template>

<script>
import { Toast, Indicator } from 'mint-ui'

export default {
  name: "Login",
  data() {
    return {
      username: '',
      password: '',
    }
  },
  methods: {
    onLogin() {
      const { username, password } = this
      if(!username) {
        Toast('请输入账号！')
        return 
      }

      if(!password) {
        Toast('请输入密码！')
        return 
      }
      Indicator.open()
      const data = {
        username,
        password
      }
      this.$http.post(this.API.HOUSE.Login, data)
        .then(res => {
          if(res.token) {
            localStorage.token = res.token
            this.$http.get(this.API.USER.User).then(res => {
              if(res) {
                localStorage.userInfo = JSON.stringify(res)
              }
              Indicator.close()
            })

            // TODO 检查是否有参数，登出成功后，重定向到之前的页面
            this.$router.push('/')
          }
        })
        .catch(error => {
          Indicator.close()
          if(error.non_field_errors) {
            Toast('用户名或密码错误！')
          }
        })
    },

    wxLogin() {

    },
  },

  destroyed() {
    Indicator.close()
  }
}
</script>
