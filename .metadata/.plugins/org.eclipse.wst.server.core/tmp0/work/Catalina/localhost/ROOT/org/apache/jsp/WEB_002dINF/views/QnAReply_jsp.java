/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-08-11 04:20:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class QnAReply_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>REPLY</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
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
      out.write("\tpadding: 30px;\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("textarea {\r\n");
      out.write("\tresize: none;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tborder: 1px solid #BDBDBD;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tborder-radius: 5px 5px 5px 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tbl2 {\r\n");
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
      out.write("\tpadding: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#txtReply {\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tmargin-left:8%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#btnInsert {\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tbackground: #e6bbea;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tborder-radius: 3px 3px 3px 3px;\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#btnInsert:active {\r\n");
      out.write("\tbackground: #cca6cf;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input::placeholder {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("hr {\r\n");
      out.write("\tborder: 1px dotted #e360f2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".replyDate {\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".active {\r\n");
      out.write("\tcolor: hotpink;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".replyer {\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#pagination{\r\n");
      out.write("\tpadding:20px;\r\n");
      out.write("}\r\n");
      out.write("#divInput{\r\n");
      out.write("\twidth:60%;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tmargin:auto;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\tREPLY COUNT : <span id=\"count\"></span>\r\n");
      out.write("\t<div class=\"title\">⊙ REPLY ⊙</div>\r\n");
      out.write("\t<div id=\"divInput\">\r\n");
      out.write("\t\t<input type=\"text\" id=\"txtReply\" size=50 placeholder=\"CONTENT\">\r\n");
      out.write("\t\t<button id=\"btnInsert\">INSERT</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"tbl2\"></div>\r\n");
      out.write("\t<script id=\"temp\" type=\"text/x-handlebars-template\">\r\n");
      out.write("\t{{#each QnAList}}\r\n");
      out.write("\t\t<div class=\"divContent\">\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t<div class=\"replydate\">\r\n");
      out.write("\t\t\t\t<span class=\"replyDate\">{{board_reply_replyDate}}</span>\r\n");
      out.write("\t\t\t\t<span class=\"replyer\">{{board_reply_replyer}}</span>\r\n");
      out.write("\t\t\t</div><br>\r\n");
      out.write("\t\t\t<div class=\"board_reply\" >\r\n");
      out.write("\t\t\t\t<button rno={{board_reply_rno}} style=\"{{printStyle board_reply_replyer}}\">X</button>\r\n");
      out.write("\t\t\t\t{{board_reply}}\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t{{/each}}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<div id=\"pagination\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("var board_reply_bno=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.board_bno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("var board_reply_replyer=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("var users_note=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_note}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("var page=1;\r\n");
      out.write("\r\n");
      out.write("Handlebars.registerHelper(\"printStyle\",function(writer){\r\n");
      out.write("\t   var src;\r\n");
      out.write("\t   if(board_reply_replyer!=writer && users_note != 1) {\r\n");
      out.write("\t\t   src=\"display:none;\";\r\n");
      out.write("\t   } else if(users_note == 1) {\r\n");
      out.write("\t\t   src=\"color:red;\";\r\n");
      out.write("\t   }\r\n");
      out.write("\t   return src;\r\n");
      out.write("\t   \r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tgetList();\r\n");
      out.write("\tfunction getList(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\turl:\"QnAReply.json\",\r\n");
      out.write("\t\t\tdata:{\"board_reply_bno\":board_reply_bno, \"page\":page},\r\n");
      out.write("\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\tvar temp=Handlebars.compile($(\"#temp\").html());\r\n");
      out.write("                $(\"#tbl2\").html(temp(data));\r\n");
      out.write("                $(\"#count\").html(data.count);\r\n");
      out.write("                \r\n");
      out.write("              \t//페이지 리스트 출력\r\n");
      out.write("                var str=\"\";\r\n");
      out.write("                if(data.pm.prev){\r\n");
      out.write("                    str += \"<a href='\" + (data.pm.startPage-1) + \"'>◀</a>\"\r\n");
      out.write("                }\r\n");
      out.write("                for(var i=data.pm.startPage; i<= data.pm.endPage; i++){\r\n");
      out.write("                    if(data.pm.cri.page == i){\r\n");
      out.write("                        str += \"[<a href='\" + i + \"' class='active'>\" + i + \"</a>]\";\r\n");
      out.write("                    }else{\r\n");
      out.write("                        str += \"[<a href='\" + i + \"'>\" + i + \"</a>]\";\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                if(data.pm.next){\r\n");
      out.write("                    str += \"<a href='\" + (data.pm.endPage+1)  +  \"'>▶</a>\"\r\n");
      out.write("                }\r\n");
      out.write("                $(\"#pagination\").html(str);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t    //페이지 번호를 클릭했을 경우\r\n");
      out.write("\t    $(\"#pagination\").on(\"click\", \"a\", function(event){\r\n");
      out.write("\t        event.preventDefault();\r\n");
      out.write("\t        page = $(this).attr(\"href\");\r\n");
      out.write("\t        getList();\r\n");
      out.write("\t    });\r\n");
      out.write("\t}\r\n");
      out.write("\t  \r\n");
      out.write("\t$(\"#txtReply\").keydown(function(key){\r\n");
      out.write("\t\tif(key.keyCode==13){\r\n");
      out.write("\t\t\t$(\"#btnInsert\").click();\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//댓글입력\r\n");
      out.write("\t$(\"#btnInsert\").on(\"click\", function(){\r\n");
      out.write("\t\tvar board_reply=$(\"#txtReply\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(board_reply==\"\") {\r\n");
      out.write("\t\t\talert(\"댓글내용을 입력하세요\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t} \r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(board_reply_replyer==\"\") {\r\n");
      out.write("\t\t\tboard_reply_replyer=\"GUEST\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\turl:\"ReplyInsert\",\r\n");
      out.write("\t\t\tdata:{\"board_reply_bno\":board_reply_bno, \"board_reply\":board_reply , \"board_reply_replyer\":board_reply_replyer},\r\n");
      out.write("\t\t\tsuccess:function(){\r\n");
      out.write("\t\t\t\talert(\"댓글이 입력되었습니다.\");\r\n");
      out.write("\t\t\t\t$(\"#txtReply\").val(\"\");\r\n");
      out.write("\t\t\t\tgetList();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//댓글삭제\r\n");
      out.write("\t$(\"#tbl2\").on(\"click\", \".board_reply button\", function(){\r\n");
      out.write("\t\tvar board_reply_rno=$(this).attr(\"rno\");\r\n");
      out.write("\t\tif(!confirm(board_reply_rno + \" 번의 댓글을 삭제하시겠습니까?\")) return;\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\turl:\"ReplyDelete\",\r\n");
      out.write("\t\t\tdata:{\"board_reply_rno\":board_reply_rno},\r\n");
      out.write("\t\t\tsuccess:function(){\r\n");
      out.write("\t\t\t\talert(\"삭제되었습니다.\");\r\n");
      out.write("\t\t\t\tgetList();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
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
