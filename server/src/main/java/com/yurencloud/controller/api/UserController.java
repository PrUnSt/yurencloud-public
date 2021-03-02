package com.yurencloud.controller.api;

import com.yurencloud.hb.api.HbdmRestApiV1;
import com.yurencloud.hb.api.IHbdmRestApi;
import com.yurencloud.mapper.MarketMapper;
import com.yurencloud.model.MarketKline;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private MarketMapper marketMapper;

    final String api_key = "bewr5drtmh-cba4fc40-484891df-2c6e7"; // huobi申请的apiKey
    final String secret_key = "af88cc6e-d3ee9000-36bb5468-31de9"; // huobi申请的secretKey

    @GetMapping("/kline{coinType}")
    @ResponseBody
    public String getKline (String coinType) throws IOException, HttpException {
        String url_prex = "https://api.hbdm.com";//火币api接口地址https://api.hbdm.com
        IHbdmRestApi futureGetV1 = new HbdmRestApiV1(url_prex);
        IHbdmRestApi futurePostV1 = new HbdmRestApiV1(url_prex, api_key, secret_key);

        // 获取K线数据
        String historyKline = futureGetV1.futureMarketHistoryKline(coinType, "15min","100");
        Date date = new Date();
        MarketKline kline = new MarketKline();
        kline.setKline(historyKline);
        kline.setTime(date);
        marketMapper.insertKline(kline);
        return historyKline;
    }

    @GetMapping("/market{coinType}")
    @ResponseBody
    public String getMarket (String coinType) throws IOException, HttpException {
        String url_prex = "https://api.hbdm.com";//火币api接口地址https://api.hbdm.com
        IHbdmRestApi futureGetV1 = new HbdmRestApiV1(url_prex);
        IHbdmRestApi futurePostV1 = new HbdmRestApiV1(url_prex, api_key, secret_key);

        // 获取聚合行情
        String merged = futureGetV1.futureMarketDetailMerged(coinType);
//        marketKlineMapper.addMarketKline(merged);
//        userMapper.insertKline(merged);
        Date date = new Date();
        MarketKline kline = new MarketKline();
        kline.setKline(merged);
        kline.setTime(date);
        marketMapper.insertKline(kline);
        return merged;
    }

}
