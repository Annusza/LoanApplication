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

import domain.LoanApplication;

@WebFilter("/person.jsp")
public class AfterParametersFilter implements Filter {

	public AfterParametersFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		boolean sessionOk = false;
		boolean requestOk = false;

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		Object object = session.getAttribute("loan");
		if (object instanceof LoanApplication) {
			LoanApplication loanApplication = (LoanApplication) object;
			if (loanApplication.hasValidNumber()) {
				sessionOk = true;
			}
		}
		
		String amount = httpRequest.getParameter("amount");
		String installmentCount = httpRequest.getParameter("installmentCount");
		Integer amountValue;
		Integer installmentCountValue;

		try {
			amountValue = Integer.parseInt(amount);
			installmentCountValue = Integer.parseInt(installmentCount);
			if (!(amountValue > 0 && amountValue < 10_000_000)) {
				throw new Exception();
			}
			if (!(installmentCountValue > 0 && installmentCountValue < 360)) {
				throw new Exception();
			}
			requestOk = true;

		} catch (Exception e) {
			requestOk = false;
		}

		boolean doFilter = false;
		if (sessionOk == true && requestOk == true) {
			doFilter = true;
		}
		if (doFilter == true) {

			chain.doFilter(request, response);
			return;

		} else {

			httpResponse.sendRedirect("/");
			System.out.println("Nie nadano nr wniosku");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
