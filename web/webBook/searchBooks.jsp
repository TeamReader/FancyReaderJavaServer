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
        <form method="post" action="bookSearch.action">
            书名：<input type="text" name="bookName"/>
            <input type="submit" value="搜索"/>
        </form>
    </div>

</body>
</html>
