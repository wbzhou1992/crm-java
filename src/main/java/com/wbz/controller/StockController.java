package com.wbz.controller;


import com.wbz.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @ResponseBody
    @RequestMapping(value = "/all")
    public Object findAllStocks(HttpServletRequest req, HttpServletResponse res, int pageNum, int pageSize) {
            Logger log = Logger.getLogger("soft");
            log.info("Process Request ALL");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST");
        return stockService.getAllStock(pageNum,pageSize);
    }


//    @ResponseBody
//    @RequestMapping(value = "/detail")
//    public Customer detail(HttpServletRequest req, HttpServletResponse res,Long id) throws Exception {
//
//        Customer customer = stockService.findCustomerById(id);
//        res.setHeader("Access-Control-Allow-Origin", "*");
//        res.setHeader("Access-Control-Allow-Methods", "GET, POST");
//        return customer;
//    }

}
