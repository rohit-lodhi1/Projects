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
  background-image:url(https://img.freepik.com/free-vector/neon-lights-geometric-shapes-background_52683-33385.jpg?w=2000);
  background-repeat:no-repeat;
  background-attachment:fixed;
  background-size:cover;
  font-family: 'PT Sans', sans-serif;
}
.card {
    border: 0.40rem solid #a5d2ff;
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

</style>
</head>
<body>
<div class="container">
  <div class="row justify-content-center">
  <div class="col-md-5">
   <div class="card">
     <h2 class="card-title text-center" style=color:indianred><b>ADD-CONTACT</b></h2>
      <div class="card-body py-md-4">
       <form _lpchecked="1" action="./ContactServlet" method="post">
          <div class="form-group">
             <input type="text" class="form-control" id="name"  name="name" placeholder="Name" required="required">
        </div>
        <div class="form-group">
             <input type="email" class="form-control" id="email" placeholder="Email"  name="email" required="required">
                            </div>                                               
   <div class="form-group">
     <input type="MobileNo" class="form-control" id="MobileNo" placeholder="MobileNo"   name="MobileNo" required="required">
   </div>
   <div class="form-group">
      <input type="Address" class="form-control" id="Address" placeholder="Address" name="Address" required="required">
   </div>
   <div class="d-flex flex-row align-items-center justify-content-between">
      <a href="./dashboard.jsp"><img alt="" src="">BACK</a>
      <input type="hidden" name="action" value="addContact" >
                                <button class="btn btn-primary">ADD</button>
          </div>
       </form>
     </div>
  </div>
</div>
</div>
</div>

</body>
</html>