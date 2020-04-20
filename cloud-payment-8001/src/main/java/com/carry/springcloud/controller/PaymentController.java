package com.carry.springcloud.controller;
import com.carry.springcloud.entities.CommonResult;
import com.carry.springcloud.entities.Payment;
import com.carry.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.xml.soap.SAAJResult;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/payment")
    public CommonResult create(Payment payment) {

        int i = paymentService.create(payment);
        log.info("insert i : "+ i);
        if (i> 0) {
            return new CommonResult(200,"插入成功", i);
        }else {
            return new CommonResult(400,"插入失败", i);
        }
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200,"查询成功", payment);
        }else {
            return new CommonResult(404,"没有找到", payment);
        }
    }


}