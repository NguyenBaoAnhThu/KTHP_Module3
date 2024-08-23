package com.example.kthp.services;

import com.example.kthp.models.PhongTroModel;
import com.example.kthp.entity.PhongTro;

import java.util.List;

public class PhongTroService {
    private PhongTroModel phongTroModel;

    public PhongTroService() {
        phongTroModel = new PhongTroModel(); // Khởi tạo đối tượng PhongTroModel
    }

    public List<PhongTro> getAllPhongTro() {
        return phongTroModel.getAllPhongTro();
    }

    public boolean insertPhongTro(PhongTro phongTro) {
        return phongTroModel.insertPhongTro(phongTro);
    }

    public boolean deletePhongTro(int id) {
        return phongTroModel.deletePhongTro(id);
    }

    public List<PhongTro> searchPhongTro(String searchTerm) {
        return phongTroModel.searchPhongTro(searchTerm);
    }
}
