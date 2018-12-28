package com.wbz.service.imlp;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wbz.dao.CustomerDao;
import com.wbz.model.Customer;
import com.wbz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerDao  customerMapper;

    /*
     * 根据id 查询用户资料
     * */
    @Override
    public Customer findCustomerById(Long id) {
        Customer customer = customerMapper.findCustomerById(id);
        return customer;
    }

    @Override
    public PageInfo<Customer> findAllCustomers(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Customer> customer = customerMapper.selectCustomers();
        PageInfo result = new PageInfo(customer);
        return result;
    }

    @Override
    public void updateCustomerState(Customer customer) {

        // TODO Auto-generated method stub
        customerMapper.updateCustomerById(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerMapper.deleteCustomer(id);
    }



}