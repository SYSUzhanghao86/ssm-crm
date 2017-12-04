package cn.zhang.mapper;

import java.util.List;

import cn.zhang.pojo.BaseDict;

public interface BaseDictDao {

	
	//查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
