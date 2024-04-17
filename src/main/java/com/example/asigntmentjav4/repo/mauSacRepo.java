package com.example.asigntmentjav4.repo;

import com.example.asigntmentjav4.connect.HibernateUlist;
import com.example.asigntmentjav4.model.mauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class mauSacRepo {
    Session session;
    public ArrayList<mauSac> getMauSac(){
        session = HibernateUlist.getFACTORY().openSession();
        ArrayList<mauSac> list =
                (ArrayList<mauSac>) session.createQuery("From mauSac").list();
        session.close();
        return list;
    }
    public mauSac detail(Integer id){
        session = HibernateUlist.getFACTORY().openSession();
        mauSac list =
                (mauSac) session.createQuery("From mauSac where id=:id").setParameter("id",id).getSingleResult();
        session.close();
        return list;
    }
    public void add(mauSac mauSac){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.saveOrUpdate(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(mauSac mauSac){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
