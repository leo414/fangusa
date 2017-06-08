<template lang="html">
<section id="login">
  <header class="header">
    <router-link active-class="active" to="/login">登录</router-link>
    <router-link active-class="active" to="/register">注册</router-link>
  </header>

  <div class="content">
    <div class="input_box">
      <section class="account box">
        <Icon type="android-person" />
        <input class="ipt" type="text" placeholder="邮箱 / 手机号" />
      </section>

      <section class="password box">
        <Icon type="android-lock" />
        <input class="ipt" type="password" placeholder="密码" />
      </section>
    </div>
    <router-link to="change_pd" class="fr theme_color">忘记密码？</router-link>
    <i-button size="large" class="login">登录</i-button>

    <hr/>

    <p class="desc">社交媒体账号登录</p>
    <i-button class="we_loign"><i class="i-weixin i"></i>微信账号登录</i-button>
  </div>
</section>
</template>

<script>
import Button from 'iview/src/components/button'
import Icon from 'iview/src/components/icon'

export default {
  name: 'Login',
  components: {
    iButton: Button,
    Icon,
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

.login {
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

.we_loign {
  @extend .login;
  letter-spacing: 2px;
  background: $we_color;

  i {
    margin-right: 20px;
    font-size: 20px;
  }
}

</style>
