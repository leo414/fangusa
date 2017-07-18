<template>
<artice>
  <div class="banner"></div>
  <div class="container">
    <h2 class="h2">联系我们</h2>
    <el-row :gutter="40" class="contact_container">
      <el-col :span="12" class="form">
        <label class="label">你的姓名</label>
        <el-input class="input" v-model="input"></el-input>

        <label class="label">联系电话</label>
        <el-input class="input" v-model="input"></el-input>

        <label class="label">邮箱 / 微信 ID （选填）</label>
        <el-input class="input" v-model="input"></el-input>

        <label class="label">你的意见</label>
        <el-input class="input" v-model="value2" type="textarea" :rows="4" placeholder="" />
        <el-button type="primary" size="large">提交</el-button>
      </el-col>

      <el-col :span="12" class="aside">
        <h3 class="h3">需要帮助？</h3>
        <ul class="link_list">
          <li><router-link to="/change_pd">忘记密码？</router-link></li>
          <li><router-link to="/user?seleted=1">修改邮箱或者手机号？</router-link></li>
          <li><router-link to="/">买房 FAQ </router-link></li>
        </ul>
        <h3 class="h3">Still need help?</h3>
        If you didn't find the answer to your question, please contact us and a member of our
        constomer support team will gladly assist you.

        <h3 class="h3">Contact Us</h3>
      </el-col>
    </el-row>
  </div>  
</artice>
</template>

<script>
export default {
  name: 'ContactUs',
  data() {
    return {
      input: '',
      value2: '',
    }
  },
}
</script>

<style lang="scss" scoped>
.banner {
  width: 100%;
  height: 500px;
  background: url('http://placehold.it/19200x500') center center no-repeat;
  background-size: cover;
}

.h2 {
  padding: 20px 0;
} 

.container {
  margin-top: 30px;
}

.contact_container {
  padding: 20px;
  width: 100%;
  height: auto;
  background: #fff;
}

.form {
  padding-right: 50px;
}

.label {
  font-size: 14px;
  color: #000;
}

.input {
  margin-top: 10px;
  margin-bottom: 20px;
}

.aside {
  .h3 {
    margin-top: 30px;
    margin-bottom: 20px;

    &:first-child {
      margin-top: 0;
    }
  }

  .link_list li {
    margin-left: 20px;
    margin-bottom: 10px;
    list-style-type: disc;
  }
}
</style>
