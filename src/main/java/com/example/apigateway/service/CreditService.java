package com.example.apigateway.service;

import com.example.apigateway.redis.CreditRedis;
import com.example.apigateway.repository.ICreditRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sa
 * @date 17.03.2021
 * @time 11:00
 */
@Service
@RequiredArgsConstructor
public class CreditService implements ICreditService
{
    private final ICreditRedisRepository creditRedisRepository;

    @Override
    public void saveCredit(String apiKey, Integer quote)
    {
        CreditRedis credit = new CreditRedis(apiKey, quote);
        creditRedisRepository.save(credit);
    }

    @Override
    public Optional<CreditRedis> getCredit(String apiKey)
    {
        return creditRedisRepository.findById(apiKey);
    }
}
