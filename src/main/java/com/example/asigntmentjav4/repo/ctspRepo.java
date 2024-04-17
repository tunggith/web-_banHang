package com.example.asigntmentjav4.repo;

import com.example.asigntmentjav4.connect.HibernateUlist;
import com.example.asigntmentjav4.model.ctsp;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class ctspRepo {
    Session session;
    public ArrayList<ctsp> getList(){
        session = HibernateUlist.getFACTORY().openSession();
        ArrayList<ctsp> list = (ArrayList<ctsp>) session.createQuery("From ctsp ").list();
        session.close();
        return list;
    }
    public ctsp detail(Integer id){
        session = HibernateUlist.getFACTORY().openSession();
        ctsp list =
                (ctsp) session.createQuery("from ctsp where id=:id_1").setParameter("id_1",id).getSingleResult();
        session.close();
        return list;
    }
    public void delete(ctsp ctsp){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void add(ctsp ctsp){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.saveOrUpdate(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
