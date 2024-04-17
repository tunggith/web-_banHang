package com.example.asigntmentjav4.servlet;

import com.example.asigntmentjav4.model.mauSac;
import com.example.asigntmentjav4.repo.mauSacRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "mauSacServlet", value = {
        "/mau-sac/trang-chu",
        "/mau-sac/delete",
        "/mau-sac/add",
        "/mau-sac/detail",
        "/mau-sac/update",
})
public class mauSacServlet extends HttpServlet {
    ArrayList<mauSac> listMauSac = new ArrayList<>();
    mauSacRepo mauSacRepo = new mauSacRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/mau-sac/trang-chu")){
            listMauSac=mauSacRepo.getMauSac();
            request.setAttribute("listMauSac",listMauSac);
            request.getRequestDispatcher("/views/mauSac.jsp").forward(request,response);
        } else if (uri.contains("/mau-sac/delete")) {
            String id = request.getParameter("id");
            mauSac mauSac = mauSacRepo.detail(Integer.parseInt(id));
            mauSacRepo.delete(mauSac);
            response.sendRedirect("/mau-sac/trang-chu");
        }
        else if (uri.contains("/mau-sac/detail")) {
            String id = request.getParameter("id");
            mauSac mauSac = mauSacRepo.detail(Integer.parseInt(id));
            request.setAttribute("mauSac",mauSac);
            request.getRequestDispatcher("/views/mauSacDetail.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/mau-sac/add")){
            String maMau = request.getParameter("maMau");
            String tenMau = request.getParameter("tenMau");
            String trangThai = request.getParameter("trangThai");

            mauSac mauSac = new mauSac();
            mauSac.setMaMau(maMau);
            mauSac.setTenMau(tenMau);
            mauSac.setTrangThai(trangThai);
            mauSac.setNgayTao(new Date());
            mauSac.setNgaySua(new Date());

            mauSacRepo.add(mauSac);
            response.sendRedirect("/mau-sac/trang-chu");
        } else if (uri.contains("/mau-sac/update")) {
            String id = request.getParameter("id");
            mauSac mauSacDetail = mauSacRepo.detail(Integer.parseInt(id));
            String maMau = request.getParameter("maMau");
            String tenMau = request.getParameter("tenMau");
            String trangThai = request.getParameter("trangThai");

            mauSac mauSac = new mauSac();
            mauSac.setId(Integer.parseInt(id));
            mauSac.setMaMau(maMau);
            mauSac.setTenMau(tenMau);
            mauSac.setTrangThai(trangThai);
            mauSac.setNgayTao(mauSacDetail.getNgayTao());
            mauSac.setNgaySua(new Date());

            mauSacRepo.add(mauSac);
            response.sendRedirect("/mau-sac/trang-chu");
        }
    }
}
