package the.daniel.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import the.daniel.model.User;

/**
 * @Author: Daniel
 * @Date: 2019/1/14 17:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class IUserMapperTest {

    @Autowired
    private IUserMapper userMapper;

    @Test
    public void testSelectUser(){
        long id = 1;
        User user = userMapper.selectUser(id);
        System.out.println(user.getUsername());
    }
}
