/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename HUser.java
 * @time 2017年8月12日 下午10:20:49
 * @copyright(C) 2017 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.pojo;

/**
 *<简述功能>
 *<功能详细描述>
 * @see
 * @since
 */
public class MUser{

	private Integer userNo; 	//序号
	private String userName;	//姓名
	private Integer userSex;	//性别
	private Integer userAge;	//年龄
	private String userPhone;	//手机号码
	private String userQQ;		//QQ号
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserQQ() {
		return userQQ;
	}
	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}
}

