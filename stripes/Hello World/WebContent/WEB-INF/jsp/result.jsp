<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
	<h1>Current time is: ${actionBean.time}</h1>
	<br/>
	<s:link
		beanclass="com.javahelps.stripes.helloworld.action.TimeActionBean"
		event="currentTime">
		Update the Time
	</s:link>
</body>
</html>