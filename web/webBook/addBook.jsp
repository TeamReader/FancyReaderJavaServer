<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 2016/7/7
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>添加书籍</title>
</head>
<body>
    <div align="center">
        <h3>书籍录入</h3>
        <form method="post" action="bookAdding.action">
            <table>
                <tr>
                    <td>书名：</td>
                    <td><input type="text" name="bookName"/></td>
                </tr>
                <tr>
                    <td>作者：</td>
                    <td><input type="text" name="author"/></td>
                </tr>
                <tr>
                    <td>封面图像：</td>
                    <td><input type="text" name="icoUrl"/></td>
                </tr>
                <tr>
                    <td>简介：</td>
                    <td><input type="text" name="description"/></td>
                </tr>
                <%--<tr><input type="submit" value="录入"/></tr>--%>
            </table>
            <input type="submit" value="录 入"/>

        </form>
    </div>

    <div>
        <s:if test="#request.result == 'success'">
            <script>
                alert("录入成功");
            </script>
        </s:if>
        <s:elseif test="#request.result == 'failure'">
            <script>
                alert("录入失败");
            </script>
        </s:elseif>
        <%--<s:else>--%>
            <%--<script>--%>
                <%--alert("请填写书籍的信息");--%>
            <%--</script>--%>
        <%--</s:else>--%>
    </div>
</body>
</html>
