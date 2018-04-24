<%@page import="domain.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address</title>
</head>
<body>
	<jsp:useBean id="parameters" class="domain.LoanParameters"
		scope="session" />
	<jsp:useBean id="loan" class="domain.LoanApplication" scope="session" />
	<jsp:useBean id="address" class="domain.Address" scope="session" />
	<jsp:useBean id="person" class="domain.Person" scope="session" />

	<jsp:setProperty property="*" name="parameters" />
	<jsp:setProperty property="*" name="loan" />
	<jsp:setProperty property="*" name="address" />
	<jsp:setProperty property="*" name="person" />


	<h2>
		<font color="mediumvioletred">Numer wniosku: ${loan.number}</font> <br />
		<font color="mediumvioletred">Wnioskowana kwota:${parameters.amount}</font> <br />
		<font color="mediumvioletred">Imię:${person.firstName}</font> <br />
		<font color="mediumvioletred">Nazwisko:${person.surname}</font> <br />
		<font color="mediumvioletred">Pesel:${person.pesel}</font> <br />

	</h2>

	<form action="success.jsp">
		<label>Ulica: <input type="text" id="street" name="street" /></label><br /> 
		<label>Nr domu: <input type="text" id="houseNumber" name="houseNumber"></label><br /> 
		<label>Nr mieszkania: <input type="text" id="localNumber" name="localNumber"></label><br />
		<label>Kod pocztowy: <input type="text" id="zipCode" name="zipCode"></label><br />
		<label>Miasto: <input type="text" id="city" name="city"></label><br />
		<label>Telefon: <input type="text" id="phoneNumber" name="phoneNumber"></label><br />
		<input type="submit" value="następny krok" />
	</form>

</body>
</html>