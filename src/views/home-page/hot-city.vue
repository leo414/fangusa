<template lang="html">
<section id="hot_city_container" class="container" :autoplay="true">
  <h2 class="h2">热门城市</h2>
  <el-carousel indicator-position="outside" height="700px" >
    <el-carousel-item>
      <el-row type="flex" justify="space-between">
        <el-col :span="8" v-for="(img, index) in img_list.slice(0,3)" :key="index">
          <router-link :to="'/result?country=' + img.text" class="category-card">
            <section class="category-card__wrapper">
              <div class="category-card__tint">
                <div
                  class="city category-card__image"
                  :style="img.style"
                >
                  {{img.text}}
                </div>
              </div>
            </section>
          </router-link>
        </el-col>
      </el-row>

      <el-row type="flex" justify="space-between">
        <el-col :span="8" v-for="(img, index) in img_list.slice(3,6)" :key="index">
          <router-link :to="'/result?country=' + img.text" class="category-card">
            <section class="category-card__wrapper">
              <div class="category-card__tint">
                <div
                  class="city category-card__image"
                  :style="img.style"
                >
                  {{img.text}}
                </div>
              </div>
            </section>
          </router-link>

        </el-col>
      </el-row>
    </el-carousel-item>

    <el-carousel-item>
      <el-row type="flex" justify="space-between">
        <el-col :span="8" v-for="(img, index) in img_list.slice(6,9)" :key="index">
          <router-link :to="'/result?country=' + img.text" class="category-card">
            <section class="category-card__wrapper">
               <div class="category-card__tint">
                 <div
                   class="city category-card__image"
                   :style="img.style"
                 >
                  {{img.text}}
                 </div>
              </div>
            </section>
          </router-link>
        </el-col>
      </el-row>

      <el-row type="flex" justify="space-between">
        <el-col :span="8" v-for="(img, index) in img_list.slice(9,12)" :key="index">
          <router-link :to="'/result?country=' + img.text" class="category-card">
            <section class="category-card__wrapper">
               <div class="category-card__tint">
                 <div
                   class="city category-card__image"
                   :style="img.style"
                 >
                  {{img.text}}
                 </div>
              </div>
            </section>
          </router-link>
        </el-col>
      </el-row>
    </el-carousel-item>
  </el-carousel>
</section>
</template>

<script>
const img_list = [
  {
    name: 'hot-1',
    text: '纽约',
  },
  {
    name: 'hot-2',
    text: '波士顿',
  },
  {
    name: 'hot-3',
    text: '芝加哥',
  },
  {
    name: 'hot-4',
    text: '达拉斯',
  },
  {
    name: 'hot-5',
    text: '洛杉矶',
  },
  {
    name: 'hot-6',
    text: '奥斯汀',
  },
  {
    name: 'hot-7',
    text: '休斯敦',
  },
  {
    name: 'hot-8',
    text: '亚特兰大',
  },
  {
    name: 'hot-9',
    text: '旧金山',
  },
  {
    name: 'hot-10',
    text: '迈阿密',
  },
  {
    name: 'hot-11',
    text: '西雅图',
  },
  {
    name: 'hot-12',
    text: '圣地亚哥',
  },
]

export default {
  name: 'HotCity',
  data() {
    const background = img => ({
      backgroundImage: `url(${process.env.BASE_URL}media/img/${img}.png)`,
      backgroundSize: 'cover',
      backgroundRepeat: 'no-repeat',
      backgroundPosition: 'center',
    })
    img_list.forEach(item => item.style = background(item.name))
    return {
      img_list,
    }
  },
  methods: {
    goFilter(city) {
      this.$router.push('/result?country=' + city)
    },
  },
}
</script>

<style lang="scss" scoped>
#hot_city_container {
  margin-top: 20px;
}

.h2 {
  padding: 20px 0;
}

.category-card {
  position: relative;
  display: block;
  width: 100%;
  overflow: hidden;
  cursor: pointer;
}

.category-card__wrapper {
  overflow: hidden;
  position: relative;
  margin-bottom: 20px;
}

.category-card__tint {
  width: 330px;
  height: 330px;
  overflow: hidden;
  -webkit-mask-image: -webkit-radial-gradient(circle,#fff,#000);
}

.city {
  margin-bottom: 28px;
  width: 330px;
  line-height: 330px;
  text-align: center;
  color: #fff;
  font-weight: bold;
  overflow: hidden;
  text-shadow: 1px 1px rgba(0,0,0,.3);
}

.category-card:hover .category-card__image, .category-card:focus .category-card__image, .category-card:active .category-card__image {
  -webkit-transform: scale(1.12);
  -moz-transform: scale(1.12);
  -ms-transform: scale(1.12);
  -o-transform: scale(1.12);
  transform: scale(1.12);
  font-size: 38px;
}

.category-card__image {
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -ms-transform: scale(1);
  -o-transform: scale(1);
  transform: scale(1);
  -webkit-transition: -webkit-transform .35s;
  -moz-transition: -moz-transform .35s;
  transition: transform .35s;
  background-size: cover;
  background-position: center center;
  background-repeat: no-repeat;
  background-color: #EFF2F5;
  font-size: 36px;
}

.category-card:hover .category-card__tint:after, .category-card:focus .category-card__tint:after, .category-card:active .category-card__tint:after {
  opacity: .4;
  background-color: #282C35;
  position: absolute;
  width: 330px;
  height: 330px;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  content: '';
}
</style>
