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
@Table(name = "ctsp")
public class ctsp {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_sp")
    private sanPham sanPham;

    @ManyToOne
    @JoinColumn(name="id_mau_sac")
    private mauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private size size;

    @Column(name = "gia_ban")
    private Double giaBan;
    @Column(name = "so_luong_ton")
    private Integer soLuongton;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;
}
