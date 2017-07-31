$(document).ready(function () {
    $(".sign-btn").on("click", function () {
        alert("您要创建一个新用户啦")
    })
    $(".home-describe > h1").on("click", function () {
        $(".home-describe > h1").fadeOut(1000);
    })

    $(".home-describe > h3").on("click", function () {
        $(".home-describe > h1").fadeTo("slow", 0.6);
    })

    $(".search-input").focus("animal", function () {
        $(".home-describe > h1").animate({left: '250px'})
    });

    $(".content-describe").on("click", function () {
        $(".navigation-items").slideUp(1500);
        $(".navigation-items").slideDown(1000);
    })
    $(".navigation ul li > .price").on("click", function () {
        $(".navigation ul li > .price").css("padding: 8px 30px");
    })
    $(".search-btn").on("click", function () {
        alert("你输入的是" + $(".search-input").val());
        $(".search-input").on("focus", function () {
            $(".search-input").val("");
        })
    })


    $(".icon").on("blur",function () {
        $(".fa-pencil").hide();
    })

    $(".icon").on("focus",function () {
        $(".fa-pencil").show();
    });


});