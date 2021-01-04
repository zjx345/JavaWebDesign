<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>云音乐-享受生活</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<!--页面框架-->
<div class="firstPage">
    <!--1.首部-->
    <div class="head">
        <!--图标及搜索框-->
        <div class="header">
            <!--logo-->
            <div class="image">
                <a href="index.jsp">
                    <img src="img/musicLogo.png" alt="logo未找到" />
                </a>
            </div>
            <!--搜索框-->
            <div class="search">
                <form action="#" method="get">
                    <input placeholder="李荣浩-爸爸妈妈" class="text" type="text" />
                    <button><i class="fa fa-search"></i></button>
                    <!--<input class="submit" type="submit" width="30px" height="30px"/>-->
                </form>
            </div>
            <!--管理中心-->
            <div class="manager">
                <dl>
                    <dd><a href="JavaScript:void(0);">客服中心</a></dd>
                    <dd><a href="JavaScript:void(0);">招贤纳士</a></dd>
                    <dd><a href="JavaScript:void(0);">会员中心</a></dd>
                </dl>
            </div>
            <div class="delimiter">
                <font>|</font>
            </div>
            <!--登录-->
            <div class="login">
                <input type="button" class="login_button" value="登  录">
            </div>

            <div class="register">
                <input type="button" class="register_button" value="注  册" >
            </div>

        </div>
        <!--导航栏-->
        <div class="guide">
            <div class="bigGuide">
                <!--导航栏左-->
                <div class="guideLeft">
                    <dl>
                        <dd><div><a href="JavaScript:void(0);">&nbsp;&nbsp;&nbsp;首页&nbsp;&nbsp;&nbsp;</a></div></dd>
                        <dd><div><a href="folkMusicRankList.jsp">&nbsp;&nbsp;&nbsp;榜单&nbsp;&nbsp;&nbsp;</a></div></dd>
                        <dd><div><a href="JavaScript:void(0);">下载客户端</a></div></dd>
                        <dd class="drop">
                            <div>
                                <a href="JavaScript:void(0);">&nbsp;&nbsp;&nbsp;更多
                                    <i class="fa fa-angle-down"></i>&nbsp;&nbsp;&nbsp;
                                </a>
                            </div>
                            <ul class="drop_list">
                                <li><div><a href="JavaScript:void(0);">电台</a></div></li>
                                <li><div><a href="html框架2.html">MV</a></div></li>
                                <li><div><a href="JavaScript:void(0);">歌单</a></div></li>
                                <li><div><a href="JavaScript:void(0);">歌手</a></div></li>
                            </ul>
                        </dd>
                    </dl>
                </div>
                <!--导航栏右-->
                <div class="guideRight">
                    <dl>
                        <dd>
                            <a href="JavaScript:void(0);"><i class="fa fa-star-o"></i>&nbsp;直播</a></dd>
                        <dd>
                            <a href="JavaScript:void(0);"><i class="fa fa-shopping-cart"></i>&nbsp;商城</a></dd>
                        <dd>
                            <a href="JavaScript:void(0);"><i class="fa fa-music"></i>&nbsp;音乐人</a></dd>
                        <dd>
                            <a href="JavaScript:void(0);"><i class="fa fa-star-o"></i>&nbsp;代理商</a></dd>
                        <dd>
                            <a href="JavaScript:void(0);"><i class="fa fa-star-o"></i>&nbsp;直播平台</a></dd>
                        <dd>
                            <a href="JavaScript:void(0);"><i class="fa fa-puzzle-piece"></i>&nbsp;开放平台</a></dd>
                    </dl>
                </div>
            </div>
        </div>
        <!--登录窗口-->
        <div class="loginFrame"> </div>
        <div class="loginArea">
            <div class="login_close"><i class="fa fa-close"></i></div>
            <h2 class="login_title">登录酷狗音乐</h2>
            <form>
                <input class="login_account" type="text" placeholder="请输入账号"><br>
                <input class="login_password" type="text" placeholder="请输入密码"><br>
                <input class="login_identity user" type="radio" name="identity" value="用户" checked="checked">用户
                <input class="login_identity admin" type="radio" name="identity" value="管理员">管理员<br>
                <input class="login_button" type="button" value="登录">
            </form>
        </div>

        <!--轮播图-->
        <div class="rotationChart">
            <img src="img/轮播图1.png" id="imgRotationChart" alt="轮播图"/>
        </div>
        <!--下载选项-->
        <div class="download">
            <img src="img/computer .png" alt="图片加载中......"/>
            <a href="JavaScript:void(0);">下载PC版</a>
            <span class="line"></span>
            <img src="img/apple.png" alt="图片加载中......"/>
            <a href="JavaScript:void(0);">下载iPhone版</a>
            <span class="line"></span>
            <img src="img/android.png" alt="图片加载中......"/>
            <a href="JavaScript:void(0);">下载Android版</a>
        </div>
    </div>
    <!--2.精选歌单-->
    <div class="jxgd">
        <!--精选歌单导航-->
        <div class="jxgdGuide">
            <!--精选歌单-->
            <div class="jxgd_left">
                <span class="fisrt"><a href="JavaScript:void(0);">精选</a></span>
                <span class="second"><a href="JavaScript:void(0);">歌单</a></span>
                <span class="alink"><a href="JavaScript:void(0);">更多</a></span>
            </div>
            <!--热门榜单-->
            <div class="jxgd_right">
                <span class="fisrt"><a href="JavaScript:void(0);">热门</a></span>
                <span class="second"><a href="JavaScript:void(0);">榜单</a></span>
                <span class="alink"><a href="JavaScript:void(0);">更多</a></span>
            </div>
        </div>
        <!--内容-->
        <div class="content">
            <!--精选歌单内容-->
            <div class="jxgd_left_content">
                <a href="JavaScript:void(0);"><img src="img/jx1.png" width="368px" height="365px" alt="精选图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/jx2.png" width="181px" height="181px" alt="精选图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/jx3.png" width="181px" height="181px" alt="精选图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/jx4.png" width="181px" height="181px" alt="精选图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/jx5.png" width="181px" height="181px" alt="精选图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
            </div>
            <!--热门榜单内容-->
            <div class="jxgd_right_content">
                <a href="JavaScript:void(0);"><img src="img/jx6.png" width="360px" height="108px" alt="精选图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/jx7.png" width="360px" height="108px" alt="精选图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/jx8.png" width="360px" height="108px" alt="精选图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
            </div>
        </div>
        <!--3.广告图-->
        <div class="advertise">
            <img src="img/ggt1.png" alt="广告图" />
        </div>
    </div>
    <!--3.新歌首发-->
    <div class="xgsf">
        <!--新歌首发导航栏-->
        <div class="xgsfGuide">
            <!--新歌首发-->
            <div class="xgsf_left">
                <span class="fisrt"><a href="JavaScript:void(0);">新歌</a></span>
                <span class="second"><a href="JavaScript:void(0);">首发</a></span>
                <span class="third"><a href="JavaScript:void(0);">华语</a></span>
                <span class="third"><a href="JavaScript:void(0);">欧美</a></span>
                <span class="third"><a href="JavaScript:void(0);">韩国</a></span>
                <span class="third"><a href="JavaScript:void(0);">日版</a></span>
                <button class="pallAll">
							<span>
							<i class="fa fa-play"></i>
							全部播放
							</span>
                </button>
            </div>
            <!--推荐MV-->
            <div class="xgsf_right">
                <span class="fisrt"><a href="JavaScript:void(0);">推荐</a></span>
                <span class="second"><a href="JavaScript:void(0);">MV</a></span>
                <span class="alink"><a href="JavaScript:void(0);">更多</a></span>
            </div>
        </div>
        <!--内容-->
        <div class="content">
            <!--新歌首发内容-->
            <div class="xgsf_left_content">
                <div class="singleHr"><hr/></div>
                <div class="musicName">
                    <div>
                        <a href="JavaScript:void(0);">
                            <span>OneRepublic - Wild Life</span>
                            <span class="flag">
									<!--<i class="fa fa-play"></i>
									<i class="fa fa-download"></i>-->
									</span>
                            <span class="time">04:27</span></a>
                    </div>
                    <div>
                        <a href="JavaScript:void(0);"><span>Melanie Martinez - Notebook(Explcit)</span>
                            <span class="time">02:30</span></a>
                    </div>
                    <div>
                        <a href="JavaScript:void(0);"><span>Sia - Courage to Change</span>
                            <span class="time">04:52</span></a>
                    </div>
                    <div>
                        <a href="JavaScript:void(0);"><span>Travis Scott、YoungThug、M.I.A - FRANCHISE(Explicit)</span>
                            <span class="time">03:22</span></a>
                    </div>
                    <div>
                        <a href="JavaScript:void(0);"><span>Tiesto - The business(Explicit)</span>
                            <span class="time">02:44</span></a>
                    </div>
                    <div>
                        <a href="JavaScript:void(0);"><span>Clean Bandit、Mabel、24KGoldn - Tick Tock(Sam feldt Remit)</span>
                            <span class="time">02:34</span></a>
                    </div>
                    <div>
                        <a href="JavaScript:void(0);"><span>R3hab、Nina Nesbitt - Family Values</span>
                            <span class="time">02:30</span></a>
                    </div>
                    <div>
                        <a href="JavaScript:void(0);"><span>Slushii - All I Need</span>
                            <span class="time">04:45</span></a>
                    </div>
                </div>

            </div>
            <!--推荐内容-->
            <div class="xgsf_right_content">
                <a href="JavaScript:void(0);"><img src="img/xg1.png" alt="推荐图片"/>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/xg2.png" alt="推荐图片"/>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/xg3.png" alt="推荐图片"/>
                    <i class="fa fa-play-circle-o"></i>
                </a>
            </div>
            <!--5.广告图-->
            <div class="advertise">
                <img src="img/ggt2.png" alt="广告图"/>
            </div>
        </div>
    </div>
    <!--4.热门电台-->
    <div class="rmdt">
        <!--热门电台导航-->
        <div class="rmdtGuide">
            <div class="rmdt_left">
                <span class="fisrt"><a href="JavaScript:void(0);">热门</a></span>
                <span class="second"><a href="JavaScript:void(0);">电台</a></span>
                <span class="alink"><a href="JavaScript:void(0);">更多</a></span>
            </div>
            <!--热门歌手-->
            <div class="rmdt_right">
                <span class="fisrt"><a href="JavaScript:void(0);">热门</a></span>
                <span class="second"><a href="JavaScript:void(0);">歌手</a></span>
                <span class="third"><a href="JavaScript:void(0);">华语</a></span>
                <span class="third"><a href="JavaScript:void(0);">欧美</a></span>
                <span class="third"><a href="JavaScript:void(0);">日韩</a></span>
                <span class="alink"><a href="JavaScript:void(0);">更多</a></span>
            </div>
        </div>
        <!--内容-->
        <div class="content">
            <!--左-->
            <div class="rmdt_left_content">
                <a href="JavaScript:void(0);"><img src="img/rm1.png" alt="热门图片" /><br />
                    <span>KTV必点曲
						</span>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/rm2.png" alt="热门图片" /><br />
                    <span>中文DJ
						</span>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/rm3.png" alt="热门图片" /><br />
                    <span>酷狗热歌
						</span>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/rm4.png" alt="热门图片" /><br />
                    <span>网络红歌
						</span>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/rm5.png" alt="热门图片" /><br />
                    <span>经典
						</span>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/rm6.png" alt="热门图片" /><br />
                    <span>老情歌
						</span>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/rm7.png" alt="热门图片" /><br />
                    <span>新歌
						</span>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/rm8.png" alt="热门图片" /><br />
                    <span>动漫
						</span>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/rm9.png" alt="热门图片" /><br />
                    <span>轻音乐
						</span>
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a href="JavaScript:void(0);"><img src="img/rm10.png" alt="热门图片" /><br />
                    <span>最爱成名曲
						</span>
                    <i class="fa fa-play-circle-o"></i>
                </a>
            </div>
            <!--右-->
            <div class="rmdt_right_content">
                <a>
                    <img src="img/rm11.png" alt="热门图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a>
                    <img src="img/rm12.png" alt="热门图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a>
                    <img src="img/rm13.png" alt="热门图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a>
                    <img src="img/rm14.png" alt="热门图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
                <a>
                    <img src="img/rm15.png" alt="热门图片" />
                    <i class="fa fa-play-circle-o"></i>
                </a>
            </div>
        </div>
        <!--7.广告图-->
        <div class="advertise">
            <img src="img/ggt3.png" alt="广告图" />
        </div>
    </div>
    <!--5.友情连接-->
    <div class="yqlj">
        <div class="yqljGuide">
            <span class="fisrt"><a href="JavaScript:void(0);">友情</a></span>
            <span class="second"><a href="JavaScript:void(0);">连接</a></span>
            <span class="alink"><a href="JavaScript:void(0);">更多</a></span>
        </div>
        <div class="yqljContent">
            <a href="JavaScript:void(0);">爱美网</a>
            <a href="JavaScript:void(0);">汽车论坛</a>
            <a href="JavaScript:void(0);">IT之家</a>
            <a href="JavaScript:void(0);">iPhone游戏</a>
            <a href="JavaScript:void(0);">旅游攻略</a>
            <a href="JavaScript:void(0);">华为商城</a>
            <a href="JavaScript:void(0);">365音乐网</a>
            <a href="JavaScript:void(0);">软件下载</a>
            <a href="JavaScript:void(0);">漫漫看漫画</a>
            <a href="JavaScript:void(0);">手机游戏</a>
            <a href="JavaScript:void(0);">5sing原创音乐</a>
            <a href="JavaScript:void(0);">腾讯音乐人</a>
            <a href="JavaScript:void(0);">豌豆荚</a>
            <a href="JavaScript:void(0);">5sing众筹</a>
            <a href="JavaScript:void(0);">智能电视网</a>
            <a href="JavaScript:void(0);">北京快网</a>
            <a href="JavaScript:void(0);">07073网页游戏</a>
            <a href="JavaScript:void(0);">站长之家</a>
        </div>
    </div>
    <!--9.结尾-->
    <div class="end">
        <!--导航-->
        <div class="endGuide">
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">关于酷狗</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">监督举报</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">商务合作</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">广告服务</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">投诉指引</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">隐私政策</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">儿童隐私政策</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">用户服务协议</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">酷狗音乐人</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">酷狗直通车</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">招聘信息</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">客服中心</a>&nbsp;&nbsp;|</span>
            <span>&nbsp;&nbsp;<a href="JavaScript:void(0);">用户体验提升计划</a>&nbsp;&nbsp;</span>
        </div>
        <!--水平线-->
        <div class="hrs">
            <hr />
        </div>
        <!--温馨提示-->
        <div class="endContent">
					<span>
					我们致力于推动网络正版音乐发展，相关版权合作请联系copyrights@kugou.com
					</span>
            <span>
					信息网络传播视听节目许可证1910564增值电信业务经营许可证库B2-20060339&nbsp;&nbsp;粤ICP备09017694号
					<img src="img/footer_icon.png"/>
					</span>
            <span>
					广播电视节目制作经营许可证（粤）字第01270号&nbsp;&nbsp;营业性演出许可证穗天演440106026&nbsp;营业执照
					</span>
            <span>
					穗公网监备案证第44010650010167&nbsp;&nbsp;互联网药品信息服务资格证编号 （粤） -非经营性2012-0018&nbsp;粤公网安备44010602000141号
					<img src="img/icon_yuewangga1.png"/>
					</span>
            <span>
					互联网不良信息举报中心: www.12377.cn&nbsp;&nbsp;酷狗不良信息举报邮箱: jubao_music@kugou.net&nbsp;&nbsp;客服邮箱: kefu@kugou.net
					</span>
            <span>
					Copyright&nbsp;&copy;&nbsp;2004-2020 KuGou-Inc.All Rights Reserved
					</span>
        </div>
        <div class="endDiv"></div>
    </div>
</div>
<script>
    var num = 0;
    function fun(){
        num ++;
        var nums= (num % 4) + 1;
        var img = document.getElementById("imgRotationChart");
        img.src ="img/轮播图" + nums + ".png";
    }
    setInterval(fun,3000);
</script>
</body>
</html>
