package com.testredis.demo.Controller;


import com.testredis.demo.Service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "订单接口")
public class OderController {
    @Resource
    private OrderService orderService;
    @ApiOperation("新增订单接口")
    @RequestMapping(value = "/odder/add",method = RequestMethod.POST)
    public  void addOder(){
        orderService.addOrder();
    }
    @ApiOperation("按照keyid订单接口")
    @RequestMapping(value = "/odder/{keyId}",method = RequestMethod.POST)
    public  String readOder(@PathVariable Integer keyId){
       return  orderService.getOrderById(keyId);
    }

}
