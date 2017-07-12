<template>
<section class="contact_us_container">
  <NavBar title="个人设置" />
  <div class="avatar">
    <div class="img_box">
      <vue-core-image-upload
        class="img"
        :crop="false"
        inputOfFile="image"
        @imageuploading="checkToken"
        @imageuploaded="imageuploaded"
        @errorhandle="imageUploadedError"
        extensions="png,jpg"
        text=""
        :maxFileSize="10485760"
        :max-file-size="5242880"
        :headers="uploadImage.reqHeader"
        :credentials="false"
        :url="uploadImage.reqUrl"
        :style="background(uploadImage.image)"
      >
      </vue-core-image-upload>
      <i class="i i-camera"></i>      
    </div>
  </div>

  <p class="divide_bar">基本信息</p>
  <div class="user_info">
    <mt-field label="用户名" placeholder="请输入用户名" v-model="name"></mt-field>
    <mt-field label="年龄" placeholder="请输入年龄" type="number" v-model="age"></mt-field>
    
    <mt-radio
      class="radio_list"
      v-model="gender"
      :options="options">
    </mt-radio>

    <div class="btn_area">
      <mt-button type="primary" size="large" @click.native="patchUserInfo">提交</mt-button>
    </div>

     <p class="account_area">
        邮&nbsp;&nbsp;&nbsp;&nbsp;箱：
        <mt-button v-if="email" class="btn_text">{{email}}</mt-button>
        <mt-button v-else size="small" type="primary" @click="updateAccount(5)">绑定邮箱</mt-button>

        <mt-button v-if="email" size="small" type="primary" @click="updateAccount(5)">更改邮箱</mt-button>
      </p>

      <p class="account_area">
        手机号：
        <mt-button v-if="mobile" class="btn_text">{{mobile}}</mt-button>
        <mt-button v-else  size="small" type="primary" @click="updateAccount(4)">绑定手机号</mt-button>

        <mt-button v-if="mobile" size="small" type="primary" @click="updateAccount(4)">更改手机号</mt-button>
      </p>

      <div class="btn_area">
        <mt-button style="background: #1AAD19;" type="primary" size="large" @click.native="patchUserInfo">绑定微信</mt-button>
      </div>
  </div>
</section>

</template>

<script>
import NavBar from '../globalLayout/NavBar.vue'
import VueCoreImageUpload from 'vue-core-image-upload'
import { API } from '../../libs/Constant'
import { Toast } from 'mint-ui'

export default {
  name: "UserProfile",
  components: {
    NavBar,
    'vue-core-image-upload': VueCoreImageUpload,
  },
  data() {
    return {
      name: '',
      age: 18,
      email: '',
      mobile: '',
      gender: 'male',
      options: [
        {
          label: '男',
          value: 'male'
        },
        {
          label: '女',
          value: 'female'
        }
      ],
      uploadImage: {
        loading: false,
        image: '',
        reqUrl:  process.env.BASE_API + API.USER.User,
        reqHeader: {
          'Authorization':  `JWT ${localStorage.token}`,
        },
      },
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
          this.uploadImage.image = res.image
        }
      })
    },

    background(img) {
      return {
        backgroundImage: 'url('+ img +')',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
      }
    },

    // 开始上传
    checkToken() {
      // TODO 检查 TOKEN 是否过期
      // this.$http.get(this.API.USER.User)
    },

    // 上传结束
    imageuploaded(res) {
      if(res.image) {
        this.uploadImage.image = res.image
      }
    },

    // 上传失败
    imageUploadedError(error) {
      Toast('上传错误，请刷新重试！')
    },

    patchUserInfo() {
      const Data = {
        name: this.name,
        age: this.age,
        gender: this.gender,
      }
      this.$http.patch(this.API.USER.User, Data).then(res => {
        Toast('修改成功！')
      })
    },

    updateAccount(send_type) {
      this.$router.push({path: '/bind', query: {send_type}})
    },
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

  .img_box {
    position: relative;
    left: 0;
    top: 0;
    display: inline-block;
    width: 100px;
    height: 100px;

    form {
      width: 100px;
      height: 100px;
    }
  }

  .img {
    width: 100px;
    height: 100px;
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

.btn_area {
  margin-top: 20px;
  margin-bottom: 30px;
  padding: 0 15px;
  width: 100%;
}

.account_area {
  margin-bottom: 10px;
  padding: 0 15px;
  width: 100%;
  height: 42px;

  .btn_text {
    margin-right: 20px;
  }
}
</style>
