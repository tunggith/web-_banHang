package com.example.asigntmentjav4.servlet;

import com.example.asigntmentjav4.model.danhMuc;
import com.example.asigntmentjav4.model.sanPham;
import com.example.asigntmentjav4.repo.danhMucRepo;
import com.example.asigntmentjav4.repo.mauSacRepo;
import com.example.asigntmentjav4.repo.sanPhamRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "sanPhamServlet", value = {
        "/sanPham/trang-chu",
        "/sanPham/add",
        "/sanPham/delete",
        "/sanPham/detail",
        "/sanPham/update"
})
public class sanPhamServlet extends HttpServlet {
    ArrayList<sanPham> listSp = new ArrayList<>();
    ArrayList<danhMuc> listDanhMuc = new ArrayList<>();
    danhMucRepo danhMucRepo = new danhMucRepo();
    sanPhamRepo sanPhamRepo = new sanPhamRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sanPham/trang-chu")) {
            this.hienThi(request, response);
        } else if (uri.contains("/sanPham/delete")) {
            this.delete(request, response);
        } else if (uri.contains("/sanPham/detail")) {
            this.detail(request, response);
        }
    }


    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        sanPham sanPhamDetail = sanPhamRepo.detail(id);
        listDanhMuc = danhMucRepo.getList();
        for (sanPham sp : listSp) {
            if (sanPhamDetail.getId().equals(id)) {
                sanPhamDetail = sp;
            }
        }
        request.setAttribute("listDanhMuc", listDanhMuc);
        request.setAttribute("sanPham", sanPhamDetail);
        request.getRequestDispatcher("/views/sanPhamDetail.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        sanPham sanPham = sanPhamRepo.detail(id);
        sanPhamRepo.delete(sanPham);
        response.sendRedirect("/sanPham/trang-chu");
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<sanPham> list = sanPhamRepo.getList();
        listDanhMuc = danhMucRepo.getList();
        request.setAttribute("listDanhMuc", listDanhMuc);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/views/sanPham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSp(request, response);
            System.out.println("thêm");
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String maSanPham = request.getParameter("maSanPham");
        String tenSanPham = request.getParameter("tenSanPham");
        String trangThai = request.getParameter("trangThai");
        String danhMuc = request.getParameter("danhMuc");

        sanPham sanPhamDetail = sanPhamRepo.detail(id);
        if(sanPhamDetail!=null){
            sanPham sanPham = new sanPham();
            sanPham.setId(id);
            sanPham.setMaSanPham(maSanPham);
            sanPham.setTenSanPham(tenSanPham);
            sanPham.setTrangThai(trangThai);
            sanPham.setNgayTao(sanPhamDetail.getNgayTao());
            sanPham.setNgaySua(new Date());
            danhMuc danhMuc1 = new danhMuc();
            danhMuc1.setId(Integer.parseInt(danhMuc));
            sanPham.setDanhMuc(danhMuc1);
            sanPhamRepo.Update(sanPham);
            response.sendRedirect("/sanPham/trang-chu");
        }


    }

    private void addSp(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String maSanPham = request.getParameter("maSanPham");
        String tenSanPham = request.getParameter("tenSanPham");
        String trangThai = request.getParameter("trangThai");
        String danhMuc = request.getParameter("danhMuc");

        sanPham sanPham = new sanPham();

        sanPham.setMaSanPham(maSanPham);
        sanPham.setTenSanPham(tenSanPham);
        sanPham.setTrangThai(trangThai);
        sanPham.setNgayTao(new Date());
        sanPham.setNgaySua(new Date());
        danhMuc danhMuc1 = new danhMuc();
        danhMuc1.setId(Integer.parseInt(danhMuc));
        sanPham.setDanhMuc(danhMuc1);

        sanPhamRepo.add(sanPham);

        response.sendRedirect("/sanPham/trang-chu");

    }
}
