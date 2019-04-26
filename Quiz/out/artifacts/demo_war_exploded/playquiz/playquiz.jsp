<%--
  Created by IntelliJ IDEA.
  User: Sanjay Bhandari
  Date: 9/11/2018
  Time: 9:30 PM
  To change this template use File | Settings | File Templates.
--%>

<% //int question_counter = (int) request.getAttribute("question_counter");
    String category = (String) request.getAttribute("category");
    if(category!=null){
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <title>Play@YourOwnRisk</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="bootstrap/css/custom-theme.css">


    <!-- Latest compiled and minified JavaScript -->
    <script src="bootstrap/js/jquery-2.2.2.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body onload="examTimer">
<div id="main">
    <jsp:include page="../menu/menu.jsp"/>;
    <div id="site_content">
        <div id="content">

            <div class="content_item">
                <div  class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <form class="form-horizontal" method="post" action="check">
                            <fieldset>
                                <legend>
                                    <div class="col-sm-9">Quiz - <%=category%></div>
                                    <span id="timeleft" class="text-right"></span>
                                  <%--  <input type="date" name="created_at">--%>
                                </legend>
                                <c:forEach items="${quizList}" var="quiz_ques" varStatus="loopCounter">
                                    <div class="quiz-ques form-group">
                                        <label class="col-lg-2 control-label">Question ${loopCounter.count}</label>
                                        <div class="col-lg-10 text-left">
                                            <input type="hidden" value="${quiz_ques.qid}" name="select+${loopCounter.count}qid">
                                            <h5>${quiz_ques.question}</h5>
                                            <label>
                                                <input type="radio" name="select+${loopCounter.count}option" required="required" value="1">
                                                    ${quiz_ques.option1}                    </label><br>
                                            <label>
                                                <input type="radio" name="select+${loopCounter.count}option" required="required" value="2">
                                                    ${quiz_ques.option2}                    </label><br>
                                            <label>
                                                <input type="radio" name="select+${loopCounter.count}option" required="required" value="3">
                                                    ${quiz_ques.option3}                    </label><br>
                                            <label>
                                                <input type="radio" name="select+${loopCounter.count}option" required="required" value="4">
                                                    ${quiz_ques.option4}                    </label>
                                        </div>
                                    </div>
                                </c:forEach>

                                <div class="form-group">
                                    <div class="col-lg-10 col-lg-offset-5">
                                        <button type="submit" class="btn btn-primary">Submit your Quiz</button>
                                        <input type="hidden" name="pageRequest" value="check">
                                    </div>
                                </div>
                            </fieldset>
                        </form>

                        </tbody>

                    </table>
                </div>
            </div><!--close content_item-->
        </div><!--close content-->
    </div><!--close site_content-->

</div><!--end of main-->
</body>
<script>
    $('.nav-collapse').click('li', function () {
        $('.nav-collapse').collapse('hide');
    });

    var x = setInterval(function() {
        myTimer()
    }, 1000);
        var d = 60;
        var min, sec;

        function myTimer() {
            d--;
            min = parseInt(d / 60);
            sec = parseInt((d / 60 - min) * 59);
            document.getElementById("timeleft").innerHTML = min + " miunte " + sec + " second left";

        if (d < 0) {
            clearInterval(x);
            document.getElementById("timeleft").innerHTML = "EXPIRED";
            myFunction()
        }
            function myFunction() {
            var txt="Quiz session EXPIRED moving to home page";
            if (confirm("Quiz session EXPIRED moving to home page")) {
                location.replace("http://localhost:8082/home?pageRequest=home")
            } else {
                location.replace("http://localhost:8082/home?pageRequest=home")
            }
            document.getElementById("timeleft").innerHTML = txt;
        }
    }
</script>
</html>
<%
    }else{
        String redirToURL = response.encodeRedirectURL("8082/play?pageRequest=quizcatagory");
        response.sendRedirect(redirToURL);
    }
%>
