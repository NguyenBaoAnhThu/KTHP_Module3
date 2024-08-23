package com.example.kthp.controllers;

import com.example.kthp.entity.HinhThucThanhToan;
import com.example.kthp.services.HinhThucThanhToanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HinhThucThanhToanController")
public class HinhThucThanhToanController extends HttpServlet {

    private HinhThucThanhToanService hinhThucThanhToanService;

    @Override
    public void init() throws ServletException {
        super.init();
        hinhThucThanhToanService = new HinhThucThanhToanService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equalsIgnoreCase(action)) {
            showList(request, response);
        } else if ("search".equalsIgnoreCase(action)) {
            search(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HinhThucThanhToan> hinhThucThanhToanList = hinhThucThanhToanService.getAllHinhThucThanhToan();
        request.setAttribute("hinhThucThanhToanList", hinhThucThanhToanList);
        request.getRequestDispatcher("hinhthucthanhtoan-list.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("searchTerm");
        List<HinhThucThanhToan> resultList = hinhThucThanhToanService.searchHinhThucThanhToan(searchTerm);
        request.setAttribute("hinhThucThanhToanList", resultList);
        request.getRequestDispatcher("hinhthucthanhtoan-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equalsIgnoreCase(action)) {
            create(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            delete(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenHinhThuc = request.getParameter("tenHinhThuc");

        if (tenHinhThuc != null && !tenHinhThuc.trim().isEmpty()) {
            HinhThucThanhToan hinhThucThanhToan = new HinhThucThanhToan();
            hinhThucThanhToan.setTenHinhThuc(tenHinhThuc);
            hinhThucThanhToanService.insertHinhThucThanhToan(hinhThucThanhToan);
        }

        response.sendRedirect("HinhThucThanhToanController?action=list");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids");

        if (ids != null) {
            for (String id : ids) {
                hinhThucThanhToanService.deleteHinhThucThanhToan(Integer.parseInt(id));
            }
        }

        response.sendRedirect("HinhThucThanhToanController?action=list");
    }
}
