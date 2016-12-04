package cn.com.businessservicesplatform.common.constants;

import java.util.ArrayList;
import java.util.List;

import cn.com.businessservicesplatform.model.vo.TypeEnumVo;

/**
 * 推荐枚举
 * @author Administrator
 *
 */
public enum RecommendEnum {
	RECCOMEND(1,"不推荐"),
	UN_RECCOMEND(0,"推荐")
	;
	private int id;
	private String des;
	
	private RecommendEnum(int id,String des){
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
		for (RecommendEnum userLookHistoryTypeEnum : RecommendEnum.values()) {
			list.add(new TypeEnumVo(userLookHistoryTypeEnum.id,userLookHistoryTypeEnum.des));
		}
		return list;
	}
	
	public static RecommendEnum get(Integer menuId) {
		if(menuId != null) {
			for (RecommendEnum userLookHistoryTypeEnum : RecommendEnum.values()) {
				if (userLookHistoryTypeEnum.id == menuId.intValue()) {
					return userLookHistoryTypeEnum;
				}
			}
		}
		return null;
	}
	
	
}
