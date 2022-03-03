<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	if(window.name == "update"){// 수정기능
		window.opener.parent.location.href="BS?command=board_update_form&num=${param.num}";
	}else if(window.name == "delete"){ //삭제 기능
		alert("삭제가 되었습니다.");
		window.opener.parent.location.href="BS?command=board_delete&num=${param.num}";
	}
	
	window.close(); //새창 닫기


</script>
</body>
</html>