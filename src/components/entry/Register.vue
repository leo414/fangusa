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
      <input type="text" class="input" placeholder="手机号注册" />
    </div>

    <div class="input_box" v-else>
      <input type="text" class="input" placeholder="邮箱注册" />
    </div>

    <div class="input_box">
      <input type="text" class="input" placeholder="请输入验证码" />
      <span class="auth_code">获取验证码</span>
    </div>

    <div class="input_box">
      <input type="text" class="input" placeholder="请输入密码" />
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
  name: "Login",
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

<style lang="scss" scoped>
@import "../../scss/variables";

.entry_container {
  width: 100%;
  padding: 5vh 20px 20px 20px;
  min-height: 100vh;
}

.logo {
  display: block;
  margin: auto;
  width: 140px;
}

.form {
  margin-top: 4vh;
  width: 100%;
  height: auto;
}

.input_box {
  margin-top: 10px;
  width: 100%;
  height: 40px;
  line-height: 40px;
  display: flex;
  border-bottom: 1px $border_color solid;
  font-size: 14px;

  .area_code {
    display: block;
    width: 40px;
    height: 40px;
    font-size: 14px;
    text-align: center;
  }

  .input {
    height: 40px;
    border: none;
    background: none;
    outline: none;
    flex: 1;
    padding-left: 5px;
    font-size: 14px;
  }

  .auth_code {
    height: 30px;
    padding: 0 10px;
    line-height: 30px;
    border-radius: 3px;
    font-size: 12px;
    color: $theme_color;
    background: $border_color;
  }
}

.btn {
  margin-top: 25px;
  letter-spacing: 2px;
  border-radius: 18px;
  background: $theme_color;
}

.aside {
  margin-top: 10px;
  text-align: center;
  font-size: 12px;
  color: $content_color;
}

.divide {
  margin-top: 40px;
  text-align: center;
  height: 30px;
  line-height: 30px;

  .hr {
    margin-bottom: -17px;
    border: none;
    border-bottom: 1px $divder_color solid;
  }

  .divide_text {
    padding: 0 20px;
    display: inline-block;
    color: $content_color;
    background: $app_bg_colol;
    text-align: center;
    font-size: 12px;
  }
}

.wexin { background: $we_color; }

.footer {
  margin-top: 30px;
  height: 24px;
  line-height: 24px;
  font-size: 12px;
  color: $content_color;

  .fr a { color: $theme_color; }
}
</style>
