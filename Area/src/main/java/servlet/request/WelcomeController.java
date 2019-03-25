package servlet.request;

import com.beans.Scheduler;
import com.model.CookieManager;
import com.model.ServicesModel;
import com.utils.HtmlCode;
import com.utils.ServicesHandler;
import com.utils.objForService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.utils.ServicesHandler.getSh;

public class WelcomeController extends HttpServlet {
    private final String VIEW_DISCONNECTED = "/index.jsp";
    private final String VIEW_CONNECTED = "/index-registered.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String LastConnexion = CookieManager.getCookieValue(request);
        if (LastConnexion != null) {
            request.setAttribute("Login", CookieManager.getCookieValue(request).split(" ")[0]);
            String cards = "";
            try {
                ServicesModel sm = new ServicesModel(CookieManager.getCookieValue(request).split(" ")[0]);
             //   sm.addServices("Redtube", "Twitter");
                sm.getServices();
                cards = sm.getRes();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (cards.isEmpty())
                cards =  "<a  href=\"connectAPI\" class=\"btn-class\">Get started</a>";
            request.setAttribute("cards", cards);
            getServletContext().getRequestDispatcher(VIEW_CONNECTED).forward(request, response);
        } else {
            //request.setAttribute("cookie_message", "[" + derniereConnexion + "]");
            getServletContext().getRequestDispatcher(VIEW_DISCONNECTED).forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getServletContext().getRequestDispatcher("/WEB-INF/APIConnect.jsp").forward(request, response);
        System.out.println("SA POSTE DANS WELCOMECONTRIOLLER");
        String connectName = request.getParameter("connectName");
        Scheduler.removeSchedule(connectName);
        doGet(request,response);
    }
}
