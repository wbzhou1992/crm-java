package com.wbz.dao;


import com.wbz.model.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> selectCustomers();
    public Customer findCustomerById(Long id);
    public void createCustomer(Customer c);
    public void updateCustomerById(Customer c);
    public void deleteCustomer(Long id);

}
