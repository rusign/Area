package com.utils;


public class HtmlCode {

    public static String getHCode(String value, String iconGet, String iconPost, String message){
        return " <li>\n" +
                "<form method=\"post\" action=\"\">"+
                "    <input name=\"connectName\" value=\""+ value +"\" type=\"hidden\">"+
                "              <div id=\"boxer-cards\">\n" +
                "                <div class=\"cards\">\n" +
                "                 <ul class=\"box-images\">\n" +
                "                   <li>\n" +
                "                   <img class=\"resize\" src=\""+ iconGet +"\" alt=\"\">\n" +
                "                   </li>\n" +
                "                   <li>\n" +
                "                     <img class=\"resize\" src=\"images/add.png\" alt=\"\">\n" +
                "                   </li>\n" +
                "                   <li>\n" +
                "                     <img class=\"resize\" src=\""+ iconPost +"\" alt=\"\">\n" +
                "                   </li>\n" +
                "                 </ul>" +
                "                  <div class=\"box-title\">\n" +
                "                    <h1>"+ message +"</h1>\n" +
                "                  </div>\n" +
                "                  <div>\n" +
                "                    <input class=\"myButton\" type=\"submit\" value=\"Delete\" style=\"\n" +
                "                       background-color: #e74c3c;\n" +
                "                       border: none;\n" +
                "                       color: white;\n" +
                "                       text-align: center;\n" +
                "                       text-decoration: none;\n" +
                "                       display: inline-block;\n" +
                "                       font-size: 20px;\n" +
                "                       cursor: pointer;\n" +
                "                       padding-bottom: 7px;\n" +
                "                       padding-top: 7px;\n" +
                "                       padding-left: 20px;\n" +
                "                       padding-right: 20px;\n" +
                "                       border-radius: 2em;\">" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "</form>" +
                "</li>";
    }

}
