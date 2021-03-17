package com.example.apigateway.aspect;

import com.example.apigateway.exception.NotEnoughCreditException;
import com.example.apigateway.exception.UnauthorizedException;
import com.example.apigateway.service.ICreditService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sa
 * @date 17.03.2021
 * @time 10:44
 */
@Aspect
@Component
@RequiredArgsConstructor
public class ValidateRequestAspect
{
    private final HttpServletRequest request;
    private final ICreditService creditService;

    @Before("@annotation(validateRequest) || @within(validateRequest)")
    public void adviseVerifyAnnotation(JoinPoint joinPoint, ValidateRequest validateRequest)
    {
        String apiKey = request.getHeader("Authorization");
        var credit = creditService.getCredit(apiKey);
        if (!credit.isPresent())
        {
            throw new UnauthorizedException();
        }
        else if (credit.get().getRemainingQuote() <= 0)
        {
            throw new NotEnoughCreditException("not-enough-credit");
        }
        creditService.saveCredit(apiKey, credit.get().getRemainingQuote() - validateRequest.credit());
    }
}
