/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-03-06 12:24:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.destination;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\"/>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/guidestyle.css\">\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css'>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/pagination.css\">\n");
      out.write("    <style>\n");
      out.write("    .thisfooter{\n");
      out.write("    \t\n");
      out.write("    }\n");
      out.write("    .footer{\n");
      out.write("     position:relative;\n");
      out.write("    }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body style=\"background-color: #ffffff\">\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("<div>\n");
      out.write("    <ul>\n");
      out.write("        <li style=\" margin-bottom: 50px; margin-top: 30px\">\n");
      out.write("            <div id=\"travelSearch\">\n");
      out.write("                <div name=\"searchTop\" action=\"guideListResult\" class=\"travelSearch-form clearfix\" target=\"_top\">\n");
      out.write("                    <fieldset>\n");
      out.write("                        <legend>搜索</legend>\n");
      out.write("                        <div class=\"travelSearch-input clearfix\">\n");
      out.write("                            <div class=\"s-combobox\" id=\"s-combobox-119\">\n");
      out.write("                                <div class=\"s-combobox-input-wrap\">\n");
      out.write("                                    <input type=\"text\" name=\"name\" style=\"text-align:left\" id=\"name\"\n");
      out.write("                                           class=\"s-combobox-input\" title=\"请输入搜索文字\" aria-label=\"请输入搜索文字\">\n");
      out.write("                                </div>\n");
      out.write("                                <button onclick=\"Query(1)\">搜索<s></s></button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </fieldset>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <div class=\"product_list qzlist2\"\n");
      out.write("                 style=\" height: auto; width: 970px; margin: 0 auto\">\n");
      out.write("                <hr size=\"1\">\n");
      out.write("                <ul id=\"guideInfo\" style=\"margin-top: 30px\">\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"clear\"></div>\n");
      out.write("                <div id=\"page\" class=\"M-box3\" style=\"align: center;z-index: -1;margin-top:30px;margin-bottom:30px;z-index: 1\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </li>\n");
      out.write("    </ul>\n");
      out.write("\t\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"thisfooter\">\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../footer.jsp", out, false);
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script src=\"js/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/jquery.pagination.js\" type=\"text/javascript\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("    $(function () {\n");
      out.write("        Query(1);\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    function Query(page) {\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'deslist',\n");
      out.write("            type: 'post',\n");
      out.write("            data: {\n");
      out.write("                page: page,\n");
      out.write("                rows: 5,\n");
      out.write("                name: $(\"#name\").val()\n");
      out.write("            },\n");
      out.write("            dataType: 'json',\n");
      out.write("            success: function (data) {\n");
      out.write("                var currentPage = data.currentPage;\n");
      out.write("                var totalPage = data.totalPage;\n");
      out.write("                var totalCount = data.totalCount;\n");
      out.write("                var html = '';\n");
      out.write("                if (data.list == null || data.list.length == 0) {\n");
      out.write("                    alert('没有数据');\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                $.each(data.list, function () {\n");
      out.write("                    html += '<li id=\"' + this.id + '\"><div style=\"margin-left: 40px\"><div class=\"product_pic\"><img src=\"' + this.picture + '\" height=\"100px\" width=\"100px\"></div><div class=\"product_con\"><div class=\"pro_info\"><h2 style=\"height: 32px\"><span style=\"text-align: justify\">' + this.address + '<span style=\"color: #6d757a;font-size: large\"><img src=\"images/pageviews.png\"/>('+this.hit+')</span></span>';\n");
      out.write("                    if(this.hit>=500){\n");
      out.write("                        html += '<img src=\"images/hot.png\" style=\"margin-left: 10px\"/>';\n");
      out.write("                    }\n");
      out.write("                    html += '</h2><br/><div style=\"margin-top: 5px\"><span class=\"txt\">' + this.outline + '</span></div></div></div></div></li>';\n");
      out.write("                });\n");
      out.write("                $('#guideInfo').html('').append(html);\n");
      out.write("                $(\"#page\").pagination({\n");
      out.write("                    pageCount: totalPage,\n");
      out.write("                    totalData: totalCount,\n");
      out.write("                    current: currentPage,\n");
      out.write("                    homePage: '首页',\n");
      out.write("                    endPage: '末页',\n");
      out.write("                    prevContent: '上页',\n");
      out.write("                    nextContent: '下页',\n");
      out.write("                    jump: true,\n");
      out.write("                    coping: true,\n");
      out.write("                    callback: function (index) {\n");
      out.write("                        Query(index.getCurrent());\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                $('li[id]').each(function () {\n");
      out.write("                    $(this).click(function () {\n");
      out.write("                        window.open('destination/detail/' + $(this).attr('id'));\n");
      out.write("                    })\n");
      out.write("                })\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("\n");
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