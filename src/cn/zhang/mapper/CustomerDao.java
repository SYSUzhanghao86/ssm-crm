package cn.zhang.mapper;

import java.util.List;

import cn.zhang.pojo.Customer;
import cn.zhang.pojo.QueryVo;

public interface CustomerDao {

	
	//总条数
	public Integer customerCountByQueryVo(QueryVo vo);
	//结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	//通过ID查询客户
	public Customer selectCustomerById(Integer id);
	//修改客户通过ID
	public void updateCustomerById(Customer customer);
	
	//通过ID 删除客户
	public void deleteCustomerById(Integer id);
	
}
