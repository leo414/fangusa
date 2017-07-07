<template>
<div class="container">
  <h2 class="h2">账户信息</h2>
  <section class="tabs_container">
    <nav class="nav">
      <a :class="seleted === 0 ? 'active' : ''" @click.stop="seleted = 0" class="item">个人资料</a> 
      <a :class="seleted === 1 ? 'active' : ''" @click.stop="seleted = 1" class="item">收藏房源</a> 
    </nav>

    <user-profile v-show="seleted === 0"></user-profile>
    <collection-list  v-show="seleted === 1"></collection-list>
  </section>
</div>  
</template>

<script>
import UserProfile from './user-profile'
import CollectionList from './collection-list'
export default {
  name: 'User',
  components: {
    UserProfile,
    CollectionList,
  },
  data() {
    return {
      activeName: 'user',
      seleted: 0,
    }
  },
}
</script>

<style lang="scss" scoped>
.container {
  margin-top: 30px;
}

.tabs_container {
  background: #fff;

  .nav {
    margin-bottom: 20px;
    width: 100%;
    height: 50px;
    line-height: 50px;
    background: #ededed;

    .active {
      background: #fff;
    }

    .item {
      display: inline-block;
      height: inherit;
      width: 150px;
      color: #000;
      font-size: 18px;
      text-align: center;
    }
  }
}

.h2 {
  padding: 20px 0;
}  
</style>
