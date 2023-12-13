<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.dollop.controller.Test" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
  <%
	 Test t = new Test();
  t.playSound("C:\\WEB\\AudioData\\Bhajman-Radhe-Radhe-Govinda (1).wav");
%>

      <button name="play" onclick="play()" value="play">Play</button>
      <button name="stop" onclick="stop()" value="stop">Stop</button>
      <button name="reset" value="reset" onclick="reset()">Reset</button>
 
  <script>
  function play(){
	  
	  <%
	      t.play();
	  %>
  }
  function stop(){
	  <%
	    t.stop();
	  %>
  }
  function reset(){
	  <%
	  t.reset();
	  %>
  }
  </script>
</body>
</html>