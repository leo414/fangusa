let util = {

}
util.title = function (title) {
    title = title ? title + '' : '房天下';
    window.document.title = title;
}

export default util
