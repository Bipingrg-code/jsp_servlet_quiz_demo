    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%--
          Created by IntelliJ IDEA.
          User: Sanjay Bhandari
          Date: 9/10/2018
          Time: 4:08 PM
          To change this template use File | Settings | File Templates.
        --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <div id="menubar">
    <div id="welcome">
    <h1><a href="#">Welcome <h1>${sessionScope.user.userName}</h1></a></h1>
    </div><!--close welcome-->
    <div id="menu_items">
    <ul id="menu">
    <li class="current"><a href="home?pageRequest=home">Home</a></li>
    <c:if test= "${sessionScope.user.role=='admin'}">
    <li><a href="userList?pageRequest=list">User</a></li>
    <li><a href="questionlist?pageRequest=questionlist">Question</a></li>
    </c:if>
    <li><a href="play?pageRequest=quizcatagory">Play</a></li>
    <li><a href="logout?pageRequest=logout">Logout</a></li>

    </ul>
    </div><!--close menu-->
    </div><!--close menubar-->
</head>
<body>

</body>
</html>
