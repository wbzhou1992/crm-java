package com.wbz.service.imlp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wbz.dao.StockDao;
import com.wbz.model.Customer;
import com.wbz.model.Stock;

import java.util.HashMap;
import java.util.List;

import com.wbz.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;

    @Override
    public PageInfo<Stock> getAllStock(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Stock> stock = stockDao.getStocks();
        PageInfo result = new PageInfo(stock);
        return result;
    }
}
