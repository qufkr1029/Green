<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>숫자 표기</h3>
<fmt:formatNumber value="1234567.89"/><br><!-- 1,234,567.89 -->
<fmt:formatNumber value="1234567.89" groupingUsed="false"/><br><!-- 1234567.89 -->
<fmt:formatNumber value=".89" type="percent"/><br><!-- 89% -->
<fmt:formatNumber value="10000" type="currency"/><br><!-- (W)10000 -->
<fmt:formatNumber value="10000" type="currency" currencySymbol="$"/><br><!-- (W)10000 -->
<hr>
<fmt:formatNumber value="1234567.891234567" pattern="#,#00.0#" /><br>
<fmt:formatNumber value="1234567.8" pattern="#,#00.0#" /><br><!-- 1,2345,567.8 -->
<fmt:formatNumber value="1234567.8" pattern="#,#00.000" /><br><!-- 1,2345,567.800 -->
<fmt:formatNumber value="67.8" pattern="000,000.000" /><br><!-- 000,067,800 -->

<hr>
<c:set var="now" value="<%=new java.util.Date() %>"/>

<fmt:formatDate value="${now}"/><br><!-- 년월일 -->
<fmt:formatDate value="${now}" type="time"/><br><!-- 시분초 -->
<fmt:formatDate value="${now}" type="both"/><br><!-- 년월일 시분초 -->
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/><br><!-- 0000년 00월 00일 00시 00분 00초 -->

<hr>
<fmt:timeZone value="GMT">
	GMT : <fmt:formatDate value="${now}" type="both"/><br>
</fmt:timeZone>

<fmt:timeZone value="GMT+9">
	GMT+9 : <fmt:formatDate value="${now}" type="both"/><br>
</fmt:timeZone>

<hr>
톰캣 서버의 기본 로케일 : <%=response.getLocale() %><br>
<hr>
<fmt:setLocale value="lt_LT"/><!-- 언어코드_국가코드 -->
로케일을 리투아니아어로 설정한 후 로케일 : <%=response.getLocale() %><br>
통화 : <fmt:formatNumber value="10000" type="currency"/><br>
날짜 : <fmt:formatDate value="${now}" type="both"/><br>
<hr>
<fmt:setLocale value="zh_CN"/><!-- 언어코드_국가코드 -->
로케일을 중국 설정한 후 로케일 : <%=response.getLocale() %><br>
통화 : <fmt:formatNumber value="10000" type="currency"/><br>
날짜 : <fmt:formatDate value="${now}" type="both"/><br>
<hr>
<fmt:setLocale value="ja_JP"/><!-- 언어코드_국가코드 -->
로케일을 일본 설정한 후 로케일 : <%=response.getLocale() %><br>
통화 : <fmt:formatNumber value="10000" type="currency"/><br>
날짜 : <fmt:formatDate value="${now}" type="both"/><br>
<hr>
<fmt:setLocale value="en_US"/><!-- 언어코드_국가코드 -->
로케일을 미국 설정한 후 로케일 : <%=response.getLocale() %><br>
통화 : <fmt:formatNumber value="10000" type="currency"/><br>
날짜 : <fmt:formatDate value="${now}" type="both"/><br>
<hr>
<fmt:setLocale value="ko_KR"/><!-- 언어코드_국가코드 -->
로케일을 대한민국 설정한 후 로케일 : <%=response.getLocale() %><br>
통화 : <fmt:formatNumber value="10000" type="currency"/><br>
날짜 : <fmt:formatDate value="${now}" type="both"/><br>

</body>
</html>

























