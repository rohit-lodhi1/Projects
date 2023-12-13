<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>
	

<div class="container">
	<div class="screen">
		<div class="screen__content">
            <h1>PHONE-BOOK</h1>
			<form class="login" action="./UserController">
				<div class="login__field">
					<i class="login__icon fas fa-user"></i>
					<input type="text" class="login__input" name="userName" placeholder="User name">
				</div>
                
				<div class="login__field">
					<i class="login__icon fas fa-user"></i>
					<input type="email" class="login__input"  name="email" placeholder="Email">
				</div>
				<div class="login__field">
					<i class="login__icon fas fa-lock"></i>
					<input type="password" class="login__input"  name="password" placeholder="Password">
				</div>
				<select >
				<option name="Role" value="ADMIN">ADMIN</option>
				<option name="Role" value="User">User</option>
				</select>
				 <input type="hidden" name="action" value="login">
				<button class="button login__submit" type="submit">
					<span class="button__text">Sign-Up Now</span>
					<i class="button__icon fas fa-chevron-right"></i>
				</button>				
			</form>
			<div class="social-login">
				<a mat-raised-button color="primary" id="sign" href="./login.jsp">
                     Log-In
                </a>
				<div class="social-icons">
					<a href="#" class="social-login__icon fab fa-instagram"></a>
					<a href="#" class="social-login__icon fab fa-facebook"></a>
					<a href="#" class="social-login__icon fab fa-twitter"></a>
				</div>
			</div>
		</div>
		<div class="screen__background">
			<span class="screen__background__shape screen__background__shape4"></span>
			<span class="screen__background__shape screen__background__shape3"></span>		
			<span class="screen__background__shape screen__background__shape2"></span>
			<span class="screen__background__shape screen__background__shape1"></span>
		</div>		
	</div>
</div>

</body>
</html>
