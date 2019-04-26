<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <title>DWIT TRAINING</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <meta name="description" content="free website template" />
    <meta name="keywords" content="enter your keywords here" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/table_style.css" />
    <link rel="stylesheet" type="text/css" href="css/message.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/image_slide.js"></script>
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
                <a href="createQuestion?pageRequest=create"><img src="../images/create.png" height="50px" width="50px" alt="Create-Question"></a>

                <div  class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                        <tr>
                            <th>Question</th>
                            <th>Category</th>
                            <th>Answer1</th>
                            <th>Answer2</th>
                            <th>Answer3</th>
                            <th>Answer4</th>
                            <th>CorrectAnswer</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <div  class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>

                        <c:forEach items="${quizList}" var="quiz">
                            <tr>
                                <td>${quiz.question}</td>
                                <td>${quiz.category}</td>
                                <td>${quiz.option1}</td>
                                <td>${quiz.option2}</td>
                                <td>${quiz.option3}</td>
                                <td>${quiz.option4}</td>
                                <td>${quiz.correctanswer}</td>
                                <td><a href="updatequestion?pageRequest=update&quizId=${quiz.qid}"> <img src="../images/edit.png" height="50px" width="50px" alt="Edit"></a></td>
                                <td><a href="deletequestion?pageRequest=deletequestion&quizId=${quiz.qid}"><img src="../images/delete.png"height="50px" width="50px" alt="Delete" ></a></td>

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
