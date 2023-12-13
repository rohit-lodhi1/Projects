<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<table style="border:2px solid black">

<%-- 
 <c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
      </c:forEach> --%>
<%-- UserID:      <p>${user.id}</p>

UserName:      <p>${user.name}</p>
    
UserROle:      <p>${user.role}</p>
  --%>
    <tr>
        <th>UserID</th>
        <th>User Name</th>
        <th>User Role</th>
        
    </tr>
    <c:forEach var = "user"  items="${list}" >
    <tr>
      <td> ${user.id }</td>
      <td> ${user.name }</td>
      <td> ${user.role }</td>
    </tr>
    
    </c:forEach>
</table>