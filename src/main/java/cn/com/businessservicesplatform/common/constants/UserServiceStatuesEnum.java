package cn.com.businessservicesplatform.common.constants;

import cn.com.businessservicesplatform.model.vo.TypeEnumVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户收藏类型枚举
 * @author Administrator
 *
 */
public enum UserServiceStatuesEnum {
	DELETED(-1,"逻辑删除"),
	WAITVERIFY(0,"待验证"),
	PASSVERIFY(1,"上线"),
	NOTPASSVERIFY(2,"下线")

	;
	private int id;
	private String des;

	private UserServiceStatuesEnum(int id, String des){
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
		for (UserServiceStatuesEnum userLookHistoryTypeEnum : UserServiceStatuesEnum.values()) {
			list.add(new TypeEnumVo(userLookHistoryTypeEnum.id,userLookHistoryTypeEnum.des));
		}
		return list;
	}
	
	public static UserServiceStatuesEnum get(Integer menuId) {
		if(menuId != null) {
			for (UserServiceStatuesEnum userServiceStatuesEnum : UserServiceStatuesEnum.values()) {
				if (userServiceStatuesEnum.id == menuId.intValue()) {
					return userServiceStatuesEnum;
				}
			}
		}
		return null;
	}
	
	
}
