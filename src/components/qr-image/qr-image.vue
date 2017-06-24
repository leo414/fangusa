<template>
 <div>
  <h2 class="tc">微信扫一扫</h2>
  <img :src="qrUrl" alt="请刷新重新获取二维码" />
</div>  
</template>

<script>
export default {
  name: 'QRImage',
  props: {
    // 房源的 url_object_id 
    houseId: {
      required: true,
      type: String,
    }
  },
  data() {
    return {
      baseURL: 'http://qr.liantu.com/api.php',
      w: 180,
      logo: 'https://ws3.sinaimg.cn/large/006tKfTcly1fgw5vvaoxrj30le04iq53.jpg',
    }
  },
  computed: {
    text() {
      return location.origin + '/detail/' + this.houseId
    },

    qrUrl() {
      const { baseURL, w, logo, text } = this
      return `${baseURL}?text=${text}&logo=${logo}&w=${w}`
    }
  },
}
</script>

<style>
  
</style>
