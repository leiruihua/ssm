/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename UserController.java
 * @time 2018年7月15日 下午3:37:17
 * @copyright(C) 2018 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;




import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.beichende.sm.pojo.MUser;
import com.beichende.sm.pojo.MUserVo;
import com.beichende.sm.service.IUserService;


/**
 *<简述功能>
 *<功能详细描述>
 *			注:这个controller可以设置成单例，因为springMVC通过url和controller方法进行映射，映射成功后
 *				springMVC生成一个Handler对象，对象中只包括了一个method，方法执行结束，形参数据销毁	
 *				
 * @see
 * @since
 */

@Controller
@RequestMapping("/user")//窄化请求映射，比如执行queryUser3()方法,前台请求就是${path}/user/queryUser3
public class UserController3{
	
	@Resource
	private IUserService iUserService;
	
	/**
	 * 根据条件查询用户
	 */
	@RequestMapping("/queryUser3")
	public String queryUser3(Model model,MUser muser) throws Exception{//返回字符串的形式
		List<MUser> list = iUserService.findUser(muser);
		//将model里的数据填充到request域
		model.addAttribute("list",list);
		System.out.println("queryUser3");
		//向前台传递数据，前台通过el表达式获取
		ModelMap modelMap = new ModelMap();
		modelMap.put("李白", "大河之剑天上来");
		return "/index";//返回类型为String的方式
	}
	
	/**
	 * 根据序号查询用户
	 * @RequestMapping
	 * 	value:指定action请求为/queryUser4
	 * 	method:限制http的请求只支持post和get请求
	 */
	@RequestMapping(value="/queryUser4",method={RequestMethod.POST,RequestMethod.GET })
	public String queryUser4(Model model,MUserVo muserVo) throws Exception{
		List<MUser> list = iUserService.findUser(null);
		MUser muser =  iUserService.findUserByUserNo(muserVo.getMuser().getUserNo());
		model.addAttribute("list",list);
		model.addAttribute("user",muser);
		System.out.println("queryUser4");
		return "/index";
	}
	
