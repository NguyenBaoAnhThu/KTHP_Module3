package com.example.kthp.services;

import com.example.kthp.entity.HinhThucThanhToan;
import com.example.kthp.models.HinhThucThanhToanModel;

import java.util.List;

public class HinhThucThanhToanService {

    private HinhThucThanhToanModel hinhThucThanhToanModel;

    public HinhThucThanhToanService() {
        hinhThucThanhToanModel = new HinhThucThanhToanModel();
    }

    public List<HinhThucThanhToan> getAllHinhThucThanhToan() {
        return hinhThucThanhToanModel.getAllHinhThucThanhToan();
    }

    public List<HinhThucThanhToan> searchHinhThucThanhToan(String searchTerm) {
        return hinhThucThanhToanModel.searchHinhThucThanhToan(searchTerm);
    }

    public void insertHinhThucThanhToan(HinhThucThanhToan hinhThucThanhToan) {
        hinhThucThanhToanModel.insertHinhThucThanhToan(hinhThucThanhToan);
    }

    public void deleteHinhThucThanhToan(int id) {
        hinhThucThanhToanModel.deleteHinhThucThanhToan(id);
    }
}
