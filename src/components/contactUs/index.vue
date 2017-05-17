<template>
<section id="contact_us">
  <NavBar title="联系我们" />

  <img src="http://placehold.it/300x300" class="qr">
  <div class="desc">
    <p>欢迎联系房美国 （fangusa.com），请选择以下方式：</p>
    <p>联系方式1：xxx</p>
    <p>联系方式2：xxx</p>
    <p>联系方式3：xxx</p>
    <h3 class="h3">直接填写以下表格联系我们：</h3>
    <mt-field label="姓名" placeholder="您的姓名" v-model="username"></mt-field>
    <mt-field label="手机号" placeholder="联系电话" type="tel" v-model="phone"></mt-field>
    <mt-field label="邮箱/微信号" placeholder="邮箱/微信ID（选填）" v-model="wexin"></mt-field>
    <mt-field label="自我介绍" placeholder="留言内容" type="textarea" rows="4" v-model="introduction"></mt-field>

    <div class="checkbox">
      <input type="checkbox" />
      我同意房美国的相关使用与隐私政策条款。
    </div>
    <mt-button class="btn" @click.native="handleClick" size="large" type="primary">提交</mt-button>
  </div>

</section>

</template>

<script>
import NavBar from '../globalLayout/NavBar.vue'

export default {
  name: "ContactUs",
  data() {
    return {
      username: '',
      phone: '',
      wexin: '',
      introduction: '我对ABC123456房源感兴趣，想了解更多信息。',
    }
  },
  components: {
    NavBar,
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

.qr {
  width: 250px;
  height: 250px;
  display: block;
  margin: 20px auto;
  margin-top: 50px;
  padding-top: 20px;
}

.desc {
  padding: 10px;
  color: #3a3a3a;
  line-height: 24px;
  font-size: 14px;

  .h3 {
    font-size: 16px;
    height: 40px;
    line-height: 40px;
  }

  .checkbox {
    margin-top: 10px;
  }

  .btn {
    margin-top: 10px;
    margin-bottom: 20px;
    background: $theme_color;
  }
}
</style>
