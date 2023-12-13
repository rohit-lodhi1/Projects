<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=PT+Sans');
body{
width=100%;
background-repeat:no-repeat;
background-size:cover;
}img {
    position: absolute;
    width: 400px;
    border-radius: 15px;
    left: 36%;
    top: 10%;
}
button.btn.btn-outline-info {
    position: absolute;
    font-size: 35px;
    top: 33%;
    left: 20%;
    width:250px;
    border: 2px solid color red;
    border: 3px solid;
}

#add{
  background-image: url('./imgtry/addCont.gif');
  background-size: 100% 100%;
  background-repeat: no-repeat;
  color: #3ad2ff;
  left:27%;
}

#add:hover{
background:transparent;
}

#view:hover{
background:transparent;

}


#view{
 left: 55%;
 border: 3px solid;
 border: 3px solid;
    background: transparent;
    color: #ff15e2;
      background-image: url('./imgtry/viewContact.gif');
  background-size: 100% 100%;
  background-repeat: no-repeat;
 
}


#search{
top:63%;
left:41%;
  background-image: url('./imgtry/search.gif');
  background-size: 100% 100%;
  background-repeat: no-repeat;
}

#search:hover{
background:transparent;
color:#3ad2ff;
}


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
.pic{
  display: inline-block;
  padding: 8px;
  background: linear-gradient(130deg, #74b9ff, #e66767);
  margin: auto;
  border-radius: 50%;
  background-size: 200% 200%;
  animation: animated-gradient 2s linear infinite;
}
.pic img{
  display: block;
  width: 100px;
  height: 100px;
  border-radius: 50%;
}
.pic {
    position: absolute;
    height: 107px;
    width: 113px;
    left: 4%;
    top: 2%;
}
img#profile {
    left: 6%;
    top: 4%;
}


</style>
</head>
<body style="background-image: url(https://img.freepik.com/premium-photo/blue-purple-neon-square-black-brick-wall-background_161844-394.jpg?w=2000) ;">
   <div class="pic">
      <%
      
      String img=(String)session.getAttribute("ProfileImg");
      System.out.println(img);
      if(img!=null){
    	  
      %>
   
        <a href="./profile.jsp"><img src="./imgtry/<%=img%>" id="profile" alt=""></a>
        <%} %>
      </div>
   <img src="./imgtry/welcome.jpeg" alt="logo">
   <div class="add-Cont">
   <a href="./addContact.jsp" id= "addCont"><button type="button" class="btn btn-outline-info" id="add" >ADD<br>CONTACTS</button></a>
   </div>
   <div class="add-Cont">
  <a href = "./ContactServlet?action=viewContact" ><button type="button" class="btn btn-outline-info" id="view">VIEW<br>CONTACTS</button></a>
   </div>
   <div class="add-Cont">
  <a href = "./ContactServlet?action=viewContact" ><button type="button" class="btn btn-outline-info" id="search">SEARCH<br>CONTACTS</button>
   </div>  
   <div class="add-Cont">
  <a href="./UserServlet?action=logout" class="logout" id="logout"><img alt="logut" src="./imgtry/logout.jpeg"></a>
   </div>
</body>
</html>