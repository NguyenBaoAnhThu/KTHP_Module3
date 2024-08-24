package com.example.kthp.services;

import com.example.kthp.entity.PhongTro;
import com.example.kthp.models.PhongTroModel;

import java.util.List;

public class PhongTroService {
    private final PhongTroModel model = new PhongTroModel();

    public List<PhongTro> getAllPhongTro() {
        return model.getAll();
    }

    public boolean addPhongTro(PhongTro phongTro) {
        return model.add(phongTro);
    }

    public boolean deletePhongTro(int id) {
        return model.delete(id);
    }
}
