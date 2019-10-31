package org.supermarket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supermarket.dao.*;
import org.supermarket.pojo.*;
import org.supermarket.service.PersonnelService;

import java.util.List;
@Service
public class PersonnelServiceImpl implements PersonnelService {
    @Autowired
    private TbPersonnelMapper personnelMapper;
    @Override
    public List<TbPersonnel> selectAll() {
        TbPersonnelExample example = new TbPersonnelExample();
        TbPersonnelExample.Criteria criteria = example.createCriteria();
        criteria.andIdGreaterThanOrEqualTo(0);
        List<TbPersonnel> list = personnelMapper.selectByExample(example);
        return list;
    }

    @Override
    public TbPersonnel getPersonnelById(Integer id) {
        TbPersonnel personnel = personnelMapper.selectByPrimaryKey(id);
        return personnel;
    }

    @Override
    public void updatePersonnel(TbPersonnel personnel) {
        personnelMapper.updateByPrimaryKey(personnel);
    }

    @Override
    public void insertPersonnel(TbPersonnel personnel) {
        personnelMapper.insert(personnel);
    }

    @Override
    public void deletePersonnel(Integer id) {
        personnelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TbPersonnel selectPersonnelByName(String name) {
        TbPersonnelExample example = new TbPersonnelExample();
        TbPersonnelExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<TbPersonnel> personnels = personnelMapper.selectByExample(example);
        return personnels.get(0);
    }
}
