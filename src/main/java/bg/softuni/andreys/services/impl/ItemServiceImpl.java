package bg.softuni.andreys.services.impl;

import bg.softuni.andreys.models.entities.Category;
import bg.softuni.andreys.models.entities.Item;
import bg.softuni.andreys.models.services.ItemAddServiceModel;
import bg.softuni.andreys.repositories.CategoryRepository;
import bg.softuni.andreys.repositories.ItemRepository;
import bg.softuni.andreys.services.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(ItemAddServiceModel itemAddServiceModel) {
        Item item = new Item();
        Category category = this.categoryRepository.findByName(itemAddServiceModel.getCategory());

        item
                .setCategory(category)
                .setDescription(itemAddServiceModel.getDescription())
                .setGender(itemAddServiceModel.getGender())
                .setName(itemAddServiceModel.getName())
                .setPrice(itemAddServiceModel.getPrice())
                .setId(itemAddServiceModel.getId());

        itemRepository.save(item);
    }
}
