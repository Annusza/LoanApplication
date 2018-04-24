<%@page import="domain.LoanApplication"%>
<%@page import="domain.LoanParameters"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person</title>
</head>
<body>
	<jsp:useBean id="loan" class="domain.LoanApplication" scope="session" />
	<jsp:useBean id="parameters" class="domain.LoanParameters" scope="session" />

	<jsp:setProperty property="*" name="parameters" />


	<h2>
		<font color="mediumvioletred">Numer wniosku: ${loan.number}</font> <br />
		<font color="mediumvioletred">Wnioskowana kwota: ${parameters.amount}</font> <br />
		<font color="mediumvioletred">Ilość rat: ${parameters.installmentCount}</font> <br />


	</h2>

	<form action="address.jsp">
		<label>Imię: <input type="text" id="firstName"
			name="firstName" /></label><br /> <label>Nazwisko: <input
			type="text" id="surname" name="surname"></label><br /> <label>Numer
			PESEL: <input type="text" id="pesel" name="pesel">
		</label><br /> <br/><input type="submit" value="następny krok" />
	</form>

</body>
</html>