package the.daniel.service;

import the.daniel.model.User;

/**
 * @Author: Daniel
 * @Date: 2019/1/14 17:17
 */
public interface IUserService {

    User selectUser(long id);

}
