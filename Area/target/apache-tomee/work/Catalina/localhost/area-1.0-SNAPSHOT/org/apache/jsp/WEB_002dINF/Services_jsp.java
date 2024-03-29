/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat (TomEE)/7.0.55 (1.7.1)
 * Generated at: 2017-01-17 18:58:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Services_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<!--\n");
      out.write("Material Design Lite\n");
      out.write("Copyright 2015 Google Inc. All rights reserved.\n");
      out.write("\n");
      out.write("Licensed under the Apache License, Version 2.0 (the \"License\");\n");
      out.write("you may not use this file except in compliance with the License.\n");
      out.write("You may obtain a copy of the License at\n");
      out.write("\n");
      out.write("https://www.apache.org/licenses/LICENSE-2.0\n");
      out.write("\n");
      out.write("Unless required by applicable law or agreed to in writing, software\n");
      out.write("distributed under the License is distributed on an \"AS IS\" BASIS,\n");
      out.write("WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n");
      out.write("See the License for the specific language governing permissions and\n");
      out.write("limitations under the License\n");
      out.write("-->\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"description\" content=\"A front-end template that helps you build fast, modern mobile web apps.\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <title>Services</title>\n");
      out.write("\n");
      out.write("    <!-- Add to homescreen for Chrome on Android -->\n");
      out.write("    <meta name=\"mobile-web-app-capable\" content=\"yes\">\n");
      out.write("    <link rel=\"icon\" sizes=\"192x192\" href=\"images/android-desktop.png\">\n");
      out.write("\n");
      out.write("    <!-- Add to homescreen for Safari on iOS -->\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n");
      out.write("    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\n");
      out.write("    <meta name=\"apple-mobile-web-app-title\" content=\"Material Design Lite\">\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" href=\"images/ios-desktop.png\">\n");
      out.write("\n");
      out.write("    <!-- Tile icon for Win8 (144x144 + tile color) -->\n");
      out.write("    <meta name=\"msapplication-TileImage\" content=\"images/touch/ms-touch-icon-144x144-precomposed.png\">\n");
      out.write("    <meta name=\"msapplication-TileColor\" content=\"#3372DF\">\n");
      out.write("\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/favicon.png\">\n");
      out.write("\n");
      out.write("    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->\n");
      out.write("    <!--\n");
      out.write("    <link rel=\"canonical\" href=\"http://www.example.com/\">\n");
      out.write("    -->\n");
      out.write("\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/material.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/Services.css\">\n");
      out.write("\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Baloo+Thambi\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Anton\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        #view-source {\n");
      out.write("            position: fixed;\n");
      out.write("            display: block;\n");
      out.write("            right: 0;\n");
      out.write("            bottom: 0;\n");
      out.write("            margin-right: 40px;\n");
      out.write("            margin-bottom: 40px;\n");
      out.write("            z-index: 900;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"topbar\">\n");
      out.write("    <div style=\" float: left; width: 25%; height: 90px;display:table\">\n");
      out.write("        <span class=\"topbar-left\">AREA</span>\n");
      out.write("    </div>\n");
      out.write("    <div style=\"float: right; height: 90px;display:table;margin-top: 20px;margin-right: 13%;\">\n");
      out.write("        <button class=\"standard-button\" onclick=\"location.href='index'\">Home</button>\n");
      out.write("        <button class=\"standard-button\" onclick=\"location.href='connectAPI'\">Connection</button>\n");
      out.write("        <button class=\"standard-button\" onclick=\"location.href='Services'\">Services</button>\n");
      out.write("        <button class=\"signout-button\" onclick=\"location.href='logout'\">Sign out</button>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<main class=\"connectC\">\n");
      out.write("    <h1 class=\"titles-service\">Connect Your Services Each Other</h1>\n");
      out.write("    </br>\n");
      out.write("    </br>\n");
      out.write("    <form method=\"post\" action=\"Services\" style=\"text-align: center\">\n");
      out.write("        <div class=\"styled-select\">\n");
      out.write("            <div style=\"display: table-cell;float: left;margin-left: 25%;\">\n");
      out.write("                <select id=\"GetChoice\" name=\"getChoice\">\n");
      out.write("                    <option value=\"Redtube\">Redtube</option>\n");
      out.write("                    <option value=\"Sensit\">Sensit</option>\n");
      out.write("                    <option value=\"Geolocalisation\">Geolocalisation</option>\n");
      out.write("                    <option value=\"Youtube\">Youtube</option>\n");
      out.write("                    <option value=\"Netfix\">Netfix</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div style=\"display: table-cell;float: right;margin-right: 25%;\">\n");
      out.write("                <select id=\"PostChoice\" name=\"postChoice\" onchange=\"choiceDisplay()\">\n");
      out.write("                    <option value=\"Twitter\">Twitter</option>\n");
      out.write("                    <option value=\"Slack\">Slack</option>\n");
      out.write("                    <option value=\"Facebook\">Facebook</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
      out.write("        <input style=\"margin-top: 40px\" class=\"intext\" id=\"chan\" name=\"channel\" value=\"enter channel\" type=\"hidden\">\n");
      out.write("        <br><br>\n");
      out.write("        <div style=\"text-align: center;\">\n");
      out.write("            <input class=\"myButton\" type=\"submit\" value=\"Validate\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorServices}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("    <script>\n");
      out.write("        function choiceDisplay() {\n");
      out.write("            var x = document.getElementById(\"PostChoice\").value;\n");
      out.write("            if (x == \"Yammer\" || x == \"Slack\" || x == \"Facebook\")\n");
      out.write("            {\n");
      out.write("                document.getElementById('chan').type =\"text\";\n");
      out.write("                document.getElementById('chan').value =\"\";\n");
      out.write("            }\n");
      out.write("            else {\n");
      out.write("                document.getElementById('chan').type =\"hidden\";\n");
      out.write("                document.getElementById('chan').value =\"\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    </br>\n");
      out.write("    </br>\n");
      out.write("    </ul>\n");
      out.write("    </br>\n");
      out.write("    </br>\n");
      out.write("    </br>\n");
      out.write("    </br>\n");
      out.write("</main>\n");
      out.write("\n");
      out.write("<script src=\"js/material.min.js\"></script>\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
