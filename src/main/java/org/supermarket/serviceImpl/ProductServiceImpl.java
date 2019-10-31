package org.supermarket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supermarket.service.ProductService;
import org.supermarket.dao.*;
import org.supermarket.pojo.*;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private TbProductMapper productMapper;
    @Override
    public List<TbProduct> selectAll() {

        List<TbProduct> list = productMapper.selectByExample(new TbProductExample());
        return list;
    }

    @Override
    public void updateProduct(TbProduct product) {
        productMapper.updateByPrimaryKey(product);
    }

    @Override
    public void insertProduct(TbProduct product) {
        productMapper.insert(product);
    }

    @Override
    public TbProduct selectProductById(Integer id) {
        TbProduct product= productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public void deleteProductById(Integer id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TbProduct> selectProductByProductName(TbProduct product) {
        TbProductExample example = new TbProductExample();
        TbProductExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(product.getName());
        List<TbProduct> products = productMapper.selectByExample(example);
        return  products ;
    }

    @Override
    public TbProduct selectProductByProductName(String product) {
        TbProductExample example = new TbProductExample();
        TbProductExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(product);
        List<TbProduct> products = productMapper.selectByExample(example);
        return products.get(0);
    }
}
