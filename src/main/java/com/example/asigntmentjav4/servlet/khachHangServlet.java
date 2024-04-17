package com.example.asigntmentjav4.servlet;

import com.example.asigntmentjav4.model.khachHang;
import com.example.asigntmentjav4.repo.khachHangRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "khachHangServlet", value = {
        "/khach-hang/trang-chu",
        "/khach-hang/add",
        "/khach-hang/update",
        "/khach-hang/detail",
        "/khach-hang/delete",
})
public class khachHangServlet extends HttpServlet {
    ArrayList<khachHang> listKhachHang = new ArrayList<>();
    khachHangRepo khachHangRepo = new khachHangRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        if(uri.contains("/khach-hang/trang-chu")){
            listKhachHang = khachHangRepo.getList();
            request.setAttribute("listKhachHang",listKhachHang);
            request.getRequestDispatcher("/views/khachHang.jsp").forward(request,response);
        } else if (uri.contains("/khach-hang/delete")) {
            String id = request.getParameter("id");
            khachHang khachHang = khachHangRepo.detail(Integer.parseInt(id));
            khachHangRepo.delete(khachHang);
            response.sendRedirect("/khach-hang/trang-chu");
        }else if (uri.contains("/khach-hang/detail")) {
            String id = request.getParameter("id");
            khachHang khachHang = khachHangRepo.detail(Integer.parseInt(id));
            request.setAttribute("khachHang",khachHang);
            request.getRequestDispatcher("/views/khachHangDetail.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/khach-hang/add")){
            String hoTen = request.getParameter("hoTen");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");

            khachHang khachHang = new khachHang();
            khachHang.setHoTen(hoTen);
            khachHang.setDiaChi(diaChi);
            khachHang.setSdt(sdt);
            khachHang.setNgayTao(new Date());
            khachHang.setNgaySua(new Date());
            khachHangRepo.add(khachHang);
            response.sendRedirect("/khach-hang/trang-chu");
        }else if(uri.contains("/khach-hang/update")){
            String id = request.getParameter("id");
            khachHang khachHangDetail = khachHangRepo.detail(Integer.parseInt(id));
            String hoTen = request.getParameter("hoTen");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");

            khachHang khachHang = new khachHang();
            khachHang.setId(Integer.parseInt(id));
            khachHang.setHoTen(hoTen);
            khachHang.setDiaChi(diaChi);
            khachHang.setSdt(sdt);
            khachHang.setNgayTao(khachHangDetail.getNgayTao());
            khachHang.setNgaySua(new Date());
            khachHangRepo.add(khachHang);
            response.sendRedirect("/khach-hang/trang-chu");
        }
    }
}
