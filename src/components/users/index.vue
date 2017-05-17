<template>
<section id="contact_us">
  <NavBar title="个人设置" />
  <div class="avatar">
    <div class="img">
      <i class="i i-camera" />
    </div>
  </div>

  <p class="divide_bar">基本信息</p>
  <div class="user_info">
    <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>

    <mt-radio
      class="radio_list"
      v-model="value"
      :options="['男', '女']">
    </mt-radio>

    <mt-field label="年龄" placeholder="请输入年龄" type="number" v-model="age"></mt-field>
    <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="email"></mt-field>
    <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="username"></mt-field>
  </div>
</section>

</template>

<script>
import NavBar from '../globalLayout/NavBar.vue'

export default {
  name: "UserProfile",
  components: {
    NavBar,
  },
  data() {
    return {
      username: '',
      email: '',
      value: ' 男',
      age: 18,
    }
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

.avatar {
  width: 100%;
  height: 140px;
  margin-top: 50px;
  padding-top: 20px;
  text-align: center;
  background: #fff;

  .img {
    position: relative;
    left: 0;
    top: 0;
    display: inline-block;
    width: 100px;
    height: 100px;
    background: url('http://placehold.it/100x100') center no-repeat;
    background-size: cover;
    border-radius: 50%;
  }

  .i-camera {
    position: absolute;
    bottom: 0;
    right: 0;
    padding: 5px;
    border-radius: 50%;
    background: $app_bg_colol;
    color: $content_color;
  }
}

.divide_bar {
  height: 26px;
  line-height: 26px;
  font-size: 12px;
  padding-left: 10px;
  width: 100%;
  font-weight: bold;
}

.user_info {
  height: auto;
  background: #fff;
}

.radio_list {
  margin-bottom: -1px;
}
</style>
