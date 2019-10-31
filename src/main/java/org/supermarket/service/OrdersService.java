package org.supermarket.service;

import org.apache.ibatis.annotations.Select;
import org.supermarket.pojo.TbOrders;

import java.util.List;

public interface OrdersService {
    public List<TbOrders> selectAll();

    public void updateOrders(TbOrders orders);

    public void insertOrders(TbOrders orders);

    public TbOrders selectOrdersById(Integer id);

    public void deleteOrdersById(Integer id);

    public List<TbOrders> selectForWeek();

    public List<TbOrders> selectLastWeek();
}
