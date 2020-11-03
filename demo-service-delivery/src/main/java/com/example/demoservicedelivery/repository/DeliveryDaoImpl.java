package com.example.demoservicedelivery.repository;

import com.example.demoservicedelivery.model.OrderDelivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DeliveryDaoImpl implements DeliveryDao {
    private final EntityManager entityManager;

    @Autowired
    public DeliveryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(OrderDelivery orderDelivery) {
        entityManager.persist(orderDelivery);
    }

    @Override
    public OrderDelivery getById(Long id) {
        Query query = entityManager.createQuery("from OrderDelivery where id = :id");
        query.setParameter("id", id);
        return (OrderDelivery) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderDelivery> getNew() {
        TypedQuery<OrderDelivery> query = (TypedQuery<OrderDelivery>) entityManager.createQuery("from OrderDelivery where orderCompleted = false");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderDelivery> getCompleted() {
        TypedQuery<OrderDelivery> query = (TypedQuery<OrderDelivery>) entityManager.createQuery("from Order where orderCompleted = true");
        return query.getResultList();
    }

    @Override
    public void update(OrderDelivery orderDelivery) {
        entityManager.merge(orderDelivery);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteCompleted() {

    }
}
