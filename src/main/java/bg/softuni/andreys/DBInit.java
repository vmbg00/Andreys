package bg.softuni.andreys;

import bg.softuni.andreys.models.entities.Category;
import bg.softuni.andreys.models.entities.enums.CategoryEnums;
import bg.softuni.andreys.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public DBInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0){

            Category shirt = new Category();
            shirt.setName(CategoryEnums.SHIRT);
            shirt.setDescription("Good for you");

            Category shorts = new Category();
            shorts.setName(CategoryEnums.SHORTS);
            shorts.setDescription("Not too short");

            Category denim = new Category();
            denim.setName(CategoryEnums.DENIM);
            denim.setDescription("Why not");

            Category jacket = new Category();
            jacket.setName(CategoryEnums.JACKET);
            jacket.setDescription("Seems good");

            this.categoryRepository.save(shirt);
            this.categoryRepository.save(shorts);
            this.categoryRepository.save(denim);
            this.categoryRepository.save(jacket);
        }
    }
}
