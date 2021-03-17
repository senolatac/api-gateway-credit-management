package com.example.apigateway.repository;

import com.example.apigateway.redis.CreditRedis;
import org.springframework.data.repository.CrudRepository;

/**
 * @author sa
 * @date 17.03.2021
 * @time 10:59
 */
public interface ICreditRedisRepository extends CrudRepository<CreditRedis, String>
{
}
