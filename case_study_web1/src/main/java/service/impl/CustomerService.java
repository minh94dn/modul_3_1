package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<Customer> showAll() {
        return iCustomerRepository.showAll();

    }

    @Override
    public boolean add(Customer customer) {
        return iCustomerRepository.add(customer);
    }

    @Override
    public Customer findByID(int idSearch) {
        return iCustomerRepository.findByID(idSearch);
    }

    @Override
    public boolean edit(Customer customer) {
        return iCustomerRepository.edit(customer);
    }

    @Override
    public boolean delete(int id) {
        return iCustomerRepository.delete(id);
    }

    @Override
    public List<Customer> search(String nameSearch, String addressSearch) {
        return iCustomerRepository.search(nameSearch, addressSearch);
    }
}
