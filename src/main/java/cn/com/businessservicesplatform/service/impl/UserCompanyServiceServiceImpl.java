package cn.com.businessservicesplatform.service.impl;

import cn.com.businessservicesplatform.dao.mysql.UserCompanyServiceMapper;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by John on 2016/12/3.
 */
@Service
public class UserCompanyServiceServiceImpl implements UserCompanyServiceService{

    @Autowired
    UserCompanyServiceMapper userCompanyServiceMapper;

    public int insert(UserCompanyServiceVo vo){
        return userCompanyServiceMapper.insert(vo);
    }

    @Override
    public UserCompanyServiceVo fetchCompanyService(UserCompanyServiceVo vo) {
        return userCompanyServiceMapper.getUserCompanyService(vo);
    }


}
