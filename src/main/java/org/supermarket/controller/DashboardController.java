package org.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.supermarket.pojo.DateModel.Week;
import org.supermarket.pojo.TbOrders;
import org.supermarket.serviceImpl.OrdersServiceImpl;
import org.supermarket.utils.DateUtils;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private OrdersServiceImpl ordersService;
    @GetMapping("/todashboard")
    public String toDashboard(){
        return "dashboard";
    }

    @ResponseBody
    @GetMapping("/weeksales")
    public Week getWeekSales() throws Exception {
        //查询本周订单集合
        List<TbOrders> orders = ordersService.selectForWeek();
        Week week = new Week();
        if(orders!=null) {
            for (TbOrders order : orders) {
                int i = DateUtils.dayForWeek(order.getCreatetime());
                if (i == 1) {
                    week.setMonday(week.getMonday() + order.getTotalPrice());
                } else if (i == 2) {
                    week.setTuesday(week.getTuesday() + order.getTotalPrice());
                } else if (i == 3) {
                    week.setWednesday(week.getWednesday() + order.getTotalPrice());
                } else if (i == 4) {
                    week.setThursday(week.getThursday() + order.getTotalPrice());
                } else if (i == 5) {
                    week.setFriday(week.getFriday()+order.getTotalPrice());
                } else if (i == 6) {
                    week.setSaturday(week.getSaturday() + order.getTotalPrice());
                } else {
                    week.setSunday(week.getSunday() + order.getTotalPrice());
                }
            }
        }
        return week;
    }

    //查询上周数据
    @ResponseBody
    @GetMapping("/lastweeksales")
    public Week getLastWeekSales() throws Exception {
        List<TbOrders> orders =ordersService.selectLastWeek();
        Week week = new Week();
        if(orders!=null) {
            for (TbOrders order : orders) {
                int i = DateUtils.dayForWeek(order.getCreatetime());
                if (i == 1) {
                    week.setMonday(week.getMonday() + order.getTotalPrice());
                } else if (i == 2) {
                    week.setTuesday(week.getTuesday() + order.getTotalPrice());
                } else if (i == 3) {
                    week.setWednesday(week.getWednesday() + order.getTotalPrice());
                } else if (i == 4) {
                    week.setThursday(week.getThursday() + order.getTotalPrice());
                } else if (i == 5) {
                    week.setFriday(week.getFriday()+order.getTotalPrice());
                } else if (i == 6) {
                    week.setSaturday(week.getSaturday() + order.getTotalPrice());
                } else {
                    week.setSunday(week.getSunday() + order.getTotalPrice());
                }
            }
        }
        return week;
    }
}
