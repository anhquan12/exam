package com.example.demo.service;

import com.example.demo.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

@Service
public class ProductService {
    private static final String uri = "10.22.186.113:8888/api/products/1";

    public Product getProductId() throws IOException, ParseException {
        String Jsonpath = uri + "";
        Product product = new Product();
        String json = urlToJson(new URL(Jsonpath));
        ObjectMapper mapper = new ObjectMapper();
        product = mapper.readValue(json, product.getClass());
        return product;
    }

    public static String urlToJson(URL urlString) throws ParseException {
        StringBuilder sb = null;
        URL url;
        URLConnection urlCon;

        try {
            url = urlString;
            urlCon = url.openConnection();
            BufferedReader in = null;
            if (urlCon.getHeaderField("Content-Encoding") != null
                    && urlCon.getHeaderField("Content-Encoding").equals("gzip")) {
                in = new BufferedReader(new InputStreamReader(new GZIPInputStream(urlCon.getInputStream())));
            } else {
                in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            }
            String inputLine;
            sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
        }
        if (sb != null) {
//        JSONParser parser = new JSONParser();
//        JSONObject json = (JSONObject) parser.parse(sb.toString());
            return sb.toString();
        } else {
            return sb.toString();
        }
    }
}
