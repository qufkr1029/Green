<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./jQuery/jquery-3.6.0.js"></script>
</head>
<body>
<form action="">
	작성자 : <input type="text" name="C_user" id="C_user" ><br>
			<input type="button" value="USER 중복체크" onclick="userChk()"><br>
	암호 :  <input type="password" name="C_Password" id="C_Password" ><br>      
		   <textarea rows="10" cols="50" name="C_Comment" id="C_Comment" ></textarea><br>
		   <input type="button" value="댓글등록" onclick="jsonTransport()"><br>
		   <div id="message"></div>
</form>

<script>
	window.onload = function () {
		$.ajax({
            type:"GET",
            async:true,  // 동기화 방식 : false 동기화, true 비동기
            url:"AjaxTest01",
            data:{
            	C_user:$('#C_user').val()
            },
            dataType:"text",  // 서버로 부터 받아올 데이터의 타입
            success:function(data,textStatus){  // 서버와 데이터 교류가 성공했을 때 실행할 함수
                $('#message').append(data);
            },error:function(){  // 서버와 데이터 교류가 실패하면 실행할 함수   
                alert('에러가 발생했습니다.');
            }
        });
	}
	




        // 다수의 데이터를 보내는 함수 => 객체(JSON)화
        function jsonTransport(){
            let C_user = $('#C_user').val();
            let C_Password = $('#C_Password').val();
            let C_Comment = $('#C_Comment').val();

            let commentInfo = {  // 다수의 데이터를 객체에 담아서
            		"C_user":C_user,
            		"C_Password":C_Password,
            		"C_Comment":C_Comment
            };

            $.ajax({
                type:"POST",
                async:true,
                url:"AjaxTest01",
                data:{
                	commentInfo:JSON.stringify(commentInfo)  //JSON 포장해서 전송
                }
            });
        }
        
       /*  function ReceiveData(){
            $.ajax({
                type:"post",
                async:true,
                url:"AjaxTest02",
                dataType:"JSON",  // JSON타입 데이터를 읽어와서 자동 파싱 처리
                success:function(data,textStatus){
                    // let userInfo = JSON.parse(data);
                    $('#message').append("아이디 : " + data.userId+"<br>");
                    $('#message').append("이름 : " + data.userName+"<br>");
                    $('#message').append("비밀번호 : " + data.userPwd+"<br>");
                }

            });
        } */
    </script>
</body>
</html>