package cn.com.businessservicesplatform.common.constants;

import java.util.ArrayList;
import java.util.List;

import cn.com.businessservicesplatform.model.vo.TypeEnumVo;

/**
 * 用户浏览类型枚举
 * @author Administrator
 *
 */
public enum UserLookHistoryTypeEnum {
	SERVICES(1,"服务浏览历史"),
	COMPANY(2,"公司浏览历史")
	;
	private int id;
	private String des;
	
	private UserLookHistoryTypeEnum(int id,String des){
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
		for (UserLookHistoryTypeEnum userLookHistoryTypeEnum : UserLookHistoryTypeEnum.values()) {
			list.add(new TypeEnumVo(userLookHistoryTypeEnum.id,userLookHistoryTypeEnum.des));
		}
		return list;
	}
	
	public static UserLookHistoryTypeEnum get(Integer menuId) {
		if(menuId != null) {
			for (UserLookHistoryTypeEnum userLookHistoryTypeEnum : UserLookHistoryTypeEnum.values()) {
				if (userLookHistoryTypeEnum.id == menuId.intValue()) {
					return userLookHistoryTypeEnum;
				}
			}
		}
		return null;
	}
	
	
}
