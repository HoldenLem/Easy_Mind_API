package EaseMood.com.api.Srvice;

import EaseMood.com.api.Entity.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User readById(long id);
    User update(User user);
    void delete(long id);
    List<User> getAll();
}