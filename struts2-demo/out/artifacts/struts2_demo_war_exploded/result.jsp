<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 18-11-12
  Time: 上午10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>result</title>
</head>
<body bgcolor="#7fffd4">
    <h1>计算器</h1>
    操作:
    <s:property value="operation"/>
    <br>
    第一个数：<s:property value="num1"/>
    第二个数：<s:property value="num2"/>
    结果：<s:property value="result"/>
    <br>
    <a href="index.jsp"><input type="button" value="返回" onclick="javascript:history.back();"></a>



</body>
</html>
