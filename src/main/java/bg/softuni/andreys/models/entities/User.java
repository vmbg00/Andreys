package bg.softuni.andreys.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String username;
    private String password;
    private String email;
    private BigDecimal budget;
    private List<Item> items;

    public User() {
    }

    @OneToMany
    public List<Item> getItems() {
        return items;
    }

    public User setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    @Column(unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column
    public BigDecimal getBudget() {
        return budget;
    }

    public User setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
}
