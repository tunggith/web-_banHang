package com.example.asigntmentjav4.servlet;

import com.example.asigntmentjav4.model.ctsp;
import com.example.asigntmentjav4.model.hdct;
import com.example.asigntmentjav4.model.hoaDon;
import com.example.asigntmentjav4.repo.ctspRepo;
import com.example.asigntmentjav4.repo.hdctRepo;
import com.example.asigntmentjav4.repo.hoaDonRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "hdctServlet", value = {
        "/hdct/trang-chu",
        "/hdct/add",
        "/hdct/update",
        "/hdct/detail",
        "/hdct/delete",

})
public class hdctServlet extends HttpServlet {
    ArrayList<hoaDon> listHoaDon = new ArrayList<>();
    ArrayList<ctsp> listCtsp = new ArrayList<>();
    ArrayList<hdct> listHdct = new ArrayList<>();

    hoaDonRepo hoaDonRepo = new hoaDonRepo();
    ctspRepo ctspRepo = new ctspRepo();
    hdctRepo hdctRepo = new hdctRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hdct/trang-chu")){
            listHdct = hdctRepo.getAll();
            listCtsp = ctspRepo.getList();
            listHoaDon = hoaDonRepo.getAll();
            request.setAttribute("listHdct",listHdct);
            request.setAttribute("listCtsp",listCtsp);
            request.setAttribute("listHoaDon",listHoaDon);
            request.getRequestDispatcher("/views/hdct.jsp").forward(request,response);
        } else if (uri.contains("/hdct/detail")) {
            String id = request.getParameter("id");
            hdct hdct = hdctRepo.detail(Integer.parseInt(id));
            listCtsp = ctspRepo.getList();
            listHoaDon = hoaDonRepo.getAll();
            request.setAttribute("hdct",hdct);
            request.setAttribute("listCtsp",listCtsp);
            request.setAttribute("listHoaDon",listHoaDon);
            request.getRequestDispatcher("/views/hdctDetail.jsp").forward(request,response);
        } else if (uri.contains("/hdct/delete")) {
            String id = request.getParameter("id");
            hdct hdct = hdctRepo.detail(Integer.parseInt(id));
            hdctRepo.delete(hdct);
            response.sendRedirect("/hdct/trang-chu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hdct/add")){
            String hoaDon = request.getParameter("hoaDon");
            String ctsp = request.getParameter("sanPham");
            String soLuongMua = request.getParameter("soLuongMua");
            String giaBan = request.getParameter("giaBan");
            String tongTien = request.getParameter("tongTien");
            String trangThai = request.getParameter("trangThai");

            hdct hdct = new hdct();
            hoaDon hoaDon1 = new hoaDon();
            hoaDon1.setId(Integer.parseInt(hoaDon));
            hdct.setHoaDon(hoaDon1);
            ctsp ctsp1 = new ctsp();
            ctsp1.setId(Integer.parseInt(ctsp));
            hdct.setCtsp(ctsp1);
            hdct.setSoLuongMua(Integer.parseInt(soLuongMua));
            hdct.setGiaBan(Double.parseDouble(giaBan));
            hdct.setTongTien(Double.parseDouble(tongTien));
            hdct.setTrangThai(trangThai);
            hdct.setNgaySua(new Date());
            hdct.setNgayTao(new Date());

            hdctRepo.add(hdct);
            response.sendRedirect("/hdct/trang-chu");
        }else if(uri.contains("/hdct/update")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            hdct hdctDetail = hdctRepo.detail(id);
            String hoaDon = request.getParameter("hoaDon");
            String ctsp = request.getParameter("sanPham");
            String soLuongMua = request.getParameter("soLuongMua");
            String giaBan = request.getParameter("giaBan");
            String tongTien = request.getParameter("tongTien");
            String trangThai = request.getParameter("trangThai");

            hdct hdct = new hdct();
            hdct.setId(id);
            hoaDon hoaDon1 = new hoaDon();
            hoaDon1.setId(Integer.parseInt(hoaDon));
            hdct.setHoaDon(hoaDon1);
            ctsp ctsp1 = new ctsp();
            ctsp1.setId(Integer.parseInt(ctsp));
            hdct.setCtsp(ctsp1);
            hdct.setSoLuongMua(Integer.parseInt(soLuongMua));
            hdct.setGiaBan(Double.parseDouble(giaBan));
            hdct.setTongTien(Double.parseDouble(tongTien));
            hdct.setTrangThai(trangThai);
            hdct.setNgaySua(new Date());
            hdct.setNgayTao(hdctDetail.getNgayTao());

            hdctRepo.add(hdct);
            response.sendRedirect("/hdct/trang-chu");
        }
    }
}
