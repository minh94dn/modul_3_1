package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    IUserService iUserService = new UserService();

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
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "sort":
                sort(request, response);
                break;
            default:
                showListUser(request, response);
        }


    }

    private void sort(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = iUserService.sort();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("view/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = iUserService.delete(id);
        String mess = "Xóa không thành công";
        if (check) {
            mess = "Xóa thành công";
            request.setAttribute("mess", mess);
            showListUser(request, response);
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        boolean check = iUserService.edit(user);
        String mess = "Chỉnh sửa không thành công";
        if (check) {
            mess = "Chỉnh sửa thành công";
        }
        request.setAttribute("mess", mess);
        showListUser(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        boolean check = iUserService.add(user);
        String mess = "Thêm mới không thành công";
        if (check) {
            mess = "Thêm mới thành công!";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/user/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                showListUser(request, response);
        }

    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = iUserService.showAll();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("view/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        request.setAttribute("country", country);
        List<User> userList = iUserService.search(country);
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("view/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = iUserService.findById(id);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("view/user/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/user/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

