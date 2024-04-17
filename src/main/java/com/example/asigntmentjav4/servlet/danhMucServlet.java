package com.example.asigntmentjav4.servlet;

import com.example.asigntmentjav4.model.danhMuc;
import com.example.asigntmentjav4.repo.danhMucRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "danhMucServlet", value = {
        "/danhMuc/index",
        "/danhMuc/add",
        "/danhMuc/update",
        "/danhMuc/detail",
        "/danhMuc/delete",
})
public class danhMucServlet extends HttpServlet {
    ArrayList<danhMuc> listDanhMuc = new ArrayList<>();
    danhMucRepo danhMucRepo = new danhMucRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/danhMuc/index")) {
            this.index(request, response);
        } else if (uri.contains("/danhMuc/delete")) {
            String id = request.getParameter("id");
            danhMuc danhMuc = danhMucRepo.detail(Integer.parseInt(id));
            danhMucRepo.delete(danhMuc);
            response.sendRedirect("/danhMuc/index");
        } else if (uri.contains("/danhMuc/detail")) {
            String id = request.getParameter("id");
            danhMuc danhMuc = danhMucRepo.detail(Integer.parseInt(id));
            request.setAttribute("danhMuc",danhMuc);
            request.getRequestDispatcher("/views/danhMucDetail.jsp").forward(request,response);
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listDanhMuc = danhMucRepo.getList();
        request.setAttribute("listDanhMuc", listDanhMuc);
        request.getRequestDispatcher("/views/danhMuc.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/danhMuc/add")) {
            this.add(request, response);
        } else if (uri.contains("/danhMuc/update")) {
            String id =request.getParameter("id");
            String maDanhMuc = request.getParameter("maDanhMuc");
            String tenDanhMuc = request.getParameter("tenDanhMuc");
            String trangThai = request.getParameter("trangThai");
            danhMuc danhMucDetail = danhMucRepo.detail(Integer.parseInt(id));
            danhMuc danhMuc = new danhMuc();
            danhMuc.setId(Integer.parseInt(id));
            danhMuc.setMaDanhMuc(maDanhMuc);
            danhMuc.setTenDanhMuc(tenDanhMuc);
            danhMuc.setTrangThai(trangThai);
            danhMuc.setNgayTao(danhMucDetail.getNgayTao());
            danhMuc.setNgaySua(new Date());

            danhMucRepo.add(danhMuc);
            System.out.println(danhMuc.getId()+danhMuc.getMaDanhMuc()+danhMuc.getTenDanhMuc()+danhMuc.getTrangThai()+danhMuc.getNgayTao());
            response.sendRedirect("/danhMuc/index");
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maDanhMuc = request.getParameter("maDanhMuc");
        String tenDanhMuc = request.getParameter("tenDanhMuc");
        String trangThai = request.getParameter("trangThai");
        danhMuc danhMuc = new danhMuc();
        danhMuc.setMaDanhMuc(maDanhMuc);
        danhMuc.setTenDanhMuc(tenDanhMuc);
        danhMuc.setTrangThai(trangThai);
        danhMuc.setNgayTao(new Date());
        danhMuc.setNgaySua(new Date());

        danhMucRepo.add(danhMuc);
        System.out.println(danhMuc.getId()+danhMuc.getMaDanhMuc()+danhMuc.getTenDanhMuc()+danhMuc.getTrangThai()+danhMuc.getNgayTao());
        response.sendRedirect("/danhMuc/index");
    }
}
