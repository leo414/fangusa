<template lang="html">
<section class="blog_layout">
  <div class="img_box"></div>

  <header class="header">
    <i class="i date" />
    2017-12-02
    <div class="label">
      <i class="i tag" />
      <span class="theme_color">文章标签</span>
    </div>
  </header>

  <h1 class="title">
    文章标题文章标题文章标题文章标题文章标题文章标题文章标题文章标题文章标题文章标题
  </h1>
  <p class="desc">
    测试内容  测试内容  测试内容  测试内容  测试内容  测试内容  测试内容  测试内容  测试内容
    测试内容  测试内容  测试内容  测试内容  测试内容
  </p>

  <footer class="footer">
    <router-link class="link" to="/">
      继续阅读
      <Icon type="arrow-right-b"></Icon>
    </router-link>

    <section class="author_info">
      <img class="face" src="http://placehold.it/50x50" alt="作者头像">
      <div class="info">
        <h3>托尼张</h3>
        <Icon type="android-person"></Icon>
        签约作者
      </div>
    </section>
  </footer>
</section>
</template>

<script>
import Icon from 'iview/src/components/icon'
export default {
  name: 'BlogLayout',
  components: {
    Icon,
  }
}
</script>

<style lang="scss" scoped>
@import '../../scss/variables.scss';
@import '../../scss/mixins.scss';

.blog_layout {
  height: auto;
  padding: 10px;
  font-size: 12px;
  background: #fff;
}

.img_box {
  position: relative;
  left: 0;
  right: 0;
  padding: 10px;
  width: 100%;
  height: 150px;
  background: url('http://placehold.it/228x150') center center no-repeat;
  background-size: cover;
}

.header {
  margin-top: 10px;

  i { font-size: 12px !important; }

  .label {
    display: inline-block;
    margin-left: 10px;
  }
}

.title {
  margin: 10px 0;
  font-size: 18px;
  color: #000;
  @include text-multiLine-ellipsis(2, 22px)
}

.desc {
  @include text-multiLine-ellipsis(3, 20px)
}

.footer {
  margin-top: 30px;
  font-size: 12px;

  .link {
    display: block;
    margin-bottom: 15px;
  }

  .face {
    margin-right: 5px;
    width: 50px;
    height: 50px;
    border-radius: 50%;
  }

  .info {
    height: 50px;
    padding-top: 5px;
    display: inline-block;
    vertical-align: top;
  }
}
</style>
