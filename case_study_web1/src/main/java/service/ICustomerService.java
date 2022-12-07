package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showAll();

    boolean add(Customer customer);

    Customer findByID(int idSearch);

    boolean edit(Customer customer);

    boolean delete(int id);

    List<Customer> search(String nameSearch, String addressSearch);

}
