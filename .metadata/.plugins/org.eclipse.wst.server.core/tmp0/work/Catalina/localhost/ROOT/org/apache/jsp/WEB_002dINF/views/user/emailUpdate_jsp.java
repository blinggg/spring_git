/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-08-26 07:07:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class emailUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1592786321749L));
    _jspx_dependants.put("jar:file:/C:/data/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/FINAL/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<title>E-MAIL</title>\r\n");
      out.write("<style>\r\n");
      out.write("#e-mail{\r\n");
      out.write("   text-align:center;\r\n");
      out.write("}\r\n");
      out.write("* {\r\n");
      out.write("   font-family: 'Comic Sans MS';\r\n");
      out.write("   font-family: '@여기어때 잘난체';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("   background: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#e-maliPage{\r\n");
      out.write("   background: white;\r\n");
      out.write("   margin: 15px;\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h3{\r\n");
      out.write("   color:red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("   width: 400px;\r\n");
      out.write("   height: 60px;\r\n");
      out.write("   font-size: 30px;\r\n");
      out.write("   cursor: pointer;\r\n");
      out.write("   background: #e6bbea;\r\n");
      out.write("   color: white;\r\n");
      out.write("   border: none;\r\n");
      out.write("   border-radius: 3px 3px 3px 3px;\r\n");
      out.write("   cursor: pointer;\r\n");
      out.write("   text-align:center;\r\n");
      out.write("   margin-bottom:20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input{\r\n");
      out.write("   height: 25px;\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button:active {\r\n");
      out.write("   background: #cca6cf;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input::placeholder {\r\n");
      out.write("   text-align: center;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"e-maliPage\">\r\n");
      out.write("   <form action=\"/emailSendInjeungUpdate\" method=\"post\" name=\"frm\">\r\n");
      out.write("      <div id=\"e-mail\">\r\n");
      out.write("         <img id=\"logoimg\" src=\"../display?fileName=gif7.gif\" width=200>\r\n");
      out.write("         <h1>E-MAIL 인증</h1>\r\n");
      out.write("         <h4>(인증이 완료되어야 다음 단계로 넘어갈 수 있습니다.)</h4>\r\n");
      out.write("          <h3>인증받을 E-MAIL을 입력하여 주세요!</h3>\r\n");
      out.write("          <input type=\"text\" name=\"emailSendInjeung\" value=\"\" size=40 placeholder=\"E-MAIL\" id=\"changeEmail\">\r\n");
      out.write("      <br><br>\r\n");
      out.write("      <div>\r\n");
      out.write("         <input type=\"hidden\" name=\"users_email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("         <button type=\"submit\">전송</button>\r\n");
      out.write("      </div>\r\n");
      out.write("      </div>\r\n");
      out.write("   </form>\r\n");
      out.write("   </div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("   $(frm).submit(function(e){\r\n");
      out.write("      e.preventDefault();\r\n");
      out.write("      var changeEmail=$(\"#changeEmail\").val();\r\n");
      out.write("      $.ajax({\r\n");
      out.write("             type:\"get\",\r\n");
      out.write("             url:\"/user/echeck\",\r\n");
      out.write("             data:{\"users_email\":changeEmail},\r\n");
      out.write("             success:function(data){\r\n");
      out.write("               if(data==2) {\r\n");
      out.write("                  alert(\"사용가능한 이메일 입니다.\");\r\n");
      out.write("                  frm.submit();\r\n");
      out.write("               } else {\r\n");
      out.write("                  alert(\"중복된 이메일 입니다.\");\r\n");
      out.write("               }\r\n");
      out.write("             }\r\n");
      out.write("          });\r\n");
      out.write("   });\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
