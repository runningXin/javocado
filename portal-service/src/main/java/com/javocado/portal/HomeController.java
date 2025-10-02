package com.javocado.portal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.javocado.portal.service.WeatherService;
import com.javocado.portal.service.StockServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private StockServiceClient stockServiceClient;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/")
    public String home(Model model) {
        //time
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        model.addAttribute("time", currentTime);
        // 天气信息
        model.addAttribute("weather", weatherService.getWeather());

        // 💡 Add stock service data
        String jsonData = stockServiceClient.fetchHelloFromStockService();
//        // 解析成 List<Map<String, String>>
//        List<Map<String, String>> stockList = new ArrayList<>();
//
//        try {
//            stockList = objectMapper.readValue(
//                    jsonData, new TypeReference<List<Map<String, String>>>() {}
//            );
//        } catch (JsonProcessingException e) {
//            // 可以打 log，或设置一个错误提示
//            e.printStackTrace();
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (Map<String, String> stock : stockList) {
//            String ticker = stock.get("ticker");
//            String ytd = stock.get("ytdReturn");
//            sb.append(ticker)
//                    .append(" YTD Return: ")
//                    .append(ytd)
//                    .append("%, ");
//        }
//
//        if (sb.length() > 2) {
//            sb.setLength(sb.length() - 2); // 去掉最后一个逗号
//        }

        model.addAttribute("stockJson", jsonData);

        return "index";
    }
}