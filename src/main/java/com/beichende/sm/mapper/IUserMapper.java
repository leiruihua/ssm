/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename ITestMybatisQuery.java
 * @time 2018年6月29日 下午7:32:30
 * @copyright(C) 2018 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.mapper;
import java.util.List;

import org.springframework.stereotype.Component;

import com.beichende.sm.pojo.MUser;
import com.beichende.sm.pojo.MUserVo;
/**
 *<简述功能> mybatis的mapper代理接口
 *<功能详细描述>
 * @see
 * @since
 */
@Component
public interface IUserMapper {
	//通过动态Sql去查询
	List<MUser> findUser(MUser user) throws Exception;
	//通过userNo查询用户
	MUser findUserByUserNo(int userNo) throws Exception;
	//修改
	void updateUser(MUser user) throws Exception;
	//批量删除
	void deleteUserByManyUserNo(MUserVo muserVo) throws Exception;
	//增加
	void insertUser(MUser user) throws Exception;
	//批量增加
	void insertManyUser(MUserVo muserVo) throws Exception;
}
