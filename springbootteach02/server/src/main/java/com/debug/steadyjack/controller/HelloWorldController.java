package com.debug.steadyjack.controller;

import com.debug.steadyjack.entity.OrderRecord;
import com.debug.steadyjack.mapper.OrderRecordMapper;
import com.debug.steadyjack.response.BaseResponse;
import com.debug.steadyjack.response.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by steadyjack on 2018/9/6.
 */
@RestController
public class HelloWorldController {

    private static final Logger log= LoggerFactory.getLogger(HelloWorldController.class);

    private static final String prefix="hello";

    @Autowired
    private OrderRecordMapper orderRecordMapper;


    /**
     * hello world测试
     * @return
     */
    @RequestMapping(value = prefix+"/world",method = RequestMethod.GET)
    public BaseResponse helloWorld(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        response.setData("这是spring boot hello-world消息");
        return response;
    }

    /**
     * 跟实体对象挂钩
     * @return
     */
    @RequestMapping(value = prefix+"/order/info",method = RequestMethod.GET)
    public BaseResponse orderInfo(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        OrderRecord record=new OrderRecord();
        record.setId(1);
        record.setOrderNo("10010");
        record.setOrderType("物流");
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        response.setData(record);
        return response;
    }

    /**
     * 跟数据库查询实体挂钩
     * @return
     */
    @RequestMapping(value = prefix+"/order/info/db",method = RequestMethod.GET)
    public BaseResponse orderInfoDB(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        OrderRecord record=orderRecordMapper.selectByPrimaryKey(1);
        response.setData(record);
        return response;
    }
}










































