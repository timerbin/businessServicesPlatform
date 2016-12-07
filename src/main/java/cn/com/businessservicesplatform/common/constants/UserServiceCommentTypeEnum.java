package cn.com.businessservicesplatform.common.constants;

import java.util.ArrayList;
import java.util.List;

import cn.com.businessservicesplatform.model.vo.TypeEnumVo;

/**
 * 评论类型
 * @author Administrator
 *
 */
public enum UserServiceCommentTypeEnum {
	GOOD(1,"好评"),
	MIDDLE(2,"中评"),
	BAD(3,"差评")
	;
	private int id;
	private String des;
	
	private UserServiceCommentTypeEnum(int id,String des){
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
		for (UserServiceCommentTypeEnum userLookHistoryTypeEnum : UserServiceCommentTypeEnum.values()) {
			list.add(new TypeEnumVo(userLookHistoryTypeEnum.id,userLookHistoryTypeEnum.des));
		}
		return list;
	}
	
	public static UserServiceCommentTypeEnum get(Integer menuId) {
		if(menuId != null) {
			for (UserServiceCommentTypeEnum userLookHistoryTypeEnum : UserServiceCommentTypeEnum.values()) {
				if (userLookHistoryTypeEnum.id == menuId.intValue()) {
					return userLookHistoryTypeEnum;
				}
			}
		}
		return null;
	}
	
	
}
