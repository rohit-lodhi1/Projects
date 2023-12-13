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
  background: #fff;
  background-image:url(./imgtry/signup.jpg);
  background-repeat:no-repeat;
  background-attachment:fixed;
  background-size:cover;
  font-family: 'PT Sans', sans-serif;
}
.card {
    border: 0.40rem solid #f8f9fa;
    top: 10%;
    background: #000000c7;
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
.card{
  border: 0.40rem solid #f8f9fa;
  top: 7%;
  background: #00000052;
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
#back {
    position: absolute;
    height: 110px;
  left:140%;
    top: 80%;
    border-radius: 21px;
}

#back:hover{
border: 5px solid #72fbff
}
#bck{
background-color: transparent;
border:0px;
}

body {
  margin: 0;
  padding: 0;
  background-color: #004882;
}

.box {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.box select {
    background-color: #ffffff;
    color: black;
    padding: 12px;
    width: 174px;
    border: none;
    font-size: 17px;
    box-shadow: 0 5px 25px rgba(0, 0, 0, 0.2);
    -webkit-appearance: button;
    appearance: button;
    outline: none;
    position: absolute;
}


select#option {
    width: 123px;
    position: relative;
    left: 45%;
}
h3 {
    color: white;
    width: 77px;
    font-size: 21px;
    text-align: center;
    border-radius: 3px;
    position: absolute;
    top: 81%;
    left:16%;
}
</style>
</head>
<body><div class="container">
  <div class="row justify-content-center">
  <div class="col-md-5">
   <div class="card">
     <h2 class="card-title text-center" style=color:indianred><b>REGISTRATION</b></h2>
      <div class="card-body py-md-4">
       <form _lpchecked="1" action="./UserServlet" method="post">
          <div class="form-group">
             <input type="text" class="form-control" id="name"  name="name" placeholder="Name" required="required">
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
   <h3>TYPE</h3>
   <div class="form-group">
<div>
  <select  class="" id="option" name="type">
    <option>-SELECT-</option>
    <option>ADMIN</option>
    <option>TEACHER</option>
    <option>STUDENT</option>
  </select>
</div>
</div>
   <div class="d-flex flex-row align-items-center justify-content-between">
      <a href="./login.jsp">Login</a>
      <input type="hidden" name="action" value="createAccount">
          <a href="./index.jsp" id="bck"><img alt=""  id="back" src="./imgtry/back.png"></a>
                                <button class="btn btn-primary">Create Account</button>
          </div>
       </form>
     </div>
  </div>
</div>
</div>
</div>
</body>
</html>