package bg.softuni.andreys.services.impl;

import bg.softuni.andreys.models.entities.User;
import bg.softuni.andreys.models.services.UserLoginServiceModel;
import bg.softuni.andreys.models.services.UserRegisterServiceModel;
import bg.softuni.andreys.repositories.UserRepository;
import bg.softuni.andreys.security.CurrentUser;
import bg.softuni.andreys.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserRegisterServiceModel userRegisterServiceModel) {
        User user = new User();

        user
                .setUsername(userRegisterServiceModel.getUsername())
                .setPassword(userRegisterServiceModel.getPassword())
                .setEmail(userRegisterServiceModel.getEmail())
                .setBudget(userRegisterServiceModel.getBudget())
                .setItems(null)
                .setId(user.getId());

        this.userRepository.save(user);
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<User> user = this.userRepository.findByUsername(username);

        if (user.isEmpty()){
            return false;
        }
        else {
            return user.get().getPassword().equals(password);
        }
    }

    @Override
    public void login(UserLoginServiceModel userLoginServiceModel) {
        this.currentUser.setName(userLoginServiceModel.getUsername()).setAnonymous(false);
    }
}
