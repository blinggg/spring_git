/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-08-19 07:20:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.QnA_005fFAQ;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class QnAInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1592786321749L));
    _jspx_dependants.put("jar:file:/C:/data/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/FINAL/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/data/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/FINAL/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Q&A INSERT</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("\tfont-family: '@여기어때 잘난체'\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#page {\r\n");
      out.write("\tbackground: white;\r\n");
      out.write("\tmargin: 15px;\r\n");
      out.write("\theight: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#content {\r\n");
      out.write("\tmargin-top: none;\r\n");
      out.write("\tmargin-left: 70px;\r\n");
      out.write("\tmargin-right: 70px;\r\n");
      out.write("\tpadding: 30px margin-top: 10px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("textarea{\r\n");
      out.write("\tresize:none;\r\n");
      out.write("\tfont-size:20px;\r\n");
      out.write("\tborder:1px solid #BDBDBD;\r\n");
      out.write("\tpadding:10px;\r\n");
      out.write("\tborder-radius:5px 5px 5px 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tbl1 {\r\n");
      out.write("\twidth: 60%;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".title {\r\n");
      out.write("\tfont-size: 50px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("\tpadding: 15px;\r\n");
      out.write("\tborder-bottom: 1px solid #e360f2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("\tpadding: 15px;\r\n");
      out.write("\tfont-size: 25px;\r\n");
      out.write("\tborder-right: 3px solid #e360f2;\r\n");
      out.write("\tborder-bottom: 1px solid #e360f2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#btnList,input[type=\"submit\"]{\r\n");
      out.write("\twidth:200px;\r\n");
      out.write("\theight: 60px;\r\n");
      out.write("\tfont-size: 30px;\r\n");
      out.write("\tmargin: 2px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tbackground: #e6bbea;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tborder:none;\r\n");
      out.write("\tborder-radius:3px 3px 3px 3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#reset{\r\n");
      out.write("\twidth:200px;\r\n");
      out.write("\theight: 60px;\r\n");
      out.write("\tfont-size: 30px;\r\n");
      out.write("\tmargin: 2px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tbackground: #969596;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tborder:none;\r\n");
      out.write("\tborder-radius:3px 3px 3px 3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#reset:active {\r\n");
      out.write("\tbackground: #757575;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"submit\"]:active,#btnList:active {\r\n");
      out.write("\tbackground: #cca6cf;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#users_id,#title{\r\n");
      out.write("\theight:25px;\r\n");
      out.write("\tfont-size:20px;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tborder:none;\r\n");
      out.write("\tpadding:5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button{\r\n");
      out.write("\tpadding:20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../index_include/menu.jsp", out, false);
      out.write("\r\n");
      out.write("\t<div id=\"page\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../index_include/header.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<div class=\"title\">⊙ Q&A INSERT ⊙</div>\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t<form name=\"frm\" action=\"/QnAInsert\" method=\"post\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t<table id=\"tbl1\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th width=200>TITLE</th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"board_title\" size=40 id=\"title\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th width=200>WRITER</th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"board_writer\" size=40 value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly id=\"users_id\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th width=200>CONTENT</th>\r\n");
      out.write("\t\t\t\t\t\t<td><textarea name=\"board_content\" rows=15 cols=56></textarea></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<div class=\"button\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"저장\"> \r\n");
      out.write("\t\t\t\t\t<input type=\"reset\" id=\"reset\" value=\"취소\"> \r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"목록\" id=\"btnList\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../index_include/chat.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("var users_id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("if(users_id == \"\") {\r\n");
      out.write("   $(\"#users_id\").val(\"GUEST\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(\"#btnList\").on(\"click\", function(){\r\n");
      out.write("   var page=$(frm.page).val();\r\n");
      out.write("   location.href=\"QnA?page=\"+page;\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(frm).submit(function(e){\r\n");
      out.write("   e.preventDefault();\r\n");
      out.write("   if($(frm.board_title).val()==\"\") {\r\n");
      out.write("      alert(\"제목을 입력하세요\");\r\n");
      out.write("      return;\r\n");
      out.write("   } \r\n");
      out.write("   \r\n");
      out.write("   if($(frm.board_content).val()==\"\") {\r\n");
      out.write("      alert(\"내용을 입력하세요\");   \r\n");
      out.write("      return;\r\n");
      out.write("   }\r\n");
      out.write("   if(!confirm(\"저장하시겠습니까?\")) return;\r\n");
      out.write("   \r\n");
      out.write("   frm.submit();\r\n");
      out.write("   \r\n");
      out.write("});\r\n");
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
