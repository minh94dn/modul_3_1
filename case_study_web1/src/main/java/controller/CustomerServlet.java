package controller;

import model.Customer;
import model.CustomerType;
import repository.ICustomerTypeRepository;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerService;
import service.impl.CustomerTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();
    private ICustomerTypeService iCustomerTypeService = new CustomerTypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                save(request, response);
                break;
            case "edit":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showListCustomer(request, response);
        }


    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = iCustomerService.delete(id);
        String mess = "Xóa không thành công !";
        if(check){
            mess= "Xóa thành công !";
        }
        request.setAttribute("mess", mess);
        request.getRequestDispatcher("view/customer/list.jsp");
        showListCustomer(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int idCustomerType = Integer.parseInt(request.getParameter("nameCustomerType"));
        String nameCustomer = request.getParameter("nameCustomer");
        String dayOfBirth = request.getParameter("dayOfBirth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, idCustomerType, nameCustomer, dayOfBirth, gender, idCard, phoneNumber, email, address);
        boolean check = iCustomerService.edit(customer);
        String mess = "Chỉnh sửa không thành công !";
        if(check){
            mess= "Chỉnh sửa thành công !";
        }
        request.setAttribute("mess", mess);
        request.getRequestDispatcher("view/customer/list.jsp");
        showListCustomer(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCustomerType = Integer.parseInt(request.getParameter("nameCustomerType"));
        String nameCustomer = request.getParameter("nameCustomer");
        String dayOfBirth = request.getParameter("dayOfBirth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(idCustomerType, nameCustomer, dayOfBirth, gender, idCard, phoneNumber, email, address);
        boolean check = iCustomerService.add(customer);
        String mess = "Thêm mới không thành công !";
        if (check) {
            mess = "Thêm mới thành công !";
        }
        request.setAttribute("mess", mess);
        request.getRequestDispatcher("view/customer/list.jsp");
        showListCustomer(request, response);
//        response.sendRedirect("/customer");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormAdd(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showListCustomer(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        String addressSearch = request.getParameter("addressSearch");
        List<Customer> customerList = iCustomerService.search(nameSearch, addressSearch);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerTypeService.showAll();
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.findByID(id);
        request.setAttribute("customer", customer);
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/customer/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = iCustomerService.showAll();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
