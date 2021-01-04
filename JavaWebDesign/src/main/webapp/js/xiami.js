$(function () {
    /*双击播放*/
    $(".songList").dblclick(function(){
        var sid = $(this).find(".start em").html();
        $(".start em[sonN="+sid+"]").click();
    });
    /*底部进度条控制*/
    $( ".dian" ).draggable({
        containment:".pro2",
        drag: function() {
            var l=$(".dian").css("left");
            var le = parseInt(l);
            audio.currentTime = audio.duration*(le/678);
        }
    });
    /*音量控制*/
    $( ".dian2" ).draggable({
        containment:".volControl",
        drag: function() {
            var l=$(".dian2").css("left");
            var le = parseInt(l);
            audio.volume=(le/80);
        }
    });
    /*底部播放按钮*/
    $(".playBtn").click(function(){
        var p = $(this).attr("isplay");
        if (p==0) {
            $(this).css("background-position","0 -30px");
            $(this).attr("isplay","1");
        };
        if (p==1) {
            $(this).css("background-position","");
            $(this).attr("isplay","0");
        };
        if(audio.paused)
            audio.play();
        else
            audio.pause();

    });
    $(".mode").click(function(){
        // var t = calcTime(Math.floor(audio.currentTime))+'/'+calcTime(Math.floor(audio.duration));
        // //alert(t);
        // var p =Math.floor(audio.currentTime)/Math.floor(audio.duration);
        // alert(p);
        //alert(lytext[1]);
    });
    /*切歌*/
    $(".prevBtn").click(function(){
        var sid = parseInt(songIndex)-1;
        $(".start em[sonN="+sid+"]").click();
    });
    $(".nextBtn").click(function(){
        var sid = parseInt(songIndex)+1;
        $(".start em[sonN="+sid+"]").click();
    });
});

