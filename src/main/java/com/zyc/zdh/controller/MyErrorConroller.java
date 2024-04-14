package com.zyc.zdh.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zyc.zdh.annotation.White;
import com.zyc.zdh.entity.RETURN_CODE;
import com.zyc.zdh.entity.ReturnInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Map;

/**
 * 异常页面服务
 * @author zyc-admin
 * @date 2018年3月2日  
 * @Description: TODO  
 */
@Controller
public class MyErrorConroller {

	/**
	 * 404页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/404")
	@White
	public String  error(HttpServletRequest request){
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		for(Map.Entry<String, String[]> m:parameterMap.entrySet()){
			System.out.println(m.getKey()+"==="+Arrays.toString(m.getValue()));
		}
		return "404";
	}

	/**
	 * 403页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/403")
	@White
	public String  permission(HttpServletRequest request){
		Map<String, String[]> parameterMap = request.getParameterMap();

		return "403";
	}

	/**
	 * 503页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/503")
	@White
	public String  manager(HttpServletRequest request){
		return "503";
	}

	@ResponseBody
	public ReturnInfo handleReturn(@NotNull BlockException e){
		Exception ex = new Exception("Sentinel Error");
		return ReturnInfo.build(RETURN_CODE.FAIL.getCode(), "查询失败", ex);
	}

	public String handleString(BlockException e){
		return "403";
	}
}
