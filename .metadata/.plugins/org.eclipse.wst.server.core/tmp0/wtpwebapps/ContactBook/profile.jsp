<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dollop.entity.User"%>
<%@ page import="com.dollop.service.PhoneBookDaoImpl"%>
<%@ page import="com.dollop.DAO.PhoneBookDAO"%>
<%@ page import="java.util.*"%>
<%@ page import="com.dollop.entity.Contacts"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" 
          href=
"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
*{
  margin: 0;
  padding: 0;
  font-family: "Ubuntu", sans-serif;
  box-sizing: border-box;
  text-decoration: none;
}

body{
  height: 100vh;
  background: url(bg.jpg) no-repeat center;
  background-size: cover;
  display: flex;
  align-items: center;
  justify-content: center;
}

.profile-card{
  width: 400px;
  text-align: center;
  border-radius: 8px;
  overflow: hidden;
  top:30%;
}


.card-header{
  background: #2c3a47;
  padding: 60px 40px;
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

@keyframes animated-gradient{
  25%{
    background-position: left bottom;
  }
  50%{
    background-position: right bottom;
  }
  75%{
    background-position: right top;
  }
  100%{
    background-position: left top;
  }
}

.pic img{
  display: block;
  width: 100px;
  height: 100px;
  border-radius: 50%;
}

.name{
  color: #f2f2f2;
  font-size: 28px;
  font-weight: 600;
  margin: 10px 0;
}

.desc{
  font-size: 18px;
  color: #e66767;
}

.sm{
  display: flex;
  justify-content: center;
  margin: 20px 0;
}

.sm a{
  color: #f2f2f2;
  width: 56px;
  font-size: 22px;
  transition: .3s linear;
}

.sm a:hover{
  color: #e66767;
}

.contact-btn{
  display: inline-block;
  padding: 12px 50px;
  color: #e66767;
  border: 2px solid #e66767;
  border-radius: 6px;
  margin-top: 16px;
  transition: .3s linear;
}

.contact-btn:hover{
  background: #e66767;
  color: #f2f2f2;
}

.card-footer{
  background: #f4f4f4;
  padding: 60px 10px;
}

.numbers{
  display: flex;
  align-items: center;
}

.item{
  flex: 1;
  text-transform: uppercase;
  font-size: 13px;
  color: #e66767;
}

.item span{
  display: block;
  color: #2c3a47;
  font-size: 30px;
}

.border{
  width: 1px;
  height: 30px;
  background: #bbb;
}


img#back {
    position: absolute;
    top: 2%;
    height: 30px;
    left: 0%;
}
#bck{
background-color: transparent;
border:0px;
}

.card {
    border: 0.40rem solid #a5d2ff;
    top: 10%;
    background: #000000c7;
    top: -109%;
    box-shadow: 0px 0px 10px 3px #ccc;
    transition:1s;
}
.card span{
position: absolute;
right:0px;
top:0px;
color:white;
background: red;
text-align:center;
line-height:30px;
height:30px;
width:30px;
}

h2{
  padding-top: 1.5rem;
}

.form-control{
  background-color: #f8f9fa;
  padding: 20px;
  padding: 25px 15px;
  margin-bottom: 1.3rem;
}

.form-control:focus {

    color: #000000;
    background-color: #ffffff;
    border: 3px solid #da5767;
    outline: 0;
    box-shadow: none;

}

.form-control:hover {

    color: #000000;
    background-color: #ffffff;
    border: 3px solid #da5767;
    outline: 0;
    box-shadow: none;

}

.btn{
  padding: 0.6rem 1.2rem;
  background: #da5767;
  border: 2px solid #da5767;
}
.btn-primary:hover {

    
    background-color: #df8c96;
    border-color: #df8c96;
  transition: .3s;

}

.showoverlay{
opacity:1;
}
.showedit {
    top: -120%;
    width: 283%;
    left: -89%;
}
.profile-card {
    position: absolute;
    top: -4%;
}
a#con{
text-decoration: none;
color: #e1566e;
}

