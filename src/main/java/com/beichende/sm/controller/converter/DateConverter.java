/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename DateConverter.java
 * @time 2018年7月22日 上午10:40:47
 * @copyright(C) 2018 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 *<简述功能>
 *<功能详细描述>
 * @see
 * @since
 */
public class DateConverter implements Converter<String, Date>{

	public Date convert(String source) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
