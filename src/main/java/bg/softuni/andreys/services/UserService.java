package bg.softuni.andreys.services;

import bg.softuni.andreys.models.services.UserLoginServiceModel;
import bg.softuni.andreys.models.services.UserRegisterServiceModel;

public interface UserService {

    void registerUser(UserRegisterServiceModel userRegisterServiceModel);

    boolean authenticate(String username, String password);

    void login(UserLoginServiceModel map);
}
