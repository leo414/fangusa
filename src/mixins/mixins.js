export const FavMixin = {
  methods: {
    userFav(id) {
      const data = {
        house: id,
      }
      
      this.$http.post(this.API.USER.Fav, data).then(res => {
        if(res) {
          console.log(res)
        }
      })

    }
  },
}