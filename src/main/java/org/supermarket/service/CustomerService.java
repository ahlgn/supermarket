package org.supermarket.service;


import org.supermarket.pojo.*;

import java.util.List;

public interface CustomerService {
    public List<TbCustomer> selectAll();

    public void updateCustomer(TbCustomer customer);

    public void insertCustomer(TbCustomer customer);

    public TbCustomer selectCustomerById(Integer id);

    public void deleteCustomerById(Integer id);
}
