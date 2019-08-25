/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename IUserService.java
 * @time 2018年7月20日 下午11:07:39
 * @copyright(C) 2018 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.service;

import java.util.List;

import com.beichende.sm.pojo.MUser;
import com.beichende.sm.pojo.MUserVo;

/**
 *<简述功能>
 *<功能详细描述>
 * @see
 * @since
 */
public interface IUserService {
	//通过动态Sql去查询
	public List<MUser> findUser(MUser user) throws Exception;
	//通过userNo查询用户
	public MUser findUserByUserNo(int userNo) throws Exception;
	//修改
	public void updateUser(MUser user) throws Exception;
	//批量删除
	public void deleteUserByManyUserNo(MUserVo muserVo) throws Exception;
	//增加
	public void insertUser(MUser user) throws Exception;
	//批量增加
	public void insertManyUser(MUserVo muserVo) throws Exception;
}
