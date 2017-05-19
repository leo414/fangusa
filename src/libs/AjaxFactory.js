import $ from 'jquery'
import Vue from 'vue'
import Message from 'iview/src/components/message'

class AjaxFactory {
  constructor(url, data={}) {
    this.url = url
    this.data = data
  }

  Get() {
    return $.ajax({
      url: this.url,
      type : 'GET',
      dataType : 'json',
      data: this.data,
      timeout : 5000,
      crossDomain : true,
      xhrFields:{
        withCredentials : true
      },
    })
    .fail(() => this.ajaxFail())
  }

  Post() {
    return $.ajax({
      url: this.url,
      type : 'POST',
      dataType : 'json',
      data: this.data,
      timeout : 5000,
      crossDomain : true,
      xhrFields:{
        withCredentials : true
      },
    })
    .fail(() => this.ajaxFail())
  }

  ajaxFail() {
    Message.error('网络错误，请刷新重试！')
  }
}

Vue.mixin({
  beforeDestroy() {
    Message.destroy()
  }
})

export default AjaxFactory
