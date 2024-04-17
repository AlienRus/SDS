package backend.application.interfaces.out.repository.usersRepository;

import backend.application.implementation.authentication.User;

public interface IUsersRepository {
    public boolean authorize(User user) throws Exception;

    public void addNewUser(User user) throws Exception;

    public void deleteUser(User user) throws Exception;

    public void updateUser(User user) throws Exception;

    public String getUserRole(User user) throws Exception;
}
