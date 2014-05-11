package com.taotaoti.member.bo;

/**
 * 
 * @author liulxiang
 * 
 */

public class Columns {
	
	public final static String memberId = "id";
	public final static String createTime = "createtime";
	public final static String updateTime = "updatetime";
	
	public final static class MemberColumns{
		public final static String name = "name";
		public final static String email = "email";
		public final static String password = "password";
		public final static String sex="sex";
		public final static String schoolId="school_id";
		public final static String partyJoinSum="party_join_sum";
		public final static String photo="photo";
		public final static String description="description";
		public final static String phone="phone";
		public final static String points="points";
		public final static String reputation="reputation";
		public final static String successSum="success_sum";
		public final static String failSum="fail_sum";
		public final static String partyCreateSum="party_create_sum";
		public final static String major="major";
		public final static String roleid="roleid";
		public final static String createTime="create_time";
		public final static String updateTime="update_time";
		
	}
	public static final class MemberInfoColumns{
		public final static String lastModified = "last_modified";
		public static final String webSite = "website";
		public static final String webSiteName = "website_name";
		public static final String telephone = "telephone";
		public static final String phone = "phone";
		public static final String address = "address";
		public static final String region = "region";
	}
	public static final class RoleColumns{
		public final static String roleid = "roleid";	
		public static final String name = "name";
		public static final String statu = "statu";
	}
	public static final class RoleauthColumns{
		public final static String id = "id";
		public static final String roleid = "roleid";
		public static final String authid = "authid";
	}
	public static final class AuthColumns{
		public final static String authid = "authid";
		public static final String authcode = "authcode";
	}
}
