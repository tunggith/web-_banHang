package com.example.asigntmentjav4.repo;

import com.example.asigntmentjav4.connect.HibernateUlist;
import com.example.asigntmentjav4.model.danhMuc;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class danhMucRepo {
    Session session;
    public ArrayList<danhMuc> getList(){
        session = HibernateUlist.getFACTORY().openSession();
        //truy vấn lấy ra toàn bộ danh mục
        ArrayList<danhMuc> list = (ArrayList<danhMuc>) session.createQuery("From danhMuc").list();
        session.close();
        return list;
    }
    public danhMuc detail(Integer id){
        session = HibernateUlist.getFACTORY().openSession();
        danhMuc list = (danhMuc) session.createQuery("from danhMuc where id=:id").setParameter("id",id).getSingleResult();
        session.close();
        return list;
    }



    public void add(danhMuc danhMuc){
        session = HibernateUlist.getFACTORY().openSession();

        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(danhMuc);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        session.close();
    }
    public void delete(danhMuc danhMuc){
        session = HibernateUlist.getFACTORY().openSession();

        Transaction transaction = session.beginTransaction();

        try {
            session.delete(danhMuc);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        session.close();
    }


//    public static void main(String[] args) {
//        ArrayList<danhMuc> list = new danhMucRepo().getList();
//        for(danhMuc danhMuc:list){
//            System.out.println(danhMuc);
//        }
//    }

}
