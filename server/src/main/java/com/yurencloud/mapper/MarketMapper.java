package com.yurencloud.mapper;

import com.yurencloud.model.MarketKline;

public interface MarketMapper {
    int insertKline(MarketKline kline);
    int insertHistoryKline(MarketKline kline);
}