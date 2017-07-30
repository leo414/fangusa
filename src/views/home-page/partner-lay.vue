<template lang="html">
<div class="container" id="partner">
  <h2 class="h2">
    合作伙伴
  </h2>
  <el-carousel class="partner_list" indicator-position="outside" height="250px" :interval="2000" :autoplay="true">
    <el-carousel-item v-for="(imgGroup, index) in imgListGroup" :key="index">
      <el-row :gutter="20">
        <el-col :span="6" v-for="(img, index2) in imgGroup" :key="index2">
          <div
            @mouseover="currentImgIndex = index2"
            @mouseout="currentImgIndex = ''"
            class="partner_img gray"
            :class="currentImgIndex === index2 ? 'no_gray' : ''"
            :style="background(img)">
          </div>
        </el-col>
      </el-row>
    </el-carousel-item>
  </el-carousel>
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
      ],
      currentImgIndex: '',
    }
  },
  computed: {
    imgListGroup() {
      let data = this.imgList
      let imgListGruop = []
      while(data.length > 0) {
        imgListGruop.push(data.splice(0, 4))
      }
      return imgListGruop
    },
  },

  methods: {
    background(img) {
       return {
        backgroundColor: '#eee',
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

.gray {
  -webkit-filter: grayscale(100%);
  -moz-filter: grayscale(100%);
  -ms-filter: grayscale(100%);
  -o-filter: grayscale(100%);
  filter: grayscale(100%);
  filter: gray;
}

.no_gray {
  filter: none !important;
}

.partner_list {
  margin-top: 20px;
  height: auto;

  .partner_img {
    height: 300px;
  }
}

</style>
