package com.wbz.controller;


import com.wbz.service.CustomerService;
import com.wbz.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/all")
    public Object findAllUsers(HttpServletRequest req, HttpServletResponse res, int pageNum, int pageSize) {
            Logger log = Logger.getLogger("soft");
            log.info("Process Request ALL");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST");
        return customerService.findAllCustomers(pageNum,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/create")
    public Map detail(HttpServletRequest req, HttpServletResponse res,Customer customer) throws Exception {

        customerService.createCustomer(customer);
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST");
        HashMap<String,Integer> message = new HashMap<>();
        message.put("code",200);
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/detail")
    public Customer detail(HttpServletRequest req, HttpServletResponse res,Long id) throws Exception {

        Customer customer = customerService.findCustomerById(id);
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST");
        return customer;
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    //@RequestBody 自动转成json格式
    public Map updateCustomer(HttpServletRequest req, HttpServletResponse res, Customer customer) throws Exception {
        customerService.updateCustomerState(customer);
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST");
        HashMap<String,Integer> message = new HashMap<>();
        message.put("code",200);
        return message;

    }
    @ResponseBody
    @RequestMapping(value = "/delete")
    public Map deleteCustomer(HttpServletRequest req, HttpServletResponse res,Long id) throws Exception {
        customerService.deleteCustomer(id);
        Logger log = Logger.getLogger("delete");
        log.info("Process Request delete cust_id:"+id);
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST");
        HashMap<String,Integer> message = new HashMap<>();
        message.put("date",200);
        return message;
    }
}
