<%--
  Created by IntelliJ IDEA.
  User: QYQ
  Date: 2021/1/28
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Excited</title>
    <link rel="stylesheet" href="resources/css/material-icons.css">
    <link rel="stylesheet" href="resources/css/material.min.css">
    <script type="text/javascript" src="resources/js/material.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
    <base href="<%=basePath%>">
    <style>
        .center {
            margin-left: auto;
            margin-right: auto;
        }
        .button {
            margin-top: 75px;
            margin-bottom: 75px;
        }
    </style>
</head>
<body>
<!-- Always shows a header, even in smaller screens. -->
<div class="mdl-layout mdl-js-layout">
    <header class="mdl-layout__header mdl-layout__header--scroll mdl-color--grey-50">
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <a class="mdl-layout-title mdl-navigation__link mdl-color-text--pink-400" href="/">Excited</a>
            <!-- Add spacer, to align navigation to the right -->
            <div class="mdl-layout-spacer"></div>
            <!-- Navigation. We hide it in small screens. -->
            <nav class="mdl-navigation">
                <c:choose>
                    <c:when test="${username != null}">
                        <a class="mdl-navigation__link mdl-color-text--pink-400"
                           href="/user/listUserInfo?username=${username}">${username}</a>
                        <c:if test="${username == 'admin'}">
                            <a class="mdl-navigation__link mdl-color-text--black" href="/admin/manageCenter">??????????????????</a>
                        </c:if>
                        <a class="mdl-navigation__link mdl-color-text--black" href="/user/loginOut">??????</a>
                    </c:when>
                    <c:when test="${username == null}">
                        <a class="mdl-navigation__link mdl-color-text--pink-400" href="/userLogin">??????</a>
                        <a class="mdl-navigation__link mdl-color-text--pink-400" href="/userRegister">??????</a>
                    </c:when>
                </c:choose>
            </nav>
        </div>
    </header>
    <!-- ???????????? -->
    <main class="mdl-layout__content">
        <div class="page-content">
            <!-- Your content goes here -->
            <!-- ??????1 -->
            <div class="mdl-grid">
                <div class="mdl-cell mdl-cell--12-col center">
                    <div align="center">
                        <img src="resources/img/home-first.png" align="center">

                    </div>
                </div>
            </div>
            <div class="mdl-grid">
                <div class="mdl-cell mdl-cell--12-col center">
                    <div align="center">
                        <a class="mdl-button mdl-js-button mdl-color--pink-400 mdl-color-text--white"
                           href="/userRegister">????????????</a>
                    </div>
                </div>
            </div>
            <!-- ??????2 -->
            <div class="mdl-grid">
                <div class="mdl-cell mdl-cell--4-col">
                    <div class="mdl-card mdl-shadow--2dp center">
                        <div class="mdl-card__title mdl-card--expand">
                            <img src="resources/img/home-ill-build.png" width="100%"/>

                        </div>
                        <div class="mdl-card__supporting-text mdl-typography--text-center">
                            <h5>??????</h5>
                        </div>
                    </div>
                </div>
                <div class="mdl-cell mdl-cell--4-col">
                    <div class="mdl-card mdl-shadow--2dp center">
                        <div class="mdl-card__title mdl-card--expand">
                            <img src="resources/img/home-ill-platform.png" width="100%"/>
                        </div>
                        <div class="mdl-card__supporting-text mdl-typography--text-center">
                            <h5>??????</h5>
                        </div>
                    </div>
                </div>
                <div class="mdl-cell mdl-cell--4-col">
                    <div class="mdl-card mdl-shadow--2dp center">
                        <div class="mdl-card__title mdl-card--expand">
                            <img src="resources/img/home-ill-work.png" width="100%"/>
                        </div>
                        <div class="mdl-card__supporting-text mdl-typography--text-center">
                            <h5>??????</h5>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ??????3 -->
            <div class="mdl-grid">
                <div class="mdl-cell--12-col center">
                    <div align="center">
                        <a href="/main" class="mdl-button mdl-js-button mdl-button--raised mdl-color-text--white mdl-color--pink-400 button">
                            ??????????????????
                        </a>
                    </div>
                </div>
            </div>
            <!-- ?????????????????? -->
            <footer class="mdl-mini-footer">
                <div class="mdl-mini-footer__left-section center" align="center">
                    <div class="mdl-logo">Excited</div>
                    <ul class="mdl-mini-footer__link-list">
                        <li><a href="#">GitHub</a></li>
                        <li><a href="#">Privacy & Terms</a></li>
                        <div align="right">
                            <li><a href="/">????????????????????????, excited!</a></li>
                        </div>
                    </ul>
                </div>
            </footer>
        </div>
    </main>
</div>
</body>
</html>
