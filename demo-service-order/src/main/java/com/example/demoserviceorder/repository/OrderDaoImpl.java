package com.example.demoserviceorder.repository;

import com.example.demoserviceorder.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    private final EntityManager entityManager;

    @Autowired
    public OrderDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public Order getById(Long id) {
        Query query = entityManager.createQuery("from Order where id = :id");
        query.setParameter("id", id);
        return (Order) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> getNew() {
        TypedQuery<Order> query = (TypedQuery<Order>) entityManager.createQuery("from Order where orderCompleted = false");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> getCompleted() {
        TypedQuery<Order> query = (TypedQuery<Order>) entityManager.createQuery("from Order where orderCompleted = true");
        return query.getResultList();
    }

    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }

    @Override
    public void updateCompleted(List<Order> orderList) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteCompleted() {

    }
}
