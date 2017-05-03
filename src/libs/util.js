let util = {

}
util.title = function (title) {
    title = title ? title + ' - Home' : 'fangusa';
    window.document.title = title;
}

export default util
