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

import domain.Person;

@WebFilter("/success.jsp")
public class AfterAddressFilter implements Filter {

	public AfterAddressFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		boolean sessionOk = false;
		boolean requestOk = false;

		// !!! sprawdzenie kroku
		System.out.println("Pocz¹tek walidacji");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		Object object = session.getAttribute("person");
		if (object instanceof Person) {
			Person person = (Person) object;
			// CZY TO JEST OK?
			if (person.isAlpha()) {
				sessionOk = true;

			}

		}

		String city = httpRequest.getParameter("city");
		String zipCode = httpRequest.getParameter("zipCode");
		String street = httpRequest.getParameter("street");
		String houseNumber = httpRequest.getParameter("houseNumber");
		String localNumber = httpRequest.getParameter("localNumber");
		String phoneNumber = httpRequest.getParameter("phoneNumber");
		Integer localNumberValue;
		Integer phoneNumberValue;

		try {
			localNumberValue = Integer.parseInt(localNumber);
			phoneNumberValue = Integer.parseInt(phoneNumber);
			if (!(city != null && city.matches("[^\\d\\s\\p{Punct}]{2,}"))) {
				throw new Exception("City nie ok" + city);
			}
			if (!(street != null && street.matches("[^\\d\\s\\p{Punct}]{2,}"))) {
				throw new Exception("Street nie ok" + street);
			}
			if (!(zipCode != null && zipCode.replaceAll("[^0-9]", "").length() == 5)) {
				throw new Exception("Zipcode nie ok" + zipCode);
			}
			if (!(houseNumber != null)) {
				throw new Exception("houseNumber  nie ok" + houseNumber);
			}
			if (!((localNumber == null) || (localNumberValue != 0 && localNumberValue > 0))) {
				throw new Exception("localNumber  nie ok" + localNumber);
			}
			if (!(phoneNumberValue != 0 && phoneNumber.length() >= 9 && phoneNumber.length() <= 13)) {
				throw new Exception("phoneNumber  nie ok" + phoneNumber);
			}

			requestOk = true;
			System.out.println("Koniec walidacji");

		} catch (Exception e) {
			requestOk = false;
			e.printStackTrace();
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
			System.out.println("Podano z³e dane adresowe");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
