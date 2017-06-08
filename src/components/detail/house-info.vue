<template>
<section id="HouseDetail">
  <div class="house_desc">
    <h3 class="h3">房屋介绍</h3>
    <p>
      房屋介绍，房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍
      房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍
    </p>
    <p>
      房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍房屋介绍
      房屋介绍房屋介绍房屋介绍房屋介绍
    </p>
  </div>

  <div class="house_parame">
    <h3 class="h3">房屋详情</h3>
    <p>
      <span class="key">房产编号：</span>
      <span class="value">ABC123456</span>
    </p>
    <p>
      <span class="key">房产编号：</span>
      <span class="value">ABC123456</span>
    </p>
    <p>
      <span class="key">房产编号：</span>
      <span class="value">ABC123456</span>
    </p>
    <p>
      <span class="key">房产编号：</span>
      <span class="value">ABC123456</span>
    </p>
    <p>
      <span class="key">房产编号：</span>
      <span class="value">ABC123456</span>
    </p>
    <p>
      <span class="key">房产编号：</span>
      <span class="value">ABC123456</span>
    </p>
    <p>
      <span class="key">房产编号：</span>
      <span class="value">ABC123456</span>
    </p>
    <p>
      <span class="key">房产编号：</span>
      <span class="value">ABC123456</span>
    </p>
  </div>

  <div class="chart">
    <h3 class="h3">租金走势</h3>
  </div>

  <div class="school">
    <h3 class="h3">学校信息</h3>
    <el-row>
      <el-col :span="9">
        <h4 class="h4">学校名字</h4>
        <p>小学：xxxx</p>
        <p>小学：xxxx</p>
        <p>小学：xxxx</p>
      </el-col>
      <el-col :span="6" class="tc">
        <h4 class="h4">评分（满分10分）</h4>
        <p>5</p>
        <p>5</p>
        <p>5</p>
      </el-col>
      <el-col :span="4" class="tc">
        <h4 class="h4">年级</h4>
        <p>4-2</p>
        <p>4-2</p>
        <p>4-2</p>
      </el-col>
      <el-col :span="5" class="tc">
        <h4 class="h4">距离（公里）</h4>
        <p>3.14</p>
        <p>3.14</p>
        <p>3.14</p>
      </el-col>
    </el-row>
  </div>

  <div class="contact_us">
    <h1 class="h1">联系我们</h1>
    欢迎联系房美国 （fangusa.com），请选择以下方式：<br/>
    联系方式1：xxx<br/>
    联系方式2：xxx<br/>
    联系方式3： xxx
    <h3 class="h3">直接填写以下表格联系我们：</h3>
    <el-row type="flex" justify="space-between" class="code-row-bg mb-20">
      <el-col :span="7"><el-input v-model="value1" size="large" placeholder="你的姓名" /></el-col>
      <el-col :span="7"><el-input v-model="value1" size="large" placeholder="联系电话" /></el-col>
      <el-col :span="7"><el-input v-model="value1" size="large" placeholder="邮箱 / 微信 ID （选填）" /></el-col>
    </el-row>
    <el-input v-model="value2" type="textarea" :rows="4" placeholder="" />

    <el-button type="primary">提交</el-button>
  </div>
</section>

</template>
<script>
export default {
  name: "HouseDetail",
  data() {
    return {
      value1: '',
      value2: '我对 L343356 号房源很感兴趣，希望了解更多相关信息。',
    }
  }
}
</script>
<style lang="scss" scoped>
#HouseDetail {
  width: 100%;
  height: auto;
}

.house_desc {
  width: 100%;
  height: auto;
  margin-bottom: 30px;
  background: #fff;
  padding: 30px;

  .h1,
  .h3 {
    padding-bottom: 10px;
    margin-bottom: 20px;
    border-bottom: 1px #e3e8ee solid;
  }

  p { margin-bottom: 20px; }
}

.house_parame {
  @extend .house_desc;
  p {
    margin-bottom: 10px;

    .key {
       width: 80px;
       display: inline-block;
     }
  }
}

.chart {
  @extend .house_desc;
}

.school {
  @extend .house_desc;
  .h4 { margin-bottom: 10px; }
  p { margin-bottom: 10px; }
}

.contact_us {
  @extend .house_desc;
  .h3 { margin-top: 20px; }
  button {
    margin-top: 20px;
    width: 120px;
  }
}
</style>
