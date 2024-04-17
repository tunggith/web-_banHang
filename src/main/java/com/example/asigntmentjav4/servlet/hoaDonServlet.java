package com.example.asigntmentjav4.servlet;

import com.example.asigntmentjav4.model.hoaDon;
import com.example.asigntmentjav4.model.khachHang;
import com.example.asigntmentjav4.repo.hoaDonRepo;
import com.example.asigntmentjav4.repo.khachHangRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "hoaDonServlet", value = {
        "/hoa-don/trang-chu",
        "/hoa-don/add",
        "/hoa-don/delete",
        "/hoa-don/update",
        "/hoa-don/detail",
})
public class hoaDonServlet extends HttpServlet {
    ArrayList<hoaDon> listHoaDon = new ArrayList<>();
    hoaDonRepo hoaDonRepo = new hoaDonRepo();
    ArrayList<khachHang> listKhachHang = new ArrayList<>();
    khachHangRepo khachHangRepo = new khachHangRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hoa-don/trang-chu")){
            listKhachHang = khachHangRepo.getList();
            listHoaDon = hoaDonRepo.getAll();
            request.setAttribute("listKhachHang",listKhachHang);
            request.setAttribute("listHoaDon",listHoaDon);
            request.getRequestDispatcher("/views/hoaDon.jsp").forward(request,response);
        } else if (uri.contains("/hoa-don/detail")) {
            String id = request.getParameter("id");
            hoaDon hoaDon = hoaDonRepo.detail(Integer.parseInt(id));
            listKhachHang = khachHangRepo.getList();
            request.setAttribute("hoaDon",hoaDon);
            request.setAttribute("listKhachHang",listKhachHang);
            request.getRequestDispatcher("/views/hoaDonDetail.jsp").forward(request,response);
        }else if (uri.contains("/hoa-don/delete")) {
            String id = request.getParameter("id");
            hoaDon hoaDon = hoaDonRepo.detail(Integer.parseInt(id));
            hoaDonRepo.delete(hoaDon);
            response.sendRedirect("/hoa-don/trang-chu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hoa-don/add")){
            String khachHang = request.getParameter("khachHang");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String trangThai = request.getParameter("trangThai");

            hoaDon hoaDon = new hoaDon();
            khachHang khachHang1 = new khachHang();
            khachHang1.setId(Integer.parseInt(khachHang));
            hoaDon.setKhachHang(khachHang1);
            hoaDon.setDiaChi(diaChi);
            hoaDon.setSdt(sdt);
            hoaDon.setTrangThai(trangThai);
            hoaDon.setNgaySua(new Date());
            hoaDon.setNgayTao(new Date());

            hoaDonRepo.add(hoaDon);
            response.sendRedirect("/hoa-don/trang-chu");
        }else if(uri.contains("/hoa-don/update")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            hoaDon hoaDonDetail = hoaDonRepo.detail(id);
            String khachHang = request.getParameter("khachHang");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String trangThai = request.getParameter("trangThai");

            hoaDon hoaDon = new hoaDon();
            hoaDon.setId(id);
            khachHang khachHang1 = new khachHang();
            khachHang1.setId(Integer.parseInt(khachHang));
            hoaDon.setKhachHang(khachHang1);
            hoaDon.setDiaChi(diaChi);
            hoaDon.setSdt(sdt);
            hoaDon.setTrangThai(trangThai);
            hoaDon.setNgaySua(new Date());
            hoaDon.setNgayTao(hoaDonDetail.getNgayTao());

            hoaDonRepo.add(hoaDon);
            response.sendRedirect("/hoa-don/trang-chu");
        }
    }
}
