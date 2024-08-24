package com.example.kthp.services;

import com.example.kthp.entity.HinhThucThanhToan;
import com.example.kthp.models.HinhThucThanhToanModel;

import java.util.List;

public class HinhThucThanhToanService {
    private final HinhThucThanhToanModel model = new HinhThucThanhToanModel();

    public List<HinhThucThanhToan> getAllHinhThucThanhToan() {
        return model.getAll();
    }

    public HinhThucThanhToan getHinhThucThanhToanById(int id) {
        return model.getById(id);
    }
}
