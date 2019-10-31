package org.supermarket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supermarket.dao.TbOrdersMapper;
import org.supermarket.pojo.TbOrders;
import org.supermarket.pojo.TbOrdersExample;
import org.supermarket.service.OrdersService;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private TbOrdersMapper ordersMapper;
    @Override
    public List<TbOrders> selectAll() {
        List<TbOrders> list = ordersMapper.selectByExample(new TbOrdersExample());
        return list;
    }

    @Override
    public void updateOrders(TbOrders orders) {
        ordersMapper.updateByPrimaryKey(orders);
    }

    @Override
    public void insertOrders(TbOrders orders) {
        ordersMapper.insert(orders);
    }

    @Override
    public TbOrders selectOrdersById(Integer id) {
        TbOrders orders = ordersMapper.selectByPrimaryKey(id);
        return orders;
    }

    @Override
    public void deleteOrdersById(Integer id) {
        ordersMapper.deleteByPrimaryKey(id);
    }


    @Override
    public List<TbOrders> selectForWeek() {
        List<TbOrders> orders = ordersMapper.selectByThisWeek();
        return orders;
    }

    @Override
    public List<TbOrders> selectLastWeek() {
        List<TbOrders> orders = ordersMapper.selectByLastWeek();
        return orders;
    }


}
