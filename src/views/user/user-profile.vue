<template>
<el-row class="user_profile_container" :gutter="30">
  <el-col class="avatar" :span="8">
    <img :src="image" alt="头像" />
    <el-button type="primary" class="submit_avatar">上传头像</el-button>
  </el-col>

  <el-col :span="16">
    <h3 class="h3">基本信息</h3>
    <div class="input_group">
      <label>姓名</label>
      <el-input size="large" class="input" v-model="name" placeholder="请输入内容"></el-input>
    </div>

    <div class="input_group">
      <label>年龄</label>
      <el-input size="large" class="input" v-model="age" placeholder="请输入内容"></el-input>
    </div>

    <div class="radio_group">
      <el-radio class="radio" v-model="gender" label="male">男</el-radio>
      <el-radio class="radio" v-model="gender" label="female">女</el-radio>
    </div>

    <div class="save_btn_area">
      <el-button class="save_btn fr" type="primary" size="large">保存</el-button>
    </div>

    <div>
      <p class="account">
        邮&nbsp;&nbsp;&nbsp;&nbsp;箱：
        <el-button v-if="email" class="btn_text" size="large" type="text">{{email}}</el-button>
        <el-button v-else  size="small" type="primary">绑定邮箱</el-button>

        <el-button v-if="email" size="small" type="primary">更改邮箱</el-button>
      </p>

      <p class="account">
        手机号：
        <el-button v-if="mobile" class="btn_text" size="large" type="text">{{mobile}}</el-button>
        <el-button v-else  size="small" type="primary">绑定手机号</el-button>

        <el-button v-if="mobile" size="small" type="primary">更改手机号</el-button>
      </p>
    </div>
  </el-col>
</el-row>
</template>

<script>
export default {
  name: 'UserProfile',
  data() {
    return {
      name: '',
      age: '',
      gender: 'male',
      email: '',
      mobile: '',
      image: '',
    }
  },
  mounted() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.$http.get(this.API.USER.User).then(res => {
        if(res) {
          this.name = res.name
          this.age = res.age
          this.gender = res.gender
          this.email = res.email
          this.mobile = res.mobile
          this.image = res.image
        }
      })
    },
  },
}
</script>

<style lang="scss" scoped>
  .user_profile_container {
    padding-bottom: 50px;
    width: 100%;
    height: auto;
  }

  .h3 {
    margin: 20px 0;
  }

  .avatar {
    text-align: center;

    img {
      width: 280px;
      height: 300px;
    }
  }

  .submit_avatar {
    margin-top: 10px;
    width: 280px;
  }

  .input_group {
    margin-right: 30px;
    margin-bottom: 20px;
    display: inline-block;
    width: 300px;
    height: auto;

    label {
      font-size: 16px;
      color: #000;
      line-height: 30px;
    }

    .input {
      display: block;
    }
  }

  .save_btn_area {
    margin-top: 10px;
    margin-bottom: 20px;
    width: 100%;
    height: 40px;

    .save_btn {
      margin-right: 40px;
      width: 120px;
    }
  }

  .account {
    margin-bottom: 20px;

    .btn_text {
      margin-right: 40px;
    }
  }

</style>
