<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<!--[if IE 8]><html lang="en" class="ie8 no-js"><![endif]-->
<!--[if IE 9]><html lang="en" class="ie9 no-js"><![endif]-->
<!--[if !IE]><!--><html lang="en" class="no-js"><!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8" />
    <title>${pd.TITLE}</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
    <link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>
    <link href="media/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
    <link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <!-- END GLOBAL MANDATORY STYLES -->
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="page-header-fixed">

<!-- BEGIN HEADER -->
    <div class="header navbar navbar-inverse navbar-fixed-top">
    <!-- BEGIN TOP NAVIGATION BAR -->
    <div class="navbar-inner">
        <div class="container-fluid">
            <!-- BEGIN LOGO -->
            <a class="brand" href="javascript:void(0);" id="brandOnclick">
                <img src="media/image/logo.png" alt="logo"/>
            </a>
            <!-- END LOGO -->
            <!-- BEGIN RESPONSIVE MENU TOGGLER -->
            <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
                <img src="media/image/menu-toggler.png" alt="" />
            </a>
            <!-- END RESPONSIVE MENU TOGGLER -->

            <!-- BEGIN TOP NAVIGATION MENU -->
            <ul class="nav pull-right">
                <%--<!-- BEGIN NOTIFICATION DROPDOWN -->--%>
                <%--<li class="dropdown" id="header_notification_bar">--%>
                <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                <%--<i class="icon-warning-sign"></i>--%>
                <%--<span class="badge">6</span>--%>
                <%--</a>--%>
                <%--<ul class="dropdown-menu extended notification">--%>
                <%--<li>--%>
                <%--<p>You have 14 new notifications</p>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<span class="label label-success"><i class="icon-plus"></i></span>--%>
                <%--New user registered.--%>
                <%--<span class="time">Just now</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<span class="label label-important"><i class="icon-bolt"></i></span>--%>
                <%--Server #12 overloaded.--%>
                <%--<span class="time">15 mins</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<span class="label label-warning"><i class="icon-bell"></i></span>--%>
                <%--Server #2 not respoding.--%>
                <%--<span class="time">22 mins</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<span class="label label-info"><i class="icon-bullhorn"></i></span>--%>
                <%--Application error.--%>
                <%--<span class="time">40 mins</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<span class="label label-important"><i class="icon-bolt"></i></span>--%>
                <%--Database overloaded 68%.--%>
                <%--<span class="time">2 hrs</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<span class="label label-important"><i class="icon-bolt"></i></span>--%>
                <%--2 user IP blocked.--%>
                <%--<span class="time">5 hrs</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li class="external">--%>
                <%--<a href="#">See all notifications <i class="m-icon-swapright"></i></a>--%>
                <%--</li>--%>
                <%--</ul>--%>
                <%--</li>--%>
                <%--<!-- END NOTIFICATION DROPDOWN -->--%>

                <!-- BEGIN INBOX DROPDOWN -->
                <li class="dropdown" id="header_inbox_bar">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="icon-envelope"></i>
                        <span class="badge">5</span>
                    </a>
                    <ul class="dropdown-menu extended inbox">
                        <li>
                            <p>You have 12 new messages</p>
                        </li>
                        <li>
                            <a href="inbox.html?a=view">
                                <span class="photo"><img src="media/image/avatar2.jpg" alt="" /></span>
									<span class="subject">
									<span class="from">Lisa Wong</span>
									<span class="time">Just Now</span>
									</span>
									<span class="message">
									Vivamus sed auctor nibh congue nibh. auctor nibh
									auctor nibh...
									</span>
                            </a>
                        </li>
                        <li>
                            <a href="inbox.html?a=view">
                                <span class="photo"><img src="./media/image/avatar3.jpg" alt="" /></span>
								<span class="subject">
								<span class="from">Richard Doe</span>
								<span class="time">16 mins</span>
								</span>
								<span class="message">
								Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh
								auctor nibh...
								</span>
                            </a>
                        </li>

                        <li>

                            <a href="inbox.html?a=view">

                                <span class="photo"><img src="./media/image/avatar1.jpg" alt="" /></span>

								<span class="subject">

								<span class="from">Bob Nilson</span>

								<span class="time">2 hrs</span>

								</span>

								<span class="message">

								Vivamus sed nibh auctor nibh congue nibh. auctor nibh

								auctor nibh...

								</span>
                            </a>
                        </li>

                        <li class="external">
                            <a href="inbox.html">See all messages <i class="m-icon-swapright"></i></a>
                        </li>
                    </ul>
                </li>
                <!-- END INBOX DROPDOWN -->

                <!-- BEGIN TODO DROPDOWN -->
                <li class="dropdown" id="header_task_bar">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="icon-tasks"></i>
                        <span class="badge">5</span>
                    </a>
                    <ul class="dropdown-menu extended tasks">
                        <li>
                            <p>You have 12 pending tasks</p>
                        </li>
                        <li>
                            <a href="#">

								<span class="task">

								<span class="desc">New release v1.2</span>

								<span class="percent">30%</span>

								</span>

								<span class="progress progress-success ">

								<span style="width: 30%;" class="bar"></span>

								</span>

                            </a>

                        </li>

                        <li>

                            <a href="#">

								<span class="task">

								<span class="desc">Application deployment</span>

								<span class="percent">65%</span>

								</span>

								<span class="progress progress-danger progress-striped active">

								<span style="width: 65%;" class="bar"></span>

								</span>

                            </a>

                        </li>

                        <li>

                            <a href="#">

								<span class="task">

								<span class="desc">Mobile app release</span>

								<span class="percent">98%</span>

								</span>

								<span class="progress progress-success">

								<span style="width: 98%;" class="bar"></span>

								</span>

                            </a>

                        </li>

                        <li>

                            <a href="#">

								<span class="task">

								<span class="desc">Database migration</span>

								<span class="percent">10%</span>

								</span>

								<span class="progress progress-warning progress-striped">

								<span style="width: 10%;" class="bar"></span>

								</span>

                            </a>

                        </li>

                        <li>

                            <a href="#">

								<span class="task">

								<span class="desc">Web server upgrade</span>

								<span class="percent">58%</span>

								</span>

								<span class="progress progress-info">

								<span style="width: 58%;" class="bar"></span>

								</span>

                            </a>

                        </li>

                        <li>

                            <a href="#">

								<span class="task">

								<span class="desc">Mobile development</span>

								<span class="percent">85%</span>

								</span>

								<span class="progress progress-success">

								<span style="width: 85%;" class="bar"></span>

								</span>

                            </a>

                        </li>

                        <li class="external">

                            <a href="#">See all tasks <i class="m-icon-swapright"></i></a>

                        </li>

                    </ul>

                </li>
                <!-- END TODO DROPDOWN -->

                <!-- BEGIN USER LOGIN DROPDOWN -->
                <li class="dropdown user">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img alt="" src="media/image/avatar1_small.jpg" />
                        <span class="username">${pd.USERNAME}</span>

                        <i class="icon-angle-down"></i>

                    </a>

                    <ul class="dropdown-menu">

                        <li><a href="extra_profile.html"><i class="icon-user"></i> My Profile</a></li>

                        <li><a href="page_calendar.html"><i class="icon-calendar"></i> My Calendar</a></li>

                        <li><a href="inbox.html"><i class="icon-envelope"></i> My Inbox(3)</a></li>

                        <li><a href="#"><i class="icon-tasks"></i> My Tasks</a></li>

                        <li class="divider"></li>

                        <li><a href="extra_lock.html"><i class="icon-lock"></i> Lock Screen</a></li>

                        <li><a href="logout"><i class="icon-key"></i> ${pd.LOGOUT}</a></li>

                    </ul>
                </li>
                <!-- END USER LOGIN DROPDOWN -->
            </ul>
            <!-- END TOP NAVIGATION MENU -->
        </div>
    </div>
    <!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->

