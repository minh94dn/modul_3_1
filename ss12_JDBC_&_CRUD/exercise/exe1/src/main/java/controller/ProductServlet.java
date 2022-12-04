package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    private IProductService iProductService = new ProductService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(request, response);
                break;
            case "edit":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showListProduct(request, response);
        }

    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = iProductService.showAll();
        request.setAttribute("productList",productList);
        try {
            request.getRequestDispatcher("view/product/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFromAdd(request, response);
                break;
            case "edit":
                showFromEdit(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showListProduct(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showFromEdit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showFromAdd(HttpServletRequest request, HttpServletResponse response) {
    }
}
