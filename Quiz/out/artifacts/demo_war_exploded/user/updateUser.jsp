<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <title>DWIT TRAINING</title>
   <%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>
    <meta name="description" content="free website template" />
    <meta name="keywords" content="enter your keywords here" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/table_style.css" />
    <link rel="stylesheet" type="text/css" href="css/message.css" />
    <link rel="stylesheet" href="css/login_style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/image_slide.js"></script>
</head>

<body>
<div id="main">


    <div id="menubar">
        <div id="welcome">
            <h1><a href="#">DWIT TRAINING</a></h1>
        </div><!--close welcome-->
        <div id="menu_items">
            <ul id="menu">
                <li class="current"><a href="../home.jsp">Home</a></li>
                <li><a href="userList?pageRequest=list">User</a></li>
                <li><a href="quizlist?pageRequest=quizlist">Quiz</a></li>
                <li><a href="#"></a></li>
                <li><a href="logout?pageRequest=logout">Logout</a></li>

            </ul>
        </div><!--close menu-->
    </div><!--close menubar-->

    <div id="site_content">
        <div id="content">

            <div class="content_item">
               <%-- <h1>Welcome To Create User Form</h1>--%>
                <h1>Please fill up the form to Update user</h1>
                <div class="message_info">

                </div>
                <div class="message_error">

                </div>

                <div class="login">
                    <h1>Update User</h1>
                   <%-- <c:forEach items="${userList}" var="user">--%>
                    <form method="post" action="updateUser">

                        <p><input type="text" name="username" value="${user.userName}" placeholder="<%--${user.userName}--%>Username" ></p>
                        <p><input type="text" name="password" value="${user.password}" placeholder="<%--${user.password}--%>Password"></p>
                        <p><input type="text" name="roal" value="${user.role}" placeholder="<%--${user.role}--%>Roal"></p>
                        <p class="submit"><input type="submit" name="commit" value="update"></p>
                        <input type="hidden" name="pageRequest" value="UpdateUser">
                        <input type="hidden" name="userId" value="${user.id}">

                    </form>
                    <%--</c:forEach>--%>
                </div>

               <%-- Here is our content

                <div  class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                        <tr>
                            <th>Code</th>
                            <th>Company</th>
                            <th>Price</th>
                            <th>Change</th>
                            <th>Change %</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <div  class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>

                        <tr>
                            <td>AAX</td>
                            <td>ADELAIDE</td>
                            <td>$3.22</td>
                            <td>+0.01</td>
                            <td>+1.36%</td>
                            <td><a href="#">Click Me</a></td>
                        </tr>

                        <tr>
                            <td>AAX</td>
                            <td>ADELAIDE</td>
                            <td>$3.22</td>
                            <td>+0.01</td>
                            <td>+1.36%</td>
                            <td><a href="#">Click Me</a></td>
                        </tr>

                        </tbody>
                    </table>
                </div>
--%>


            </div><!--close content_item-->
        </div><!--close content-->
    </div><!--close site_content-->



</div><!--close main-->

<div id="footer">
    DWIT TRAINING
</div><!--close footer-->

</body>
</html>
