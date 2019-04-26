<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <meta charset="UTF-8">
    <title>Play@YourOwnRisk</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="bootstrap/css/custom-theme.css">


    <!-- Latest compiled and minified JavaScript -->
    <script src="bootstrap/js/jquery-2.2.2.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>


<body>
<div id="main">
    <jsp:include page="../menu/menu.jsp"/>;

    <div id="site_content">
        <div id="content">

            <div class="content_item">
                <h1>Result</h1>
                <div class="message_info">

                </div>
                <div class="message_error">

                </div>

                <div class="col-lg-12">
                    <table id="previous-result" class="table table-striped table-hover ">
                        <thead>
                        <tr>
                            <th>User</th>
                            <th>Catagory</th>
                            <th>Correct-Question</th>
                            <th>Score</th>
                            <th>Date</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${resultList}" var="result">
                            <tr>
                                <td><c:out value="${result.username}"/></td>
                                <td><c:out value="${result.catagory}"/></td>
                                <td><c:out value="${result.no_of_correct_question}"/></td>
                                <td><c:out value="${result.no_of_correct_question * 5}"/></td>
                                <td><c:out value="${result.created_at}"/></td>
                            </tr>
                            <br>
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