<!-- BEGIN CONTAINER -->
    <div class="page-container row-fluid">
        <div class="page-sidebar nav-collapse collapse">
            <!-- BEGIN SIDEBAR MENU -->
            <ul class="page-sidebar-menu">
                <li>
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                    <div class="sidebar-toggler hidden-phone"></div>
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                </li>
                <li>
                    <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
                    <form class="sidebar-search">
                        <div class="input-box">
                            <a href="javascript:;" class="remove"></a>
                            <input type="text" placeholder="Search..." />
                            <input type="button" class="submit" value=" " />
                        </div>
                    </form>
                    <!-- END RESPONSIVE QUICK SEARCH FORM -->
                </li>

                <li class="start active ">
                    <a href="javascript:void(0);" onclick="test('showMain');">
                        <i class="icon-home"></i>
                        <span class="title">${pd.DASHBOARD}</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <c:forEach items="${menu}" var="menu1">
                    <c:if test="${menu1.PARENT_ID == '0'}">
                        <li>
                            <c:if test="${not empty menu1.firstSubMenu}">
                                <a href="javascript:;">
                                    <i class="icon-folder-open"></i>
                                    <span class="title">${menu1.MENU_NAME}</span>
                                    <span class="arrow "></span>
                                </a>
                                <ul class="sub-menu">
                                    <c:forEach items="${menu1.firstSubMenu}" var="firstSubMenu">
                                        <li>
                                            <c:if test="${not empty firstSubMenu.secondSubMenu}">
                                                <a href="javascript:;">
                                                    <i class="icon-cogs"></i>
                                                        ${firstSubMenu.MENU_NAME}
                                                    <span class="arrow"></span>
                                                </a>
                                                <ul class="sub-menu">
                                                    <c:forEach items="${firstSubMenu.secondSubMenu}" var="secondSubMenu">
                                                        <li>
                                                            <c:if test="${not empty secondSubMenu.thirdSubMenu}">
                                                                <a href="javascript:;">
                                                                    <i class="icon-user"></i>
                                                                        ${secondSubMenu.MENU_NAME}
                                                                    <span class="arrow"></span>
                                                                </a>
                                                                <ul class="sub-menu">
                                                                    <c:forEach items="${secondSubMenu.thirdSubMenu}" var="thirdSubMenu">
                                                                        <li><a href="javascript:;" onclick="test('${thirdSubMenu.MENU_URL}');"><i class="icon-remove"></i>${thirdSubMenu.MENU_NAME}</a></li>
                                                                    </c:forEach>
                                                                </ul>
                                                            </c:if>
                                                            <c:if test="${empty secondSubMenu.thirdSubMenu}">
                                                                <a href="javascript:;" onclick="test('${secondSubMenu.MENU_URL}');">
                                                                    <i class="icon-user"></i>
                                                                        ${secondSubMenu.MENU_NAME}
                                                                </a>
                                                            </c:if>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </c:if>
                                            <c:if test="${empty firstSubMenu.secondSubMenu}">
                                                <a href="javascript:;" onclick="test('${firstSubMenu.MENU_URL}');">
                                                    <i class="icon-cogs"></i>
                                                        ${firstSubMenu.MENU_NAME}
                                                </a>
                                            </c:if>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:if>
                            <c:if test="${empty menu1.firstSubMenu}">
                                <a href="javascript:;" onclick="test('${menu1.MENU_URL}');">
                                    <i class="icon-folder-open"></i>
                                    <span class="title">${menu1.MENU_NAME}</span>
                                </a>
                            </c:if>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
            <!-- END SIDEBAR MENU -->
        </div>
        <div class="page-content">
            <div class="container-fluid">
                <div id="rightContent"></div>
            </div>
        </div>
    </div>
