/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename MUserVo.java
 * @time 2018年7月22日 下午2:33:39
 * @copyright(C) 2018 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.pojo;

import java.util.List;
import java.util.Map;

/**
 *<简述功能>
 *<功能详细描述>
 * @see
 * @since
 */
public class MUserVo {
	private MUser muser;		 //pojo对象 	 name="muser.userName"
	private String[] userNoArray;//string数组   name="userNoArray"
	private List<MUser> muserList;//list列表  name="muserList[0].userName"
	private Map<String,Object> map;//map集合 name="map['pageCount']"
	
	public MUser getMuser() {
		return muser;
	}

	public void setMuser(MUser muser) {
		this.muser = muser;
	}

	public String[] getUserNoArray() {
		return userNoArray;
	}

	public void setUserNoArray(String[] userNoArray) {
		this.userNoArray = userNoArray;
	}

	public List<MUser> getMuserList() {
		return muserList;
	}

	public void setMuserList(List<MUser> muserList) {
		this.muserList = muserList;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
}
