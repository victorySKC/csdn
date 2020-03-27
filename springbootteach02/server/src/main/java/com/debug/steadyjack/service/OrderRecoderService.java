package com.debug.steadyjack.service;

import com.debug.steadyjack.entity.OrderRecord;
import com.debug.steadyjack.mapper.OrderRecordMapper;
import com.debug.steadyjack.request.OrderRecordInsertUpdataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: springbootteach02
 * @description: 服务层
 * @author: sikuncheng
 * @create: 2020-03-27 00:14
 **/
@Service
public class OrderRecoderService {
    private static final Logger log = LoggerFactory.getLogger(OrderRecoderService.class);

    @Autowired
    private OrderRecordMapper orderRecordMapper;
    /*
     * @author sikuncheng
     * @description 
     * @name 查询列表
     * @date 2020/3/27 0:22
     * @param []
     * @return java.util.List<com.debug.steadyjack.entity.OrderRecord>
     */
    public List<OrderRecord> list(){
        return orderRecordMapper.selectAll();
    }
    /*
     *  
     * @author sikuncheng
     * @description 
     * @name 新增
     * @date 2020/3/27 11:05
     * @param [dto]
     * @return void
     */
   // @Transactional(rollbackFor = Exception.class)
    public void insert(OrderRecordInsertUpdataDto dto) throws Exception{
        /*//常见的设置方法
        OrderRecord record = new OrderRecord();
        record.setOrderNo(dto.getOrderNo());
        record.setOrderType(dto.getOrderType());*/
        //TODO ：使用spring提供的BeanUtils进行操作
        OrderRecord record = new OrderRecord();
        BeanUtils.copyProperties(dto,record);
        orderRecordMapper.insertSelective(record);
    }

    /*
     *
     * @author sikuncheng
     * @description
     * @name updata
     * @date 2020/3/27 16:21
     * @param [entity, dto]
     * @return void
     */
    public void update(OrderRecord entity,OrderRecordInsertUpdataDto dto) throws Exception{
//        OrderRecord record = new OrderRecord();
//        BeanUtils.copyProperties(dto,record);
//        orderRecordMapper.insertSelective(record);
        final Integer pk = entity.getId();
        BeanUtils.copyProperties(dto,entity);
        entity.setUpdateTime(new Date());
        entity.setId(pk);

        orderRecordMapper.updateByPrimaryKeySelective(entity);
    }
}
