<template lang="html">
<section id="hot_city" class="container">
  <h1 class="h1">热门城市</h1>
  <Row type="flex" justify="space-between" class="code-row-bg">
    <Coll class="city" span="8"></Coll>
    <Coll class="city" span="8"></Coll>
    <Coll class="city" span="8"></Coll>
    <Coll class="city" span="8"></Coll>
    <Coll class="city" span="8"></Coll>
    <Coll class="city" span="8"></Coll>
  </Row>
</section>
</template>

<script>
import { Row, Col } from 'iview/src/components/grid'
export default {
  name: 'HotCity',
  components: {
    Row,
    Coll: Col,
  },
}
</script>

<style lang="scss" scoped>
#hot_city {
  margin-top: 20px;
}

.h1 {
  padding: 20px 0;
  color: #000;
}

.city {
  width: 330px;
  height: 330px;
  margin-bottom: 28px;
  background: url('http://placehold.it/330x330') center center no-repeat;
  background-size: cover;
}
</style>
