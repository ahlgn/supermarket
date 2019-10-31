package org.supermarket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supermarket.dao.TbCustomerMapper;
import org.supermarket.pojo.TbCustomer;
import org.supermarket.pojo.TbCustomerExample;
import org.supermarket.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private TbCustomerMapper customerMapper;
    @Override
    public List<TbCustomer> selectAll() {

        List<TbCustomer> list = customerMapper.selectByExample(new TbCustomerExample());
        return list;
    }

    @Override
    public void updateCustomer(TbCustomer customer) {
        customerMapper.updateByPrimaryKey(customer);
    }

    @Override
    public void insertCustomer(TbCustomer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public TbCustomer selectCustomerById(Integer id) {
        TbCustomer customer= customerMapper.selectByPrimaryKey(id);
        return customer;
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerMapper.deleteByPrimaryKey(id);
    }
}
