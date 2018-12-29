package com.wbz.service;

import com.wbz.model.Stock;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StockService {
    PageInfo<Stock> getAllStock(int pageNum, int pageSize);
}
