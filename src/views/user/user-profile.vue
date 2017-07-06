<template>
<el-row class="user_profile_container" :gutter="30">
  <el-col class="avatar" :span="8">
    <img src="http://placehold.it/280x300" alt="头像" />
    <el-button type="primary" class="submit_avatar">上传头像</el-button>
  </el-col>

  <el-col :span="16">
    <h3 class="h3">基本信息</h3>
    <div class="input_group">
      <label>姓名</label>
      <el-input size="large" class="input" v-model="input" placeholder="请输入内容"></el-input>
    </div>

    <div class="input_group">
      <label>年龄</label>
      <el-input size="large" class="input" v-model="input" placeholder="请输入内容"></el-input>
    </div>

    <div class="input_group">
      <label>姓名</label>
      <el-input size="large" class="input" v-model="input" placeholder="请输入内容"></el-input>
    </div>

    <div class="input_group">
      <label>姓名</label>
      <el-input size="large" class="input" v-model="input" placeholder="请输入内容"></el-input>
    </div>
    
    <div class="radio_group">
      <el-radio class="radio" v-model="radio" label="1">男</el-radio>
      <el-radio class="radio" v-model="radio" label="2">女</el-radio>
    </div>

    <el-button class="save_btn fr" type="primary" size="large">保存</el-button>
  </el-col>
</el-row>
</template>

<script>
export default {
  name: 'UserProfile',
  data() {
    return {
      input: '',
      radio: '1',
    }
  }
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

  .save_btn {
    margin-top: 30px;
    margin-right: 40px;
    width: 120px;
  }
</style>
