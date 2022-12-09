package controller;

import model.Facility;
import service.IFacilityService;
import service.impl.FacilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"})
public class FacilityServlet extends HttpServlet {
    private IFacilityService iFacilityService = new FacilityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                save(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showListFacility(request, response);
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String nameFacility = request.getParameter("nameFacility");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int facilityType = Integer.parseInt(request.getParameter("facilityType"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea;
        if (request.getParameter("poolArea") == null) {
            poolArea = 0;
        } else {
            poolArea = Double.parseDouble(request.getParameter("poolArea"));
        }
        Integer numberOfFloors;
        if (request.getParameter("numberOfFloors") == null) {
            numberOfFloors = 0;
        } else {
            numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        }
        String facilityFree = request.getParameter("facilityFree");

        Facility facility = new Facility(nameFacility, area, cost, maxPeople, rentType, facilityType, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree);
        boolean check = iFacilityService.add(facility);
        String mess = "Thêm mới không thành công !";
        if (check) {
            mess = "Thêm mới thành công !";
        }
        request.setAttribute("mess", mess);
        request.getRequestDispatcher("view/facility/list.jsp");
        showListFacility(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = iFacilityService.delete(id);
        String mess = "Xóa thành công !";
        if (check) {
            mess = "Xóa thành công";
        }
        request.setAttribute("mess", mess);
        request.getRequestDispatcher("view/facility/list.jsp");
        showListFacility(request, response);
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
            case "search":
                search(request, response);
                break;
            default:
                showListFacility(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        double searchCost = Double.parseDouble(request.getParameter("searchCost"));
        String searchRentType = request.getParameter("searchRentType");
        List<Facility> facilityList = iFacilityService.search(searchName, searchCost, searchRentType);
        request.setAttribute("facilityList", facilityList);
        try {
            request.getRequestDispatcher("view/facility/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/facility/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListFacility(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = iFacilityService.showAll();
        request.setAttribute("facilityList", facilityList);
        try {
            request.getRequestDispatcher("view/facility/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
