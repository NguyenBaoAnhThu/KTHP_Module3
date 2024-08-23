package com.example.kthp.models;

import com.example.kthp.entity.HinhThucThanhToan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HinhThucThanhToanModel {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/CHOTHUEPHONGTRO";
        String username = "root";
        String password = "password";
        return DriverManager.getConnection(url, username, password);
    }

    public List<HinhThucThanhToan> getAllHinhThucThanhToan() {
        List<HinhThucThanhToan> list = new ArrayList<>();
        String query = "SELECT * FROM HINHTHUCTHANHTOAN";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                HinhThucThanhToan hinhThuc = new HinhThucThanhToan();
                hinhThuc.setId(rs.getInt("Id"));
                hinhThuc.setTenHinhThuc(rs.getString("TenHinhThuc"));
                list.add(hinhThuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HinhThucThanhToan> searchHinhThucThanhToan(String searchTerm) {
        List<HinhThucThanhToan> list = new ArrayList<>();
        String query = "SELECT * FROM HINHTHUCTHANHTOAN WHERE TenHinhThuc LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + searchTerm + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                HinhThucThanhToan hinhThuc = new HinhThucThanhToan();
                hinhThuc.setId(rs.getInt("Id"));
                hinhThuc.setTenHinhThuc(rs.getString("TenHinhThuc"));
                list.add(hinhThuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertHinhThucThanhToan(HinhThucThanhToan hinhThucThanhToan) {
        String query = "INSERT INTO HINHTHUCTHANHTOAN (TenHinhThuc) VALUES (?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, hinhThucThanhToan.getTenHinhThuc());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHinhThucThanhToan(int id) {
        String query = "DELETE FROM HINHTHUCTHANHTOAN WHERE Id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
