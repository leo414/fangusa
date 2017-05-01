/**
 * Created by lvxiaojun on 15/11/26.
 */
$(function () {
    window.Modal = function () {
        var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
        var alr = $("#ycf-alert");
        var ahtml = alr.html();

        //关闭时恢复 modal html 原样，供下次调用时 replace 用
        //var _init = function () {
        //	alr.on("hidden.bs.modal", function (e) {
        //		$(this).html(ahtml);
        //	});
        //}();

        /* html 复原不在 _init() 里面做了，重复调用时会有问题，直接在 _alert/_confirm 里面做 */


        var _alert = function (options) {
            alr.html(ahtml);	// 复原
            alr.find('.ok').removeClass('btn-success').addClass('btn-primary');
            alr.find('.cancel').hide();
            _dialog(options);

            return {
                on: function (callback) {
                    if (callback && callback instanceof Function) {
                        alr.find('.ok').click(function () {
                            callback(true)
                        });
                    }
                }
            };
        };

        var _confirm = function (options) {
            alr.html(ahtml); // 复原
            alr.find('.ok').removeClass('btn-primary').addClass('btn-success');
            alr.find('.cancel').show();
            _dialog(options);

            return {
                on: function (callback) {
                    if (callback && callback instanceof Function) {
                        alr.find('.ok').click(function () {
                            callback(true)
                        });
                        alr.find('.cancel').click(function () {
                            callback(false)
                        });
                    }
                }
            };
        };

        var _dialog = function (options) {
            var ops = {
                msg: "提示内容",
                title: "操作提示",
                btnok: "确定",
                btncl: "取消"
            };

            $.extend(ops, options);

            console.log(alr);

            var html = alr.html().replace(reg, function (node, key) {
                return {
                    Title: ops.title,
                    Message: ops.msg,
                    BtnOk: ops.btnok,
                    BtnCancel: ops.btncl
                }[key];
            });

            alr.html(html);
            alr.modal({
                width: 500,
                backdrop: 'static'
            });
        }

        return {
            alert: _alert,
            confirm: _confirm
        }

    }();
});

function hiddenSidebar() {
    $("#sidebar").removeClass("col-md-1").addClass("hidden-el");
    $("#main").removeClass("col-md-11").removeClass("col-md-offset-1").addClass("col-md-12");
    $("#hr").removeClass("hidden-el").css('top', $(document).scrollTop() + $(window).height()/2)
        .click(function(){
            displaySidebar();
        });
}

function displaySidebar() {
    $("#hr").addClass("hidden-el");
    $("#sidebar").removeClass("hidden-el").addClass("col-md-1");
    $("#main").removeClass("col-md-12").addClass("col-md-11").addClass("col-md-offset-1");
}

$(window).scroll(function() {
    $("#hr").css('top', $(document).scrollTop() + $(window).height()/2);
});

var sideArray = {
    '/admin/contract/config/configs' : 'index',
    '/admin/contract/config/index' : 'index',
    '/admin/contract/config/trans' : 'trans',
    '/admin/contract/config/attrConf' : 'attr_conf',
    '/admin/contract/config/sealConf' : 'attr_conf'
};

var tabArray = {
    '/admin/contract/config/attrConf' : 'attr_conf_tab',
    '/admin/contract/config/sealConf' : 'seal_conf_tab'
};
var currentUrl = window.location.pathname;
currentUrl = currentUrl.replace(new RegExp('/cp-contract'), '');
$('#' + sideArray[currentUrl]).addClass('active');
$('#' + tabArray[currentUrl]).addClass('active');

var util = {
    fillSelect: function ($dom, dataList, key, name, showBlank) {
        console.log($dom);
        var options = [];
        if (showBlank) options.push('<option></option>')
        dataList.forEach(function (data) {
            options.push('<option value="' + data[key] + '">' + data[name] + '</option>')
        });
        $dom.html(options.join(''));
    }
}