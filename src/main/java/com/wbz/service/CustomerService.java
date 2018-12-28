package com.wbz.service;

import com.wbz.model.Customer;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CustomerService {


    public PageInfo<Customer> findAllCustomers(int pageNum, int pageSize);

    public Customer findCustomerById(Long id);

    public void updateCustomerState(Customer customer);
    // 删除用户
    public void deleteCustomer(Long id);
}
