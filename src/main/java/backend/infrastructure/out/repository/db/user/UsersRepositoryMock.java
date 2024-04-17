package backend.infrastructure.out.repository.db.user;

import java.sql.SQLException;
import java.util.ArrayList;
import backend.application.implementation.authentication.User;
import backend.application.interfaces.out.repository.usersRepository.IUsersRepository;

public class UsersRepositoryMock implements IUsersRepository {
    public ArrayList<User> users;

    @Override
    public void addNewUser(User user) throws SQLException {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    @Override
    public boolean authorize(User user) throws SQLException {
        if (!users.contains(user)) {
            return false;
        }
        User userFromList = users.get(users.indexOf(user));
        if (userFromList.getLogin() != user.getLogin() || userFromList.getPassword() != user.getPassword()
                || userFromList.getRole() != user.getRole()) {
            return false;
        }
        return true;
    }

    @Override
    public void deleteUser(User user) throws Exception {

    }

    @Override
    public void updateUser(User user) throws Exception {

    }

    @Override
    public String getUserRole(User user) throws Exception {
        return "role";
    }

}
