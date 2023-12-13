<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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


</style>
</head>
<body>
 <div class="profile-card">
    <div class="card-header">
      <div class="pic">
        <img src="./imgtry/back.png" alt="">
      </div>
      <div class="name">John Doe</div>
      <a href="" class="contact-btn">Edit Profile</a>
      <a href="" class="contact-btn">View Profile</a>
      <a href="#" class="contact-btn">Contact Me</a>
      
    </div>
    <div class="card-footer">
      <div class="numbers">
        <div class="item">
          <span>120</span>
          Contacts
        </div>
        <div class="border"></div>
        <div class="item">
          <span>12</span>
          Favrouits
        </div>
    </div>
  </div>
</body>
</html>