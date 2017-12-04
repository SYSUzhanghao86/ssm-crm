package cn.zhang.service;

import java.util.List;

import cn.zhang.pojo.BaseDict;

public interface BaseDictService {

	
	//查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
