package cn.com.businessservicesplatform.common.constants;

import java.util.ArrayList;
import java.util.List;

import cn.com.businessservicesplatform.model.vo.TypeEnumVo;

public enum BaseConfigTypeEnum {
	MANAGEMENT(1,"经营管理"),
	COMPANY_PROPERTY(2,"企业性质"),
	SERVICES_TYPE(3,"服务类别"),
	SERVICES_COMMENT(4,"企业服务评论标签")  
	;
	private int id;
	private String des;
	
	private BaseConfigTypeEnum(int id,String des){
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
		for (BaseConfigTypeEnum baseConfigTypeEnum : BaseConfigTypeEnum.values()) {
			list.add(new TypeEnumVo(baseConfigTypeEnum.id,baseConfigTypeEnum.des));
		}
		return list;
	}
	
	public static BaseConfigTypeEnum get(Integer menuId) {
		if(menuId != null) {
			for (BaseConfigTypeEnum baseConfigTypeEnum : BaseConfigTypeEnum.values()) {
				if (baseConfigTypeEnum.id == menuId.intValue()) {
					return baseConfigTypeEnum;
				}
			}
		}
		return null;
	}
}
