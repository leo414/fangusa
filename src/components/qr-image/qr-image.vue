<template>
 <div>
  <h2 class="tc">微信扫一扫</h2>
  <qriously :value="text" :size="180" />
</div>  
</template>

<script>
import VueQr from 'vue-qr'

export default {
  name: 'QRImage',
  props: {
    // 房源的 url_object_id 
    houseId: {
      default: '',
      type: String,
    }
  },
  computed: {
    text() {
      return location.origin + '/detail/' + this.houseId
    },
  },
}
</script>

<style>
  
</style>
