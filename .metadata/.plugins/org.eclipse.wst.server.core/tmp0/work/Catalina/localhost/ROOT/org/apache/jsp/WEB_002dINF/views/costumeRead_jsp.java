/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-08-11 04:22:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class costumeRead_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1592786321749L));
    _jspx_dependants.put("jar:file:/C:/data/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/FINAL/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>COSTUME</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("\tfont-family: '@여기어때 잘난체'\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#page {\r\n");
      out.write("\tbackground: white;\r\n");
      out.write("\tmargin: 15px;\r\n");
      out.write("\tpadding-bottom: 30px;\r\n");
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
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tbl1 {\r\n");
      out.write("\twidth: 80%;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("\tpadding: 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("\tpadding: 15px;\r\n");
      out.write("\tfont-size: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".info {\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tpadding-left: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".title {\r\n");
      out.write("\tfont-size: 50px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("select {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\ttext-align-last: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("select option {\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\ttext-align-last: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".cart,#btnList,input[type=submit] {\r\n");
      out.write("\twidth: 300px;\r\n");
      out.write("\theight: 100px;\r\n");
      out.write("\tfont-size: 35px;\r\n");
      out.write("\tmargin: 2px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tbackground: #e6bbea;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tborder-radius: 3px 3px 3px 3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".cart:active,#btnList:active {\r\n");
      out.write("\tbackground: #cca6cf;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=file] {\r\n");
      out.write("\tvisibility: hidden;\r\n");
      out.write("\theight: 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=text] {\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tborder:none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=number] {\r\n");
      out.write("\twidth:60px;\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tborder:none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn{\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("\tpadding:20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".price input[type='text']{\r\n");
      out.write("\theight: 60px;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tfont-size: 60px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tcolor:#fc8da0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".price{\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tfont-size: 40px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tpadding-left:80px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".name input[type='text']{\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\r\n");
      out.write("\t<div id=\"page\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<div class=\"title\">⊙ COSTUME ⊙</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t<form name=\"frm\" action=\"costumeUpdate\" method=\"post\"\r\n");
      out.write("\t\t\t\tenctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t<!-- <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> -->\r\n");
      out.write("\t\t\t\t<table id=\"tbl1\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th width=150>TITLE</th>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=4 class=\"name\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" value=\"[");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("]\" name=\"lend_costume_code\" readonly size=4>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"lend_costume_name\" size=35>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td rowspan=6 width=500><input type=\"file\" name=\"file\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write(' ');
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write(" <!-- 예시사진 --> \r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"lend_costume_image\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_image}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th width=150>SIZE</th>\r\n");
      out.write("\t\t\t\t\t\t<td width=200><select name=\"size\" id=\"size\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>S</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>M</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>L</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>XL</option>\r\n");
      out.write("\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t\t<th>AMOUNT</th>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"number\" value=\"1\" min=\"1\" id=\"quantity\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=4>\r\n");
      out.write("\t\t\t\t\t\t\t<textarea name=lend_costume_content rows=10 cols=50>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=200 class=\"price\" colspan=4>\r\n");
      out.write("\t\t\t\t\t\t\t\\<input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"lend_costume_price\" size=10>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<div class=\"btn\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"LIST\" id=\"btnList\" onClick=\"location.href='costumeList'\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"장바구니에 담기\" class=\"cart\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "costumeReply.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "chat.jsp", out, false);
      out.write('\r');
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\t//이미지 클릭했을떄\r\n");
      out.write("\t$(\"#image\").on(\"click\", function() { //이미지클릭할때 file클릭한거처럼 됨\r\n");
      out.write("\t\t$(frm.file).click();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t//파일업로드\r\n");
      out.write("\t$(frm.file).on(\"change\", function() {\r\n");
      out.write("\t\tvar file = $(frm.file)[0].files[0]; //1번째 input type=\"file\"에서 이미지 1개만\r\n");
      out.write("\t\t$(\"#image\").attr(\"src\", URL.createObjectURL(file));\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//장바구니 버튼을 클릭했을 때\r\n");
      out.write("\t$(\".cart\").on(\"click\", function(){\r\n");
      out.write("\t\tvar title=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\tvar id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\tvar code=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\tvar quantity=$(\"#quantity\").val();\r\n");
      out.write("\t\tvar price=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\tvar size=$(\"#size\").val();\r\n");
      out.write("\t\tif(!confirm(title + \" 의상을 장바구니에 담으시겠습니까?\")) return;\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\turl:\"/cart/cinsert\",\r\n");
      out.write("\t\t\tdata:{\"costume_cart_id\":id, \"costume_cart_costume_code\":code, \"costume_cart_quantity\":quantity, \"costume_cart_price\":price, \"costume_size\":size},\r\n");
      out.write("\t\t\tsuccess:function(){}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tif(!confirm(\"담겼습니다. 장바구니로 이동하시겠습니까?\")) return;\r\n");
      out.write("\t\tlocation.href=\"user/cart\";\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//수정버튼을 눌렀을 대\r\n");
      out.write("\t$(frm).submit(function(e){\r\n");
      out.write("\t\te.preventDefault();\r\n");
      out.write("\t\tif(!confirm(\"상품정보를 수정하시겠습니까?\")) return;\r\n");
      out.write("\t\tfrm.submit();\r\n");
      out.write("\t\talert(\"상품정보를 수정하였습니다!\");\r\n");
      out.write("\t});\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/views/costumeRead.jsp(157,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_image!=null && vo.lend_costume_image!=''}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t<img id=\"image\" src=\"/display?fileName=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_image}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("\"\r\n");
        out.write("\t\t\t\t\t\t\t\t\twidth=400 />\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/views/costumeRead.jsp(161,15) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.lend_costume_image==null || vo.lend_costume_image==''}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t<img id=\"image\" src=\"http://placehold.it/100x80\" width=100>\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/views/costumeRead.jsp(195,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_note==1}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"수정\">\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }
}
