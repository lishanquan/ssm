package the.daniel.mapper;

import org.springframework.stereotype.Repository;
import the.daniel.model.User;

/**
 * @Author: Daniel
 * @Date: 2019/1/14 17:11
 */
@Repository
public interface IUserMapper {

    User selectUser(long id);

}
