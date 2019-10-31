package org.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.supermarket.pojo.ListModel.Level;
import org.supermarket.pojo.TbCustomer;
import org.supermarket.serviceImpl.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/tocustomer")
    public String toCustomer(Model model){
        List<TbCustomer> list = customerService.selectAll();
        model.addAttribute("customer",list);
        return "customer";
    }

    @GetMapping("/addpage")
    public String toAdd(Model model){
        model.addAttribute("level",levelList());
        return "editCustomer";
    }

    @PostMapping("/addcustomer")
    public String addCustomer(TbCustomer customer){
        customerService.insertCustomer(customer);
        return "redirect:/customer/tocustomer";
    }
    @PutMapping("/addcustomer")
    public String updateCustomer(TbCustomer customer){
        customerService.updateCustomer(customer);
        return "redirect:/customer/tocustomer";
    }

    @GetMapping("/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model){
        TbCustomer customer = customerService.selectCustomerById(id);
        model.addAttribute("customer",customer);
        model.addAttribute("level",levelList());
        return "editCustomer";
    }

    private List<Level> levelList(){
        List<Level> list = new ArrayList<>();
        list.add(new Level("Lv1"));
        list.add(new Level("Lv2"));
        list.add(new Level("Lv3"));
        list.add(new Level("Lv4"));
        list.add(new Level("Lv5"));
        list.add(new Level("Lv6"));
        list.add(new Level("Lv7"));
        list.add(new Level("Lv8☆"));
        return list;
    }
}
