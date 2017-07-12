<template>
<section class="entry_container">
  <img src="../../assets/logo.png" alt="LOGO" class="header logo">

  <div class="form">
    <div class="input_box">
      <input type="text" class="input" v-model.trim="account" placeholder="手机号/邮箱" />
    </div>

    <div class="input_box">
      <input type="tel" class="input" v-model.trim="code" placeholder="请输入验证码" />
      <span class="auth_code"  v-if="!isSendCodeIng" @click.stop="sendCode">获取验证码</span>
      <span class="send_code gray" v-else>{{timeOut}} 秒后重新获取</span>
    </div>

    <div class="input_box">
      <input type="password" class="input"  v-model.trim="password" placeholder="请输入密码" />
    </div>

    <div class="input_box">
      <input type="password" class="input"  v-model.trim="password_re" placeholder="请确认密码" />
    </div>

    <mt-button class="btn submit" @click="onSubmit" size="large" type="primary">提交</mt-button>
  </div>
</section>

</template>

<script>
import { Toast } from 'mint-ui'

export default {
  name: "Register",
  data() {
    const { send_type = 4 } = this.$route.query
    return {
      account: '',
      password: '',
      password_re: '',
      code: '',
      send_type,
      timeOut: 60,
      isSendCodeIng: false,
    }
  },

  created() {
    this.timer = null
  },

  methods: {
    sendCode() {
      const { account } = this
      if(!account) {
        return Toast('请填写手机号或邮箱！')
      }

      const TelPattern = /^1[34578]\d{9}$/
      const MailPattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/
      
      if(!TelPattern.test(account)) {
        if(!MailPattern.test(account)) {
          return Toast('手机号或邮箱格式错误！')
        }
      }

       if(TelPattern.test(account)) {
        // 手机号
        this.send_type = 4
      } else if (MailPattern.test(account)) {
        // 邮箱
        this.send_type = 5
      }
      
      this.isSendCodeIng = true
      this.timer = setInterval(() => {
        if(this.timeOut === 1) {
          this.timeOut = 60
          this.isSendCodeIng = false
          return clearInterval(this.timer)
        }
        this.timeOut -= 1
      }, 1000)

      const Data = {
        account,
        send_type: this.send_type,
      }
      this.$http.post(this.API.HOUSE.Code, Data).then(res => {
        console.log(res)
      }).catch(error => {
        // TODO 到底返回哪个字段
        Toast(error)
      })
      
    },

    onSubmit() {
      const {
        account,
        password,
        password_re,
        code,
      } = this
      if(!password) {
        return Toast('请填写密码！')
      }

      if(!code) {
        return Toast('请填写验证码！')
      }

      if(password !== password_re) {
        return Toast('密码不一致！')
      }
      
      const Data = {
        password: password,
        password_re: password_re,
        username: account,
        code: code,
      }
      this.$http.post(this.API.USER.Bind, Data).then(res => {
        if(res.token) {
          localStorage.token = res.token
          // TODO 检查是否有参数，登出成功后，重定向到之前的页面
          Toast('修改成功！')
          setTimeout(() => this.$router.push('/users'), 800) 
        }
      })
    },

    destroyed() {
      clearInterval(this.timer)
    },
  },
}
</script>
