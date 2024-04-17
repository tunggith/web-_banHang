package com.example.asigntmentjav4.servlet;

import com.example.asigntmentjav4.model.ctsp;
import com.example.asigntmentjav4.model.mauSac;
import com.example.asigntmentjav4.model.sanPham;
import com.example.asigntmentjav4.model.size;
import com.example.asigntmentjav4.repo.ctspRepo;
import com.example.asigntmentjav4.repo.mauSacRepo;
import com.example.asigntmentjav4.repo.sanPhamRepo;
import com.example.asigntmentjav4.repo.sizeRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ctspServlet", value = {
        "/ctsp/trang-chu",
        "/ctsp/delete",
        "/ctsp/add",
        "/ctsp/update",
        "/ctsp/detail"
})
public class ctspServlet extends HttpServlet {
    ArrayList<ctsp> listCtsp = new ArrayList<>();
    ArrayList<sanPham> listSanPham = new ArrayList<>();
    ArrayList<mauSac> listMauSac = new ArrayList<>();
    ArrayList<size> listSize = new ArrayList<>();
    ctspRepo repo = new ctspRepo();
    sanPhamRepo sanPhamRepo = new sanPhamRepo();
    mauSacRepo mauSacRepo = new mauSacRepo();
    sizeRepo sizeRepo = new sizeRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/ctsp/trang-chu")){
            this.hienThi(request,response);
        } else if (uri.contains("/ctsp/delete")) {
            String id = request.getParameter("id");
            ctsp ctsp = repo.detail(Integer.parseInt(id));
            repo.delete(ctsp);
            response.sendRedirect("/ctsp/trang-chu");
        }else if(uri.contains("/ctsp/detail")){
            String id = request.getParameter("id");
            ctsp ctsp = repo.detail(Integer.parseInt(id));
            listCtsp = repo.getList();
            request.setAttribute("ctsp",ctsp);
            listSanPham = sanPhamRepo.getList();
            request.setAttribute("listSanPham",listSanPham);
            listMauSac = mauSacRepo.getMauSac();
            request.setAttribute("listMauSac",listMauSac);
            listSize = sizeRepo.getList();
            request.setAttribute("listSize",listSize);
            request.getRequestDispatcher("/views/ctspDetail.jsp").forward(request,response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCtsp = repo.getList();
        request.setAttribute("listCtsp",listCtsp);
        listSanPham = sanPhamRepo.getList();
        request.setAttribute("listSanPham",listSanPham);
        listMauSac = mauSacRepo.getMauSac();
        request.setAttribute("listMauSac",listMauSac);
        listSize = sizeRepo.getList();
        request.setAttribute("listSize",listSize);
        request.getRequestDispatcher("/views/ctsp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/ctsp/add")){
            String sanPham = request.getParameter("sanPham");
            String mauSac = request.getParameter("mauSac");
            String size = request.getParameter("size");
            String giaBan = request.getParameter("giaBan");
            String soLuongTon = request.getParameter("soLuongTon");
            String trangThai = request.getParameter("trangThai");

            ctsp ctsp = new ctsp();
            sanPham sanPham1 = new sanPham();
            sanPham1.setId(Integer.parseInt(sanPham));
            mauSac mauSac1 = new mauSac();
            mauSac1.setId(Integer.parseInt(mauSac));
            size size1 = new size();
            size1.setId(Integer.parseInt(size));
            ctsp.setSanPham(sanPham1);
            ctsp.setMauSac(mauSac1);
            ctsp.setSize(size1);
            ctsp.setGiaBan(Double.parseDouble(giaBan));
            ctsp.setSoLuongton(Integer.parseInt(soLuongTon));
            ctsp.setTrangThai(trangThai);
            ctsp.setNgayTao(new Date());
            ctsp.setNgaySua(new Date());

            repo.add(ctsp);
            response.sendRedirect("/ctsp/trang-chu");
        }else if(uri.contains("/ctsp/update")){
            String id = request.getParameter("id");
            String sanPham = request.getParameter("sanPham");
            String mauSac = request.getParameter("mauSac");
            String size = request.getParameter("size");
            String giaBan = request.getParameter("giaBan");
            String soLuongTon = request.getParameter("soLuongTon");
            String trangThai = request.getParameter("trangThai");
            ctsp ctspDetail = repo.detail(Integer.parseInt(id));
            if(ctspDetail!=null){
                ctsp ctsp = new ctsp();
                sanPham sanPham1 = new sanPham();
                sanPham1.setId(Integer.parseInt(sanPham));
                mauSac mauSac1 = new mauSac();
                mauSac1.setId(Integer.parseInt(mauSac));
                size size1 = new size();
                size1.setId(Integer.parseInt(size));
                ctsp.setSanPham(sanPham1);
                ctsp.setMauSac(mauSac1);
                ctsp.setSize(size1);
                ctsp.setId(Integer.parseInt(id));
                ctsp.setGiaBan(Double.parseDouble(giaBan));
                ctsp.setSoLuongton(Integer.parseInt(soLuongTon));
                ctsp.setTrangThai(trangThai);
                ctsp.setNgayTao(ctspDetail.getNgayTao());
                ctsp.setNgaySua(new Date());
                repo.add(ctsp);
            }

            response.sendRedirect("/ctsp/trang-chu");
        }
    }
}
