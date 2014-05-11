package com.taotaoti.memmber.druc.constant;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

/**
 * @author leon
 *
 * 2013-12-5
 */
public class DrucConstant {

	public static final String UC_ROLE_SUPER_ADMIN	= "bao_super_admin";  //平台超级管理员
	public static final String UC_ROLE_EXPERT		= "bao_expert";  //专家
	public static final String UC_ROLE_MEMBER		= "bao_member";  //会员
	public static final String UC_ROLE_OPT_ADMIN		= "bao_opt_admin";  //运营管理员
	public static final String UC_ROLE_FINAN_ADMIN	= "bao_finan_admin";  //财务管理员
	public static final String UC_ROLE_SALE_ADMIN		= "bao_sale_admin";  //销售管理员
	public static final String UC_ROLE_VISITOR		= "bao_visitor";  //销售管理员
	
	
	public static final String UC_ROLE_SUPER_ADMIN_NAME	= "超级管理员";  //平台超级管理员
	public static final String UC_ROLE_EXPERT_NAME		= "专家主账号";  //专家
	public static final String UC_ROLE_MEMBER_NAME		= "会员";  //会员
	public static final String UC_ROLE_OPT_ADMIN_NAME		= "运营管理员";  //运营管理员
	public static final String UC_ROLE_FINAN_ADMIN_NAME	= "财务管理员";  //财务管理员
	public static final String UC_ROLE_SALE_ADMIN_NAME		= "销售管理员";  //销售管理员
	public static final String UC_ROLE_VISITOR_NAME		= "参观用户";  //参观用户
	public static final String UC_ROLE_UNKONWN_NAME		= "未知角色";  //未知角色
	
	public static String getRoleName(String[] roleArr){
		if(Arrays.asList(roleArr).contains(UC_ROLE_SUPER_ADMIN)){
			return UC_ROLE_SUPER_ADMIN_NAME;
		}else if(Arrays.asList(roleArr).contains(UC_ROLE_EXPERT)){
			return UC_ROLE_EXPERT_NAME;
		}else if(Arrays.asList(roleArr).contains(UC_ROLE_OPT_ADMIN)){
			return UC_ROLE_OPT_ADMIN_NAME;
		}else if(Arrays.asList(roleArr).contains(UC_ROLE_FINAN_ADMIN)){
			return UC_ROLE_FINAN_ADMIN_NAME;
		}else if(Arrays.asList(roleArr).contains(UC_ROLE_SALE_ADMIN)){
			return UC_ROLE_SALE_ADMIN_NAME;
		}else if(Arrays.asList(roleArr).contains(UC_ROLE_MEMBER)){
			return UC_ROLE_MEMBER_NAME;
		}else if(Arrays.asList(roleArr).contains(UC_ROLE_VISITOR)){
			return UC_ROLE_VISITOR_NAME;
		}else{
			return UC_ROLE_UNKONWN_NAME;
		}
	}
	
	public static boolean isSuperAdmin(String[] roleArr){
		if(ArrayUtils.isEmpty(roleArr)){
			return false;
		}
		return Arrays.asList(roleArr).contains(UC_ROLE_SUPER_ADMIN);
	}
	public static boolean isVisitor(String[] roleArr){
		if(ArrayUtils.isEmpty(roleArr)){
			return false;
		}
		return Arrays.asList(roleArr).contains(UC_ROLE_VISITOR);
	}
	
	
	public static final String UC_AUTH_INDEX		= "web_auth_index"; 
	public static final String UC_AUTH_MEMBER_HOME		= "web_auth_member_home"; 
	public static final String UC_AUTH_MEMBER_UPDATE		= "web_auth_member_update";
	
}
