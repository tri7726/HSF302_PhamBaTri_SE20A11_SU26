package com.example.execrise2.dao;

import com.example.execrise2.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class StudentDao {

    private EntityManager en;
    private EntityManagerFactory enf;

    public StudentDao(String persistenceUnit) {
        enf = Persistence.createEntityManagerFactory(persistenceUnit);
    }

    public void save(Student stu) {
        EntityManager em = null;
        try {
            em = enf.createEntityManager();
            em.getTransaction().begin();
            em.merge(stu);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Student> getStudent() {
        EntityManager em = null;
        List<Student> liststu = null;
        try {
            em = enf.createEntityManager();
            liststu = em.createQuery("from Student", Student.class).getResultList();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return liststu;
    }

    public void deleted(int idstu) {
        EntityManager em = null;
        try {
            em = enf.createEntityManager();
            em.getTransaction().begin();
            Student stu = em.find(Student.class, idstu);
            if (stu != null) {
                em.remove(stu);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Student Fing(int idstu) {
        EntityManager em = null;
        Student stu = null;
        try {
            em = enf.createEntityManager();
            stu = em.find(Student.class, idstu);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return stu;
    }

    public void update(Student student) {
        EntityManager em = null;
        try {
            em = enf.createEntityManager();
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void upd(Student student) {
        EntityManager em = null;
        try {
            em = enf.createEntityManager();
            em.getTransaction().begin();
            Student stu = em.find(Student.class, student.getId());
            if (stu != null) {
                stu.setFirstName(student.getFirstName());
                stu.setLastName(student.getLastName());
                stu.setMarks(student.getMarks());
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
