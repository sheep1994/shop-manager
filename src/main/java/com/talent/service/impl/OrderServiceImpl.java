package com.talent.service.impl;

import com.alibaba.fastjson.JSON;
import com.talent.mapper.OrderMapper;
import com.talent.mapper.PreferentialMapper;
import com.talent.model.*;
import com.talent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author guobing
 * @Title: OrderServiceImpl
 * @ProjectName shop-manager
 * @Description: TODO
 * @date 2019/1/18上午10:36
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PreferentialMapper preferentialMapper;

    @Override
    public List<Preferential> getPreferential(Map<String, Object> paramMap) {
        return preferentialMapper.getPreferential(paramMap);
    }

    @Override
    public List<CartGood> getOrderList(Map<String,Object> paramMap) {
        return orderMapper.getOrderListByPhone(paramMap);
    }

    @Override
    public List<Order> getOrderSuccessList(String phoneId) {
        return orderMapper.getSuccessOrder(phoneId);
    }

    @Override
    public int deleteUserOrder(Long orderId, String phoneId) {
        return orderMapper.deleteByPrimaryKey(orderId,phoneId);
    }

    @Override
    public int editUserOrder(Long orderId, String phoneId,Integer orderCount) {
        return orderMapper.updateOrderCount(orderId,phoneId,orderCount);
    }

    @Override
    public int insertSelectiveOrder(Order order) {
        return orderMapper.insertSelective(order);
    }

    @Override
    public int changeOrderStatus2Buy(String phoneId, String orderId,String togetherId,String rank,String reserveTime,String message,Short payWay,Float price,Float totalPrice) {

        return orderMapper.changeOrderStatus2Buy(Long.valueOf(orderId),phoneId,togetherId,rank,reserveTime,message,payWay,price,totalPrice);
    }

    @Override
    public int changeOrderStatus2Deliver(String phoneId, String togetherId) {
        return orderMapper.changeOrderStatus2Deliver(togetherId, phoneId);
    }

    @Override
    public int changeOrderStatus2Finish(String phoneId, String orderId) {
        return orderMapper.changeOrderStatus2Finish(orderId, phoneId);
    }

    @Override
    public List<SmallOrder> getOrderListInMine(Map<String,Object> map) {
        return orderMapper.getOrderListInMine(map);
    }

    @Override
    public List<SmallOrder> getOrderListInMineWait2Deliver(String phoneId) {
        return orderMapper.getOrderListInMineWait2Deliver(phoneId);
    }

    @Override
    public List<SmallOrder> getOrderListInMineDeliver(String phoneId) {
        return orderMapper.getOrderListInMineDeliver(phoneId);
    }

    @Override
    public List<SmallOrder> getOrderListInMineFinish(String phoneId) {
        return orderMapper.getOrderListInMineFinish(phoneId);
    }

    @Override
    public List<String> getTogetherId(Map<String,Object> map) {
        return orderMapper.getTogetherId(map);
    }

    @Override
    public Map<String, Object> getOrderSummaryCount(String phone) {
        Map<String, Object> map=new HashMap<String, Object>();

        return map;
    }

    @Override
    public List<Order> selectOrder(Order order) {
        return orderMapper.selectOrder(order);
    }

    @Override
    public void deleteCartGood(Order order) {
        orderMapper.deleteCartGood(order);
    }

    @Override
    public Order selectPersonOrder(String phoneId, Long orderId) {
        return orderMapper.selectPersonOrder(phoneId,orderId);
    }

    @Override
    public void updateOrderRemarked(String phoneId, Long orderId) {
        orderMapper.updateOrderRemarked(phoneId,orderId);
    }

    @Override
    public List<SuperAdminOrder> superAdminGetOrder(Map<String, Object> paramMap) {
        return orderMapper.superAdminGetOrder(paramMap);
    }


    /**
     * 设置配送员
     * @param togetherId
     * @param adminPhone
     * @return
     */
    @Override
    public int setDeliverAdmin(String togetherId, String adminPhone) {
        return orderMapper.setDeliverAdmin(togetherId,adminPhone);
    }

    @Override
    public Order selectOneOrder(String phoneId, String orderId) {
        return orderMapper.selectByPrimaryKey(Long.valueOf(orderId),phoneId);
    }


    /**
     * 配送员获取配送订单
     * @param paramMap
     * @return
     */
    @Override
    public List<DeliverOrder> deliverGetOrder(Map<String, Object> paramMap) {
        return orderMapper.deliverGetOrder(paramMap);
    }

    @Override
    public List<DeliverChildOrder> getDeliverChildOrders(String togetherId) {
        return orderMapper.getDeliverChildOrders(togetherId);
    }

    public List<PCOrder> getPCOrders(Short status,Integer limit,Integer offset,String search) {
        Calendar calendar = Calendar.getInstance();

        if(status != 1){
            calendar.add(Calendar.MONTH, -1);
            // 设定默认只显示近两个月的数据
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            return orderMapper.getPCOrders(status,calendar.getTime(),limit,offset,search);
        }else{
            // 代发货订单默认显示两周内订单
            calendar.add(Calendar.DAY_OF_MONTH, -14);
            return orderMapper.getPCOrdersWithOutAdmin(status, calendar.getTime(),limit,offset,search);
        }
    }

    public Long getPCOrdersCount(Short status, String search) {
        Calendar calendar=Calendar.getInstance();

        if(status!=1){
            calendar.add(Calendar.MONTH, -1);
            // 设定默认只显示近两个月的数据
            calendar.set(Calendar.DAY_OF_MONTH, 1);
        }else{
            // 代发货订单默认显示两周内订单
            calendar.add(Calendar.DAY_OF_MONTH, -14);
        }

        return orderMapper.getPCOrdersCount(status,calendar.getTime(),search);
    }

    @Override
    public int setOrderInvalid(Map<String, Object> parameterMap) {
        return orderMapper.setOrderInvalid(parameterMap);
    }

    @Override
    public List<DeliverOrder> selectOrdersByDate(Map<String, Object> paramMap) {
        return orderMapper.selectOrdersByDate(paramMap);
    }

    @Override
    public List<DeliverChildOrder> getAllChildOrders(
            Map<String, Object> paramMap) {
        return orderMapper.getAllChildOrder(paramMap);
    }

    @Override
    public Date getTogetherDate(Map<String, Object> paramMap) {
        return orderMapper.getTogetherDate(paramMap);
    }

    @Override
    public List<SmallOrder> getOrdersById(Map<String, Object> paramMap) {
        return orderMapper.getOrdersById(paramMap);
    }


    @Override
    public Integer modifyOrderStatus(Map<String, Object> paramMap) {
        return orderMapper.modifyOrderStatus(paramMap);
    }

    @Override
    public void deleteOrder(Map<String, Object> paramMap) {
        orderMapper.deleteOrder(paramMap);
    }

    @Override
    public SmallOrder getOrderById(Map<String, Object> paramMap) {
        return orderMapper.getOrderById(paramMap);
    }

    @Override
    public String getUserPhone(Map<String, Object> requestMap) {
        return orderMapper.getUserPhone(requestMap);
    }

    @Override
    public String getAdminPhone(Map<String, Object> requestMap) {
        return orderMapper.getAdminPhone(requestMap);
    }

    @Override
    public Preferential getPreferentialById(Integer preferentialId) {
        return preferentialMapper.selectByPrimaryKey(preferentialId);
    }

    public PreferentialMapper getPreferentialMapper() {
        return preferentialMapper;
    }

    @Override
    public Integer updateOrderPrice(Map<String, Object> paramMap) {
        return orderMapper.updateOrderPrice(paramMap);
    }
    @Override
    public Integer updateOrder(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }


    @Override
    public Float getTotalPriceByTogetherId(String togetherId) {
        // TODO Auto-generated method stub
        return orderMapper.selectTotalPriceByTogetherId(togetherId);
    }

    @Override
    public int updateOrderStatusAndAmount(Map<String, Object> paramMap) {
        return orderMapper.updateOrderStatusAndAmount(paramMap);
    }

    /**
     * 获取某笔订单的校区状态
     * @param paramMap
     * @return
     */
    @Override
    public Integer getCampusIdByTogetherId(Map<String, Object> paramMap) {
        return orderMapper.getCampusIdByTogetherId(paramMap);
    }

    /**
     * 计算折扣和优惠后的价格
     */
    @Override
    public  Float getPriceDiscounted(String[] orderId,int campusId,String phoneId){
        //获取满减的信息
        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put("campusId",campusId);
        paramMap.put("phoneId", phoneId);
        System.out.println(paramMap);
        List<Preferential> prefers = getPreferential(paramMap);

        System.out.println(JSON.toJSONString(prefers));
        // 折扣之后的总价
        Float discountPrice = 0f;
        // 满减商品之后的总价
        Float fullDiscount = 0f;
        System.out.println(JSON.toJSONString(orderId));
        for (String id : orderId) {
            paramMap.put("orderId",Long.parseLong(id));
            Float price = 0f;
            CartGood order=orderMapper.getOrderByOrderId(paramMap);
            System.out.println("order is"+JSON.toJSONString(order));
            if(order.getIsDiscount() == 1){
                System.out.println(order.getDiscountPrice());
                price = order.getOrderCount()*order.getDiscountPrice();
            }else{
                price = order.getOrderCount()*order.getPrice();
            }

            if(order.getIsFullDiscount()==1){
                fullDiscount+=price;
            }

            discountPrice+=price;
        }

        Integer discount=0;
        for (Preferential preferential : prefers) {
            if(fullDiscount>=preferential.getNeedNumber()){
                discount=preferential.getDiscountNum();
                break;
            }
        }
        return discountPrice-discount;
    }

    @Override
    public Integer cancelOrderWithRefund(Map<String, Object> paramMap) {
        return orderMapper.cancelOrderWithRefund(paramMap);
    }

    @Override
    public List<SuperAdminOrder> getPCOrders(Map<String, Object> paramMap) {
        return orderMapper.getPCOrdersNew(paramMap);
    }

    @Override
    public int updateCancelRefund(Map<String, Object> paramMap) {
        return orderMapper.updateCancelRefund(paramMap);
    }

    @Override
    public String getChargeId(Map<String, Object> paramMap) {
        // 获取支付的chargeId
        return orderMapper.getChargeId(paramMap);
    }

    @Override
    public Integer updateRefundStatus(Map<String, Object> paramMap) {
        return orderMapper.updateRefundStatus(paramMap);
    }

    /**
     * 退款完成时将状态置为11
     * @param paramMap
     * @return
     */
    @Override
    public Integer updateOrderStatusRefundSuccess(Map<String, Object> paramMap) {
        return orderMapper.updateorderStatusRefundSuccess(paramMap);
    }

    @Override
    public Integer getMiniOrderByPhone(Map<String, Object> paramMap) {
        return orderMapper.getMiniOrderByPhone(paramMap);
    }

    @Override
    public Integer getSalesInfoByCampusId(Map<String, Object> paramMap) {
        return orderMapper.getSalesInfoByCampusId(paramMap);
    }

    @Override
    public Float getTradeVolumeByCampusId(Map<String, Object> paramMap) {
        return orderMapper.getTradeVolumeByCampusId(paramMap);
    }

    @Override
    public List<PCOrder> getPCSimpleOrders(Map<String, Object> paramMap) {
        return orderMapper.getPCSimpleOrders(paramMap);
    }

    @Override
    public long getPCSimpleOrdersCount(Map<String, Object> paramMap) {
        return orderMapper.getPCSimpleOrdersCount(paramMap);
    }

    @Override
    public List<SuperAdminOrder> getPCInvalidOrders(Map<String, Object> paramMap) {
        return orderMapper.getPCInvalidOrders(paramMap);
    }

    @Override
    public int deleteOrderTrue(Map<String, Object> paramMap) {
        return orderMapper.deleteOrderTrue(paramMap);
    }

    @Override
    public void deleteStatus7Order(String phone) {
        orderMapper.deleteStatus7Order(phone);
    }

    @Override
    public List<Order> getAllOrdersByTogetherId(String orderNo) {
        return orderMapper.getAllOrderByTogetherId(orderNo);
    }

}
