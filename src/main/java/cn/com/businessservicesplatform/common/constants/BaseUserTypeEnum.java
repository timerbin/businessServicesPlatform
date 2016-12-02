package cn.com.businessservicesplatform.common.constants;

import java.util.ArrayList;
import java.util.List;

import cn.com.businessservicesplatform.model.vo.TypeEnumVo;

public enum BaseUserTypeEnum {
	GENERAL_USER(1,"普通用户"),
	ADMIN_USER(2,"管理员")
	;
	private int id;
	private String des;
	
	private BaseUserTypeEnum(int id,String des){
		this.id = id;
		this.des = des;
	}

	public int getId() {
		return id;
	}

	public String getDes() {
		return des;
	}
	
	public static List<TypeEnumVo> getList(){
		List<TypeEnumVo> list = new ArrayList<TypeEnumVo>();
		for (BaseUserTypeEnum baseUserTypeEnum : BaseUserTypeEnum.values()) {
			list.add(new TypeEnumVo(baseUserTypeEnum.id,baseUserTypeEnum.des));
		}
		return list;
	}
	
	public static BaseUserTypeEnum get(Integer menuId) {
		if(menuId != null) {
			for (BaseUserTypeEnum baseUserTypeEnum : BaseUserTypeEnum.values()) {
				if (baseUserTypeEnum.id == menuId.intValue()) {
					return baseUserTypeEnum;
				}
			}
		}
		return null;
	}
	
	
}
