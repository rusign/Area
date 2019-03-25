package servlet.request;

import com.beans.MessageHolder;
import com.databases.MysqlHandler;
import com.model.RegistrationModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;


public class RegisterController extends HttpServlet {
    private final String VIEW = "/WEB-INF/register.jsp";
    private final String ERROR_START = "<span style=\"color:#e74c3c;text:bold;font-weight:500;\"><i class=\"fa fa-exclamation-triangle\" style=\"margin-right:5px\"></i>";
    private final String ERROR_END  = "</span>";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(VIEW).forward(request, response);

    }

    private void doGet_error(HttpServletRequest request, HttpServletResponse response, String error_message) throws ServletException, IOException {
        request.setAttribute("error_message", ERROR_START + error_message + ERROR_END);
        getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String message = new RegistrationModel().registerNewUser(username, password);
            if (!message.isEmpty())
                doGet_error(request, response, message);
            else
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
