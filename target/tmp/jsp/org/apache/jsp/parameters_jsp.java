package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import domain.LoanApplication;
import java.util.Random;
import java.util.Date;

public final class parameters_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

private Random generator = new Random();
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Formular</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

		String number = "" + generator.nextInt(Integer.MAX_VALUE);
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      domain.LoanApplication loan = null;
      synchronized (session) {
        loan = (domain.LoanApplication) _jspx_page_context.getAttribute("loan", PageContext.SESSION_SCOPE);
        if (loan == null){
          loan = new domain.LoanApplication();
          _jspx_page_context.setAttribute("loan", loan, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\t");
      domain.LoanParameters parameters = null;
      synchronized (session) {
        parameters = (domain.LoanParameters) _jspx_page_context.getAttribute("parameters", PageContext.SESSION_SCOPE);
        if (parameters == null){
          parameters = new domain.LoanParameters();
          _jspx_page_context.setAttribute("parameters", parameters, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("parameters"), request);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("loan"), "number",
number);
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("loan"), "date",
new Date());
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<h2>\r\n");
      out.write("\t\t<font color=\"limegreen\">Wygenerowany numer wniosku: ");
      out.print(loan.getNumber());
      out.write("\r\n");
      out.write("\t\t</font> <br /> Data wygenerowania:\r\n");
      out.write("\t\t");
      out.print(loan.getDate());
      out.write("\r\n");
      out.write("\t</h2>\r\n");
      out.write("\r\n");
      out.write("\t<form action=\"person.jsp\">\r\n");
      out.write("\t\t<label>Wnioskowana kwota: <input type=\"number\" id=\"amount\"\r\n");
      out.write("\t\t\tname=\"amount\" /></label><br /> <label>Ilość rat: <input\r\n");
      out.write("\t\t\ttype=\"number\" id=\"installmentCount\" name=\"installmentCount\"></label><br />\r\n");
      out.write("\t\t<br /> <input type=\"submit\" value=\"następny krok\" />\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
