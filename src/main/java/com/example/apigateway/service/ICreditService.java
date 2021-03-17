package com.example.apigateway.service;

import com.example.apigateway.redis.CreditRedis;

import java.util.Optional;

/**
 * @author sa
 * @date 17.03.2021
 * @time 11:00
 */
public interface ICreditService
{
    void saveCredit(String apiKey, Integer quote);

    Optional<CreditRedis> getCredit(String apiKey);
}
