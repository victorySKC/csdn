package com.debug.steadyjack.request;

import java.io.Serializable;

/**
 * @program: springbootteach02
 * @description: 插入数据类
 * @author: sikuncheng
 * @create: 2020-03-27 10:10
 **/
public class OrderRecordInsertUpdataDto implements Serializable {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    private String orderNo;

    private String orderType;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "OrderRecordInsertUpdataDto{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
