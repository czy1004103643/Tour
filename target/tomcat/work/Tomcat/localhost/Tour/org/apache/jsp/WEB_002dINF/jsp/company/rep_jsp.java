/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-03-06 12:25:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.company;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class rep_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    ");

        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    
      out.write("\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("    <title>结伴</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<form id=\"rep\">\n");
      out.write("\n");
      out.write("    活动标题：<input type=\"text\" name=\"title\"> <br>\n");
      out.write("    联系方式：<input type=\"text\" name=\"contact\"> <br>\n");
      out.write("    目的地：<input type=\"text\" name=\"dest.id\"> <br>\n");
      out.write("    出发地：<input type=\"text\" name=\"start.id\"> <br>\n");
      out.write("    出发日期:<input type=\"text\" name=\"date\"> <br>\n");
      out.write("    活动天数:<input type=\"text\" name=\"last\"> <br>\n");
      out.write("    限制人数：<input type=\"text\" name=\"num\"> <br>\n");
      out.write("    结伴描述：<textarea name=\"desc\"></textarea> <br>\n");
      out.write("    <input type=\"hidden\" name=\"user.id\" value=\"123456\">\n");
      out.write("    <button type=\"button\" onclick=\"rep()\">发布问题</button>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<script src=\"js/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/jquery.form.js\" type=\"text/javascript\"></script>\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("    function rep() {\n");
      out.write("        $('#rep').ajaxSubmit({\n");
      out.write("            url: 'comins',\n");
      out.write("            type: 'post',\n");
      out.write("            dataType: 'json',\n");
      out.write("            success: function (data) {\n");
      out.write("                if (data.success) {\n");
      out.write("                    alert('success');\n");
      out.write("                    location.href = 'company/detail/' + data.msg;\n");
      out.write("                } else {\n");
      out.write("                    alert(data.msg);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
