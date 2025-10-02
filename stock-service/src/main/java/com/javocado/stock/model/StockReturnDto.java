package com.javocado.stock.model;

public class StockReturnDto {
    private String ticker;
    private String ytdReturn;

    public StockReturnDto(String ticker, String ytdReturn) {
        this.ticker = ticker;
        this.ytdReturn = ytdReturn;
    }

    public String getTicker() {
        return ticker;
    }

    public String getYtdReturn() {
        return ytdReturn;
    }
}
