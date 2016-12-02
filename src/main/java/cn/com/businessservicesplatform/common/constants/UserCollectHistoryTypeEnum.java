package cn.com.businessservicesplatform.common.constants;

import java.util.ArrayList;
import java.util.List;

import cn.com.businessservicesplatform.model.vo.TypeEnumVo;

/**
 * 用户收藏类型枚举
 * @author Administrator
 *
 */
public enum UserCollectHistoryTypeEnum {
	SERVICES(1,"服务收藏"),
	COMPANY(2,"店铺收藏")
	;
	private int id;
	private String des;
	
	private UserCollectHistoryTypeEnum(int id,String des){
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
		for (UserCollectHistoryTypeEnum userLookHistoryTypeEnum : UserCollectHistoryTypeEnum.values()) {
			list.add(new TypeEnumVo(userLookHistoryTypeEnum.id,userLookHistoryTypeEnum.des));
		}
		return list;
	}
	
	public static UserCollectHistoryTypeEnum get(Integer menuId) {
		if(menuId != null) {
			for (UserCollectHistoryTypeEnum userLookHistoryTypeEnum : UserCollectHistoryTypeEnum.values()) {
				if (userLookHistoryTypeEnum.id == menuId.intValue()) {
					return userLookHistoryTypeEnum;
				}
			}
		}
		return null;
	}
	
	
}
