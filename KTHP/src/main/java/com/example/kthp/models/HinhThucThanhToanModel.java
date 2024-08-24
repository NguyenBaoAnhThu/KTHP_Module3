package com.example.kthp.models;

import com.example.kthp.databases.DatabaseConnect;
import com.example.kthp.entity.HinhThucThanhToan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HinhThucThanhToanModel {

    public List<HinhThucThanhToan> getAll() {
        List<HinhThucThanhToan> list = new ArrayList<>();
        String query = "SELECT * FROM HINHTHUCTHANHTOAN";
        try (Connection conn = DatabaseConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                HinhThucThanhToan htt = new HinhThucThanhToan(rs.getInt("Id"), rs.getString("TenHinhThuc"));
                list.add(htt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public HinhThucThanhToan getById(int id) {
        String query = "SELECT * FROM HINHTHUCTHANHTOAN WHERE Id = ?";
        try (Connection conn = DatabaseConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new HinhThucThanhToan(rs.getInt("Id"), rs.getString("TenHinhThuc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
