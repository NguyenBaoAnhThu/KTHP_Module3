package com.example.kthp.controllers;

import com.example.kthp.entity.HinhThucThanhToan;
import com.example.kthp.entity.PhongTro;
import com.example.kthp.services.HinhThucThanhToanService;
import com.example.kthp.services.PhongTroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/phongtro")
public class PhongTroController extends HttpServlet {
    private final PhongTroService phongTroService = new PhongTroService();
    private final HinhThucThanhToanService hinhThucThanhToanService = new HinhThucThanhToanService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            List<HinhThucThanhToan> hinhThucThanhToanList = hinhThucThanhToanService.getAllHinhThucThanhToan();
            req.setAttribute("hinhThucThanhToanList", hinhThucThanhToanList);
            req.getRequestDispatcher("/views/PhongTroCreate.jsp").forward(req, resp);
        } else {
            List<PhongTro> list = phongTroService.getAllPhongTro();
            req.setAttribute("phongTroList", list);
            req.getRequestDispatcher("/views/PhongTroList.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            String[] ids = req.getParameterValues("ids");
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
            resp.sendRedirect(req.getContextPath() + "/phongtro");
        } else {
            String tenNguoiThue = req.getParameter("tenNguoiThue");
            String soDienThoai = req.getParameter("soDienThoai");
            Date ngayThue = new Date();
            int hinhThucThanhToanId = Integer.parseInt(req.getParameter("hinhThucThanhToanId"));
            String ghiChu = req.getParameter("ghiChu");

            HinhThucThanhToan hinhThucThanhToan = hinhThucThanhToanService.getHinhThucThanhToanById(hinhThucThanhToanId);
            PhongTro phongTro = new PhongTro(0, tenNguoiThue, soDienThoai, ngayThue, hinhThucThanhToan, ghiChu);

            boolean isSuccess = phongTroService.addPhongTro(phongTro);
            if (isSuccess) {
                resp.sendRedirect(req.getContextPath() + "/phongtro");
            } else {
                req.setAttribute("error", "Failed to add Phong Tro");
                List<HinhThucThanhToan> hinhThucThanhToanList = hinhThucThanhToanService.getAllHinhThucThanhToan();
                req.setAttribute("hinhThucThanhToanList", hinhThucThanhToanList);
                req.getRequestDispatcher("/views/PhongTroCreate.jsp").forward(req, resp);
            }
        }
    }
}
