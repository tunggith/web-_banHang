package com.example.asigntmentjav4.servlet.banHang;

import com.example.asigntmentjav4.model.*;
import com.example.asigntmentjav4.repo.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "banHangServlet", value = {
        "/ban-hang/trang-chu",
        "/ban-hang/detail",
        "/ban-hang/addHoaDon",
        "/ban-hang/search",
        "/ban-hang/thanh-toan",
        "/ban-hang/add-san-pham",
        "/ban-hang/delete-san-pham",
})
public class banHangServlet extends HttpServlet {
    ArrayList<hoaDon> listHoaDon = new ArrayList<>();
    hoaDonRepo hoaDonRepo = new hoaDonRepo();
    ArrayList<hdct> listHdct = new ArrayList<>();
    hdctRepo hdctRepo = new hdctRepo();
    ArrayList<sanPham> listSanPham = new ArrayList<>();
    sanPhamRepo sanPhamRepo = new sanPhamRepo();
    ArrayList<ctsp> listCtsp = new ArrayList<>();
    ctspRepo ctspRepo = new ctspRepo();
    ArrayList<khachHang> listKhachHang = new ArrayList<>();
    khachHangRepo khachHangRepo = new khachHangRepo();
    ArrayList<mauSac> listMauSac = new ArrayList<>();
    mauSacRepo mauSacRepo = new mauSacRepo();
    ArrayList<size> listSize = new ArrayList<>();
    sizeRepo sizeRepo = new sizeRepo();
    ArrayList<danhMuc> listDanhMuc = new ArrayList<>();
    danhMucRepo danhMucRepo = new danhMucRepo();
    Double tongTien = 0.0;
    Integer id_hoaDon = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/ban-hang/trang-chu")) {
            listCtsp = ctspRepo.getList();
            listHoaDon = hoaDonRepo.getList();
            listHdct = hdctRepo.getAll();
            request.setAttribute("tongTien", tongTien);
            request.setAttribute("listCtsp", listCtsp);
            request.setAttribute("listHoaDon", listHoaDon);
            request.setAttribute("hdct", listHdct);
            request.getRequestDispatcher("/viewsBh/banHang.jsp").forward(request, response);
        } else if (uri.contains("/ban-hang/detail")) {
            String id = request.getParameter("id");
            id_hoaDon = Integer.parseInt(id);
            listCtsp = ctspRepo.getList();
            request.setAttribute("listCtsp", listCtsp);
            listHoaDon = hoaDonRepo.getList();
            request.setAttribute("listHoaDon", listHoaDon);
            listHdct = hdctRepo.getAll();
            request.setAttribute("hdct", listHdct);
            listHdct = hdctRepo.getList(Integer.parseInt(id));
            request.setAttribute("listHdct", listHdct);
            hoaDon hdctId = hoaDonRepo.detail(Integer.parseInt(id));
            request.setAttribute("hdctId", hdctId);
            tongTien = 0.0;
            for (hdct hdct : listHdct) {
                tongTien += hdct.getTongTien();
            }
            request.setAttribute("tongTienH", tongTien);
            request.getRequestDispatcher("/viewsBh/banHang.jsp").forward(request, response);
            //response.sendRedirect("/ban-hang/trang-chu");
        } else if (uri.contains("/ban-hang/addHoaDon")) {
            String idKhachHang = request.getParameter("sdt");
            if (idKhachHang.isEmpty()) {
                System.out.println("chua co khach hang");
                request.getSession().setAttribute("message","chưa có khách hàng");
                response.sendRedirect("/ban-hang/trang-chu");
            } else {
                khachHang khachHang = khachHangRepo.searchSdt(idKhachHang);
                hoaDon hoaDon = hoaDonRepo.detail(khachHang.getId());
                String sdt = request.getParameter("sdt");
                String trangThai = "chua thanh toan";
                hoaDon hoaDon1 = new hoaDon();
                hoaDon1.setNgaySua(new Date());
                hoaDon1.setNgayTao(new Date());
                hoaDon1.setTrangThai(trangThai);
                hoaDon1.setKhachHang(hoaDon.getKhachHang());
                hoaDon1.setDiaChi(hoaDon.getKhachHang().getDiaChi());
                hoaDon1.setSdt(sdt);

                hoaDonRepo.add(hoaDon1);
                request.getSession().setAttribute("message","tạo thành công");
                response.sendRedirect("/ban-hang/trang-chu");
            }
        } else if (uri.contains("/ban-hang/thanh-toan")) {
            String id = request.getParameter("id");
            if (id.isEmpty()) {
                System.out.println("chua chon hoa don muon thanh toan");
                request.getSession().setAttribute("message", "Chưa chọn hóa đơn muốn thanh toán");
                response.sendRedirect("/ban-hang/trang-chu");
            } else {
                String trangThai = "da thanh toan";
                if(tongTien==0){
                    System.out.println("hóa đơn không có gái trị là 0đ");
                    request.getSession().setAttribute("message", "hóa đơn không có gái trị là 0đ");
                    response.sendRedirect("/ban-hang/trang-chu");
                }else {
                    hoaDon hoaDon = hoaDonRepo.detail(Integer.parseInt(id));
                    hoaDon hoaDon1 = new hoaDon();
                    hoaDon1.setId(Integer.parseInt(id));
                    hoaDon1.setTrangThai(trangThai);
                    hoaDon1.setKhachHang(hoaDon.getKhachHang());
                    hoaDon1.setNgayTao(hoaDon.getNgayTao());
                    hoaDon1.setNgaySua(new Date());
                    hoaDon1.setDiaChi(hoaDon.getDiaChi());
                    hoaDon1.setSdt(hoaDon.getSdt());
                    hoaDonRepo.add(hoaDon1);
                    request.getSession().setAttribute("message","thanh toán thành công");
                    response.sendRedirect("/ban-hang/trang-chu");
                }
            }
        } else if (uri.contains("/ban-hang/add-san-pham")) {
            String id_sanPham = request.getParameter("id_sanPham");
            ctsp ctsp = ctspRepo.detail(Integer.parseInt(id_sanPham));
            hdct hdct = new hdct();

            hoaDon hoaDon = new hoaDon();
            hoaDon.setId(id_hoaDon);
            hdct.setCtsp(ctsp);
            hdct.setHoaDon(hoaDon);
            request.getSession().setAttribute("nhapSoLuong","chua co hoa don");
            String soLuong = request.getParameter("soLuong");
            hdct.setSoLuongMua(1);
            hdct.setGiaBan(ctsp.getGiaBan());
            hdct.setTongTien(ctsp.getGiaBan() * 1);
            hdct.setNgayTao(new Date());
            hdct.setNgaySua(new Date());
//            hdctRepo.add(hdct);

            ctsp ctspDetail = ctspRepo.detail(Integer.parseInt(id_sanPham));
            ctsp ctsp1 = new ctsp();
            ctsp1.setId(Integer.parseInt(id_sanPham));
            ctsp1.setSanPham(ctspDetail.getSanPham());
            ctsp1.setMauSac(ctspDetail.getMauSac());
            ctsp1.setSize(ctspDetail.getSize());
            ctsp1.setGiaBan(ctspDetail.getGiaBan());
            ctsp1.setSoLuongton(ctspDetail.getSoLuongton() - 1);
            ctsp1.setTrangThai(ctspDetail.getTrangThai());
            ctsp1.setNgaySua(ctspDetail.getNgaySua());
            ctsp1.setNgayTao(ctspDetail.getNgayTao());
//            ctspRepo.add(ctsp1);
            if (id_hoaDon == 0) {
                System.out.println("chua co hoa don");
                request.getSession().setAttribute("message","chua co hoa don");
                response.sendRedirect("/ban-hang/trang-chu");
            } else {
                if (ctspDetail.getSoLuongton() == 0) {
                    System.out.println("san pham da het");
                    request.getSession().setAttribute("message","san pham da het");
                    response.sendRedirect("/ban-hang/detail?id=" + id_hoaDon);
                } else {
                    hdctRepo.add(hdct);
                    ctspRepo.add(ctsp1);
                    response.sendRedirect("/ban-hang/detail?id=" + id_hoaDon);
                }
            }

            //response.sendRedirect("/ban-hang/detail?id="+id_hoaDon);
        } else if (uri.contains("/ban-hang/delete-san-pham")) {
            String idHdct = request.getParameter("idCtsp");
            hdct hdct = hdctRepo.detail(Integer.parseInt(idHdct));
            hdctRepo.delete(hdct);
            Integer idCtsp = hdct.getCtsp().getId();
            System.out.println(idCtsp);
            ctsp ctspDetail = ctspRepo.detail(idCtsp);
            ctsp ctsp = new ctsp();
            ctsp.setId(idCtsp);
            ctsp.setSanPham(ctspDetail.getSanPham());
            ctsp.setMauSac(ctspDetail.getMauSac());
            ctsp.setSize(ctspDetail.getSize());
            ctsp.setGiaBan(ctspDetail.getGiaBan());
            ctsp.setSoLuongton(ctspDetail.getSoLuongton() + 1);
            ctsp.setTrangThai(ctspDetail.getTrangThai());
            ctsp.setNgaySua(ctspDetail.getNgaySua());
            ctsp.setNgayTao(ctspDetail.getNgayTao());
            ctspRepo.add(ctsp);
            request.getSession().setAttribute("message","xóa thành công");
            response.sendRedirect("/ban-hang/detail?id=" + id_hoaDon);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/ban-hang/search")) {
            String sdt = request.getParameter("sdt");
            if (sdt.isEmpty()) {
                System.out.println("chua co khach hang");
                request.getSession().setAttribute("message","chưa có khách hàng");
                response.sendRedirect("/ban-hang/trang-chu");
            } else {
                khachHang khachHang = khachHangRepo.searchSdt(sdt);
                request.setAttribute("khachHang", khachHang);
                String id = request.getParameter("id");
                listCtsp = ctspRepo.getList();
                request.setAttribute("listCtsp", listCtsp);
                listHoaDon = hoaDonRepo.getList();
                request.setAttribute("listHoaDon", listHoaDon);
                listHdct = hdctRepo.getAll();
                request.setAttribute("hdct", listHdct);
                listHdct = hdctRepo.getList(id_hoaDon);
                request.setAttribute("listHdct", listHdct);
                tongTien = 0.0;
                for (hdct hdct : listHdct) {
                    tongTien += hdct.getTongTien();
                }
                request.setAttribute("tongTienH", tongTien);
                request.getSession().setAttribute("message","đã tìm thấy");
                request.getRequestDispatcher("/viewsBh/banHang.jsp").forward(request, response);
                response.sendRedirect("/ban-hang/trang-chu");
            }
        }
    }
}
