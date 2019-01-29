package the.daniel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the.daniel.mapper.IUserMapper;
import the.daniel.model.User;
import the.daniel.service.IUserService;

/**
 * @Author: Daniel
 * @Date: 2019/1/14 17:17
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User selectUser(long id) {
        return this.userMapper.selectUser(id);
    }
}
