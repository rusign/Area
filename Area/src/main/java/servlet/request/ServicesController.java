package servlet.request;

import com.beans.Scheduler;
import com.controller.MainController;
import com.databases.MysqlHandler;
import com.model.CookieManager;
import com.model.ServicesModel;
import com.utils.ServicesHandler;
import com.utils.objForService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ServicesController extends HttpServlet {
    private final String VIEW_DISCONNECTED = "/index.jsp";
    private final String VIEW_CONNECTED = "/WEB-INF/Services.jsp";
    private String _login;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String LastConnexion = CookieManager.getCookieValue(request);
        if (LastConnexion != null) {
            _login = CookieManager.getCookieValue(request).split(" ")[0];
            request.setAttribute("Login", _login);
            getServletContext().getRequestDispatcher(VIEW_CONNECTED).forward(request, response);
        } else {
            getServletContext().getRequestDispatcher(VIEW_DISCONNECTED).forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("sa post");
            ServicesModel sm = new ServicesModel(_login);
            String getc = request.getParameter("getChoice");
            String postc = request.getParameter("postChoice");
            String channel = request.getParameter("channel");
            String ass =getc + ":" + postc + ":" + _login;
            System.out.println(getc);
            System.out.println(postc);
            System.out.println(channel);
         //   sm.addServices(getc, postc);
            //MainController.getUserController(_login).addGet(getc,MainController.getUserController(_login).getGetter(getc));
            //MainController.getUserController(_login).addPost(postc,MainController.getUserController(_login).getPoster(postc));
            if (Scheduler.getMap().containsKey(ass))
            {
                request.setAttribute("Login", _login);
                request.setAttribute("errorServices", "<p >Services Already present</p>");
                getServletContext().getRequestDispatcher(VIEW_CONNECTED).forward(request, response);
            }
            else if (!MainController.getUserController(_login).getGetMap().containsKey(getc))
            {
                request.setAttribute("Login", _login);
                request.setAttribute("errorServices", "<p >" + getc +" not install</p>");
                getServletContext().getRequestDispatcher(VIEW_CONNECTED).forward(request, response);
            }
            else if (!MainController.getUserController(_login).getPostMap().containsKey(postc))
            {
                request.setAttribute("Login", _login);
                request.setAttribute("errorServices", "<p >" + postc + " not install</p>");
                getServletContext().getRequestDispatcher(VIEW_CONNECTED).forward(request, response);
            }
            else{
                MainController.getUserController(_login).addSchedule(getc + ":" + postc + ":" + _login, MainController.getUserController(_login).getGetter(getc), MainController.getUserController(_login).getPoster(postc), channel);
                System.out.println("Add schedule for " + _login);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(request,response);
    }
}