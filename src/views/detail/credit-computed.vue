<template>
<section class="credit_computed">
  <h3 class="h3">贷款计算器</h3>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="房屋总价">
      <el-input disabled :value="price">
        <template slot="append">$</template>
      </el-input>
    </el-form-item>

     <el-form-item label="首付金额">
      <el-input disabled :value="downPayment">
        <template slot="append">$</template>
      </el-input>
    </el-form-item>

     <el-form-item label="首付比例">
      <el-input type="number" v-model.number="form.paymentRatio">
        <template slot="append">%</template>
      </el-input>
    </el-form-item>

    <el-form-item label="贷款计划">
      <el-select v-model="form.months">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
    </el-form-item>

     <el-form-item label="年利率">
      <el-input type="number" v-model.number="form.rate">
        <template slot="append">%</template>
      </el-input>
    </el-form-item>

    <el-button class="button" type="danger">贷款月供：${{monthPayment}}（约￥{{monthPayment | toRMB}}）</el-button>
    <el-button class="button bottom" @click="onSubmit" type="primary">立刻申请贷款</el-button>
  </el-form>
  
  <small class="small">
    贷款计算结果仅供参考，实际利率与贷款金额依个人情况而定。
    <i class="i i-i" />
  </small>

</section>

</template>
<script>
export default {
  name: "CreditComputed",
  props: {
    price: {
      type: Number,
      required: true,
    }
  },
  data() {
    return {
      options: [{
          value: 360,
          label: '30-year fixed'
        }, {
          value: 180,
          label: '15-year fixed'
        }, {
          value: 60,
          label: '5/1 ARM'
        }],
      form: {
        months: 360,// 贷款多少个月
        rate: 4.108, //银行利息多少，单位 %
        paymentRatio: 20,//首付比例，单位 %
      },
    }
  },
  computed: {
    // 首付价格, 单位 $
    downPayment() {
      return this.price * (this.form.paymentRatio / 100)
    },

    // 月供价格, 单位 $
    monthPayment() {
      let { rate, months } = this.form
      rate = rate / 1200
      const Numerator = (this.price  - this.downPayment) * rate
      const Denominator = 1 - Math.pow((1 + rate), -months)
      return (Numerator / Denominator).toFixed(2)
    },
  },
  methods: {
    onSubmit() {

    },
  },
}
</script>
<style lang="scss" scoped>
.credit_computed {
  padding: 25px 20px;
  width: 100%;
  background: #fff;
  height: auto;
}

.h3 {
  margin-bottom: 15px;
}

.word {
  font-size: 12px;
}

.button {
  width: 100%;
  margin-left: 0;
}

.button.bottom {
  margin-top: 15px;
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
