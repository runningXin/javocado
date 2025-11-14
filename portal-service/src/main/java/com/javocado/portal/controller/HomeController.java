package com.javocado.portal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javocado.idiom.model.Idiom;
import com.javocado.idiom.repository.IdiomRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.javocado.portal.service.WeatherService;
import com.javocado.portal.service.StockServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private IdiomRepository idiomRepository;

    @GetMapping("/")
    public String home(Model model) {
        //time
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        model.addAttribute("time", currentTime);
        // 天气信息
        model.addAttribute("weather", weatherService.getWeather());

        // 💡 Add stock service data
        String jsonData = stockServiceClient.fetchHelloFromStockService();
        model.addAttribute("stockJson", jsonData);

        //thought of the day
        Idiom idiom = idiomRepository.findRandomIdiom();
        if (idiom != null) {
            model.addAttribute("idiomText", idiom.getText());
            model.addAttribute("idiomTag", idiom.getTag());
        } else {
            model.addAttribute("idiomText", "No idiom found.");
            model.addAttribute("idiomTag", "");
        }

        // Article of the Day（只显示 digest）
        try {
            RestTemplate restTemplate = new RestTemplate();
            JsonNode articleNode = restTemplate.getForObject(
                    "http://localhost:8082/article-of-the-day", JsonNode.class);

            if (articleNode != null && articleNode.has("digest")) {
                model.addAttribute("articleDigest", articleNode.get("digest").asText());
            } else {
                model.addAttribute("articleDigest", "No article found.");
            }
        } catch (Exception e) {
            model.addAttribute("articleDigest", "Failed to load article.");
        }

        return "index";
    }
}