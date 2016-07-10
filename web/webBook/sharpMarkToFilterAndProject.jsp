<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="og_nl.sharpMark.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 2016/6/4
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>#用于过滤和投影集合</h1>
    <h5>----->?：提取所有匹配选择逻辑的元素</h5>
    <h5>----->^：只提取符合选择逻辑的第一个元素</h5>
    <h5>----->$：只提取符合选择逻辑的最后一个元素</h5>
    <%!
        private List<User> userList;
    %>
    <%
        userList = new ArrayList<User>();
        User u = new User();
        u.setAge(10);
        u.setName("Mike");
        u.setPwd("Mike pwd");
        userList.add(u);

        u = new User();
        u.setAge(20);
        u.setName("John");
        u.setPwd("John pwd");
        userList.add(u);

        u = new User();
        u.setAge(30);
        u.setName("Anny");
        u.setPwd("Anny pwd");
        userList.add(u);

        u = new User();
        u.setAge(40);
        u.setName("Jane");
        u.setPwd("Jane pwd");
        userList.add(u);
        session.setAttribute("users",userList);
    %>
    全部打印：<br>
    <s:iterator value="#attr.users" id="u">
        <s:property value="#u.name"/>----<s:property value="#u.age"/>----<s:property value="#u.pwd"/><br>
    </s:iterator>
    年龄大于20：<br>
    <s:iterator value="#attr.users.{?#this.age>20}" var="u">
        <s:property value="#u.name"/>----<s:property value="#u.age"/>----<s:property value="#u.pwd"/><br>
    </s:iterator>
    取第一个：<br>
    <s:iterator value="#attr.users.{^#this.age}" var="u">
        <s:property value="#u.name"/>----<s:property value="#u.age"/>----<s:property value="#u.pwd"/><br>
    </s:iterator>
    取最后一个：<br>
    <s:iterator value="#attr.users.{$#this.age}" var="u">
        <s:property value="#u.name"/>----<s:property value="#u.age"/>----<s:property value="#u.pwd"/><br>
    </s:iterator>


<br>
-----------------------上面因为属性为private，所以直接访问访问不到-------------------------------------
    <br>全部打印：<br>
    <s:iterator value="#attr.users" var="u1">
        <s:property value="name"/>----<s:property value="age"/>----<s:property value="pwd"/><br>
    </s:iterator>
    年龄大于20：<br>
    <s:iterator value="#attr.users.{?#this.getAge()>20}" var="u">
        <s:property value="u.name"/>----<s:property value="u.age"/>----<s:property value="u.pwd"/><br>
    </s:iterator>
    取第一个：<br>
    <s:iterator value="#attr.users.{^#this.age}" var="u">
        <s:property value="u.name"/>----<s:property value="u.age"/>----<s:property value="u.pwd"/><br>
    </s:iterator>
    取最后一个：<br>
    <s:iterator value="#attr.users.{$#this.age}" var="u">
        <s:property value="u.name"/>----<s:property value="u.age"/>----<s:property value="u.pwd"/><br>
    </s:iterator>
</body>
</html>
