import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/getm")
public class GetMessage extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<SendMessage> mess = SendMessageDB.select();
        request.setAttribute("mess", mess);

        getServletContext().getRequestDispatcher("/getm.jsp").forward(request, response);
    }
}
