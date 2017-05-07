<template>
<section id="CreditComputed">
  <h3>贷款计算器</h3>
  <div class="ivu-input-wrapper ivu-input-type">
    <span class="ivu-icon ivu-input-icon word">$</span>
    <input type="text" placeholder="房屋总价" class="ivu-input" />
  </div>

  <div class="ivu-input-wrapper ivu-input-type">
    <span class="ivu-icon ivu-input-icon word">$</span>
    <input type="text" placeholder="首付金额" class="ivu-input" />
  </div>

  <div class="ivu-input-wrapper ivu-input-type">
    <span class="ivu-icon ivu-input-icon word">%</span>
    <input type="text" placeholder="贷款年利率" class="ivu-input" />
  </div>

  <div class="ivu-input-wrapper ivu-input-type">
    <i class="ivu-icon ivu-icon-android-clipboard ivu-input-icon ivu-input-icon-normal" />
    <input type="text" placeholder="贷款计划" class="ivu-input" />
  </div>

  <div class="ivu-input-wrapper ivu-input-type">
    <span class="ivu-icon ivu-input-icon word">$</span>
    <input type="text" placeholder="Principal" class="ivu-input" />
  </div>

  <i-button class="button" type="error">贷款月供：$900（约￥7200）</i-button>
  <i-button class="button" type="primary">立刻申请贷款</i-button>
  <small class="small">
    贷款计算结果仅供参考，实际利率与贷款金额依个人情况而定。
    <Icon type="ios-information-outline"></Icon>
  </small>

</section>

</template>
<script>
import Button from 'iview/src/components/button'
import Icon from 'iview/src/components/icon'

export default {
  name: "CreditComputed",
  components: {
    iButton: Button,
    Icon,
  },
  data() {
    return {

    }
  }
}
</script>
<style lang="scss" scoped>
#CreditComputed {
  padding: 30px 20px;
  width: 100%;
  background: #fff;
  height: 480px;
}

.ivu-input-wrapper {
  width: 240px;
  margin-bottom: 12px;
}

.ivu-input-icon {
  left: 0;
  font-size: 12px;
  border-right: 1px solid #d7dde4;
}

.ivu-input {
  padding-left: 40px;
}

.word {
  font-size: 12px;
}

.button {
  width: 100%;
  margin-top: 15px;
}

.small {
  display: inline-block;
  transform: scale(.8, .8);
  margin-top: 30px;
  font-size: 12px;

  i {
    font-size: 20px;
    font-weight: bold;
  }
}
</style>
