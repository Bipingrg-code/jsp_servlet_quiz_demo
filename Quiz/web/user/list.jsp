<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <title>DWIT TRAINING</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <%-- <meta name="description" content="free website template" />
    <meta name="keywords" content="enter your keywords here" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/table_style.css" />
    <link rel="stylesheet" type="text/css" href="css/message.css" />
    <link rel="stylesheet" href="css/login_style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/image_slide.js"></script>--%>
    <meta name="description" content="free website template" />
    <meta name="keywords" content="enter your keywords here" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/table_style.css" />
    <link rel="stylesheet" type="text/css" href="css/message.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/image_slide.js"></script>
   <%-- <script >
        function userForm(){
            var login=document.getElementsByClassName("login");
            if(login.style.display=="none"){
                login.style.display=="block";
            }
        }
    </script>--%>
</head>

<body>
<div id="main">
    <jsp:include page="../menu/menu.jsp"/>;



    <div id="site_content">
        <div id="content">

            <div class="content_item">
                <h1>Welcome To Your Website</h1>
                <div class="message_info">

                </div>
                <div class="message_error">

                </div>
                <a href="createUser?pageRequest=create"><img src="../images/create.png" height="50px" width="50px" alt="Create User"></a>

                <div  class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                        <tr>
                            <th>User Name</th>
                            <th>Password</th>
                            <th>Role</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <div  class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>

                        <c:forEach items="${userList}" var="user">
                            <tr>
                                <td>${user.userName}</td>
                                <td>${user.password}</td>
                                <td>${user.role}</td>
                                <td><a href="updateUser?pageRequest=update&userId=${user.id}"> <img src="../images/edit.png" height="50px" width="50px" alt="Edit"></a></td>
                                <td><a href="deleteUser?pageRequest=delete&userId=${user.id}"><img src="../images/delete.png"height="50px" width="50px" alt="Delete" ></a></td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div><!--close content_item-->
        </div><!--close content-->
    </div><!--close site_content-->



</div><!--close main-->

<div id="footer">
    DWIT TRAINING
</div><!--close footer-->

</body>
</html>
