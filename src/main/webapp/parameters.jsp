<%@page import="domain.LoanApplication"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formular</title>
</head>
<body>
	<%!private Random generator = new Random();%>

	<%
		String number = "" + generator.nextInt(Integer.MAX_VALUE);
	%>

	<jsp:useBean id="loan" class="domain.LoanApplication" scope="session" />
	<jsp:useBean id="parameters" class="domain.LoanParameters"
		scope="session" />

	<jsp:setProperty property="*" name="parameters" />

	<jsp:setProperty property="number" name="loan" value="<%=number%>" />
	<jsp:setProperty property="date" name="loan" value="<%=new Date()%>" />

	<h2>
		<font color="limegreen">Wygenerowany numer wniosku: <%=loan.getNumber()%>
		</font> <br /> Data wygenerowania:
		<%=loan.getDate()%>
	</h2>

	<form action="person.jsp">
		<label>Wnioskowana kwota: <input type="number" id="amount"
			name="amount" /></label><br /> <label>Ilość rat: <input
			type="number" id="installmentCount" name="installmentCount"></label><br />
		<br /> <input type="submit" value="następny krok" />

	</form>

</body>
</html>