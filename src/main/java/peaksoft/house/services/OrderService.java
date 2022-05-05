package peaksoft.house.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.house.configuration.Configurations;
import peaksoft.house.models.Order;

import java.util.List;

public class OrderService implements AutoCloseable {

    private final EntityManagerFactory entityManagerFactory = Configurations.createEntityManagerFactory();

    public void save(Order newOrder) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newOrder);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void update(Long orderId, Order newOrder) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Order o set o.date = :date , o.price = :price, o.status = :status where o.id = :id")
                .setParameter("date", newOrder.getDate())
                .setParameter("price", newOrder.getPrice())
                .setParameter("id", orderId).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Order> findAllOrders() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Order> orders = entityManager.createQuery("select o from Order o", Order.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return orders;
    }

    public Order findById(Long orderId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Order order = entityManager.createQuery("select o from Order o where o.id = ?1", Order.class)
                .setParameter(1, orderId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return order;
    }

    public void deleteById(Long orderId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Order order = entityManager.find(Order.class, orderId);
        entityManager.remove(order);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
