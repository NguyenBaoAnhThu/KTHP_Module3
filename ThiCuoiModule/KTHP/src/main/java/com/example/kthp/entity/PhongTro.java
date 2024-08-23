package com.example.kthp.entity;

import java.util.Date;

public class PhongTro {
    private int id;
    private String tenNguoiThue;
    private String soDienThoai;
    private Date ngayThue;
    private int hinhThucThanhToan;
    private String ghiChu;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNguoiThue() {
        return tenNguoiThue;
    }

    public void setTenNguoiThue(String tenNguoiThue) {
        this.tenNguoiThue = tenNguoiThue;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public int getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
