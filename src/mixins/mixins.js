export const FavMixin = {
  methods: {
    userFav(id) {
      const data = {
        house: id,
      }
      
      this.$http.post(this.API.USER.Fav, data).then(res => {
        // TODO 这里用 house 字段来检查的
        if(res.house) {
          this.$message.success('收藏成功！')
        }
      }).catch(error => {
        if(error.non_field_errors) {
          this.$message.warning('已经收藏过该房源，请在个人中心查看！')
        }
      })

    }
  },
}