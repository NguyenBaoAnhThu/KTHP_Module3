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

@WebServlet("/HinhThucThanhToan")
public class HinhThucThanhToanController extends HttpServlet {
    private final HinhThucThanhToanService service = new HinhThucThanhToanService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HinhThucThanhToan> list = service.getAllHinhThucThanhToan();
        req.setAttribute("hinhThucThanhToanList", list);
        req.getRequestDispatcher("/WEB-INF/views/HinhThucThanhToan.jsp").forward(req, resp);
    }
}
