package com.example.asigntmentjav4.repo;

import com.example.asigntmentjav4.connect.HibernateUlist;
import com.example.asigntmentjav4.model.size;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class sizeRepo {
    Session session;
    public ArrayList<size> getList(){
        session = HibernateUlist.getFACTORY().openSession();
        ArrayList<size> list =
                (ArrayList<size>) session.createQuery("From size").list();
        session.close();
        return list;
    }
    public size detail(Integer id){
        session = HibernateUlist.getFACTORY().openSession();
        size list =
                (size) session.createQuery("From size where id=:id_1").setParameter("id_1",id).getSingleResult();
        session.close();
        return list;
    }
    public void add(size size){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.saveOrUpdate(size);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(size size){
        session = HibernateUlist.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(size);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }



//    public static void main(String[] args) {
//        ArrayList<size> list = new sizeRepo().getList();
//        for(size size: list){
//            System.out.println(size.getId());
//            System.out.println(size.getMaSz());
//            System.out.println(size.getTrangThai());
//            System.out.println(size.getNgayTao());
//            System.out.println(size.getNgaySua());
//        }
//    }
}
