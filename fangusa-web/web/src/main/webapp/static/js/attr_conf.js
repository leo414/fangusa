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
        $("#city").trigger("change");
    });
}
