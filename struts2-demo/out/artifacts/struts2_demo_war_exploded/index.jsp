<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 18-11-12
  Time: 上午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>算术计算器</title>
</head>
<body bgcolor="#faebd7">
<h1 align="center">计算器</h1>
<s:form action="Calculate" theme="simple">
    第一个数：<s:textfield name="num1"/>
    <font color="red"><s:property value="errors['num1'][0]"/></font>
    <br/>
    第二个数：<s:textfield name="num2";/>
    <font color="red"><s:property value="error['num2'][0]"/></font>
    <br/>
    <s:submit value="加" name="operation"/>
    <s:submit value="减" name="operation"/>
    <s:submit value="乘" name="operation"/>
    <s:submit value="除" name="operation"/>
</s:form>
</body>
</html>
