package org.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.supermarket.pojo.*;
import org.supermarket.pojo.ListModel.Department;
import org.supermarket.serviceImpl.PersonnelServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/personnel")
public class PersonnelController {

    @Autowired
    private PersonnelServiceImpl personnelService;


    @RequestMapping("/tolist")
    public String toList(Model model){
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>tolist");
        List<TbPersonnel> list = personnelService.selectAll();
        model.addAttribute("items",list);
        return "list";
    }

    /**
     * 修改人员信息 跳转修改页面 与添加共用一个页面
     */
    @GetMapping("/{id}")
    public String toEditPersonnel(@PathVariable("id") Integer id,Model model){
        TbPersonnel personnel=personnelService.getPersonnelById(id);
        model.addAttribute("personnel",personnel);

        model.addAttribute("department",departmentList());
        return "add";
    }
    @PutMapping("/addpersonnel")
    public String editPersonnel(TbPersonnel personnel){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>正在修改"+personnel.getName()+"的员工数据");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>姓名"+personnel.getName());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>职位"+personnel.getPosition());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>联系"+personnel.getPhone());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>销售额"+personnel.getSales());
        personnelService.updatePersonnel(personnel);
        return "redirect:/personnel/tolist";
    }

    /**
     * 跳转add页面添加人员名单
     * @return
     */
    @GetMapping("/addpage")
    public String toAdd(Model model){
        model.addAttribute("department",departmentList());
        return "add";
    }

    @PostMapping("/addpersonnel")
    public String addPersonnel(TbPersonnel personnel){
        personnelService.insertPersonnel(personnel);
        return "redirect:/personnel/tolist";
    }

    @GetMapping("/delete/{id}")
    public String deletePersonnel(@PathVariable("id") Integer id){
        personnelService.deletePersonnel(id);
        return "redirect:/personnel/tolist";
    }

    private List<Department> departmentList(){
        List<Department> department =new ArrayList<>();
        department.add(new Department("销售总监"));
        department.add(new Department("销售主管"));
        department.add(new Department("销售经理"));
        department.add(new Department("金牌销售"));
        department.add(new Department("银牌销售"));
        department.add(new Department("铜牌销售"));
        //("销售总监","营销主管","销售经理","金牌销售","银牌销售","铜牌销售")
        return department;
    }
}
