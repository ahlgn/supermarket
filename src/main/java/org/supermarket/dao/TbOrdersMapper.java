package org.supermarket.dao;

import org.apache.ibatis.annotations.Param;
import org.supermarket.pojo.TbOrders;
import org.supermarket.pojo.TbOrdersExample;

import java.util.List;

public interface TbOrdersMapper {
    int countByExample(TbOrdersExample example);

    int deleteByExample(TbOrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbOrders record);

    int insertSelective(TbOrders record);

    List<TbOrders> selectByExample(TbOrdersExample example);

    TbOrders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbOrders record, @Param("example") TbOrdersExample example);

    int updateByExample(@Param("record") TbOrders record, @Param("example") TbOrdersExample example);

    int updateByPrimaryKeySelective(TbOrders record);

    int updateByPrimaryKey(TbOrders record);

    List<TbOrders> selectByThisWeek();

    List<TbOrders> selectByLastWeek();
}