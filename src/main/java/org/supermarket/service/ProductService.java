package org.supermarket.service;



import org.supermarket.pojo.*;

import java.util.List;

public interface ProductService {
    public List<TbProduct> selectAll();

    public void updateProduct(TbProduct product);

    public void insertProduct(TbProduct product);

    public TbProduct selectProductById(Integer id);

    public void deleteProductById(Integer id);

    public List<TbProduct> selectProductByProductName(TbProduct product);
    public TbProduct selectProductByProductName(String product);

}
