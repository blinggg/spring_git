/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-08-12 01:05:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("\tfont-family: 'Comic Sans MS'\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#menu {\r\n");
      out.write("\twidth: 1780px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\tposition: fixed;\r\n");
      out.write("\tright: 50px;\r\n");
      out.write("\ttop: 30px;\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("\tbackground:white;\r\n");
      out.write("\tbackground-color:rgba(255,255,255,0.3);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#menu1 {\r\n");
      out.write("\twidth: 1780px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\tposition: fixed;\r\n");
      out.write("\tright: 50px;\r\n");
      out.write("\ttop: 100px;\r\n");
      out.write("\ttext-align:right;\r\n");
      out.write("\tbackground:white;\r\n");
      out.write("\tbackground-color:rgba(255,255,255,0.3);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".items0,.items1,.items2,.items3,.items4,.items5,.items6,.items7,.items8,.items5-1{\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\tfont-size: 30px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\ttext-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;\r\n");
      out.write("\tbackground-color:rgba(0.7);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".items1-1,.items2-1,.items3-1,.items4-1,.items2-2{\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\ttext-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;\r\n");
      out.write("\tbackground-color:rgba(0.7);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".items4:hover ,.items0:hover,.items1:hover,.items2:hover,.items3:hover,.items5:hover,.items6:hover,.items7:hover,.items8:hover,.items5-1:hover,.items1-1:hover,.items2-1:hover,.items3-1:hover,.items4-1:hover,.items2-2:hover{\r\n");
      out.write("\tcolor: #e360f2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("   text-decoration:none;\r\n");
      out.write("   color:black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\t<div id=\"menu\">\r\n");
      out.write("\t\t<div class=\"items1\">\r\n");
      out.write("\t\t\t<b>HOME</b>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"items8\">\r\n");
      out.write("\t\t\t<b>PACKAGE</b>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"items0\">\r\n");
      out.write("\t\t\t<b>COSTUME</b>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"items2\">\r\n");
      out.write("\t\t\t<b>Q&A</b>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"items3\">\r\n");
      out.write("\t\t\t<b>FAQ</b>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("     \t");
      if (_jspx_meth_c_005fif_005f5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"menu1\">\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f6(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("<script>\r\n");
      out.write("\t/*HOME메뉴*/\r\n");
      out.write("\t$(\".items1\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/index\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*COSTUME메뉴*/\r\n");
      out.write("\t$(\".items0\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/costumeList\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*PACKAGE메뉴*/\r\n");
      out.write("\tvar URL = window.location.pathname;\r\n");
      out.write("\t$(\".items8\").on(\"click\",function(){\r\n");
      out.write("\t\tif(URL!=\"/index\"){\r\n");
      out.write("\t\t\tlocation.href=\"/packageList\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\twindow.onload = function(){\r\n");
      out.write("\t\t\t({scrollTop : 3000}, 400);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t/*ADMIN USER LIST메뉴*/\r\n");
      out.write("\t$(\".items1-1\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/admin/userlist\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*ADMIN pCHART메뉴*/\r\n");
      out.write("\t$(\".items2-1\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/admin/pchart\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*ADMIN cCHART메뉴*/\r\n");
      out.write("\t$(\".items2-2\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/admin/cchart\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*ADMIN CHART메뉴*/\r\n");
      out.write("\t$(\".items3-1\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/admin/blacklist\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*ADMIN COSTUM INSERT메뉴*/\r\n");
      out.write("\t$(\".items4-1\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/costumeInsert\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*Q&A메뉴*/\r\n");
      out.write("\t$(\".items2\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/QnA\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*FAQ메뉴*/\r\n");
      out.write("\t$(\".items3\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/FAQ\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*CART메뉴*/\r\n");
      out.write("\t$(\".items4\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/user/cart\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*MY PGAE메뉴*/\r\n");
      out.write("\t$(\".items5\").on(\"click\",function(){\r\n");
      out.write("\t\tlocation.href=\"/user/mypage\";\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/*LOGIN메뉴*/\r\n");
      out.write("\t$(\".items6\").on(\"click\",function(){\r\n");
      out.write("\t\tvar options = 'width=500, height=700, top=30, left=30, resizable=no, scrollbars=no, location=no';\r\n");
      out.write("\t\twindow.open('/user/login', 'LOGIN', options);\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("\t");
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
    // /WEB-INF/views/menu.jsp(80,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_note==0}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<div class=\"items4\">\r\n");
        out.write("\t\t\t<b>CART</b>\r\n");
        out.write("\t\t</div>\r\n");
        out.write("\t\t");
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
    // /WEB-INF/views/menu.jsp(85,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_note==0}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<div class=\"items5\">\r\n");
        out.write("\t\t\t<b>MY PAGE</b>\r\n");
        out.write("\t\t</div>\r\n");
        out.write("\t\t");
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
    // /WEB-INF/views/menu.jsp(90,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_id==null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("         <div class=\"items6\">\r\n");
        out.write("            <b>LOGIN</b>\r\n");
        out.write("         </div>\r\n");
        out.write("    \t");
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

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /WEB-INF/views/menu.jsp(95,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_note==1}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t[ ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write(" ] 관리자님\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent(null);
    // /WEB-INF/views/menu.jsp(98,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_note==0 && users_id!=null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t[ <b>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("</b>님 ]\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f5.setParent(null);
    // /WEB-INF/views/menu.jsp(101,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_id!=null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f5 = _jspx_th_c_005fif_005f5.doStartTag();
    if (_jspx_eval_c_005fif_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("         <div class=\"items7\">\r\n");
        out.write("            <a href=\"/user/logout\"><b>LOGOUT</b></a>\r\n");
        out.write("        </div>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f6(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f6.setParent(null);
    // /WEB-INF/views/menu.jsp(108,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users_note==1}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f6 = _jspx_th_c_005fif_005f6.doStartTag();
    if (_jspx_eval_c_005fif_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<div class=\"items1-1\">\r\n");
        out.write("\t\t\t<b>USER LIST</b>\r\n");
        out.write("\t\t</div>\r\n");
        out.write("\t\t<div class=\"items2-1\">\r\n");
        out.write("\t\t\t<b>PACKAGE ORDERS</b>\r\n");
        out.write("\t\t</div>\r\n");
        out.write("\t\t<div class=\"items2-2\">\r\n");
        out.write("\t\t\t<b>COSTUME ORDERS</b>\r\n");
        out.write("\t\t</div>\r\n");
        out.write("\t\t<div class=\"items3-1\">\r\n");
        out.write("\t\t\t<b>BLACK LIST</b>\r\n");
        out.write("\t\t</div>\r\n");
        out.write("\t\t<div class=\"items4-1\">\r\n");
        out.write("\t\t\t<b>COSTUME INSERT</b>\r\n");
        out.write("\t\t</div>\r\n");
        out.write("      ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f6);
    return false;
  }
}