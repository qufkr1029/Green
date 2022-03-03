<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
정수타입 : ${30}<br>
실수타입 : ${2.52}<br>
문자열 : ${"String스트링"}<br>
논리타입 : ${true}<br>
null : ${null}<br> <!-- null의 경우 화면에 아무것도 안나온다. -->

<hr>
5+2 : ${5+2}<br> <!-- 7 -->
5-2 : ${5-2}<br> <!-- 3 -->
5*2 : ${5*2}<br> <!-- 10 -->
5/2 : ${5/2}<br> <!-- 2.5 -->
5%2 : ${5%2}<br> <!-- 1 -->
<hr>
5 div 2 : ${5 div 2}<br> <!-- 2.5 -->
5 mod 2 : ${5 mod 2}<br> <!-- 1 -->
<hr>
5>2 : ${5>2}<br>
5>2 : ${5 gt 2}<br>
5<2 : ${5<2}<br>
5<2 : ${5 lt 2}<br>
<hr>
(5>2)?5:2 => ${(5>2)?5:2}<br> <!-- 5 -->
(5<2)?5:2 => ${(5<2)?5:2}<br> <!-- 2 -->




</body>
</html>