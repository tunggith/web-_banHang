package com.example.asigntmentjav4.repo;

import com.example.asigntmentjav4.connect.HibernateUlist;
import com.example.asigntmentjav4.model.sanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class sanPhamRepo {
    Session session;

    public ArrayList<sanPham> getList() {
        session = HibernateUlist.getFACTORY().openSession();
        ArrayList<sanPham> list = (ArrayList<sanPham>) session.createQuery("From sanPham").list();
        session.close();
        return list;
    }

    public void add(sanPham sanPham){
        session = HibernateUlist.getFACTORY().openSession();

        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        session.close();
    }
    public sanPham detail(Integer id) {
        session = HibernateUlist.getFACTORY().openSession();
        sanPham list = (sanPham) session.createQuery("From sanPham where id=:id_1").setParameter("id_1",id).getSingleResult();
        session.close();
        return list;
    }

    public void delete(sanPham sanPham){
        session = HibernateUlist.getFACTORY().openSession();

        Transaction transaction = session.beginTransaction();

        try {
            session.delete(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        session.close();
    }
    public void Update(sanPham sanPham){
        session = HibernateUlist.getFACTORY().openSession();

        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        session.close();
    }
}
