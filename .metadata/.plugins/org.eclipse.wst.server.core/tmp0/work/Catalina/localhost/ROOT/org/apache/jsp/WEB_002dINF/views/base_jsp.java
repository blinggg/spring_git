/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-08-04 06:25:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class base_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\">\r\n");
      out.write("<title>부모창입니다</title>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction getCookie(name) {\r\n");
      out.write("\t\tvar Found = false\r\n");
      out.write("\t\tvar start, end\r\n");
      out.write("\t\tvar i = 0\r\n");
      out.write("\t\t// cookie 문자열 전체를 검색\r\n");
      out.write("\t\twhile (i <= document.cookie.length) {\r\n");
      out.write("\t\t\tstart = i\r\n");
      out.write("\t\t\tend = start + name.length\r\n");
      out.write("\t\t\t// name과 동일한 문자가 있다면\r\n");
      out.write("\t\t\tif (document.cookie.substring(start, end) == name) {\r\n");
      out.write("\t\t\t\tFound = true\r\n");
      out.write("\t\t\t\tbreak\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\ti++\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// name 문자열을 cookie에서 찾았다면\r\n");
      out.write("\t\tif (Found == true) {\r\n");
      out.write("\t\t\tstart = end + 1\r\n");
      out.write("\t\t\tend = document.cookie.indexOf(\";\", start)\r\n");
      out.write("\t\t\t// 마지막 부분이라 는 것을 의미(마지막에는 \";\"가 없다)\r\n");
      out.write("\t\t\tif (end < start)\r\n");
      out.write("\t\t\t\tend = document.cookie.length\r\n");
      out.write("\t\t\t\t// name에 해당하는 value값을 추출하여 리턴한다.\r\n");
      out.write("\t\t\treturn document.cookie.substring(start, end)\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// 찾지 못했다면\r\n");
      out.write("\t\treturn \"\"\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction openMsgBox() {\r\n");
      out.write("\t\tvar eventCookie = getCookie(\"memo\");\r\n");
      out.write("\t\tif (eventCookie != \"no\")\r\n");
      out.write("\t\t\twindow.open(\r\n");
      out.write("\t\t\t\t\t\t\t'popup',\r\n");
      out.write("\t\t\t\t\t\t\t'popup',\r\n");
      out.write("\t\t\t\t\t\t\t'toolbar=no, location=no, directories=no, status=no, menubar=no, copyhistory=no,width=500,height=500,top=200,left=50,location=no,scrollbars=no');\r\n");
      out.write("\t\t// window.open('팝업창 웹페이지','윈도우명',); \r\n");
      out.write("\r\n");
      out.write("\t\t/* 옵션\r\n");
      out.write("\t\t 새창 뛰울때 용도에 맞게 옵션 설정을 해줍니다. \"YES\" 또는 \"NO\" 로 지정 해주면 됩니다. \r\n");
      out.write("\t\t menubar - 파일, 편집, 보기....부분 \r\n");
      out.write("\t\t toolbar - 뒤로, 앞으로, 새로고침 아이콘등이 있는 부분 \r\n");
      out.write("\t\t directories - 연결 디렉토리가 표시되는 부분 \r\n");
      out.write("\t\t location - 주소 입력창 \r\n");
      out.write("\t\t status - 아래 브라우저 상태 바 \r\n");
      out.write("\t\t scrollbars - 스크롤 \r\n");
      out.write("\t\t resizable - 리사이즈 옵션 */\r\n");
      out.write("\r\n");
      out.write("\t\t//팝업창의 주소, 같은 도메인에 있어야 한다.\r\n");
      out.write("\t}\r\n");
      out.write("\topenMsgBox();\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("</body>\r\n");
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