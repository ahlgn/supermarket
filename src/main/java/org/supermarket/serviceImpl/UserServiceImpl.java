package org.supermarket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supermarket.dao.TbUserMapper;
import org.supermarket.pojo.TbUser;
import org.supermarket.pojo.TbUserExample;
import org.supermarket.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;
    @Override
    public Integer loginUser(TbUser user) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<TbUser> list = userMapper.selectByExample(example);
        if(list.size()>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public Integer registerUser(TbUser user) {
        int status=userMapper.insert(user);
        if(status>0){
            return 1;
        }else{
            return 0;
        }

    }
}
