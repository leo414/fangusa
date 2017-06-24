<template lang="html">
<section id="login">
  <header class="header">
    找回密码
  </header>

  <div class="content">
    <div class="input_box">
      <section class="account box">
        <i class="i i-user" />
        <input class="ipt" type="text" placeholder="邮箱 / 手机号" />
      </section>

      <section class="password box">
        <i class="i i-lock" />
        <input class="ipt" type="password" placeholder="密码" />
      </section>

      <section class="code box">
        <i class="i i-code" />
        <input class="ipt" type="password" placeholder="手机/邮箱 验证码" />
      </section>
    </div>
    <el-button class="login_btn">提交</el-button >
  </div>
</section>
</template>

<script>
export default {
  name: 'ChangePd',
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

#login {
  width: 420px;
  margin: 60px auto;
  height: 380px;
  background: #fff;
}

.header {
  width: 100%;
  height: 50px;
  line-height: 50px;
  background: #324057;
  text-align: center;
  color: #fff;

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

  .code .ipt {
    border: none;
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

</style>
