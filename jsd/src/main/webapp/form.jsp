<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
</head>
<body>
	<form name="myform" action="formServlet" method="post" enctype="multipart/form-data">
        <input type="text" name="user"><br>
        <input type="text" name="passwd"><br>
        <input type="file" name="img"><br>
        <input type="hidden" name="cmd" value="search">
        <input type="hidden" name="name">
        <input type="hidden" name="age">
        <input type="submit" value="전송">
    </form>
    <form name="my"></form>
    <script>
    	let myfrom = document.forms.myform;
    	myfrom.onsubmit = function(){
    	  myfrom.action = "sample.html"
          myfrom.cmd.value = "insert";  
          myfrom.user.value = "admin";  
          myfrom.passwd.value = "1234";
          myfrom.name.value = "hong";
          myfrom.age.value = 12;
    	}
    	
    </script>
</body>
</html>