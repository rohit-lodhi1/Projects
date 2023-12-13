<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<button  class="btn btn-danger"><a href="/user/add-user">Add User</a></button>
<table class="table table-hover table-dark" >
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">UserName</th>
      <th scope="col">Mobile</th>
      <th scope="col">Address</th>
       <th scope="col">Action</th>
    </tr>
  </thead>
  <style>
  a{
  text-decoration:none;
  color:white;
  }
  </style> 
  <tbody>
    <c:forEach var = "user"  items="${userList}" >
    <tr>
       <td>${user.u_id }</td>
      <td>${user.u_user_name }</td>
      <td>${user.u_mobile }</td>
      <td>${user.u_address }</td>
     
      <td><button class="btn btn-danger"><a href="/user/edit/${user.u_id }">Edit</a></button></td>
     <td><button  class="btn btn-danger"><a  onclick="return confirm('Are you sure you want to delete this item?');" data-confirm="Are you sure?" data-method="DELETE" href="/user/delete/${user.u_id }">Delete</a></button></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<h1>${msg}</h1>
<script>
if(${check}==true)
	{
window.onload = function(){
	window.location.href="/user";
}
	}
</script>