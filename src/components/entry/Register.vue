<template>
<section class="entry_container">
  <img src="../../assets/logo.png" alt="LOGO" class="header logo">

  <mt-actionsheet
    :actions="actions"
    v-model="sheetVisible"
  />

  <div class="form">
    <div class="input_box" v-if="registerWay === 'phone'">
      <span @click="sheetVisible = true" class="area_code">+{{area_code}}</span>
      <input type="tel" class="input" placeholder="手机号注册" />
    </div>

    <div class="input_box" v-else>
      <input type="email" class="input" placeholder="邮箱注册" />
    </div>

    <div class="input_box">
      <input type="tel" class="input" placeholder="请输入验证码" />
      <span class="auth_code">获取验证码</span>
    </div>

    <div class="input_box">
      <input type="password" class="input" placeholder="请输入密码" />
    </div>

    <mt-button class="btn submit" @click.native="handleClick" size="large" type="primary">注册</mt-button>
    <p class="aside">
      <i class="i i-agree theme_color" />
      注册即为同意美国（fangusa.com）用户协议
    </p>
  </div>

  <div class="divide">
    <hr class="hr" />
    <p class="divide_text">其他注册方式</p>
  </div>

  <mt-button class="btn wexin" @click.native="handleClick" size="large" type="primary">微信登录</mt-button>

  <footer class="footer">
    <span @click="registerWay = 'email'" v-if="registerWay === 'phone'">切换邮箱登录</span>
    <span @click="registerWay = 'phone'" v-else>切换手机号登录</span>

    <div class="fr">
      <router-link to="/login">已有账号立即登录</router-link>
    </div>
  </footer>
</section>

</template>

<script>

export default {
  name: "Register",
  data() {
    const self = this
    return {
      registerWay: 'phone',
      area_code: '86',
      sheetVisible: false,
      actions: [
        {name: 'China（中国）+86', method() {self.area_code = 86}},
        {name: 'USA（美国）+1', method() {self.area_code = 1}},
      ]
    }
  }
}
</script>
