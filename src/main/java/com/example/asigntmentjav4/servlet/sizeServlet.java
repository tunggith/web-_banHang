package com.example.asigntmentjav4.servlet;

import com.example.asigntmentjav4.model.size;
import com.example.asigntmentjav4.repo.sizeRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "sizeServlet", value = {
        "/size/trang-chu",
        "/size/add",
        "/size/update",
        "/size/detail",
        "/size/delete",
})
public class sizeServlet extends HttpServlet {

    ArrayList<size> listSize = new ArrayList<>();
    sizeRepo sizeRepo = new sizeRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/size/trang-chu")){
            listSize = sizeRepo.getList();
            request.setAttribute("listSize",listSize);
            request.getRequestDispatcher("/views/size.jsp").forward(request,response);
        } else if (uri.contains("/size/delete")) {
            String id = request.getParameter("id");
            size size = sizeRepo.detail(Integer.parseInt(id));
            sizeRepo.delete(size);
            response.sendRedirect("/size/trang-chu");
        } else if (uri.contains("/size/detail")) {
            String id = request.getParameter("id");
            size sizeDetail = sizeRepo.detail(Integer.parseInt(id));
//            listSize = sizeRepo.getList();
            request.setAttribute("size",sizeDetail);
            request.getRequestDispatcher("/views/sizeDetail.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/size/add")){
            String maSz = request.getParameter("maSz");
            String tenSz = request.getParameter("tenSz");
            String trangThai = request.getParameter("trangThai");

            size size = new size();
            size.setMaSz(maSz);
            size.setTenSz(tenSz);
            size.setTrangThai(trangThai);
            size.setNgayTao(new Date());
            size.setNgaySua(new Date());

            sizeRepo.add(size);
            response.sendRedirect("/size/trang-chu");
        } else if (uri.contains("/size/update")) {
            String id = request.getParameter("id");
            size sizeDetail = sizeRepo.detail(Integer.parseInt(id));
            String maSz = request.getParameter("maSz");
            String tenSz = request.getParameter("tenSz");
            String trangThai = request.getParameter("trangThai");

            size size = new size();
            size.setId(Integer.parseInt(id));
            size.setMaSz(maSz);
            size.setTenSz(tenSz);
            size.setTrangThai(trangThai);
            size.setNgayTao(sizeDetail.getNgayTao());
            size.setNgaySua(new Date());

            sizeRepo.add(size);
            response.sendRedirect("/size/trang-chu");
        }
    }
}
