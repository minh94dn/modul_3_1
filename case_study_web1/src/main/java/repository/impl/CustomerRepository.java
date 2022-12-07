package repository.impl;

import model.Customer;
import model.CustomerType;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String SELECT_ALL = "select * from customer c join customer_type ct on ct.id_customer_type = c.id_customer_type order by id_customer;";
    private final String INSERT_CUSTOMER = "insert into customer (id_customer_type, `name`, date_of_birth, gender, id_card, phone_number, email, address) values (?,?,?,?,?,?,?,?);";
    private final String FIND_BY_ID = "select * from customer where id_customer = ?;";
    private final String UPDATE_CUSTOMER = "update customer set id_customer_type = ?, `name`= ?, date_of_birth = ?, gender = ?, id_card = ?, phone_number= ?, email= ?, address= ? where id_customer = ?;";
    private final String DELETE_CUSTOMER = "delete from customer where id_customer = ?;";
    private final String SEARCH_CUSTOMER = "select * from customer c join customer_type ct on ct.id_customer_type = c.id_customer_type where `name` like ? and address like ?;";

    @Override
    public List<Customer> showAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_customer = rs.getInt("id_customer");
                int id_customer_type = rs.getInt("id_customer_type");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                boolean gender = rs.getBoolean("gender");
                String idCard = rs.getString("id_card");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String nameCustomerType = rs.getString("name_customer_type");
                CustomerType customerType1 = new CustomerType(nameCustomerType);
                Customer customer = new Customer(id_customer, id_customer_type, name, dateOfBirth, gender, idCard, phoneNumber, email, address, customerType1);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean add(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER);
            ps.setInt(1, customer.getCustomerTypeId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getDateOfBirth());
            ps.setBoolean(4, customer.isGender());
            ps.setString(5, customer.getIdCard());
            ps.setString(6, customer.getPhoneNumber());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer findByID(int idSearch) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID);
            ps.setInt(1, idSearch);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCustomer = rs.getInt("id_customer");
                int idCustomer_type = rs.getInt("id_customer_type");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                boolean gender = rs.getBoolean("gender");
                String idCard = rs.getString("id_card");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customer = new Customer(idCustomer, idCustomer_type, name, dateOfBirth, gender, idCard, phoneNumber, email, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean edit(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER);
            ps.setInt(1, customer.getCustomerTypeId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getDateOfBirth());
            ps.setBoolean(4, customer.isGender());
            ps.setString(5, customer.getIdCard());
            ps.setString(6, customer.getPhoneNumber());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());
            ps.setInt(9, customer.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> search(String nameSearch, String addressSearch) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH_CUSTOMER);
            ps.setString(1,"%" + nameSearch + "%");
            ps.setString(2,"%" + addressSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_customer = rs.getInt("id_customer");
                int id_customer_type = rs.getInt("id_customer_type");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                boolean gender = rs.getBoolean("gender");
                String idCard = rs.getString("id_card");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String nameCustomerType = rs.getString("name_customer_type");
                CustomerType customerType1 = new CustomerType(nameCustomerType);
                Customer customer = new Customer(id_customer, id_customer_type, name, dateOfBirth, gender, idCard, phoneNumber, email, address, customerType1);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