<!-- BEGIN CONTAINER -->

<!-- BEGIN FOOTER -->
<div class="footer">
    <div class="footer-inner">
        2013 &copy; Metronic by keenthemes.
    </div>
    <div class="footer-tools">
			<span class="go-top">
			<i class="icon-angle-up"></i>
			</span>
    </div>
</div>
<!-- END FOOTER -->

<!-- START CORE PLUGINS -->
<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="media/js/bootstrap.min.js" type="text/javascript"></script>
<!--[if lt IE 9]>
<script src="media/js/excanvas.min.js"></script>
<script src="media/js/respond.min.js"></script>
<![endif]-->
<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>
<script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->

<script src="media/js/app.js" type="text/javascript"></script>
<script src="media/js/index.js" type="text/javascript"></script>

<!-- END PAGE LEVEL SCRIPTS -->
<script>
    jQuery(document).ready(function() {
        App.init(); // initlayout and core plugins
        Index.init();

        //rightContent
        $.ajax({
           post : 'type',
           url : 'frame_tab',
           success : function (data) {
               $("#rightContent").html(data);
           }
        });

    });
</script>

<script type="text/javascript">
    function test(MENU_URL){
        $.ajax({
            type : 'post',
            url : MENU_URL,
            async : false,
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success : function (data) {
                $("#rightContent").html(data);
            }
        });
    }
</script>


<script type="text/javascript">
    $(function(){
        $("#brandOnclick").click(function () {
            //rightContent
            $.ajax({
                post : 'type',
                url : 'frame_tab',
                success : function (data) {
                    $("#rightContent").html(data);
                }
            });
        });
    })

</script>



</body>

<!-- END BODY -->

</html>