$(document).ready(function () {
    var data = [{
        "name": "张三",
        "info": [
            "眼睛",
            "耳朵",
            "鼻子"
        ]
    }, {
        "name": "李四",
        "info": [
            "爸爸",
            "妈妈",
            "妻子"
        ]
    }];

    var myTemplate = Handlebars.compile($("#table-template").html());

    $('#dataList').html(myTemplate(data));
})
;
