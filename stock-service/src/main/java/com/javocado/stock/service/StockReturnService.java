package com.javocado.stock.service;

import com.javocado.stock.model.StockReturnDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockReturnService {

    private static final String[] TICKERS = {
            "VOO", "QQQ", "TQQQ", "TSLA", "SOXL", "GOOGL", "META", "AAPL", "NVDA", "MAGS", "JEPI"
    };

    public List<StockReturnDto> getYtdReturns() {
        List<StockReturnDto> results = new ArrayList<>();

        for (String ticker : TICKERS) {
            try {
                String url = "https://www.cnbc.com/quotes/" + ticker + "?qsearchterm=" + ticker;
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0")
                        .referrer("https://www.cnbc.com")
                        .header("Accept-Language", "en-US,en;q=0.9")
                        .get();

                Element ytdSpan = doc.selectFirst("span:contains(YTD % Change)");
                String ytdValue = "Data not available";

                if (ytdSpan != null) {
                    Element valueSpan = ytdSpan.parent().selectFirst("span.SplitStats-price");
                    if (valueSpan != null) {
                        ytdValue = valueSpan.text().trim();
                    }
                }

                results.add(new StockReturnDto(ticker, ytdValue));
            } catch (Exception e) {
                results.add(new StockReturnDto(ticker, "Error"));
            }
        }

        return results;
    }
}