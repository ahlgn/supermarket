package org.supermarket.service;

import org.supermarket.pojo.TbUser;

public interface UserService {
    public Integer loginUser(TbUser user);
    public Integer registerUser(TbUser user);
}
