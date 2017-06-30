<template>
<section class="house_detail">
  <div class="house_desc">
    <h3 class="h3">房屋介绍</h3>
    <p>{{info.house_desc}}</p>
  </div>

  <div class="house_parame">
    <h3 class="h3">房屋详情</h3>
    <p>
      <span class="key">房产编号：</span>
      <span class="value">ABC123456</span>
    </p>
    <p>
      <span class="key">房屋地址：</span>
      <span class="value">{{info.address}}</span>
    </p>
    <p>
      <span class="key">居住面积：</span>
      <span class="value">{{info.square}}</span>
    </p>
    <p>
      <span class="key">土地面积：</span>
      <span class="value">{{info.lot}}</span>
    </p>
    <p>
      <span class="key">建筑年代：</span>
      <span class="value">{{info.build_year}}</span>
    </p>
    <p>
      <span class="key">房屋类型：</span>
      <span class="value">{{info.house_type}}</span>
    </p>
    <p>
      <span class="key">卧室数：</span>
      <span class="value">{{info.beds}}</span>
    </p>
    <p>
      <span class="key">卫浴数：</span>
      <span class="value">{{info.baths}}</span>
    </p>
    <p>
      <span class="key">私人车库：</span>
      <span class="value">{{info.parking}}</span>
    </p>
    <p>
      <span class="key">物业费（每月）：</span>
      <span class="value">{{info.property_costs}}</span>
    </p>
    <p>
      <span class="key">地产税（每年）：</span>
      <span class="value">{{info.property_tax_history}}</span>
    </p>
    <p>
      <span class="key">预估月租金收入：</span>
      <span class="value">{{info.rent_estimate}}</span>
    </p>
  </div>

  <div class="chart">
    <h3 class="h3">租金走势</h3>
    <chart-line :id="info.url_object_id"></chart-line>
  </div>

  <div class="school">
    <h3 class="h3">学校信息</h3>
    <el-row>
      <el-col :span="9" v-if="info.nearby_schools">
        <h4 class="h4">学校名字</h4>
        <p>小学：{{info.nearby_schools[0].school_name}}</p>
        <p>中学：{{info.nearby_schools[1].school_name}}</p>
        <p>高中：{{info.nearby_schools[2].school_name}}</p>
      </el-col>
      <el-col :span="6" class="tc">
        <h4 class="h4">评分（满分10分）</h4>
        <p :key="index" v-for="(school, index) in info.nearby_schools">{{school.school_score}}</p>
      </el-col>
      <el-col :span="4" class="tc">
        <h4 class="h4">年级</h4>
        <p :key="index" v-for="(school, index) in info.nearby_schools">{{school.school_grade}}</p>
      </el-col>
      <el-col :span="5" class="tc">
        <h4 class="h4">距离（公里）</h4>
        <p :key="index" v-for="(school, index) in info.nearby_schools">{{school.school_distance | toKM}}</p>
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
import ChartLine from './chart-line'
export default {
  name: "HouseDetail",
  components: {
    ChartLine,
  },
  props: {
    info: {
      type: Object,
      default() {
        return {}
      },
    }
  },
  data() {
    return {
      value1: '',
      value2: '我对 L343356 号房源很感兴趣，希望了解更多相关信息。',
    }
  },
  filters: {
    toKM(value) {
      return (Number(value) * 1.61).toFixed(2)
    }
  },
}
</script>
<style lang="scss" scoped>
.house_detail {
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

    // .key {
    //    width: 140px;
    //    display: inline-block;
    //  }
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
