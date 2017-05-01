/**
 * Created by lvxiaojun on 15/11/26.
 */
function addRow() {
    var txt = $("#hiddenTb tbody").html();
    $("#configs").prepend(txt);
    $("#configTable tbody tr:first-child").find(".mselect").multiselect({
        maxHeight: 200,
        buttonWidth: '150px',
        enableCaseInsensitiveFiltering: true,
        onChange: function (option, checked, select) {
            var origVal = $(option).parents("td").next().find("textarea").val();
            var newVal;
            if (checked) {
                newVal = origVal + $(option).val() + "=;";
            } else {
                var reg = $(option).val() + "=(\\(.*\\)|(#?\\w\,?)*);?";
                newVal = origVal.replace(new RegExp(reg), "");
            }
            $(option).parents("td").next().find("textarea").val(newVal).trigger("change");
        }
    });
}
function initMultipleSelect() {
    $("#configs .mselect").multiselect({
        maxHeight: 200,
        buttonWidth: '150px',
        enableCaseInsensitiveFiltering: true,
        onChange: function (option, checked, select) {
            var origVal = $(option).parents("td").next().find("textarea").val();
            var newVal;
            if (checked) {
                newVal = origVal + $(option).val() + "=;";
            } else {
                var reg = $(option).val() + "=(\\(.*\\)|(#?\\w\,?)*);?";
                newVal = origVal.replace(new RegExp(reg), "");
            }
            $(option).parents("td").next().find("textarea").val(newVal).trigger("change");
        }
    });
}
function delRow(row) {
    var id = $(row).parents("tr").find("[name='id']").val();
    if (id != undefined && id != "") {
        $.get('delOneCDC', {id: id}, function (data) {
            if (data.code == 1) {
                $(row).parents("tr").remove();
            } else {
                Modal.alert({msg: "后端删除失败!"});
            }
        });
    } else {
        $(row).parents("tr").remove();
    }
}
function delAllRow() {
    Modal.confirm({msg: "是否删除所有数据？"})
        .on(function (e) {
            if (e) {
                $("#configs").empty();
            }
        });
}
function saveRow(row) {
    var tr = $(row).closest("tr");
    console.log(row);
    console.log(tr);
    var json = JSON.stringify(formatData(tr));
    $.post("saveRow", {data: json}, function (data) {
        if (data.code == 1) {
            $(tr).find("[name='id']").val(data.data);
            $(tr).find("td:first-child").html("<input type='hidden' name='id' value='" + data.data + "'>" + data.data);
            Modal.alert({msg: "保存成功!"});
        } else {
            Modal.alert({msg: "后端保存失败!"});
        }
    });
}

function saveAll() {
    var dataArray = new Array();
    $("#configs > tr").each(function () {
        dataArray.push(formatData($(this)));
    });
    var json = JSON.stringify(dataArray);
    $.post("saveAll", {data: json}, function (data) {
        if (data.code == 1) {
            Modal.alert({msg: "保存成功!点击确定刷新页面!"}, function () {
                setTimeout("window.location.reload()", 3000);
            });
        } else {
            Modal.alert({msg: "后端保存失败!"});
        }
    });
}

function formatData(row) {
    var rowArray = {};
    console.log(row);
    rowArray['key'] = $(row).find("input[name='keyword']").val() ? $(row).find("input[name='keyword']").val() : $('#key_h').val();
    //先查找所有input的
    $(row).find("td > input").each(function () {
        rowArray[$(this).attr('name')] = $(this).val();
    });
    //所有select
    $(row).find("td > select").each(function () {
        var value = "";
        $(this).find("option:selected").each(function () {
            value += $(this).val() + ",";
        });
        value = value.replace(new RegExp(",$"), "");
        if ($(this).attr('name') != "readonly") {
            rowArray[$(this).attr('name')] = value;
        } else {
            rowArray[$(this).attr('name')] = value == 0 ? false : true;
        }

    });
    //所有textarea
    $(row).find("td textarea").each(function () {
        rowArray[$(this).attr('name')] = $(this).val();
    });
    return rowArray;
}

