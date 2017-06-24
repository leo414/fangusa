<template>
<section class="credit_computed">
  <h3 class="h3">贷款计算器</h3>

  <div class="el-input">
    <i class="i el-input__icon i-font34" />
    <input 
      placeholder="房屋总价" 
      type="text" 
      class="el-input__inner" 
    />
  </div>

  <div class="el-input">
    <i class="i el-input__icon i-font34" />
    <input 
      placeholder="首付金额" 
      type="text" 
      class="el-input__inner" 
    />
  </div>

   <div class="el-input">
    <i class="i el-input__icon i-baifenbi" />
    <input 
      placeholder="贷款年利率" 
      type="text" 
      class="el-input__inner" 
    />
  </div>

   <div class="el-input">
    <i class="i el-input__icon i-calc" />
    <input 
      placeholder="贷款计划" 
      type="text" 
      class="el-input__inner" 
    />
  </div>

   <div class="el-input">
    <i class="i el-input__icon i-font34" />
    <input 
      placeholder="Principal" 
      type="text" 
      class="el-input__inner" 
    />
  </div>

  <el-button class="button" type="danger">贷款月供：$900（约￥7200）</el-button>
  <el-button class="button" type="primary">立刻申请贷款</el-button>
  <small class="small">
    贷款计算结果仅供参考，实际利率与贷款金额依个人情况而定。
    <i class="i i-i" />
  </small>

</section>

</template>
<script>
export default {
  name: "CreditComputed",
  data() {
    return {}
  }
}
</script>
<style lang="scss" scoped>
.credit_computed {
  padding: 25px 20px;
  width: 100%;
  background: #fff;
  height: 480px;
}

.h3 {
  margin-bottom: 15px;
}

.el-input {
  width: 240px;
  margin-bottom: 12px;
}

.el-input__icon {
  left: 0;
  border-right: 1px solid #d7dde4;
}

.el-input__icon+.el-input__inner {
  padding-left: 40px;
}

.word {
  font-size: 12px;
}

.button {
  width: 100%;
  margin-top: 15px;
  margin-left: 0;
}

.small {
  display: inline-block;
  margin-top: 30px;
  font-size: 12px;

  i {
    font-size: 18px;
    font-weight: bold;
  }
}
</style>
