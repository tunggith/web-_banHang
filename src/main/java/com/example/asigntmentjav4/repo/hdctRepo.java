package com.example.asigntmentjav4.repo;

import com.example.asigntmentjav4.connect.HibernateUlist;
import com.example.asigntmentjav4.model.hdct;
import com.example.asigntmentjav4.model.hoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class hdctRepo {
    Session session;
    public ArrayList<hdct> getList(Integer id){
        session = HibernateUlist.getFACTORY().openSession();
        hoaDon hoaDonDetail = new hoaDon();
        hoaDonDetail.setId(id);
        ArrayList<hdct> list = (ArrayList<hdct>) session.createQuery("From hdct WHERE hoaDon = :hoaDonDetail")
                .setParameter("hoaDonDetail", hoaDonDetail)
                .getResultList();
        session.close();
        return list;
    }
    public ArrayList<hdct> getAll(){
        session = HibernateUlist.getFACTORY().openSession();
        ArrayList<hdct> list = (ArrayList<hdct>) session.createQuery("From hdct ").list();
        session.close();
        return list;
    }
    public  hdct detail(Integer id){
        session = HibernateUlist.getFACTORY().openSession();
        hdct list =
                (hdct) session.createQuery("From hdct where id=:id ").setParameter("id",id).getSingleResult();
        session.close();
        return list;
    }
    public void add(hdct hdct){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.saveOrUpdate(hdct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();;
            transaction.commit();
        }
    }
    public void delete(hdct hdct){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(hdct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();;
            transaction.commit();
        }
    }
}
