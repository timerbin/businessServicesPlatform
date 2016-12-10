package cn.com.businessservicesplatform.service.impl;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import cn.com.businessservicesplatform.dao.mysql.BaseUserMapper;
import cn.com.businessservicesplatform.dao.mysql.BaseUserSendInfoMapper;
import cn.com.businessservicesplatform.model.mysql.BaseUser;
import cn.com.businessservicesplatform.model.mysql.BaseUserSendInfo;
import cn.com.businessservicesplatform.service.BaseUserSendInfoService;

@Service
public class BaseUserSendInfoServiceImpl implements BaseUserSendInfoService {
	@Autowired
	BaseUserSendInfoMapper baseUserSendInfoMapper;
	@Autowired
	BaseUserMapper baseUserMapper;
	@Autowired
	JavaMailSenderImpl javaMailSender ;

	@Override
	public int insertEmailCode(Integer userId) {
		if(null == userId){
			return 0;
		}
		String code = getFourRandom();
		BaseUser baseUser = baseUserMapper.selectByPrimaryKey(userId);
		if(null == baseUser || baseUser.getId() == null || StringUtils.isBlank(code)){
			return -2;
		}
		BaseUserSendInfo baseUserSendInfo = new BaseUserSendInfo();
		baseUserSendInfo.setUserId(userId);
		baseUserSendInfo.setEmail(baseUser.getEmail());
		baseUserSendInfo.setStatus(0);
		baseUserSendInfo.setMobilePhone(baseUser.getMobilePhoneNumber());
		baseUserSendInfo.setType(1);
		baseUserSendInfo.setSendCode(code);
		baseUserSendInfo.setCreateTime(new Date());
		baseUserSendInfo.setModifyTime(new Date());
		int result = baseUserSendInfoMapper.insert(baseUserSendInfo);
		if(result > 0){
			SimpleMailMessage smm = new SimpleMailMessage();
			// 设定邮件参数
			smm.setFrom(javaMailSender.getUsername());
			smm.setTo(baseUser.getEmail());
			smm.setSubject("泰兴虹桥");
			smm.setText("验证码"+code);
			// 发送邮件
			javaMailSender.send(smm);
		}
		return result;
	}
	private   String getFourRandom(){
        Random random = new Random();
        String fourRandom = String.valueOf(random.nextInt(10000));
        int randLength = fourRandom.length();
        if(randLength<4){
          for(int i=1; i<=4-randLength; i++)
              fourRandom = "0" + fourRandom  ;
      }
        return fourRandom;
    }

	@Override
	public BaseUserSendInfo updateCheckCode(Integer userId) {
		BaseUserSendInfo sendinfo = null;
		if(null == userId){
			return sendinfo;
		}
		BaseUser baseUser = baseUserMapper.selectByPrimaryKey(userId);
		if(null == baseUser || baseUser.getId() == null){
			return sendinfo;
		}
		sendinfo = baseUserSendInfoMapper.select(baseUser.getId(), baseUser.getEmail());
		if(null == sendinfo || sendinfo.getId()== null){
			return sendinfo;
		}
		sendinfo.setStatus(1);
		sendinfo.setModifyTime(new Date());
		baseUserSendInfoMapper.updateByPrimaryKey(sendinfo);
		return sendinfo;
	}
}
