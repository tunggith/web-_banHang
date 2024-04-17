package com.example.asigntmentjav4.repo;

import com.example.asigntmentjav4.connect.HibernateUlist;
import com.example.asigntmentjav4.model.hoaDon;
import com.example.asigntmentjav4.model.khachHang;
import com.example.asigntmentjav4.model.mauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class khachHangRepo {

    Session session;
    public ArrayList<khachHang> getList(){
        session = HibernateUlist.getFACTORY().openSession();
        ArrayList<khachHang> list =
                (ArrayList<khachHang>) session.createQuery("From khachHang ").list();
        session.close();
        return list;
    }
    public khachHang detail(Integer id){
        session = HibernateUlist.getFACTORY().openSession();
        khachHang list =
                (khachHang) session.createQuery("From khachHang where id=:id").setParameter("id",id).getSingleResult();
        session.close();
        return list;
    }
    public khachHang searchSdt(String sdt){
        session = HibernateUlist.getFACTORY().openSession();
        khachHang list =
                (khachHang) session.createQuery("From khachHang where sdt=:id ").setParameter("id",sdt).getSingleResult();
        session.close();
        return list;
    }
    public void add(khachHang khachHang){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.saveOrUpdate(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(khachHang khachHang){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
