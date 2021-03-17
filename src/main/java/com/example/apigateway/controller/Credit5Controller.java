package com.example.apigateway.controller;

import com.example.apigateway.aspect.ValidateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sa
 * @date 17.03.2021
 * @time 10:39
 */
@RestController
@RequestMapping("api/credit-5")
@ValidateRequest(credit = 5)
public class Credit5Controller
{
    @GetMapping
    public ResponseEntity<?> getMethod()
    {
        return ResponseEntity.ok(true);
    }
}
