<template>
<section class="entry_container">
  <img src="../../assets/logo.png" alt="LOGO" class="header logo">

  <div class="form">
    <div class="input_box">
      <input type="text" class="input" placeholder="手机号 / 邮箱" />
    </div>

    <div class="input_box">
      <input type="password" class="input" placeholder="请输入密码" />
    </div>

    <mt-button class="btn submit" @click.native="handleClick" size="large" type="primary">登录</mt-button>
  </div>

  <div class="divide">
    <hr class="hr" />
    <p class="divide_text">其他登录方式</p>
  </div>

  <mt-button class="btn wexin" @click.native="handleClick" size="large" type="primary">微信登录</mt-button>

  <footer class="footer">
    <router-link class="forget_pd" to="/forget_password">忘记密码？</router-link>
    <div class="fr">
      <router-link to="/register">尚未注册？现在去注册</router-link>
    </div>
  </footer>
</section>

</template>

<script>

export default {
  name: "Login",
  data() {
    return {

    }
  }
}
</script>
