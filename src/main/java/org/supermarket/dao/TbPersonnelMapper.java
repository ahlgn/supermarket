package org.supermarket.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.supermarket.pojo.TbPersonnel;
import org.supermarket.pojo.TbPersonnelExample;

public interface TbPersonnelMapper {
    int countByExample(TbPersonnelExample example);

    int deleteByExample(TbPersonnelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPersonnel record);

    int insertSelective(TbPersonnel record);

    List<TbPersonnel> selectByExample(TbPersonnelExample example);

    TbPersonnel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPersonnel record, @Param("example") TbPersonnelExample example);

    int updateByExample(@Param("record") TbPersonnel record, @Param("example") TbPersonnelExample example);

    int updateByPrimaryKeySelective(TbPersonnel record);

    int updateByPrimaryKey(TbPersonnel record);
}