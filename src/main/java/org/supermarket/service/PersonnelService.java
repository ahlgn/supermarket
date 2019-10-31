package org.supermarket.service;

import org.supermarket.pojo.*;

import java.util.List;

public interface PersonnelService {
    public List<TbPersonnel> selectAll();
    public TbPersonnel getPersonnelById(Integer id);
    public void updatePersonnel(TbPersonnel personnel);
    public void insertPersonnel(TbPersonnel personnel);
    public void deletePersonnel(Integer id);
    public TbPersonnel selectPersonnelByName(String name);
}
