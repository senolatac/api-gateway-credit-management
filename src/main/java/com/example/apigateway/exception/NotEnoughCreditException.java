package com.example.apigateway.exception;

/**
 * @author sa
 * @date 17.03.2021
 * @time 11:18
 */
public class NotEnoughCreditException extends RuntimeException
{
    public NotEnoughCreditException(String message)
    {
        super(message);
    }
}
