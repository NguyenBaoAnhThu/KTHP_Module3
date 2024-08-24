package com.example.kthp.entity;

import java.util.Date;

public class PhongTro {
    private int id;
    private String tenNguoiThue;
    private String soDienThoai;
    private Date ngayThue;
    private HinhThucThanhToan hinhThucThanhToan;
    private String ghiChu;

    public PhongTro(int id, String tenNguoiThue, String soDienThoai, Date ngayThue, HinhThucThanhToan hinhThucThanhToan, String ghiChu) {
        this.id = id;
        this.tenNguoiThue = tenNguoiThue;
        this.soDienThoai = soDienThoai;
        this.ngayThue = ngayThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ghiChu = ghiChu;
    }

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

    public HinhThucThanhToan getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(HinhThucThanhToan hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
