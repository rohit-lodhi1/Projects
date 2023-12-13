<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.dollop.entity.Contacts" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
<style>
</style>
</head>
<body>

</body>
</html>

<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.dollop.entity.Contacts" %>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style type="text/css">

</style> 
</head>
  <%
  boolean f=true;
  if(f){
  %>
<body><div class="container">
  <div class="row justify-content-center">
  <div class="col-md-5">
   <div class="card">
     <h2 class="card-title text-center" style=color:indianred><b>REGISTRATION</b></h2>
      <div class="card-body py-md-4">
       <form _lpchecked="1" action="#" method="post">
          <div class="form-group">
             <input type="text" class="form-control" id="name" pattern="[a-z]*" name="name" placeholder="Name" required="required">
        </div>
        <div class="form-group">
             <input type="email" class="form-control" id="email" placeholder="Email"  name="email" required="required">
                            </div>                                               
   <div class="form-group">
     <input type="password" class="form-control" id="password" placeholder="Password"   name="password" required="required">
   </div>
   <div class="form-group">
      <input type="password" class="form-control" id="confirm-password" placeholder="confirm-password"  name="cpassword" required="required">
   </div>
     <div class="form-group">
     <input type="MobileNo" class="form-control" id="MobileNo" placeholder="MobileNo"   name="MobileNo" required="required">
   </div>
   
   <div class="d-flex flex-row align-items-center justify-content-between">
      <a href="./login.jsp">Login</a>
      <input type="hidden" name="action" value="createAccount">
        
                                <button class="btn btn-primary" id="btn" onclick="nxt()" >Create Account</button>
          </div>
       </form>
     </div>
  </div>
</div>
</div>
</div>

<%}else{
%>
<button>hello</button>
<%} %>


</body>
 </body>
 <script>
function nxt(){
	<% 
	f=false;
	%>
	alert("hello");
}

 </script>
</html>    

    
    
    
 ---%>   
    
    
    
    
    
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<style>
@import url('https://fonts.googleapis.com/css?family=PT+Sans');
.overlay{
width: 100%;
height: 100vh;
top: 0%;
position: fixed;
background: rgba(0, 0, 0, 0.5);
z-index: -1;
opacity: 0;
transition:1s;
}
*{
margin:0px;
padding:0px;
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
a:hover{
  text-decoration: none;
  color:white;
   
    background-color: #df8c96;
    border-color: #df8c96;
  transition: .3s;
  
}
a{
  color:white; 
  padding: 0.6rem 1.2rem;
  background: #da5767;
  border: 2px solid #da5767;
  transition:.3s;
  border-radius:7px;
  text-decoration: none;
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
.showedit{
top:15%;
}
</style>
</head>
<%
Contacts con =(Contacts)request.getAttribute("Contact");
if(con!=null)
{
	
%>
<body>
<button class = "btn-edit">edit</button>
<div class="overlay"></div>
<div class="container">
  <div class="row justify-content-center">
  <div class="col-md-5">
   <div class="card">
   <span>&times;</span>
      <h2 class="card-title text-center" style=color:indianred><b>EDIT-CONTACT</b></h2>
       <div class="card-body py-md-4">
        <form _lpchecked="1" action="./ContactServlet?action=saveContact&id=<%=con.getId() %>" method="post">
          <div class="form-group">
             <input type="text" class="form-control" id="name"  name="name" placeholder="name" value=<%=con.getName() %> required="required">
        </div>
        <div class="form-group">
             <input type="email" class="form-control" id="email" placeholder="email"   name="email" value = <%=con.getEmail() %>  required="required">
                            </div>                                               
   <div class="form-group">
     <input type="MobileNo" class="form-control" id="MobileNo" placeholder="Mobile Number"   name="MobileNo" value=<%=con.getMobile() %>  required="required">
   </div>
   <div class="form-group">
      <input type="Address" class="form-control" id="Address" placeholder="Address"  name="Address"  value=<%=con.getAddress() %>  required="required">
   </div>
   <div class="d-flex flex-row align-items-center justify-content-between">
      <a href="./login.jsp"><img alt="" src="./imgtry/logout.jpeg"></a>
      <input type="hidden" name="action" value="saveContact" >
                                <button class="btn btn-primary">SAVE</button>
   
  <%} %>
          </div>
       
       </form>
     </div>
  </div>
</div>
</div>
</div>

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

var btnedit = document.querySelector(".btn-edit");
btnedit.addEventListener("click",showModel);

var c= document.querySelector("span");
c.addEventListener("click",closeModel);
</script>
</html>


 --%>