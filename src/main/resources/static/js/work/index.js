$(function () {
    //加载图片
    searchImages();
});

function searchImages() {
    var url = "/images/searchImages";
    var params = {};
    execAjax(url, params, callback);

    function callback(result) {
        if (result.success) {
            var data = result.data;
            var _li = $("li");
            var L = _li.size();
            for (var i in data) {
                var images = data[i];
                var url = images.url;
                _li.eq(i).css({
                    "transition": "transform " + ((L - i) * .5) + "s",
                    "background": "url(images/" + url + ")",
                    "transform": "rotateY(" + i * 36 + "deg) translateZ(200px)",
                    "background-size": "100%"
                });
            }
        } else {
            alert(result.message);
        }
    };
}


$(document)[0].onselectstart = function () {
    return false;
}
//
var L = $("li").size();
// $("li").each(function (i) {
//     $(this).css({
//         "transition": "transform " + ((L - i) * .5) + "s",
//         "background": "url(images/d" + (i + 1) + ".jpg)",
//         "transform": "rotateY(" + i * 36 + "deg) translateZ(200px)",
//         "background-size": "100%"
//     });
// });
//
var diffX, x = 0, diffY, y = -15, p = null;
$(document).mousedown(function (e) {
    clearInterval(p);
    var xBe = e.clientX;
    var yBe = e.clientY;
    $(this).bind("mousemove", function (e) {
        //console.log(1);
        var xNo = e.clientX;
        diffX = xNo - xBe;
        xBe = e.clientX;
        x += diffX * .5;
        //
        var yNo = e.clientY;
        diffY = yNo - yBe;
        yBe = e.clientY;
        y -= diffY * .3;
        $(".ctn").css({"transform": "perspective(800px) rotateX(" + y + "deg) rotateY(" + x + "deg) "});

    });
});
//
$(document).mouseup(function () {
    $(this).unbind("mousemove");
    var p = setInterval(function () {
        diffX *= .95;
        diffY *= .95;
        x += diffX * .2;
        y -= diffY * .2;
        $(".ctn").css({"transform": "perspective(800px) rotateX(" + y + "deg) rotateY(" + x + "deg) "});
        if (Math.abs(diffX) < .5 && Math.abs(diffY) < .5) {
            clearInterval(p);
        }
    }, 30);
});