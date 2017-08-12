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

    $(".search-input").on("blur", function () {
        var inputValue = $(".search-input").val();
        $.ajax({
            type: "POST",
            url: "users",
            data: {"id": "7", "name": inputValue, "age": "24"},
            success: function (res) {
                alert(inputValue + "\t" +"was insert succeed!")
            },
            error: function () {
                alert('error');
            }
        }),
            $(".search-input").on("focus", function () {
                    $(".search-input").val("");
                }
            )
    })


    $(".icon").on("blur", function () {
        console.log('blur')
        $(".fa-pencil").hide();
    })

    $(".icon").on("focus", function () {
        console.log('focus')
        $(".fa-pencil").show();
    });

    $(".portrait-one").on("click", function () {
        $.ajax({
            type: "GET",
            url: "/user",
            data: {"id": 1},
            success: function (res) {
                $(".footer-name").text(res)
            },
            error: function () {
                alert('error');
            }
        })
    });

    $(".portrait-two").on("click", function () {
        $.ajax({
            type: "GET",
            url: "/user",
            data: {"id": 2},
            success: function (res, status) {
                $(".footer-name").text(res)
                $(".footer-position").text(status)
            }
        })
    });

    $(".portrait-three").on("click", function () {
        $.ajax({
            type: "GET",
            url: "/user",
            data: {"id": 3},
            success: function (res) {
                $(".footer-name").text(res)
            }
        })
    });
});