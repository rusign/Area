package servlet.request;

import com.controller.MainController;
import com.getter.AGet;
import com.getter.GetMovieDesc;
import com.getter.GetSensit;
import com.getter.GetYoutube;
import com.model.CookieManager;
import com.poster.APost;
import com.poster.PostFacebook;
import com.poster.PostSlack;
import com.poster.PostTwitter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class APIConnectController  extends HttpServlet {
    private final String VIEW_DISCONNECTED = "/index.jsp";
    private final String VIEW_CONNECTED = "/WEB-INF/APIConnect.jsp";
    private int facebookStep = 0;
    private String _login;

    APost post;
    AGet get;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String LastConnexion = CookieManager.getCookieValue(request);
        facebookStep = 0;
        _login = CookieManager.getCookieValue(request).split(" ")[0];
        System.out.println("login name =" + _login);
        request.setAttribute("Login", _login);
        if (LastConnexion != null) {
            request.setAttribute("facebookHtml", "    <input   name=\"FirstToken\" placeholder=\"enter first token\" type=\"text\">\n" +
                    "    <input   name=\"SecondToken\" placeholder=\"enter second token\" type=\"text\">");
            request.setAttribute("twitterHtml", "   <input   name=\"Token1\" placeholder=\"enter first token\" type=\"text\">\n" +
                    "    <input   name=\"Token2\" placeholder=\"enter second token\" type=\"text\">" +
                    "    <input   name=\"Token3\" placeholder=\"enter first token\" type=\"text\">\n" +
                    "    <input   name=\"Token4\" placeholder=\"enter first token\" type=\"text\">\n");
            request.setAttribute("sensitHtml", "    <input   name=\"FirstToken\" placeholder=\"enter first token\" type=\"text\">");
            request.setAttribute("youtubeHtml", "    <input   name=\"VidId\" placeholder=\"enter video id\" type=\"text\">\n");
            request.setAttribute("slackHtml", "    <input   name=\"token\" placeholder=\"enter token\" type=\"text\">\n");
            request.setAttribute("netfixHtml", "    <input   name=\"desc\" placeholder=\"enter movie name\" type=\"text\">\n");
            getServletContext().getRequestDispatcher(VIEW_CONNECTED).forward(request, response);
        } else {
            getServletContext().getRequestDispatcher(VIEW_DISCONNECTED).forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("sa post");
        String connectName = request.getParameter("connectName");
        switch (connectName) {
            case "facebook":
                System.out.println("facebook");
                doFacebook(request, response);
                break;
            case "twitter":
                System.out.println("twitter");
                doTwitter(request, response);
                break;
            case "sensit":
                System.out.println("sensit");
                doSensit(request, response);
                break;
            case "youtube":
                System.out.println("youtube");
                doYoutube(request, response);
                break;
            case "slack":
                System.out.println("slack");
                doSlack(request, response);
                break;
            case "netfix":
                System.out.println("netfix");
                doNetfix(request, response);
                break;
        }
    }

    private void doFacebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(facebookStep);
        switch (facebookStep) {
            case 0:
                if (!request.getParameter("FirstToken").equals("") && !request.getParameter("SecondToken").equals("")) {
                    post = new PostFacebook(request.getParameter("FirstToken") + ":" + request.getParameter("SecondToken"));
                    post.connect();
                    request.setAttribute("facebookHtml", "<a href=\"" + ((PostFacebook)post).getLink() + "\" target=\"_blank\">link text</a>");
                    facebookStep += 1;
                    request.setAttribute("twitterHtml", "   <input   name=\"Token1\" placeholder=\"enter first token\" type=\"text\">\n" +
                            "    <input   name=\"Token2\" placeholder=\"enter second token\" type=\"text\">" +
                            "    <input   name=\"Token3\" placeholder=\"enter first token\" type=\"text\">\n" +
                            "    <input   name=\"Token4\" placeholder=\"enter first token\" type=\"text\">\n");
                    request.setAttribute("sensitHtml", "    <input   name=\"FirstToken\" placeholder=\"enter first token\" type=\"text\">");
                    request.setAttribute("youtubeHtml", "    <input   name=\"VidId\" placeholder=\"enter video id\" type=\"text\">\n");
                    request.setAttribute("slackHtml", "    <input   name=\"token\" placeholder=\"enter token\" type=\"text\">\n");
                    getServletContext().getRequestDispatcher(VIEW_CONNECTED).forward(request, response);
                } else {
                    request.setAttribute("errorFacebook", "<span style=\"color:red\">bad token</span>");
                    request.setAttribute("facebookHtml", "    <input   name=\"FirstToken\" placeholder=\"enter first token\" type=\"text\">\n" +
                            "    <input   name=\"SecondToken\" placeholder=\"enter second token\" type=\"text\">");
                    doGet(request, response);

                }
                break;
            case 1:
                request.setAttribute("facebookHtml", "<input   name=\"FinalToken\" placeholder=\"enter final token\" type=\"text\">\n");
                facebookStep += 1;
                request.setAttribute("twitterHtml", "   <input   name=\"Token1\" placeholder=\"enter first token\" type=\"text\">\n" +
                        "    <input   name=\"Token2\" placeholder=\"enter second token\" type=\"text\">" +
                        "    <input   name=\"Token3\" placeholder=\"enter first token\" type=\"text\">\n" +
                        "    <input   name=\"Token4\" placeholder=\"enter first token\" type=\"text\">\n");
                request.setAttribute("sensitHtml", "    <input   name=\"FirstToken\" placeholder=\"enter first token\" type=\"text\">");
                request.setAttribute("youtubeHtml", "    <input   name=\"VidId\" placeholder=\"enter video id\" type=\"text\">\n");
                request.setAttribute("slackHtml", "    <input   name=\"token\" placeholder=\"enter token\" type=\"text\">\n");
                getServletContext().getRequestDispatcher(VIEW_CONNECTED).forward(request, response);
                break;
            case 2:
                if (!request.getParameter("FinalToken").equals("")) {
                    ((PostFacebook)post).setCode(request.getParameter("FinalToken"));
                    MainController.getUserController(_login).addPost("Facebook", post);
                    facebookStep = 0;
                    doGet(request, response);
                } else {
                    request.setAttribute("errorFacebook", "<span style=\"color:red\">bad token</span>");
                    request.setAttribute("facebookHtml", "<input   name=\"FinalToken\" placeholder=\"enter final token\" type=\"text\">\n");
                    doGet(request, response);

                }
                break;
        }
    }

    private void doTwitter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tok1 = request.getParameter("Token1");
        String tok2 = request.getParameter("Token2");
        String tok3 = request.getParameter("Token3");
        String tok4 = request.getParameter("Token4");
        String assembler = tok1 + ":" + tok2 + ":" +tok3 + ":" +tok4;
        System.out.println(assembler);
        if(!tok1.equals("") && !tok2.equals("") && !tok3.equals("") && !tok4.equals(""))
        {
            request.setAttribute("facebookHtml", "    <input   name=\"FirstToken\" placeholder=\"enter first token\" type=\"text\">\n" +
                    "    <input   name=\"SecondToken\" placeholder=\"enter second token\" type=\"text\">");
            request.setAttribute("twitterHtml", "  <input   name=\"Token1\" placeholder=\"enter first token\" type=\"text\">\n" +
                    "    <input   name=\"Token2\" placeholder=\"enter second token\" type=\"text\">" +
                    "    <input   name=\"Token3\" placeholder=\"enter first token\" type=\"text\">\n" +
                    "    <input   name=\"Token4\" placeholder=\"enter first token\" type=\"text\">\n");
            request.setAttribute("sensitHtml", "    <input   name=\"FirstToken\" placeholder=\"enter first token\" type=\"text\">");
            post = new PostTwitter(assembler);
            if (!post.connect()) {
                request.setAttribute("errorTwitter", "<span style=\"color:red\">bad token</span>");
                doGet(request,response);
            } else {
                MainController.getUserController(_login).addPost("Twitter", post);
            }
            doGet(request, response);
        }
        else
        {
            request.setAttribute("errorTwitter", "<span style=\"color:red\">bad token</span>");
            doGet(request, response);

        }

    }

    private void doSensit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tok1 = request.getParameter("FirstToken");
        if(!tok1.equals(""))
        {
            request.setAttribute("facebookHtml", "    <input   name=\"FirstToken\" placeholder=\"enter first token\" type=\"text\">\n" +
                    "    <input   name=\"SecondToken\" placeholder=\"enter second token\" type=\"text\">");
            request.setAttribute("twitterHtml", "  <input   name=\"Token1\" placeholder=\"enter first token\" type=\"text\">\n" +
                    "    <input   name=\"Token2\" placeholder=\"enter second token\" type=\"text\">" +
                    "    <input   name=\"Token3\" placeholder=\"enter first token\" type=\"text\">\n" +
                    "    <input   name=\"Token4\" placeholder=\"enter first token\" type=\"text\">\n");
            request.setAttribute("sensitHtml", "    <input   name=\"FirstToken\" placeholder=\"enter first token\" type=\"text\">");
          //  post = new PostTwitter(assembler);
            get = new GetSensit(tok1);
            if (!get.connect()) {
                request.setAttribute("errorSensit", "<span style=\"color:red\">bad token</span>");
                doGet(request,response);

            } else {
                MainController.getUserController(_login).addGet("Sensit", get);
            }
           doGet(request, response);
        }
        else
        {
            request.setAttribute("errorSensit", "<span style=\"color:red\">bad token</span>");
            doGet(request,response);

        }

    }

    private void doYoutube(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("VidId");
        if (!id.equals("")){
            GetYoutube.setVidId(id);
        }
        else {
            request.setAttribute("errorYoutube", "<span style=\"color:red\">bad token</span>");
            doGet(request,response);
        }
        doGet(request,response);
    }

    private void doSlack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String tok = request.getParameter("token");
        if (!tok.equals("")){
            post = new PostSlack(tok);
            MainController.getUserController(_login).addPost("Slack", post);
        }
        else {
            request.setAttribute("errorSlack", "<span style=\"color:red\">bad token</span>");
            doGet(request,response);
        }
        doGet(request,response);
    }
    private void doNetfix(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String tok = request.getParameter("desc");
        if (!tok.equals("")){
            get = new GetMovieDesc(tok);
            MainController.getUserController(_login).addGet("Netfix", get);
        }
        else {
            request.setAttribute("errorNetfix", "<span style=\"color:red\">bad token</span>");
            doGet(request,response);
        }
        doGet(request,response);
    }
}
