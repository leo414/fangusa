<template lang="html">
<div class="container" id="partner" v-once>
  <h2 class="h2">
    合作伙伴
  </h2>

  <el-row class="partner_list" :gutter="8">
    <el-col :span="6" v-for="(img, index) in imgList" :key="index">
      <div class="item" :style="background(img)"></div>
    </el-col>
  </el-row>  
</div>
</template>

<script>

export default {
  name: 'PartnerLay',
  data() {
    return {
      imgList: [
        '2000px-State_Farm_logo.svg.png',
        'ashton-woods.png',
        'California-Regional-MLS-no-tag.png',
        'ebby_logo.jpg',
        'EWB_Logo_Reg_Eng_Vert_Pos_RGB-61a7fa19c7.png',
        'idx.png',
        'jinjilie_logo.jpg',
        'juranzhijia_logo.jpg',
        'Keller_Williams_Logo.png',
        'MatterportLogo_Navy-b9d1ff8908576314972631116667878cd24eecea09fef907a050cd61760e78b1.png',
        'NTREIS-logo.png',
        'WeWork-Logo_copy.jpg',
      ]
    }
  },
  methods: {
    background(img) {
       return {
        backgroundImage: `url(${process.env.BASE_URL}media/logo/${img})`,
        backgroundSize: 'contain',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
      }
    }
  },
}
</script>

<style lang="scss" scoped>
#partner {
  margin-top: 60px;
}

.partner_list {
  margin-top: 20px;
  height: auto;

  &:last-child {
    margin-top: 8px;
  }

  .item {
    height: 160px;
    margin-bottom: 10px;
    overflow: hidden;
  }
}
</style>
