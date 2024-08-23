package com.example.kthp.controllers;

import com.example.kthp.entity.PhongTro;
import com.example.kthp.services.PhongTroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/phongtro")
public class PhongTroController extends HttpServlet {
    private PhongTroService phongTroService;

    @Override
    public void init() throws ServletException {
        super.init();
        phongTroService = new PhongTroService(); // Initialize the service
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            showCreateForm(request, response);
        } else if ("search".equals(action)) {
            searchPhongTro(request, response);
        } else {
            listPhongTro(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createPhongTro(request, response);
        } else if ("delete".equals(action)) {
            deletePhongTro(request, response);
        } else {
            listPhongTro(request, response);
        }
    }

    private void listPhongTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("searchTerm");
        List<PhongTro> phongTroList;

        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            phongTroList = phongTroService.searchPhongTro(searchTerm);
        } else {
            phongTroList = phongTroService.getAllPhongTro();
        }

        request.setAttribute("phongTroList", phongTroList);
        request.setAttribute("searchTerm", searchTerm); // Preserve search term
        request.getRequestDispatcher("/views/PhongTroList.jsp").forward(request, response);
    }

    private void searchPhongTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("searchTerm");
        List<PhongTro> phongTroList = phongTroService.searchPhongTro(searchTerm);
        request.setAttribute("phongTroList", phongTroList);
        request.setAttribute("searchTerm", searchTerm); // Preserve search term
        request.getRequestDispatcher("/views/PhongTroList.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/PhongTroCreate.jsp").forward(request, response);
    }

    private void createPhongTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhongTro phongTro = new PhongTro();
        phongTro.setTenNguoiThue(request.getParameter("tenNguoiThue"));
        phongTro.setSoDienThoai(request.getParameter("soDienThoai"));
        phongTro.setNgayThue(parseDate(request.getParameter("ngayThue")));
        phongTro.setHinhThucThanhToan(Integer.parseInt(request.getParameter("hinhThucThanhToan")));
        phongTro.setGhiChu(request.getParameter("ghiChu"));

        boolean isCreated = phongTroService.insertPhongTro(phongTro);
        if (isCreated) {
            response.sendRedirect(request.getContextPath() + "/phongtro");
        } else {
            request.setAttribute("error", "Failed to create PhongTro.");
            request.getRequestDispatcher("/views/PhongTroCreate.jsp").forward(request, response);
        }
    }

    private void deletePhongTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids");

        if (ids != null) {
            for (String id : ids) {
                try {
                    int phongTroId = Integer.parseInt(id);
                    phongTroService.deletePhongTro(phongTroId);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        response.sendRedirect(request.getContextPath() + "/phongtro");
    }

    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
