<%--
  Created by IntelliJ IDEA.
  User: islix
  Date: 2022/7/11
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${status ==1}">
    <h1>true</h1>
</c:if>
<c:if test="false">
    <h1>false</h1>
</c:if>
</body>
</html>
