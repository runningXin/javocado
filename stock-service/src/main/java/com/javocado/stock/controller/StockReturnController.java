package com.javocado.stock.controller;

import com.javocado.stock.model.StockReturnDto;
import com.javocado.stock.service.StockReturnService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockReturnController {

    private final StockReturnService stockReturnService;

    public StockReturnController(StockReturnService stockReturnService) {
        this.stockReturnService = stockReturnService;
    }

    @GetMapping("/api/ytd-returns")
    public List<StockReturnDto> getStockYtdReturns() {
        return stockReturnService.getYtdReturns();
    }
}