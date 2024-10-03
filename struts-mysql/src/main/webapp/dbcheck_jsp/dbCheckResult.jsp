<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dbcheck.DBCheckActionForm" %>
<% DBCheckActionForm d = (DBCheckActionForm)request.getAttribute("dbCheckObj"); %>
<HTML>
<HEAD>
</HEAD>
<BODY>
<h1>입력 정보</h1>
<table border="0" cellspacing="0" cellpadding="0" width="400" style="border-collapse: collapse">
    <tr bgcolor="#ffffff" align="center">
        <td>name</td>
        <td>id</td>
        <td>pwd</td>
    </tr>
    <tr bgcolor="#ffffff" align="center" valign="top">
        <td><%= d.getUserName() %></td>
        <td><%= d.getUserId() %></td>
        <td><%= d.getUserPwd() %></td>
    </tr>
</table>
</BODY>
</HTML>