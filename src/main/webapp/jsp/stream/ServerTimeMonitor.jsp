<%--
  Created by IntelliJ IDEA.
  User: wtts
  Date: 2016/7/21
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="../jquery-2.2.3.min.js"></script>
    <title>HTTP 长连接测试 —— 监控服务器时间 </title>
</head>

<body>
<div id="monitor-window">服务器现在是：<span id="time"></span></div>
<form id="a-form" action="/ServerTimeMonitor" method="post" target="handleFrame1">
    <input type="submit" name="submit" id="submit" value=" 获取并监控服务器时间 "/>
</form>
<%--<iframe name="handleFrame1" id="handleFrame1" style="display:none"></iframe>--%>
Post请求
<iframe name="handleFrame1" id="handleFrame1"></iframe>
Get请求
<iframe name="handleFrame2" id="handleFrame2" src="/ServerTimeMonitor"></iframe>

<script type="text/javascript">//<![CDATA[
function showServerTime(msg) {
    $("#time").html(msg);
}
//]]></script>
</body>
</html>
