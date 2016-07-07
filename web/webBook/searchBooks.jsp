<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 2016/7/7
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>搜索书籍</title>
</head>
<body>
    <div align="center">
        <h2>搜索书籍</h2>
        <form method="post">
            书名：<input type="text" name="bookName"/>
            <input type="submit" value="搜索"/>
        </form>
    </div>
    <div align="center" style="width:100%;">
        <h3>搜索结果</h3>
        <table>
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>icoUrl</th>
                <th>简介</th>
                <th>操作</th>

            </tr>
            <s:iterator value="#request.data" var="book">
                <tr>
                    <td><s:property value="#book.bookName"/> </td>
                    <td><s:property value="#book.author"/></td>
                    <td><s:property value="#book.icoUrl"/></td>
                    <td><s:property value="#book.description"/></td>
                    <td></td>
                    <td></td>
                </tr>
            </s:iterator>
        </table>
    </div>
</body>
</html>
