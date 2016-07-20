<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 2016/7/8
  Time: 8:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>修改书籍信息</title>
</head>
<body>
    <div align="center">
        <h2>修改书籍信息</h2>
        <form method="post" action="bookUpdate.action">
            <table>
                <tr>
                    <td>书名</td>
                    <td><input type="text" name="bookName" value="<s:property value="#request.bookName"/> " disabled="disabled"/></td>
                </tr>
                <tr>
                    <td>作者</td>
                    <td><input type="text" name="author"  value="<s:property value="#request.author"/>"/> </td>
                </tr>
                <tr>
                    <td>封面url</td>
                    <td><input type="text" name="icoUrl"  value="<s:property value="#request.icoUrl"/>"/></td>
                </tr>
                <tr>
                    <td>简介</td>
                    <td><input type="text" name="description"  value="<s:property value="#request.description"/>"/></td>
                </tr>
            </table>
            <input type="submit" value="确 认 修 改"/>
        </form>
    </div>
</body>
</html>
