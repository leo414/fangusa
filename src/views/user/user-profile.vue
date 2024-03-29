<template>
<el-row class="user_profile_container">
  <el-col class="avatar" :span="8" v-loading.body="uploadImage.loading">
    <img :src="uploadImage.image" alt="头像" />
    <vue-core-image-upload
      class="el-button el-button--primary el-button--small submit_avatar"
      :crop="false"
      inputOfFile="image"
      @imageuploading="checkToken"
      @imageuploaded="imageuploaded"
      @errorhandle="imageUploadedError"
      extensions="png,jpg"
      text="上传头像"
      :maxFileSize="10485760"
      :max-file-size="5242880"
      :headers="uploadImage.reqHeader"
      :credentials="false"
      :url="uploadImage.reqUrl">
    </vue-core-image-upload>
  </el-col>

  <el-col :span="16" style="padding-left: 20px;">
    <h3 class="h3">基本信息</h3>
    <div class="input_group">
      <label>姓名</label>
      <el-input size="large" class="input" v-model="name" placeholder="请输入内容"></el-input>
    </div>

    <div class="input_group">
      <label>年龄</label>
      <el-input size="large" type="number" class="input" v-model.number="age" placeholder="请输入内容"></el-input>
    </div>

    <div class="radio_group">
      <el-radio class="radio" v-model="gender" label="male">男</el-radio>
      <el-radio class="radio" v-model="gender" label="female">女</el-radio>
    </div>

    <div class="save_btn_area">
      <el-button class="save_btn fr" @click="patchUserInfo" type="primary" size="large">保存</el-button>
    </div>

    <div>
      <p class="account">
        邮&nbsp;&nbsp;&nbsp;&nbsp;箱：
        <el-button v-if="email" class="btn_text" size="large" type="text">{{email}}</el-button>
        <el-button v-else size="small" type="primary" @click="updateAccount('绑定邮箱', 5)">绑定邮箱</el-button>

        <el-button v-if="email" size="small" type="primary" @click="updateAccount('更改邮箱', 5)">更改邮箱</el-button>
      </p>

      <p class="account">
        手机号：
        <el-button v-if="mobile" class="btn_text" size="large" type="text">{{mobile}}</el-button>
        <el-button v-else  size="small" type="primary" @click="updateAccount('绑定手机号', 4)">绑定手机号</el-button>

        <el-button v-if="mobile" size="small" type="primary" @click="updateAccount('更改手机号', 4)">更改手机号</el-button>
      </p>
    </div>

    <el-dialog @close="onDialogClose" :title="dialog.title" :visible.sync="dialog.isShow">
      <section class="dialog_container">
        <el-input v-model="dialog.account" class="dialog_account" :placeholder="dialog.title"></el-input>
        <el-input v-model="dialog.code"  class="dialog_code" placeholder="验证码"></el-input>
        <el-button v-if="!dialog.disabled" type="primary" @click="sendCode">获取验证码</el-button>
        <el-button v-else type="primary" :plain="true" :disabled="true">{{dialog.timeOut}}秒后重新获取</el-button>

        <footer>
          <el-button type="primary" size="large" class="dialog_submit" @click="onSunmitAccount">提交</el-button>          
        </footer>
      </section>
    </el-dialog>
  </el-col>
</el-row>
</template>

<script>
import VueCoreImageUpload from 'vue-core-image-upload'
import { API } from 'libs/Constant'

export default {
  name: 'UserProfile',
  data() {
    return {
      name: '',
      age: '',
      gender: 'male',
      email: '',
      mobile: '',
      uploadImage: {
        loading: false,
        image: '',
        reqUrl:  process.env.BASE_API + API.USER.User,
        reqHeader: {
          'Authorization':  `JWT ${localStorage.token}`,
        },
      },
      dialog: {
        title: '',
        send_type: null,
        account: '',
        code: '',
        timeOut: 60,
        disabled: false,
        isShow: false,
      },
    }
  },
  components: {
    'vue-core-image-upload': VueCoreImageUpload,
  },
  mounted() {
    this.fetchData()
    this.$http.post(this.API.OTHER.VerifyToken, {token: localStorage.token})
      .then(res => {
        if(res.token) {
          // TODO
        }
      })
      .catch(error => {
        localStorage.token = ''
        this.$router.push('/login')
      })
  },
  created() {
    this.timer = null
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
          this.uploadImage.image = res.image
        }
      })
    },

    // 开始上传
    checkToken() {
      // TODO 检查 TOKEN 是否过期
      // this.$http.get(this.API.USER.User)
      this.uploadImage.loading = true
    },

    // 上传结束
    imageuploaded(res) {
      this.uploadImage.loading = false
      if(res.image) {
        this.uploadImage.image = res.image
      }
    },

    // 上传失败
    imageUploadedError(error) {
      this.uploadImage.loading = false
      this.$message.warning('上传错误，请刷新重试！')
    },

    patchUserInfo() {
      const Data = {
        name: this.name,
        age: this.age,
        gender: this.gender,
      }
      this.$http.patch(this.API.USER.User, Data).then(res => {
        this.$message.success('修改成功！')
      })
    },

    updateAccount(title, send_type) {
      this.dialog.title = title
      this.dialog.send_type = send_type
      this.dialog.isShow = true
    },

    sendCode() {
      const {account, send_type} = this.dialog
      if(!account) {
        return this.$message.warning('请填写账号！')
      }

      const TelPattern = /^1[34578]\d{9}$/
      const MailPattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/
      
      if(send_type === 4) { // 绑定 or 更改手机号
        if(!TelPattern.test(account)) return this.$message.warning('手机号格式错误！')
      } else if(send_type === 5) { // 绑定 or 更改邮箱
        if(!MailPattern.test(account)) return this.$message.warning('邮箱格式错误！')
      } else {
        return this.$message.warning('发生错误，请刷新重试！')
      }
      
      this.dialog.disabled = true
      this.timer = setInterval(() => {
        if(this.dialog.timeOut === 1) {
          this.dialog.timeOut = 60
          this.dialog.disabled = false
          return clearInterval(this.timer)
        }
        this.dialog.timeOut -= 1
      }, 1000)

      const Data = {
        account,
        send_type,
      }
      this.$http.post(this.API.HOUSE.Code, Data).then(res => {
        console.log(res)
      }).catch(error => {
        this.$message.error(error)
      })
    },

    onDialogClose() {
      clearInterval(this.timer)
      this.dialog.timeOut = 60
      this.dialog.disabled = false
      this.dialog.account = ''
    },

    onSunmitAccount() {
      if(!this.dialog.code) {
        return this.$message.warning('请填写验证码！')
      }
      
      const Data = {
        account: this.dialog.account,
        type: this.dialog.send_type,
        code: this.dialog.code,
      }
      this.$http.post(this.API.USER.Bind, Data).then(res => {
        // TODO待测试
        this.$message.success('修改成功！')
        this.fetchData()
      })
    },

    destroyed() {
      this.uploadImage.loading = false
      clearInterval(this.timer)
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

  .dialog_container {
    width: 80%;

    .dialog_account {
      width: 250px;
      margin-right: 30px;
    }

    .dialog_code {
      width: 180px;
    }

    .dialog_submit {
      margin-top: 20px;
      width: 100px;
    }
  }

</style>
