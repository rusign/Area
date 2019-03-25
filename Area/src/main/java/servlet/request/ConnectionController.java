package servlet.request;

import com.beans.MessageHolder;
import com.databases.MysqlHandler;
import com.model.ConnectionModel;
import com.model.CookieManager;
import com.model.ServicesModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

public class ConnectionController  extends HttpServlet {
    private final String VIEW = "/WEB-INF/connection.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String derniereConnexion = CookieManager.getCookieValue(request);
        if (derniereConnexion != null) {
            getServletContext().getRequestDispatcher("/index-registered.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher(VIEW).forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            MessageHolder m = new ConnectionModel().connectNewUser(username, password);
            if (m.m_code == 200) {
                System.err.println(m.m_message);
                CookieManager.setCookie(response, username + " " + password);
                String cards = "";

                    cards =  "<a  href=\"connectAPI\" class=\"btn-class\">Get started</a>";
                request.setAttribute("cards", cards);
                getServletContext().getRequestDispatcher("/index-registered.jsp").forward(request, response);
            } else {
                System.err.println(m.m_message);
                doGet(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