function export_csv() {
    var params = {
        'key': $('#key_h').val(),
    };
    var url = 'exportGroup?' + $.param(params);
    window.location.href = url;
}
function set_orig_val() {
    $("#configTable").find("input[type='text']").each(function () {
        $(this).attr("orig-val", $(this).val())
    });
    //所有select
    $("#configTable").find("select").each(function () {
        var value = "";
        $(this).find("option:selected").each(function () {
            value += $(this).val() + ",";
        });
        value = value.replace(new RegExp(",$"), "");
        $(this).attr("orig-val", value);
    });
    //所有textarea
    $("#configTable").find("textarea").each(function () {
        $(this).attr("orig-val", $(this).val())
    });
    $("#addRow").click(function () {
        addRow();
    });
    $("#delAll").click(function () {
        delAllRow();
    });
    $("#saveAll").click(function () {
        saveAll($(this));
    });
    $("#export").click(function () {
        export_csv();
    });
}

function bind_table_event() {
    $("#configTable").on("focus", "textarea", function (event) {
        $(event.currentTarget).parent().removeClass("area-div-normal").addClass("area-div-lg");
    }).on("focusout", "textarea", function (event) {
        $(event.currentTarget).parent().removeClass("area-div-lg").addClass("area-div-normal");
    }).on("click", "[name='saveRow']", function (event) {
        saveRow(event.currentTarget);
    }).on("click", "[name='delRow']", function (event) {
        delRow(event.currentTarget);
    }).on("change", "input[type='text']", function (event) {
        var el = event.currentTarget;
        if ($(el).val() != $(el).attr("orig-val")) {
            $(el).addClass("bg-change");
        } else {
            $(el).removeClass("bg-change");
        }
        if ($(el).attr("name") == "columnName") {
            var unionNode = $(el).parents("tr").find("[name='columnDescrption']");
            if ($(unionNode).val() == "") {
                $(unionNode).val($(el).val());
            }
        }
    }).on("change", "select", function (event) {
        var el = event.currentTarget;
        var value = "";
        $(el).find("option:selected").each(function () {
            value += $(this).val() + ",";
        });
        value = value.replace(new RegExp(",$"), "");
        if (value != $(el).attr("orig-val")) {
            if ($(el).attr("multiple") == "multiple") {
                $(el).next().find("button:first").addClass("bg-change");
            } else {
                $(el).addClass("bg-change");
            }
        } else {
            if ($(el).attr("multiple") == "multiple") {
                $(el).next().find("button:first").removeClass("bg-change");
            } else {
                $(el).removeClass("bg-change");
            }
        }
    }).on("change", "textarea", function (event) {
        var el = event.currentTarget;
        if ($(el).val() != $(el).attr("orig-val")) {
            $(el).addClass("bg-change");
        } else {
            $(el).removeClass("bg-change");
        }
    });
}

function fill_and_bind_query() {
    $.get("cityJson", function (data) {
        var json = JSON.parse(data.data);
        console.log(json);
        var cityArray = [];
        var cityMap = {};
        json.forEach(function (d) {
            cityArray.push(d['city']);
            cityMap[d['city']['value']] = d;
        });
        util.fillSelect($("#city"), cityArray, 'value', 'label');
        $("#city").change(function () {
            var v = $(this).children('option:selected').val();
            $("#branch").val(cityMap[v].branch);
            console.log(cityMap[v].protocol);
            util.fillSelect($("#protocol"), cityMap[v].protocol, 'value', 'label');
            $("#protocol").trigger("change");
        });
        $("#protocol").change(function () {
            var c = $("#city").children('option:selected').val();
            var p = $(this).children('option:selected').val();
            cityMap[c].protocol.forEach(function (d) {
                if (d.value == p) {
                    util.fillSelect($("#biz"), d.biz, 'value', 'label');
                }
            });
            $("#biz").trigger("change");
        });
        $("#biz").change(function () {
            var c = $("#city").children('option:selected').val();
            var p = $("#protocol").children('option:selected').val();
            var b = $(this).children('option:selected').val();
            cityMap[c].protocol.forEach(function (d) {
                if (d.value == p) {
                    d.biz.forEach(function (d1) {
                        d1.value == b && util.fillSelect($("#product"), d1.product, 'value', 'label');
                        d1.value == b && util.fillSelect($("#section"), d1.section, 'value', 'label');
                    });
                }
            });
        });
        if ($("[name='city_h']").val() != "") {
            $("#city").val($("[name='city_h']").val());
        }
        $("#city").trigger("change");
        if ($("[name='city_h").val() != "") {
            $("#protocol").val($("#protocol_h").val());
            $("#biz").val($("#biz_h").val());
            $("#product").val($("#product_h").val());
            $("#section").val($("#section_h").val());
        }
    });
}


