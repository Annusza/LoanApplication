package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoanParameters;
import domain.Person;

@WebFilter("/address.jsp")
public class AfterPersonFilter implements Filter {

	public AfterPersonFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		boolean sessionOk = false;
		boolean requestOk = false;
		boolean doFilter = false;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		Object object = session.getAttribute("parameters");

		System.out.println("Object = object to " + object);

		if (object instanceof LoanParameters) {
			LoanParameters loanParameters = (LoanParameters) object;
			if (loanParameters.hasAmountAndInstallmentcount()) {
				sessionOk = true;

			}
		}
		String firstName = httpRequest.getParameter("firstName");
		String surname = httpRequest.getParameter("surname");
		String pesel = httpRequest.getParameter("pesel");

		System.out.println("Imie to: " + firstName);

		try {

			if (!Person.isValidFirstName(firstName)) {
				throw new Exception();
			}
			if (!Person.isValidSurname(surname)) {
				throw new Exception();
			}
			if (!Person.isValidPesel(pesel)) {
				throw new Exception();
			}

			requestOk = true;
		} catch (Exception e) {
			requestOk = false;
		}

		if (sessionOk == true && requestOk == true) {
			doFilter = true;
		}
		if (doFilter == true) {

			chain.doFilter(request, response);
			return;

		} else {
			httpResponse.sendRedirect("/");
			System.out.println("Niew³aœciwe dane personalne");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
