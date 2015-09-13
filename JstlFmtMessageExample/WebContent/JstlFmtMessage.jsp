<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL fmt:message Tag</title>
</head>
<body>

Привіт
<p>Hindi (India) Locale</p>
<fmt:setLocale value="hi_IN"/>
<fmt:bundle basename="myProperties.Prop.Pop">
   1. <fmt:message key="ONE"/><br/>
   2. <fmt:message key="TWO"/><br/>
   3. <fmt:message key="THREE"/><br/>
   4. <fmt:message key="FOUR"/><br/>
   5. <fmt:message key="FIVE"/><br/>
</fmt:bundle>
</body>
</html>