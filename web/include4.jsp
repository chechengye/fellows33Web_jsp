<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/16
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
this is include4 page
<jsp:include page="include3.jsp"></jsp:include>
<jsp:forward page="include2.jsp"></jsp:forward>
</body>
</html>