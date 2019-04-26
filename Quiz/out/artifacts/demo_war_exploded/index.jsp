<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Login Form</title>
    <link rel="stylesheet" href="css/login_style.css">
    <script>
        function validateForm() {
            var username = document.forms["myForm"]["username"].value;
            var password = document.forms["myForm"]["password"].value;
            if(username=="" ||password=='' ){
                alert("name or password must be filled");
                return false;
            }

        }
        function loginsignup() {
            var myForm = document.getElementsByClassName("login");
            var signupForm=document.getElementById("")
             var loginbutton = document.getElementById("loginbutton")
            var signupbutton = document.getElementById("signupbutton")
            if(signupForm.style.display=="none"){
                signupForm.style.display=="block"
                loginbutton.style.display=="none"
                signupbutton.style.display=="none"
            }else{
                signupForm.style.display="none"
                loginbutton.style.display="block"
                signupbutton.style.display="block"
            }

        }
    </script>
    <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
<section class="container">

    <div class="message_info">

    </div>
    <div class="message_error">

    </div>
    <div class="login">
        <h1>Login to DWIT</h1>
        <form method="post" action="login" name="myForm" onsubmit="return validateForm()">
            <p><input type="text" name="username" value="" placeholder="Username or Email"></p>
            <p><input type="password" name="password" value="" placeholder="Password"></p>
            <p class="submit"><input type="submit" name="commit" value="Login"></p>
            <input type="hidden" name="pageRequest" value="login">
        </form>
    </div>
    <div class="login" >
        <div id = "signup" style="display: none">
        <h1>Login to DWIT</h1>
        <form method="post" action="login" name="loginForm" >
            <p><input type="text" name="username" value="" placeholder="Username or Email"></p>
            <p><input type="password" name="password" value="" placeholder="Password"></p>
            <p class="submit"><input type="submit" name="commit" value="sign-up"></p>
            <input type="hidden" name="pageRequest" value="login">
        </form>
        </div><%--end of signup id--%>
    </div>

    <div class="login-help">
       <%--<p>Forgot your password? <a href="#">Click here to reset it</a>.</p>--%>
       <p class="submit"><input type="submit" id= "signupbutton",onclick="loginsignup()"></p>
           <p class="submit"><input type="submit" id= "loginbutton",onclick="loginsignup()" style="display: none"></p>
    </div>
</section>
</body>
</html>
