<template lang="html">
<router-link tag="article" :to="'/article/' + info.id" class="blog_layout">
  <div class="img_box" :style="background"></div>

  <header class="header">
    <i class="i i-date" />
    {{info.add_time.substring(0, 10)}}
    <div class="label">
      <i class="i i-tag" />
      <span class="theme_color">{{info.tags[0] || ''}}</span>
      <span class="theme_color">{{info.tags[1] || ''}}</span>
    </div>
  </header>

  <h3 class="title text_ellipsis">{{info.title}}</h3>
  <p class="desc">{{info.contect_bref}}</p>

  <footer class="footer">
    <router-link class="link" to="/">
      继续阅读
      <i class="i i-youjiantou" />
    </router-link>

    <section class="author_info">
      <img class="face" :src="info.author_image" alt="作者头像">
      <div class="info">
        <h4 class="text_ellipsis">{{info.author_name}}</h4>
        <i class="i i-user" />
        签约作者
      </div>
    </section>
  </footer>
</router-link>
</template>

<script>
export default {
  name: 'BlogLayout',
  props: {
    info: {
      type: Object,
    }
  },
  computed: {
    background() {
      return {
        backgroundImage: 'url('+ this.info.front_image +')',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
      }
    }
  },
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
  cursor: pointer;
}

.img_box {
  position: relative;
  left: 0;
  right: 0;
  padding: 10px;
  width: 100%;
  height: 150px;
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
  color: #324057;
  // @include text-multiLine-ellipsis(2, 22px)
}

.desc {
  height: auto;
  @include text-multiLine-ellipsis(3, 20px)
}

.footer {
  margin-top: 20px;
  font-size: 12px;

  i { font-size: 14px; }

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
