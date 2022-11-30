import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "displayListCustomerServlet", value = "/customer")
public class displayListCustomerServlet extends javax.servlet.http.HttpServlet {
    static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("Minh", "24/05/1994", "Đà Nẵng", "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg"));
        customerList.add(new Customer("Thắng", "24/05/2004", "Đà Nẵng", "http://www.elle.vn/wp-content/uploads/2017/07/25/hinh-anh-dep-1.jpg"));
        customerList.add(new Customer("Sỹ", "24/05/1997", "Đà Nẵng", "https://thuthuatphanmem.vn/uploads/2018/09/11/hinh-anh-dep-6_044127357.jpg"));
        customerList.add(new Customer("Cường", "24/05/2001", "Đà Nẵng", "https://s3.cloud.cmctelecom.vn/tinhte1/2018/11/4482526_beach_sunset_wallpaper.jpg"));
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/displayListCustomer.jsp");
        requestDispatcher.forward(request, response);
    }
}
