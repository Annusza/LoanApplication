<%@page import="domain.Address"%>
<%@page import="domain.LoanApplication"%>
<%@page import="domain.LoanParameters"%>
<%@page import="domain.Person"%>
<%@page import="services.LoanService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>

	<jsp:useBean id="loanService" class="services.LoanService"
		scope="application" />
	<jsp:useBean id="loan" class="domain.LoanApplication" scope="session" />
	<jsp:useBean id="parameters" class="domain.LoanParameters"
		scope="session" />
	<jsp:useBean id="person" class="domain.Person" scope="session" />
	<jsp:useBean id="address" class="domain.Address" scope="session" />

	<jsp:setProperty property="*" name="parameters" />
	<jsp:setProperty property="*" name="address" />
	<jsp:setProperty property="*" name="loan" />
	<jsp:setProperty property="*" name="person" />

	<%
		loan.setParameters(parameters);
			loan.setPerson(person);
			loan.setAddress(address);
			loanService.add(loan);
	%>
	<h2><font color="Teal">Zarejestrowane wnioski</font></h2><br/>
	<ul>
		<%
			for(LoanApplication loanApplication: loanService.getAll()){
		%>
		<li><h3><font color="navyblue">Wniosek: <%=loanApplication.getNumber()
		+"; "+" Osoba: " + loanApplication.getPerson().getFirstName()+" "+ loanApplication.getPerson().getSurname()
		+"; "+" Adres: "+ loanApplication.getAddress().getStreet()+ " "+ loanApplication.getAddress().getHouseNumber()+" "+ loanApplication.getAddress().getLocalNumber()+" "+ loanApplication.getAddress().getZipCode()+" "+ loanApplication.getAddress().getCity()+", "+loanApplication.getAddress().getPhoneNumber()
		+" Kwota: "+loanApplication.getParameters().getAmount()%></font></h3></li>
		<%
			}
		%>
	</ul>

</body>
</html>