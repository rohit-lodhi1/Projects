<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

.logout img{
    position: absolute;
    width: 105px;
    border-radius: 15px;
    left: 85%;
    top: 68%;
    height: 106px;
}

.logout img:hover{

   border:3px solid #28c3ff;
}



</style>
</head>
<body>
HEY YOU STUDENT GO TO STUDY
<div class="add-Cont">
  <a href="./UserServlet?action=logout" class="logout" id="logout"><img alt="logut" src="./imgtry/logout.jpeg"></a>
   </div>
</body>
</html>