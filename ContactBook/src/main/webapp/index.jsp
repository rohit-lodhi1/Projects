<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
width=100%;
background-repeat:no-repeat;
background-size:cover;
}


.title img {
    height: 69px;
    position: absolute;
    top: 13%;
    border-radius: 12px;
    left: 30%;
    width:555px;
}

.login img{
    position: absolute;
    width: 160px;
    border-radius: 15px;
    left: 30%;
    top: 62%;
    height: 60px;
}

.sign img{
    position: absolute;
    width: 180px;
    border-radius: 15px;
    left: 60%;
    top: 62%;
    height: 60px;
}
.login img:hover{

   border:3px solid #fd57fb;
}
.sign img:hover{

   border:3px solid #fd57fb;
}


</style>
</head>
<body style="background-image: url(https://wallpapercave.com/wp/wp7932324.jpg) ;">
<div class="title" ><img alt="" src="./imgtry/title.png"></div>

   <div class="login">
      <a href="./login.jsp"><img id="login" src="./imgtry/SIGnUP.png"></a>                       
          </div>
          <div class="sign">
          <a href="./signup.jsp"><img id="signup" src="./imgtry/LOGIN.png"></a>
          </div>
</body>
</html>