</style>
</head>
<body>
 <div class="profile-card">
    <div class="card-header">
  <form action="./FileHandler?action=updateProfile" method="post" enctype="multipart/form-data">
      <div class="pic">
      <%
      
      String img=(String)session.getAttribute("ProfileImg");
      System.out.println(img);
      if(img!=null){
    	  
      %>
        <img src="./imgtry/<%=img%>" alt="">
        <%}
      else
      %><img src="./imgtry/profile.jpg" alt="">
      </div>
      <div class="">
        <i class="fa fa-folder"></i><input type="file" id="take"name="file">
    <input type="submit" id="val"value="upload"/>
      </div>
      </form>
<%
PhoneBookDAO ph = new PhoneBookDaoImpl();
User us1 = ph.getUser((Integer)session.getAttribute("login"));
%>
      <div class="name"><%=us1.getName()%></div>
      <a data-confirm="Are you sure?" class="contact-btn" href="./UserServlet?action=editUser" rel="nofollow">Edit Profile </a>
      <a href="" class="contact-btn">View Profile</a>
      <a href="./addContact.jsp" class="contact-btn">Add-Contacts</a>
      <%
      try{
      List<Contacts> list = ph.getContacts((Integer)session.getAttribute("login"));
      %>
      
    </div>
    <div class="card-footer">
      <div class="numbers">
        <div class="item">
          <span><%=list.size() %></span>
          <%}catch(Exception e){} %>
          <a href="./ContactServlet?action=viewContact" id="con">Contacts</a>
        </div>
        <div class="border"></div>
        <div class="item">
          <span>12</span>
          Favrouits
        </div>
    </div>
  </div>
  

<%
try{
if((Boolean)request.getAttribute("on"))
{
%>
   <body onload="showModel()"></body>
   
   <%}}catch(Exception e){} %>

  
  
<%
try{
if((Boolean)request.getAttribute("on"))
{
User us =(User)request.getAttribute("User");
if(us!=null)
{
	
%>
<div class="overlay" onclick="closeModel()" ></div>
<div class="container">
  <div class="row justify-content-center">
  <div class="col-md-5">
   <div class="card">
   <span>&times;</span>
      <h2 class="card-title text-center" style=color:indianred><b>EDIT-CONTACT</b></h2>
       <div class="card-body py-md-4">
        <form _lpchecked="1" action="./UserServlet?action=saveUser&id=<%=us.getId() %>" method="post">
          <div class="form-group">
             <input type="text" class="form-control" id="name"  name="name" placeholder="name" value=<%=us.getName() %> required="required">
        </div>
        <div class="form-group">
             <input type="email" class="form-control" id="email" placeholder="email"   name="email" value = <%=us.getEmail() %>  required="required">
                            </div>                                               
   <div class="form-group">
     <input type="text" class="form-control" id="MobileNo" placeholder="Mobile Number"  id="contact" name="MobileNo" value=<%=us.getContact() %>  required="required">
   </div>
   <div class="form-group">
      <input type="text" class="form-control" id="Address" placeholder="password"  name="password"  value=<%=us.getPassword() %>  required="required">
   </div>
   <div class="d-flex flex-row align-items-center justify-content-between">
   
      <input type="hidden" name="action" value="saveUser" >
                                <button class="btn btn-primary">SAVE</button>   
          </div>
     <%}}}catch(Exception e){} %>  
       </form>
     </div>
  </div>
</div>
</div>
</div>


        <a href="./dashboard.jsp" id="bck"><img alt=""  id="back" src="./imgtry/back.png"></a>  
</body>


<script>
function showModel(){
	document.querySelector('.overlay').classList.add('showoverlay');
	document.querySelector('.card').classList.add('showedit');
}
function closeModel(){
	document.querySelector('.overlay').classList.remove('showoverlay');
	document.querySelector('.card').classList.remove('showedit');
}

var btnedit = document.querySelector(".contact-btn");
btnedit.addEventListener("click",showModel)

var c = document.querySelector("span");
c.addEventListener("click",closeModel)
</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>
