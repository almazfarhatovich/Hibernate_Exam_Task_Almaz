package peaksoft.house;

import peaksoft.house.enums.*;
import peaksoft.house.models.*;
import peaksoft.house.services.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static peaksoft.house.enums.OrderStatus.*;

public class App {
    public static void main(String[] args) throws Exception {
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        SupplierService supplierService = new SupplierService();
        Address address = new Address("KGZ", "BISHKEK", "Djal", "Tynaieva 23");
        Address address1 = new Address("RU", "MOSCOW", "METRO LUBLINO", "LUBLINO 23");
        Address address2 = new Address("KAZ", "ALMATY", "ALMA", "TY 47");
        Address address3 = new Address("KGZ", "TALAS", "BAKAI_ATA", "DOSBAI 91");
        Address address4 = new Address("UZ", "TASHKENT", "ASSA", "ASDE 53");
        Address address5 = new Address("KGZ", "OSH", "OPO", "PSG 83");
        Address address6 = new Address("RU", "PETER", "PETERBURG", "DSAD 01");
        Address address7 = new Address("KAZ", "ASTANA", "ASTA", "NA 88");
        Address address00 = new Address("KGZ", "BISHKEK", "Ddjal", "Tynaie8va 23");
        Address address11 = new Address("RU", "MO8SCOW", "METRO LUBLINO", "LUBLINO 23");
        Address address22 = new Address("K8AZ", "ALMATY", "ALMA", "TY 47");
        Address address33 = new Address("KG8Z", "TALAS", "BAKAI_ATA", "DOSBAI 91");
        Address address44 = new Address("UZ", "TASHKENT", "ASSA", "ASDE 53");
        Address address55 = new Address("KGZ", "OSH", "OPO", "PSG 83");
        Address address66 = new Address("RU", "PETER", "PETERBURG", "DSAD 01");
        Address address77 = new Address("KAZ", "ASTANA", "ASTA", "NA 88");

        Order order = new Order(LocalDateTime.now(), BigDecimal.valueOf(1900), REQUEST);
        Order order1 = new Order(LocalDateTime.now(), BigDecimal.valueOf(1000), DELIVERED);
        Order order2 = new Order(LocalDateTime.now(), BigDecimal.valueOf(900), CANCELED);
        Order order3 = new Order(LocalDateTime.now(), BigDecimal.valueOf(19000), REQUEST);
        Order order4 = new Order(LocalDateTime.now(), BigDecimal.valueOf(9000), REQUEST);
        Order order5 = new Order(LocalDateTime.now(), BigDecimal.valueOf(12900), DELIVERED);
        Order order6 = new Order(LocalDateTime.now(), BigDecimal.valueOf(5900), DELIVERED);
        Order order7 = new Order(LocalDateTime.now(), BigDecimal.valueOf(2900), DELIVERED);

        Customer customer = new Customer("Almaz Zhanybekov", 706280609L, List.of(order), address);
        Customer customer1 = new Customer("Nurgazy Nurmamaton", 705123456L, List.of(order1), address1);
        Customer customer2 = new Customer("Muhammad Toichubai uulu", 705654123L, List.of(order2), address2);
        Customer customer3 = new Customer("Erbol Anarbaev", 709874561L, List.of(order3), address3);
        Customer customer4 = new Customer("Ulan Kubanychbekov", 705231231L, List.of(order4), address4);
        Customer customer5 = new Customer("Altynbek Zhumadil uulu", 705454565L, List.of(order5), address5);
        Customer customer6 = new Customer("Altynbek Zhumadil uulu", 707894561L, List.of(order6), address6);
        Customer customer7 = new Customer("Altynbek Zhumadil uulu", 708745222L, List.of(order7), address7);


        Supplier supplier = new Supplier("Mike Tyson", 2925, SupplierStatus.BUSY, List.of(order, order2));
        Supplier supplier1 = new Supplier("Jason Stat ham", 925, SupplierStatus.FREE, List.of(order1, order1));
        Supplier supplier2 = new Supplier("Brad Pitt", 295, SupplierStatus.FREE, List.of(order2, order4));
        Supplier supplier3 = new Supplier("Sylvester Stallone", 955, SupplierStatus.BUSY, List.of(order3, order2));
        Supplier supplier4 = new Supplier("Leonardo Di Capri", 258, SupplierStatus.FREE, List.of(order4, order));
        Supplier supplier5 = new Supplier("Bradley Cooper", 2778, SupplierStatus.BUSY, List.of(order5, order3));
        Supplier supplier6 = new Supplier("Tom Hardy", 5253, SupplierStatus.FREE, List.of(order6, order3));
        Supplier supplier7 = new Supplier("Tom Holland", 8521, SupplierStatus.BUSY, List.of(order7, order4));


//        orderService.save(order);
//        orderService.save(order1);
//        orderService.save(order2);
//        orderService.save(order3);
//        orderService.save(order4);
//        orderService.save(order5);
//        orderService.save(order6);
//        orderService.save(order7);

//        supplierService.save(supplier);
//        supplierService.save(supplier1);
//        supplierService.save(supplier2);
//        supplierService.save(supplier3);
//        supplierService.save(supplier4);
//        supplierService.save(supplier5);
//        supplierService.save(supplier6);
//        supplierService.save(supplier7);

//        customerService.save(customer);
//        customerService.save(customer1);
//        customerService.save(customer2);
//        customerService.save(customer3);
//        customerService.save(customer4);
//        customerService.save(customer5);
//        customerService.save(customer6);
//        customerService.save(customer7);


        //   customerService.deleteById(6L);
//        Supplier id = supplierService.findById(7L);
//        Order byId = orderService.findById(7L);
//        id.setOrders(List.of(byId));
//        byId.setSupplier(id);
//        supplierService.save(id);

//        supplierService.findAllOrders(6L).forEach(System.out::println);
        supplierService.getOrder(10L, 31L);
//        supplierService.save(supplier6);
//        customerService.close();
//        orderService.close();
        supplierService.close();
    }
}
