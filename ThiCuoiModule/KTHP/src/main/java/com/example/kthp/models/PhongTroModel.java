package com.example.kthp.models;

import com.example.kthp.databases.DatabaseConnect;
import com.example.kthp.entity.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongTroModel {

    public List<PhongTro> getAllPhongTro() {
        List<PhongTro> phongTroList = new ArrayList<>();
        String query = "SELECT * FROM PHONGTRO";

        try (Connection connection = DatabaseConnect.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                PhongTro phongTro = new PhongTro();
                phongTro.setId(resultSet.getInt("Id"));
                phongTro.setTenNguoiThue(resultSet.getString("TenNguoiThue"));
                phongTro.setSoDienThoai(resultSet.getString("SoDienThoai"));
                phongTro.setNgayThue(resultSet.getDate("NgayThue"));
                phongTro.setHinhThucThanhToan(resultSet.getInt("HinhThucThanhToan"));
                phongTro.setGhiChu(resultSet.getString("GhiChu"));
                phongTroList.add(phongTro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongTroList;
    }

    // Thêm một phòng trọ mới
    public boolean insertPhongTro(PhongTro phongTro) {
        String query = "INSERT INTO PHONGTRO (TenNguoiThue, SoDienThoai, NgayThue, HinhThucThanhToan, GhiChu) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, phongTro.getTenNguoiThue());
            preparedStatement.setString(2, phongTro.getSoDienThoai());
            preparedStatement.setDate(3, new java.sql.Date(phongTro.getNgayThue().getTime()));
            preparedStatement.setInt(4, phongTro.getHinhThucThanhToan());
            preparedStatement.setString(5, phongTro.getGhiChu());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePhongTro(int id) {
        String query = "DELETE FROM PHONGTRO WHERE Id = ?";

        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PhongTro> searchPhongTro(String searchTerm) {
        List<PhongTro> phongTroList = new ArrayList<>();
        String query = "SELECT * FROM PHONGTRO WHERE Id LIKE ? OR TenNguoiThue LIKE ? OR SoDienThoai LIKE ?";

        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            String searchPattern = "%" + searchTerm + "%";
            preparedStatement.setString(1, searchPattern);
            preparedStatement.setString(2, searchPattern);
            preparedStatement.setString(3, searchPattern);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    PhongTro phongTro = new PhongTro();
                    phongTro.setId(resultSet.getInt("Id"));
                    phongTro.setTenNguoiThue(resultSet.getString("TenNguoiThue"));
                    phongTro.setSoDienThoai(resultSet.getString("SoDienThoai"));
                    phongTro.setNgayThue(resultSet.getDate("NgayThue"));
                    phongTro.setHinhThucThanhToan(resultSet.getInt("HinhThucThanhToan"));
                    phongTro.setGhiChu(resultSet.getString("GhiChu"));
                    phongTroList.add(phongTro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongTroList;
    }
}