	/**
	 * 修改用户
	 * @ModelAttribute
	 * 	value:设定此参数放入request域中的key(名称),可以在前台取其值
	 * 		  注:springmvc会默认把前台传过来的pojo数据(不支持简单类型)放入request域中，key等于pojo类型(首字母小写)
	 * @RequestParam
	 * 	value:指定前台参数的命名为 nowDate
	 * 	required:表示是否必传，默认为true必传
	 * 	defaultValue:表示默认值
	 */
	@RequestMapping("/updateUser")
	public String updateUser(Model model,
			@ModelAttribute(value="user")MUser user,
			@RequestParam(value="nowDate",required=true,defaultValue="")Date date) throws Exception{//pojo类型里的属性名要跟前台传过来参数名保持一致
		iUserService.updateUser(user);
		List<MUser> list = iUserService.findUser(null);
		model.addAttribute("list",list);
		System.out.println("updateUser");
		System.out.println(date);
		return "/index";
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping("/deleteUserByManyUserNo")
	public String deleteUserByManyUserNo(Model model,MUserVo muserVo) throws Exception{
		iUserService.deleteUserByManyUserNo(muserVo);
		List<MUser> list = iUserService.findUser(null);
		model.addAttribute("list",list);
		System.out.println("deleteManyUser");
		return "/index";
	}
	
	/**
	 * 增加单个用户
	 */
	@RequestMapping("/insertUser")
	public String insertUser(Model model,MUser user) throws Exception{
		iUserService.insertUser(user);
		List<MUser> list = iUserService.findUser(null);
		model.addAttribute("list",list);
		System.out.println("insertUser");
		return "/index";
	}
	
	/**
	 * 增加多个用户
	 */
	@RequestMapping("/insertManyUser")
	public String insertManyUser(Model model,MUserVo muserVo) throws Exception{
		iUserService.insertManyUser(muserVo);
		model.addAttribute("muserList",muserVo.getMuserList());
		List<MUser> list = iUserService.findUser(null);
		model.addAttribute("list",list);
		System.out.println("insertManyUser");
		return "/index";
	}
	/**
	 * 文件上传
	 * 1.MultipartFile是个接口，必须加@RequestParam，不然绑定请求参数的时候会把这个当作类去初始化，会抛异常
	 */
	@RequestMapping("/fileUpload")
	public String fileUpload(Model model,@RequestParam("file")MultipartFile file) throws Exception{

		if(file != null){
			//获取上传图片的原始文件名称(例如:xx.jpg)
			String fileName = file.getOriginalFilename();
			// 获取文件的名称后缀
			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
			if(fileName.length() > 0){
				//存储新图片的物理路径
				String filePath = "E:"+File.separator+"apache-tomcat-7.0.32-windows-x64"+File.separator+"image"+File.separator;
				//新的图片名称
				String newFileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
				//生成新图片
				File newFile = new java.io.File(filePath+newFileName);
				//将内存中的数据写到磁盘
				file.transferTo(newFile);
				//把生成的图片名称返回前台
				model.addAttribute("imageURL",newFileName);
				System.out.println("fileUpload");
			}
		}
		List<MUser> list = iUserService.findUser(null);
		model.addAttribute("list",list);
		return "/index";
	}

	// 导入文件
	@RequestMapping("/importFile")
	public String importFile(Model model,@RequestParam("file")MultipartFile file) throws Exception{
		MUserVo mUserVo = new MUserVo();
		//获取上传图片的原始文件名称(例如:xx.jpg)
		String fileName = file.getOriginalFilename();
		// 获取文件的名称后缀
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		// 工作簿
		Workbook workbook = null;
		if ("xls".equals(suffix.toUpperCase())) {// 2003及以前的excle
			// 数据超过65536会内存溢出
			workbook = new HSSFWorkbook(file.getInputStream());

		}else if ("xlsx".equals(suffix.toLowerCase())) {//2007及以后的excel
			// 数据超过65536行会内存溢出
			// workbook = new XSSFWorkbook(file.getInputStream());

			// 数据超过65536行不会内存溢出，会将超出的数据写到硬盘
			workbook = new SXSSFWorkbook(new XSSFWorkbook(file.getInputStream()));
		}
		// 获取工作簿中的 sheet 总数
		int sheetNum = workbook.getNumberOfSheets();
		// 遍历 sheet
		for (int i = 0; i < sheetNum; i++) {
			// 获取 单个 sheet对象
			Sheet sheet = workbook.getSheetAt(i);
			// 获取总行数
			int rowNum = sheet.getLastRowNum();
			// 获取第一行
			Row firstRow =  sheet.getRow(0);
			// 获取总列数
			int columnNum = firstRow.getLastCellNum();
			// 从第二行开始遍历
			for (int j = 1; j < rowNum; j++) {
				Row row =  sheet.getRow(j);
				List<String> list = new ArrayList<String>();
				// 遍历每一列
				for (int k = 0; k < columnNum; k++) {
					Cell cell = row.getCell(k);
					list.add(cell.getStringCellValue().trim());
				}
				MUser muser = new MUser();
				muser.setUserName(list.get(0));
				muser.setUserSex(Integer.parseInt(list.get(1)));
				muser.setUserAge(Integer.parseInt(list.get(2)));
				muser.setUserPhone(list.get(3));
				muser.setUserQQ(list.get(4));
				mUserVo.getMuserList().add(muser);
			}

		}
		iUserService.insertManyUser(mUserVo);
		List<MUser> list = iUserService.findUser(null);
		model.addAttribute("list",list);
		return "/index";
	}
	
	/**
	 * Json数据交互
	 * 1.通过@RequestBody将json串解析成java对象，
	 * 2.通过@ResponseBody将java对象解析成json串
	 */
	@RequestMapping("/requestJson")
	public @ResponseBody MUser requestJson(@RequestBody MUser user){
		System.out.println("requestJson");
		return user;
	}
	/**
	 * Json数据交互
	 * 1.通过key-value的形式直接解析成java对象
	 * 2.通过@ResponseBody将java对象解析成json串
	 */
	@RequestMapping("/requestKeyValue")
	public @ResponseBody MUser requestKeyValue(MUser user){
		System.out.println("requestKeyValue");
		return user;
	}
	
	/**
	 * restful的支持
	 */
	@RequestMapping("/restful/{id}")
	public String  restful(Model model,@PathVariable("id") Integer userNo) throws Exception{
		List<MUser> list = iUserService.findUser(null);
		model.addAttribute("list",list);
		System.out.println("restful["+userNo+"]");
		return "/index";
	}
	
	/**
	 * 	登陆
	 */
	@RequestMapping("/login")
	public String login(HttpSession session,String userName,String password){
		session.setAttribute("userName", userName);
		return "/index";
	}
}
