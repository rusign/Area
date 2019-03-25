package servlet.request;

import com.model.CookieManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class logout extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        System.out.println("IZI");
        session.invalidate();
        CookieManager.DeleteCookie(resp);
        resp.sendRedirect("/area-1.0-SNAPSHOT/");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }
}
