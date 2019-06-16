<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.weichuang.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/16
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("name","lisi");
        request.setAttribute("name" , "zhangsan");
        User user = new User();
        user.setName("zhaoliu");
        session.setAttribute("user" , user);
        List<User> list = new ArrayList<>();
        list.add(user);
        User user1 = new User();
        user1.setName("tianqi");
        list.add(user1);
        application.setAttribute("list" , list);
    %>
    <!--从request域中取值-->
    ${requestScope.name} <br/>
    ${sessionScope.user.name}<br/>
    ${applicationScope.list[1].name}<br/>

    ${header["User-Agent"]}
    ${name}  <!--pageContext.findAttribute(key)-->

    ${pageContext.request.contextPath}  <!--request.getContextPath()-->
    <br/>
    <c:forEach begin="0" end="5" var="i">
        <c:if test="${i==3}">
            ${i}
        </c:if>
        <c:if test="${i!=3}">
            ${i+1}
        </c:if>
    </c:forEach>

    <br/>

    <c:forEach items="${list}" var="user" varStatus="vs">
        第${vs.count}个用户的名字为:${user.name}<br>
    </c:forEach>

</body>
</html>
