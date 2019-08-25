/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename UserServiceImpl.java
 * @time 2018年7月20日 下午11:11:06
 * @copyright(C) 2018 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beichende.sm.mapper.IUserMapper;
import com.beichende.sm.pojo.MUser;
import com.beichende.sm.pojo.MUserVo;
import com.beichende.sm.service.IUserService;

/**
 *<简述功能>
 *<功能详细描述>
 * @see
 * @since
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserMapper iUserMapper;

	
	public List<MUser> findUser(MUser user) throws Exception{
		List<MUser> list = iUserMapper.findUser(user);
		return list;
	}

	
	public MUser findUserByUserNo(int userNo) throws Exception{
		MUser user = iUserMapper.findUserByUserNo(userNo);
		return user;
	}

	
	public void updateUser(MUser user) throws Exception{
		iUserMapper.updateUser(user);
	}
	
	
	public void deleteUserByManyUserNo(MUserVo muserVo) throws Exception{
		iUserMapper.deleteUserByManyUserNo(muserVo);
	}	
	
	
	public void insertUser(MUser user) throws Exception{
		iUserMapper.insertUser(user);
	}

	public void insertManyUser(MUserVo muserVo) throws Exception{
		iUserMapper.insertManyUser(muserVo);	
	}
}
