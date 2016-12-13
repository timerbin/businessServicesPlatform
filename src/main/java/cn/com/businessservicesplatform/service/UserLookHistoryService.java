package cn.com.businessservicesplatform.service;

import java.util.List;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.UserLookHistory;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.UserLookHistoryVo;

public interface UserLookHistoryService {
	
	/**
	 * @Description: 添加浏览记录 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月2日 <br>
	 * @Time: 下午9:19:22 <br>
	 * @param userLookHistoryVo
	 * @return
	 * @return int <br>UserCompanyServiceService
	 * @throws
	 */
	public int insert(UserLookHistoryVo userLookHistoryVo);
	
	/**
	 * 查询浏览记录
	 * @Description:  <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月2日 <br>
	 * @Time: 下午9:19:41 <br>
	 * @param userLookHistoryVo
	 * @return
	 * @return List<UserLookHistory> <br>
	 * @throws
	 */
	public List<UserLookHistory> queryHistroyList(UserLookHistoryVo userLookHistoryVo);


    public List<UserLookHistoryVo> queryByPage(BasePage basePage, UserLookHistoryVo userLookHistoryVo);
	
	/**
	 * @Description: 删除浏览记录 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月2日 <br>
	 * @Time: 下午9:25:31 <br>
	 * @param id
	 * @return
	 * @return int <br>
	 * @throws
	 */
	public int updateDel(Integer id);

	/**
	 * 获取浏览历史的所有日期
	 * @return
     */
	public List<String> queryHisDate();
	
	/**
	 * @Description: 猜你喜欢 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月4日 <br>
	 * @Time: 下午4:28:48 <br>
	 * @param userLookHistoryVo
	 * @return
	 * @return List<UserLookHistory> <br>
	 * @throws
	 */
	public List<UserLookHistory> queryTopHistroyList(UserLookHistoryVo userLookHistoryVo);
	
	public List<BaseConfigDataVo> queryServiceLook(UserLookHistoryVo userLookHistoryVo);
	
}
