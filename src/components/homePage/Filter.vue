<template>
<div>
  <section id="filter_container">
    <input type="text" placeholder="房源编号 / 邮编 / 地址" class="input" />
    <div class="select_list">
      <multiselect
        v-model="value"
        :options="options"
        :searchable="false"
        :close-on-select="true"
        :show-labels="false"
        placeholder="Pick a value"
        v-for="n in 6" :key="n"
      />
    </div>
    <div class="range_ctrl">
      价格区间：
      <p class="fr">美元<mt-switch v-model="switch1"></mt-switch>人民币</p>
    </div>
    <div class="range_box">
      <span class="range_label">开始：</span>
      <mt-range v-model="rangeValue">
        <div slot="start">0</div>
        <div slot="end">100</div>
      </mt-range>
    </div>
    <div class="range_box">
      <span class="range_label">结束：</span>
      <mt-range v-model="rangeValue">
        <div slot="start">0</div>
        <div slot="end">100</div>
      </mt-range>
    </div>

    <div class="range_ctrl">
      房屋面积：
      <p class="fr">平方英尺<mt-switch v-model="switch1"></mt-switch>平方米</p>
    </div>
    <div class="range_box">
      <span class="range_label">开始：</span>
      <mt-range v-model="rangeValue">
        <div slot="start">0</div>
        <div slot="end">100</div>
      </mt-range>
    </div>
    <div class="range_box">
      <span class="range_label">结束：</span>
      <mt-range v-model="rangeValue">
        <div slot="start">0</div>
        <div slot="end">100</div>
      </mt-range>
    </div>
    <mt-button class="btn" @click.native="handleClick" size="large" type="primary">提交</mt-button>
    <mt-button class="btn go_back" @click.native="$router.go(-1)" size="large" type="primary">取消</mt-button>
  </section>
</div>


</template>

<script>
import Multiselect from 'vue-multiselect'

export default {
  name: "Filter",
  components: { Multiselect },
  data () {
    return {
      value: '',
      options: ['Select option', 'options', 'selected', 'mulitple', 'label', 'searchable', 'clearOnSelect', 'hideSelected', 'maxHeight', 'allowEmpty', 'showLabels', 'onChange', 'touched'],
      rangeValue: 2,
      rangeValue2: 4,
      switch1: false,
    }
  },
  methods: {

  },
}
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style lang="scss" scoped>
@import "../../scss/variables";

#filter_container {
  width: 100%;
  height: auto;
  min-height: 100vh;
  padding: 20px;
  background: #fff;
}

.input {
  width: 100%;
  height: 40px;
  padding-left: 10px;
  display: inline-block;
  border: none;
  outline: none;
  background: none;
  border-radius: 4px;
  border: 1px solid rgba(60,60,60,.15);
}

.multiselect {
  margin-top: 15px;
  margin-right: 4%;
  width: 48%;
  display: inline-block;

  &:nth-child(2n+0) {
    margin-right: 0;
  }
}

.range_ctrl {
  margin-top: 10px;
  font-size: 16px;
  height: 40px;
  line-height: 40px;

  .mint-switch {
    display: inline-block;
    padding-top: 5px;
    vertical-align: top;
  }

  .fr {
    width: 60%;
    font-size: 14px;
    text-align: right;
  }
}

.range_box {
  margin-bottom: 10px;
  display: flex;
  width: 100%;
  height: 30px;
  line-height: 30px;

  .range_label {
    width: 44px;
    font-size: 14px;
  }

  .mt-range {
    flex: 1;
  }
}

.btn {
  margin-top: 15px;
  background: $theme_color;
}

.go_back {
  display: block;
  width: 100%;
  height: 40px;
  line-height: 40px;
  text-align: center;
  color: $content_color;
  background: #ccc;
}

.go_back {
  background: #ccc;
}
</style>
