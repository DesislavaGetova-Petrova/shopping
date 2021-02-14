package softuni.service;


import softuni.model.service.UserServiceModel;

public interface UserService {
UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel user);
}
