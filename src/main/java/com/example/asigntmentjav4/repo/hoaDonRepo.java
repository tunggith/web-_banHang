package com.example.asigntmentjav4.repo;

import com.example.asigntmentjav4.connect.HibernateUlist;
import com.example.asigntmentjav4.model.hoaDon;
import com.example.asigntmentjav4.model.khachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class hoaDonRepo {
    Session session;
    public ArrayList<hoaDon> getList(){
        session = HibernateUlist.getFACTORY().openSession();
        ArrayList<hoaDon> list =
                (ArrayList<hoaDon>) session.createQuery("From hoaDon where trangThai = 'chua thanh toan' ").list();
        session.close();
        return list;
    }
    public ArrayList<hoaDon> getAll(){
        session = HibernateUlist.getFACTORY().openSession();
        ArrayList<hoaDon> list =
                (ArrayList<hoaDon>) session.createQuery("From hoaDon ").list();
        session.close();
        return list;
    }
    public hoaDon detail(Integer id){
        session = HibernateUlist.getFACTORY().openSession();
        hoaDon list =
                (hoaDon) session.createQuery("From hoaDon where id=:id ").setParameter("id",id).getSingleResult();
        session.close();
        return list;
    }

    public void add(hoaDon hoaDon){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.saveOrUpdate(hoaDon);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(hoaDon hoaDon){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(hoaDon);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }


}
