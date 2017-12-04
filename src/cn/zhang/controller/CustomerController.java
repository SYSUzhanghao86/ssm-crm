package cn.zhang.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhang.common.utils.Page;
import cn.zhang.pojo.BaseDict;
import cn.zhang.pojo.Customer;
import cn.zhang.pojo.QueryVo;
import cn.zhang.service.BaseDictService;
import cn.zhang.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	//注解在成员变量上
    @Value("${fromType.code}")
    private String fromTypeCode;
	
	//入口
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo,Model model){
		
		List<BaseDict> fromType=baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType=baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType=baseDictService.selectBaseDictListByCode("006");
		
		//数据绑定,将数据嵌入到jsp页面
		model.addAttribute("levelType",levelType);
		model.addAttribute("fromType",fromType);
		model.addAttribute("industryType",industryType);
		
		//通过四个条件  查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	//修改客户信息入口
	//采用ajax
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody Customer edit(Integer id){
		Customer customer=customerService.selectCustomerById(id);
		return customer;
	}
	
	//修改客户信息入口
	//采用ajax
	@RequestMapping(value="/customer/update.action")
	public @ResponseBody String update(Customer customer){
		customerService.updateCustomerById(customer);
		return "OK";
	}
	
	//修改客户信息入口
	//采用ajax
	@RequestMapping(value="/customer/delete.action")
	public @ResponseBody String delete(Integer id){
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
