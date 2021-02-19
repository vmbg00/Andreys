package bg.softuni.andreys.repositories;

import bg.softuni.andreys.models.entities.Category;
import bg.softuni.andreys.models.entities.enums.CategoryEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(CategoryEnums category);
}
