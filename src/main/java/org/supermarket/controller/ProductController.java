package org.supermarket.controller;


import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.supermarket.pojo.*;
import org.supermarket.serviceImpl.ProductServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    //跳转product商品库存页面
    @GetMapping("/toproduct")
    public String toProduct(Model model) {
        List<TbProduct> productList=productService.selectAll();
        model.addAttribute("product",productList);
        return "product";
    }

    /**
     * 添加商品库存信息
     * 跳转至添加页面,与编辑共用一个页面
     * @return
     */
    @GetMapping("/addpage")
    public String toEdit(){
        return "editProduct";
    }

    /**
     * 编辑商品库存信息
     * 跳转至编辑页面,与添加商品页面公用一个页面
     */
    @GetMapping("/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model){
        TbProduct product= productService.selectProductById(id);
        model.addAttribute("product",product);
        return "editProduct";
    }

    /**
     * 编辑商品功能 只修改商品库存信息
     *
     */
    @PutMapping("/addproduct")
    public String updateProduct(TbProduct product){
        productService.updateProduct(product);
        return "redirect:/product/toproduct";
    }

    /**
     * 添加商品功能
     * 只能添加商品库存信息
     */

    @PostMapping("/addproduct")
    public String addProduct(TbProduct product){
        productService.insertProduct(product);
        return "redirect:/product/toproduct";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProductById(id);
        return "redirect:/product/toproduct";
    }

}
