package peaksoft.house.services;

import jakarta.persistence.*;
import peaksoft.house.configuration.Configurations;
import peaksoft.house.enums.OrderStatus;
import peaksoft.house.models.Customer;
import peaksoft.house.models.Order;
import java.util.List;
import static peaksoft.house.enums.OrderStatus.*;



public class CustomerService implements AutoCloseable {

    private final EntityManagerFactory entityManagerFactory = Configurations.createEntityManagerFactory();


    public void save(Customer newCustomer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newCustomer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void merge(Customer newCustomer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(newCustomer);
        entityManager.getTransaction().commit();

    }

    public void makeAnOrder(Long customerId, Order newOrder) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, customerId);
        customer.setOrder(newOrder);
        entityManager.close();
    }

    public void cancelOrder(Long customerId, Long orderId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Order o set o.status = :status where o.customer.id = :id and o.id = :oId").setParameter("status",CANCELED)
                        .setParameter("id",customerId)
                                .setParameter("oId",orderId).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Long customerId, Customer newCustomer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Customer c set c.fullName= :fullName,c.phoneNumber = :phoneNumber where c.id = :id")
                .setParameter("fullName", newCustomer.getFullName())
                .setParameter("phoneNumber", newCustomer.getPhoneNumber())
                .setParameter("id", customerId).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Order> findAllOrders(Long customerId, OrderStatus orderStatus) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Order> orders = entityManager.createQuery("select o from Order o join Customer c on o.id = c.id " +
                        "where c.id = :id and o.status = :status", Order.class)
                .setParameter("id", customerId)
                .setParameter("status", orderStatus).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return orders;
    }

    public List<Customer> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Customer> customers = entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return customers;
    }

    public Customer findById(Long customerId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = entityManager.createQuery("select c from Customer c where c.id=?1", Customer.class).setParameter(1, customerId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return customer;
    }

    public void deleteById(Long customerId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, customerId);
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void close() throws Exception {
       entityManagerFactory.close();
    }
}
