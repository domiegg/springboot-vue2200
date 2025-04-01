/**
 * Created by LENOVO 2.0 on 2016/10/28.
 */

$(function(){
    function res() {
        w = $(window).innerWidth();
        if(w>992) {
            $(window).scroll(function () {
                var d = $('.comment').offset().top-300;
                if($(this).scrollTop()>1530 && $(this).scrollTop()<d) {
                    $('.textBox').addClass('fixed-top');
                }
                else{
                    $('.textBox').removeClass('fixed-top');
                }
            })
        }

        if(w<=991&&w>=768) {
            //平板上侧边导航的效果
            $('.sorts a').click(function () {
                $(this).siblings('ul').slideToggle(500);
            });

        }
        if(w>=768) {

// 通过控制top ，来显示不同的幻灯片
            function showImg(index){
                var adHeight = $(".slide-box").height();
                $(".menu-slide").stop(true,false).animate({top : -adHeight*index},500);
                $(".menu-list li").removeClass("on")
                    .eq(index).addClass("on");
            }


            var len = $(".menu-list li").length;
            var index = 0;
            var adTimer;
            $(".menu-list li").mouseover(function(){
                index = $(".menu-list li").index(this);
                showImg(index);
            }).eq(0).mouseover();
//滑入停止动画，滑出开始动画
            $('.slide-box').hover(function(){
                clearInterval(adTimer);
            },function(){
                adTimer = setInterval(function(){
                    showImg(index);
                    index++;
                    if(index==len){index=0;}
                } , 4000);
            }).trigger("mouseleave");



        }

    }
    var w;
    res(),$(window).resize(function () {
        res();
    });

    //返回顶部

    $('.return').click(function () {
        $('html,body').animate({
            scrollTop: 0
        },1000)
    })

    //关闭右侧浮动条
    $('.sidebar .closed').click(function () {
        $('.sidebar ol').animate({
            right: -35+'px'
        },200),
            $('.showbar').animate({
                right: 0
            },200)
    });

    $('.showbar').click(function () {
        $(this).animate({
            right: -35+'px'
        },200),
            $('.sidebar ol').animate({
                right: 0
            },200)
    });
    $('.sidebar .vip').hover(function () {
        $('.sidebar-login').fadeToggle(200);
    })

    //详细页的下拉二级导航
    $('.sorts1').hover(function () {
        $(this).children('ul').slideToggle();
    })





    //商品详情等四个导航的效果
    $('.package1-title').find('a').on('click', function (e) {
        var n = $(this),id = n.attr('href');
        return $('html,body').animate(
            {
                scrollTop:$(id).offset().top
            },1000
        ),!1
    })


    //登录注册
    $('.reg_title li').click(function (e) {
        var index = $(this).index();
        $(this).addClass('on').siblings().removeClass('on');
        $('.reg_list').eq(index).addClass('visible').siblings('form').removeClass('visible');
    })
    //列表页商品列表模式切换
    $('.list-pro ul li').click(function () {
        $(this).addClass('on').siblings().removeClass('on');
        var index = $(this).index();
        $('.img-display ul').eq(index).show().siblings().hide();
    })
});



//==================图片详细页函数=====================
//鼠标经过预览图片函数
// 通过鼠标事件调用函数（传入当前鼠标移入的对象）
function preview(img){
}

//图片放大镜效果
$(function(){
});

//图片预览小图移动效果,页面加载时触发
$(function() {
    var tempLength = 0; //临时变量,当前移动的长度
    var viewNum = 5; //设置每次显示图片的个数量
    var moveNum = 2; //每次移动的数量
    var moveTime = 300; //移动速度,毫秒
    var scrollDiv = $(".spec-scroll ul"); //进行移动动画的容器
    var scrollItems = $(".spec-scroll ul li a"); //移动容器里的集合
    var moveLength = scrollItems.eq(0).width() * moveNum; //计算每次移动的长度
    var countLength = (scrollItems.length - viewNum) * scrollItems.eq(0).width(); //计算总长度,总个数*单个长度
});