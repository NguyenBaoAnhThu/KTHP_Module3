package com.example.kthp.models;

import com.example.kthp.databases.DatabaseConnect;
import com.example.kthp.entity.HinhThucThanhToan;
import com.example.kthp.entity.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongTroModel {

    public List<PhongTro> getAll() {
        List<PhongTro> list = new ArrayList<>();
        String query = "SELECT pt.Id, pt.TenNguoiThue, pt.SoDienThoai, pt.NgayThue, pt.GhiChu, htt.Id as HinhThucId, htt.TenHinhThuc " +
                "FROM PHONGTRO pt INNER JOIN HINHTHUCTHANHTOAN htt ON pt.HinhThucThanhToan = htt.Id";
        try (Connection conn = DatabaseConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                HinhThucThanhToan htt = new HinhThucThanhToan(rs.getInt("HinhThucId"), rs.getString("TenHinhThuc"));
                PhongTro phongTro = new PhongTro(
                        rs.getInt("Id"),
                        rs.getString("TenNguoiThue"),
                        rs.getString("SoDienThoai"),
                        rs.getDate("NgayThue"),
                        htt,
                        rs.getString("GhiChu")
                );
                list.add(phongTro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean add(PhongTro phongTro) {
        String query = "INSERT INTO PHONGTRO (TenNguoiThue, SoDienThoai, NgayThue, HinhThucThanhToan, GhiChu) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, phongTro.getTenNguoiThue());
            stmt.setString(2, phongTro.getSoDienThoai());
            stmt.setDate(3, new java.sql.Date(phongTro.getNgayThue().getTime()));
            stmt.setInt(4, phongTro.getHinhThucThanhToan().getId());
            stmt.setString(5, phongTro.getGhiChu());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String query = "DELETE FROM PHONGTRO WHERE Id = ?";
        try (Connection conn = DatabaseConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<PhongTro> search(String searchTerm) {
        List<PhongTro> list = new ArrayList<>();
        String query = "SELECT pt.Id, pt.TenNguoiThue, pt.SoDienThoai, pt.NgayThue, pt.GhiChu, htt.Id as HinhThucId, htt.TenHinhThuc " +
                "FROM PHONGTRO pt INNER JOIN HINHTHUCTHANHTOAN htt ON pt.HinhThucThanhToan = htt.Id " +
                "WHERE pt.TenNguoiThue LIKE ? OR pt.SoDienThoai LIKE ?";
        try (Connection conn = DatabaseConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + searchTerm + "%");
            stmt.setString(2, "%" + searchTerm + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    HinhThucThanhToan htt = new HinhThucThanhToan(rs.getInt("HinhThucId"), rs.getString("TenHinhThuc"));
                    PhongTro phongTro = new PhongTro(
                            rs.getInt("Id"),
                            rs.getString("TenNguoiThue"),
                            rs.getString("SoDienThoai"),
                            rs.getDate("NgayThue"),
                            htt,
                            rs.getString("GhiChu")
                    );
                    list.add(phongTro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
