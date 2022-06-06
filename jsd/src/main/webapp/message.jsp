<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#show{
		width: 500px;
		height: 300px;
		border: 1px solid blue;
	}

</style>

</head>
<body>
 <% 
    String user = request.getParameter("user");
 %>
<div id="show">
<div class="row">test</div>
</div>
<input type = "text" name="content">
<input type="hidden" name="writer" value = "<%=user%>">

<script>
   document.querySelector('input[name="content"]').addEventListener('change', changeCall);
   function changeCall(){
      let content = document.querySelector('input[name="content"]').value;
      let writer = document.querySelector('input[name="writer"]').value;
      
      fetch('message', {
         method: 'post',
         headers : {'Content-type' : 'application/x-www-form-urlencoded'},
         body: 'writer='+writer+'&content='+content
      })
         .then(result => {
            console.log(result);
            e.target.value = ''; //e.target => input   
         })
         .catch(err => console.log(err));
   }
   
   let lastMsg = -1;
   setInterval(e=>{
      
      fetch('message')
      .then(result => result.json())
      .then(resolve => {
         //기존화면의 메세지를 지우기
         let divs = document.querySelectorAll('#show div')
         divs.forEach(elem => elem.remove());
         
         fitAry = resolve.filter(elem =>{
            console.log(lastMsg);
            return elem.msgId > lastMsg -14;
         })
         
         //조호된 메세리를 새로 그려주기
         let show = document.getElementById('show');
         fitAry.forEach(row =>{
            lastMsg = row.msgId;
            let div = createRow(row);
            show.append(div);
         });
         
      })
      .catch(error => console.log(error));
   }, 1500);
   
   function createRow(message){
      let div = document.createElement('div');
      div.setAttribute('class', 'row');
   /*    div.innerText = `${message.writer}> ${message.content}`; */
      let txt = document.createTextNode(message.writer + '>' + message.content);
      div.append(txt);
      return div;
   }
</script>

</body>


</html>