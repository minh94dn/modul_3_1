import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "computerApplicationServlet", value = "/calculator")
public class computerApplicationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("num1"));
        double secondOperand = Double.parseDouble(request.getParameter("num2"));
        String operator = request.getParameter("operator");
        double result=0;
     try {
        result = Calculator.calculate(firstOperand, secondOperand, operator);
     }catch (Exception e){
         e.getMessage();
     }
        request.setAttribute("firstOperand", firstOperand);
        request.setAttribute("secondOperand", secondOperand);
        request.setAttribute("operator", operator);
        request.setAttribute("result", result);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
