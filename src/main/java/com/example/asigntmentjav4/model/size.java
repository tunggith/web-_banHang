package com.example.asigntmentjav4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "size")
public class size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "ma_size")
    private String maSz;
    @Column(name = "ten_size")
    private String tenSz;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Column(name = "ngay_tao")
    private Date ngayTao;
}
