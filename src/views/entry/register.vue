<template lang="html">
<div>
  <section class="register_container">
    <header class="header">
      <router-link active-class="active" to="/login">登录</router-link>
      <router-link active-class="active" to="/register">注册</router-link>
    </header>
  
    <div class="content">
      <div class="input_box">
        <section class="account box">
          <i class="i i-user" />
          <input class="ipt" type="text" v-model.trim="account" placeholder="手机号 / 邮箱" />
        </section>
  
        <section class="password box">
          <i class="i i-lock" />
          <input class="ipt" type="password" v-model.trim="password" placeholder="密码" />
        </section>
  
        <section class="code_box">
          <i class="i i-code" />
          <input class="ipt" type="tel" v-model.trim="code" placeholder="验证码" />
          <a v-if="!isSendCodeIng" @click.stop="sendCode" class="send_code">获取验证码</a>
          <span class="send_code gray" v-else>{{timeOut}} 秒后重新获取</span>
        </section>
      </div>
      <el-button type="primary" @click="onRegister" size="large" class="login_btn">注册</el-button >
      <hr/>
  
      <p class="desc">社交媒体账号登录</p>
      <el-button class="we_loign_btn"><i class="i-weixin i"></i>微信账号登录</el-button >
    </div>
  </section>
</div>
</template>

<script>

export default {
  name: 'Register',
  data() {
    return {
      account: '',
      password: '',
      code: '',
      send_type: 1,
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
        return this.$message.warning('请填写手机号或邮箱！')
      }

      const TelPattern = /^1[34578]\d{9}$/
      const MailPattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/
      
      if(!TelPattern.test(account)) {
        if(!MailPattern.test(account)) {
          return this.$message.warning('手机号或邮箱格式错误！')
        }
      }
      
      if(TelPattern.test(account)) {
        // 手机号
        this.send_type = 1
      } else if (MailPattern.test(account)) {
        // 邮箱
        this.send_type = 2
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
        this.$message.error(error)
      })
      
    },

    onRegister() {
      if(!this.password) {
        return this.$message.warning('请填写密码！')
      }

      if(!this.code) {
        return this.$message.warning('请填写验证码！')
      }
      
      const Data = {
        password: this.password,
        username: this.account,
        type: this.send_type,
        code: this.code,
      }
      this.$http.post(this.API.HOUSE.Register, Data).then(res => {
        if(res.token) {
          localStorage.token = res.token
          // TODO 检查是否有参数，登出成功后，重定向到之前的页面
          this.$router.push('/')
        }
      })
    },

    destroyed() {
      clearInterval(this.timer)
    },
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

.register_container {
  width: 420px;
  margin: 60px auto;
  height: 500px;
  background: #fff;
}

.header {
  width: 100%;
  height: 50px;
  line-height: 50px;
  font-size: 0;
  background: #324057;

  a {
    display: inline-block;
    width: 50%;
    font-size: 16px;
    text-align: center;
    color: #fff;
  }

  .active {
    color: #324057;
    background: #fff;
  }
}

.content {
  width: 100%;
  padding: 30px;
}

.input_box {
  width: 100%;
  height: auto;
  margin-bottom: 20px;
  border: 1px #ccc solid;
  border-radius: 5px;
  overflow: hidden;

  .box {
    width: 100%;
    height: 50px;
    position: relative;
    left: 0;
    right: 0;

    i {
      position: absolute;
      top: 15px;
      left: 10px;
      font-size: 20px;
    }

    .ipt {
      width: 100%;
      height: 50px;
      padding-left: 35px;
      border: none;
      border-bottom: 1px #ccc solid;
      outline: none;
    }
  }

  .gray { color: #333 !important; }

  .code_box {
    @extend .box;
    font-size: 0;

    .ipt {
      display: inline-block;
      border: none;
      width: 70%;
      font-size: 16px;
    }

    .send_code {
      display: inline-block;
      vertical-align: top;
      line-height: 50px;
      width: 30%;
      height: 50px;
      border-left: 1px #ccc solid;
      text-align: center;
      color: $theme_color;
      font-size: 14px;
    }
  }
}

.login_btn {
  width: 100%;
  height: 42px;
  font-size: 16px;
  margin-top: 20px;
  clear: both;
  background: $theme_color;
  color: #fff;
  letter-spacing: 10px;
}

hr {
  border: none;
  border-bottom: 1px #eee solid;
  margin: 30px 0;
}

.desc {
  text-align: center;
}

.we_loign_btn {
  @extend .login_btn;
  letter-spacing: 2px;
  background: $we_color;

  i {
    margin-right: 20px;
    font-size: 20px;
  }
}

</style>
