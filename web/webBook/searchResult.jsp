<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 2016/7/8
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="org.yyz.pojo.BookEntity" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>搜索结果</title>
</head>
<body>

<div align="center">
    <h3>搜索结果</h3>
    <table style="border-collapse: collapse" border="1" cellpadding="1" width="250">
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>icoUrl</th>
            <th>简介</th>
            <th colspan="2">操作</th>

        </tr>
        <s:iterator value="#attr.data" id="b">
            <tr>
                <td><s:property value="#b.bookName"/> </td>
                <td><s:property value="#b.author"/></td>
                <td><s:property value="#b.icoUrl"/></td>
                <td><s:property value="#b.description"/></td>
                <td><a href="./modifyBook.jsp?
                bookName=<s:property value="#b.bookName"/>
                &author=<s:property value="#b.author"/>
                &icoUrl=<s:property value="#b.icoUrl"/>
                &description=<s:property value="#b.description"/>">修改</a></td>
                <td><a>删除</a></td>
            </tr>
        </s:iterator>
    </table>
</div>
</body>
</html>
