package com.codegym.service;

import com.codegym.model.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customers = new HashMap<>();
    static{
        customers.put(1, new Customer(1, "Truong"," truong@gmail.com", "Hoa Binh"));
        customers.put(2, new Customer(2, "Hoang"," hoang@gmail.com", "Ha Noi"));
        customers.put(3, new Customer(3, "Nam"," nam@gmail.com", "Hoa Binh"));
        customers.put(4, new Customer(4, "Dung"," dung@gmail.com", "Bac Ninh"));
        customers.put(5, new Customer(5, "Trang"," trang@gmail.com", "Ho Chi Minh"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<Customer>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
