<template lang="html">
<section id="hot_city_container" class="container">
  <h2 class="h2">热门城市</h2>
  <el-carousel indicator-position="outside" height="700px">
    <el-carousel-item>
      <el-row type="flex" justify="space-between">
        <el-col
          v-for="(img, index) in img_list.slice(0,3)" :key="index"
          class="city"
          :style="img.style"
          @click.native="goFilter(img.text)"
          :span="8">
          {{img.text}}
        </el-col>
      </el-row>

      <el-row type="flex" justify="space-between">
        <el-col
          v-for="(img, index) in img_list.slice(3,6)" :key="index"
          class="city"
          :style="img.style"
          @click.native="goFilter(img.text)"
          :span="8">
          {{img.text}}
        </el-col>
      </el-row>
    </el-carousel-item>

    <el-carousel-item>
      <el-row type="flex" justify="space-between">
        <el-col
          v-for="(img, index) in img_list.slice(6,9)" :key="index"
          class="city"
          :style="img.style"
          @click.native="goFilter(img.text)"
          :span="8">
          {{img.text}}
        </el-col>
      </el-row>

      <el-row type="flex" justify="space-between">
        <el-col
          v-for="(img, index) in img_list.slice(9,12)" :key="index"
          class="city"
          :style="img.style"
          @click.native="goFilter(img.text)"
          :span="8">
          {{img.text}}
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

.city {
  margin-bottom: 28px;
  width: 330px;
  height: 330px;
  line-height: 330px;
  text-align: center;
  color: #fff;
  font-size: 40px;
  font-weight: bold;
  overflow: hidden;
  cursor: pointer;
  text-shadow: 1px 1px rgba(0,0,0,.3);
}
</style>
