<template lang="html">
<section id="login">
  <header class="header">
    <router-link active-class="active" to="/login">登录</router-link>
    <router-link active-class="active" to="/register">注册</router-link>
  </header>

  <div class="content">
    <div class="input_box">
      <section class="account box">
        <i class="i i-user" />
        <input class="ipt" v-model.trim="username" type="text" placeholder="邮箱 / 手机号" />
      </section>

      <section class="password box">
        <i class="i i-lock" />
        <input class="ipt" v-model.trim="password"  @keyup.enter="onLogin" type="password" placeholder="密码" />
      </section>
    </div>
    <router-link to="/change_pd" class="fr theme_color">忘记密码？</router-link>
    <el-button type="primary" size="large" @click="onLogin" class="login_btn">登录</el-button >

    <hr/>

    <p class="desc">社交媒体账号登录</p>
    <el-button class="we_loign_btn"><i class="i-weixin i"></i>微信账号登录</el-button >
  </div>
</section>
</template>

<script>
export default {
  name: 'Login',
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
        this.$message.error('请输入账号！')
        return 
      }

      if(!password) {
        this.$message.error('请输入密码！')
        return 
      }
      const data = {
        username,
        password
      }
      this.$http.post(this.API.USER.Login, data)
        .then(res => {
          if(res.token) {
            localStorage.token = res.token
            // TODO 检查是否有参数，登出成功后，重定向到之前的页面
            this.$router.push('/')
          }
        })
        .catch(error => {
          if(error.non_field_errors) {
            this.$message.error('用户名或密码错误！')
          }
        })
    },
  }
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

#login {
  width: 420px;
  margin: 60px auto;
  height: 480px;
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
      outline: none;
    }
  }

  .account .ipt {
    border-bottom: 1px #ccc solid;
  }
}

.login_btn {
  width: 100%;
  height: 42px;
  font-size: 16px;
  margin-top: 20px;
  clear: both;
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
