package com.example.asigntmentjav4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="danh_muc")
public class danhMuc {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ma_danh_muc")
    private String maDanhMuc;
    @Column(name = "ten_danh_muc")
    private  String tenDanhMuc;
    @Column(name="trang_thai")
    private String trangThai;
    @Column(name="ngay_tao")
    private Date ngayTao;

    @Column(name="ngay_sua")
    private Date ngaySua;

    @Override
    public String toString() {
        return "DanhMuc{" +
                "id=" + id +
                ", maDanhMuc='" + maDanhMuc + '\'' +
                ", tenDanhMuc='" + tenDanhMuc + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                '}';
    }
}

