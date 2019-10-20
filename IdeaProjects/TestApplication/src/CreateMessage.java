import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createm")
public class CreateMessage extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/createm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String message = request.getParameter("message");
            SendMessage mess = new SendMessage(message);
            SendMessageDB.insert(mess);
            response.sendRedirect(request.getContextPath()+"/createm");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/createm.jsp").forward(request, response);
        }
    }
}