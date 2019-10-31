package org.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.supermarket.pojo.TbCustomer;
import org.supermarket.pojo.TbOrders;
import org.supermarket.pojo.TbPersonnel;
import org.supermarket.pojo.TbProduct;
import org.supermarket.serviceImpl.CustomerServiceImpl;
import org.supermarket.serviceImpl.OrdersServiceImpl;
import org.supermarket.serviceImpl.PersonnelServiceImpl;
import org.supermarket.serviceImpl.ProductServiceImpl;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private PersonnelServiceImpl personnelService;
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private OrdersServiceImpl ordersService;
    @GetMapping("/toorders")
    public String toOrders(Model model){
        List<TbOrders> orders = ordersService.selectAll();
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/addpage")
    public String toAdd(Model model){
        setSelectOption(model);
        return "editOrders";
    }

    @GetMapping("/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model){
        TbOrders orders = ordersService.selectOrdersById(id);
        setSelectOption(model);
        model.addAttribute("orders",orders);
        return "editOrders";
    }
    @PutMapping("/addorders")
    public String updateOrders(TbOrders orders){
   /*
            PS:!!!! 先通过该订单的订单号查询到原先数据库中交易总价和交易数量(否则数据异常)
            1.获取订单中总价和经办人名称.获得订单物品数量
            2.获取该订单经办人的销售额
            3.原本销售额+订单的总价 重新写入 销售人员表
            4. 获得商品库存剩余 修改商品库存剩余 减去订单中货品数量
                   */
        TbOrders order = ordersService.selectOrdersById(orders.getId());
        Double oldTotalPrice = order.getTotalPrice();
        Integer oldStock = order.getProductNum();
        //----------------------------------------------------
        Double totalPrice = orders.getTotalPrice();
        String personnename = orders.getPersonnelName();
        Integer num = orders.getProductNum();
        String productname=orders.getProductName();
            //------
        TbPersonnel personnel = personnelService.selectPersonnelByName(personnename);
        Double sales = personnel.getSales();
        //--------------------------------
        personnel.setSales((sales-oldTotalPrice)+totalPrice);
        personnelService.updatePersonnel(personnel);
        //-------------------------------------
        TbProduct product = productService.selectProductByProductName(productname);
        Integer stock = product.getStock();
        product.setStock((stock+oldStock)-num);
        productService.updateProduct(product);
        //---------------------------------
        ordersService.updateOrders(orders);
            return "redirect:/orders/toorders";
    }
    @PostMapping("/addorders")
    public String addOrders(TbOrders orders){
        /*
            1.获取订单中总价和经办人名称
            2.获取该订单经办人的销售额
            3.原本销售额+订单的总价 重新写入 销售人员表
            4.获得商品库存剩余
            5.修改商品库存剩余 减去订单中货品数量

                   */
        //------
        TbPersonnel personnel = personnelService.selectPersonnelByName(orders.getPersonnelName());
        personnel.setSales(personnel.getSales()+orders.getTotalPrice());
        personnelService.updatePersonnel(personnel);
        //-------------------------------------
        TbProduct product = productService.selectProductByProductName(orders.getProductName());
        product.setStock(product.getStock()-orders.getProductNum());
        productService.updateProduct(product);

        orders.setCreatetime(new Date());
        ordersService.insertOrders(orders);
        return "redirect:/orders/toorders";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrders(@PathVariable("id") Integer id){
        /*

            PS:!!!! 先通过该订单的订单号查询到原先数据库中交易总价和交易数量(否则数据异常)
            1.获取订单中总价和经办人名称.获得订单物品数量
            2.获取该订单经办人的销售额
            3.原本销售额-订单的总价 重新写入 销售人员表
            4. 获得商品库存剩余 修改商品库存剩余 加上订单中货品数量
         */

        TbOrders order = ordersService.selectOrdersById(id);

        TbPersonnel personnel = personnelService.selectPersonnelByName(order.getPersonnelName());
        personnel.setSales(personnel.getSales()-order.getTotalPrice());
        personnelService.updatePersonnel(personnel);

        TbProduct product= productService.selectProductByProductName(order.getProductName());
        product.setStock(product.getStock()+order.getProductNum());
        productService.updateProduct(product);

        ordersService.deleteOrdersById(id);
        return "redirect:/orders/toorders";
    }



    @ResponseBody
    @PostMapping("/getunitprice")
    public TbProduct getUnitPrice(@RequestBody TbProduct product){
        List<TbProduct> products = productService.selectProductByProductName(product);
        TbProduct productJson = products.get(0);
        System.out.println(productJson.getPrice());
        return productJson;
    }
    private void setSelectOption(Model model){
        List<TbPersonnel> personnel = personnelService.selectAll();
        List<TbProduct> product = productService.selectAll();
        List<TbCustomer> customer = customerService.selectAll();
        model.addAttribute("personnel",personnel);
        model.addAttribute("product",product);
        model.addAttribute("customer",customer);
    }
}
