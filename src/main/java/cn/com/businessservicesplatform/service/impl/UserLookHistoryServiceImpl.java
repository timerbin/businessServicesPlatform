package cn.com.businessservicesplatform.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.businessservicesplatform.common.util.DateUtils;
import cn.com.businessservicesplatform.dao.mysql.UserLookHistoryMapper;
import cn.com.businessservicesplatform.model.mysql.UserLookHistory;
import cn.com.businessservicesplatform.model.vo.UserLookHistoryVo;
import cn.com.businessservicesplatform.service.UserLookHistoryService;

@Service
public class UserLookHistoryServiceImpl implements UserLookHistoryService{
	
	@Autowired
	UserLookHistoryMapper userLookHistoryMapper;

	@Override
	public int insert(UserLookHistoryVo userLookHistoryVo) {
		int result = 0;
		if(null != userLookHistoryVo && null != userLookHistoryVo.getUserId()){
			/**当前时间**/
			String nowDate = DateUtils.getString(new Date(),DateUtils.DEF_DATE_NO_TIME_FORMAT);
			userLookHistoryVo.setNowDate(nowDate);
			
			UserLookHistory lookHistory = userLookHistoryMapper.getByVo(userLookHistoryVo);
			if(null == lookHistory || lookHistory.getId() == null){
				lookHistory = new UserLookHistory(userLookHistoryVo);
				lookHistory.setStatus(1);
				lookHistory.setNowDate(nowDate);
				lookHistory.setCreateTime(new Date());
				lookHistory.setModifyTime(new Date());
				result = userLookHistoryMapper.insert(lookHistory);
			}else{
				if(null != lookHistory.getLookCount()){
					lookHistory.setLookCount(lookHistory.getLookCount().intValue()+1);
				}else{
					lookHistory.setLookCount(1);
				}
				lookHistory.setModifyTime(new Date());
				result = userLookHistoryMapper.updateByPrimaryKey(lookHistory);
			}
		}
		return result;
	}

	@Override
	public List<UserLookHistory> queryHistroyList(UserLookHistoryVo userLookHistoryVo) {
		return userLookHistoryMapper.queryHistroyList(userLookHistoryVo);
	}

	@Override
	public int updateDel(Integer id) {
		if(null == id){
			return 0;
		}
		return userLookHistoryMapper.updateDelStatus(id);
	}

	 
	 

}
