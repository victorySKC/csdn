package com.debug.steadyjack.controller;

import com.debug.steadyjack.entity.OrderRecord;
import com.debug.steadyjack.enums.StatusCode;
import com.debug.steadyjack.mapper.OrderRecordMapper;
import com.debug.steadyjack.request.OrderRecordInsertUpdataDto;
import com.debug.steadyjack.response.BaseResponse;
import com.debug.steadyjack.service.OrderRecoderService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by steadyjack on 2018/9/6.
 */
@RestController
public class OrderRecordController {

    private static final Logger log= LoggerFactory.getLogger(OrderRecordController.class);

    private static final String prefix="order/order";

    @Autowired
    private OrderRecordMapper orderRecordMapper;

    @Autowired
    private OrderRecoderService orderRecoderService;
    /**
     *  
     * @author sikuncheng
     * @description 
     * @name 使用id查询
     * @date 2020/3/27 0:01
     * @param id
     * @return OrderRecord
     */
    @RequestMapping(value = prefix+"/detail/{id}", method = RequestMethod.GET)
    public OrderRecord detail(@PathVariable Integer id){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {

            OrderRecord record = orderRecordMapper.selectByPrimaryKey(id);
            response.setData(record);
        }catch (Exception e){
            log.error("查询发生异常",e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        
        return response;
    }
    /**
     *
     * @author sikuncheng
     * @description
     * @name 查询
     * @date 2020/3/27 10:01
     * @param
     * @return com.debug.steadyjack.entity.OrderRecord
     */
    @RequestMapping(value = prefix+"/list", method = RequestMethod.GET)
    public OrderRecord list(){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            //将结果保存到list里面
           /*List<OrderRecord> dataList = orderRecoderService.list();
            response.setData(dataList);
            */

            List<OrderRecord> dataList = orderRecoderService.list();
           Map<String,Object> resMap = Maps.newHashMap();
           resMap.put("dataList",dataList);
           response.setData(resMap);
        }catch (Exception e){
            log.error("查询2发生异常",e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }

        return response;
    }
    /*
     *  
     * @author sikuncheng
     * @description 
     * @name 更新
     * @date 2020/3/27 11:23
     * @param [dto]
     * @return com.debug.steadyjack.response.BaseResponse
     */
    @RequestMapping(value = prefix+"/save",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse insert(@RequestBody OrderRecordInsertUpdataDto dto){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            log.info("接受数据，{}",dto);
            //TODO：进行属于你自己的控制层层面的校验以及处理
            orderRecoderService.insert(dto);
        }catch (Exception e){
            log.error("新增发生异常",e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }

        return response;

    }

    @RequestMapping(value = prefix+"/updata",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse updata(@RequestBody OrderRecordInsertUpdataDto dto){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            log.info("接受数据，{}",dto);
            //TODO：进行属于你自己的控制层层面的校验以及处理
            OrderRecord entity = orderRecordMapper.selectByPrimaryKey(dto.getId());
            if (entity == null){
                return new BaseResponse(StatusCode.Entity_Not_Exist);
            }
            orderRecoderService.update(entity,dto);
        }catch (Exception e){
            log.error("更新发生异常",e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }

        return response;

    }


    /**
     * hello world测试
     * @return
     *//*
    @RequestMapping(value = prefix+"/world",method = RequestMethod.GET)
    public BaseResponse helloWorld(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        response.setData("这是spring boot hello-world消息");
        return response;
    }

    *//**
     * 跟实体对象挂钩
     * @return
     *//*
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

    *//**
     * 跟数据库查询实体挂钩
     * @return
     *//*
    @RequestMapping(value = prefix+"/order/info/db",method = RequestMethod.GET)
    public BaseResponse orderInfoDB(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        OrderRecord record=orderRecordMapper.selectByPrimaryKey(1);
        response.setData(record);
        return response;
    }*/
}










































