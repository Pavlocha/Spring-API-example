package com.mehdi.spring.foodapi.services;

import com.mehdi.spring.foodapi.domain.Food;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public List<Food> listALL() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("From Food").getResultList();
    }

    @Override
    public Food getByID(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Food.class, id);
    }

    @Override
    public Object saveOrUpdate(Object domainObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Object savedFood = em.merge(domainObject);
        em.getTransaction().commit();
        return savedFood;
    }


    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Food.class, id));
        em.getTransaction().commit();
    }

    @Override
    public long getSumCalories() {
        EntityManager em = emf.createEntityManager();
        return (long) em.createQuery("SELECT SUM(calories)FROM Food ").getSingleResult();

    }
}
