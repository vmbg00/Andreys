package bg.softuni.andreys.models.binding;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class UserRegisterBindingModel {

    private String username;
    private String email;
    private BigDecimal budget;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "Cannot be blank")
    @Size(min = 3, message = "Username length must be more than two characters")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank(message = "Cannot be blank")
    @Email
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @DecimalMin(value = "0", message = "Must be a positive budget")
    public BigDecimal getBudget() {
        return budget;
    }

    public UserRegisterBindingModel setUserBudget(BigDecimal userBudget) {
        this.budget = userBudget;
        return this;
    }

    @NotBlank(message = "Cannot be blank")
    @Size(min = 3, message = "Password length must be more than two characters")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Cannot be blank")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
