package bg.softuni.andreys.services.impl;

import bg.softuni.andreys.models.entities.Category;
import bg.softuni.andreys.models.entities.Item;
import bg.softuni.andreys.models.services.ItemAddServiceModel;
import bg.softuni.andreys.models.views.ItemViewModel;
import bg.softuni.andreys.repositories.CategoryRepository;
import bg.softuni.andreys.repositories.ItemRepository;
import bg.softuni.andreys.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public List<ItemViewModel> getAllItems() {
        return this.itemRepository
                .findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName()));

                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(Long id) {
        return this.itemRepository.findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName()));

                    return itemViewModel;
                }).orElse(null);

    }

    @Override
    public void deleteItem(Long id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public int itemCount() {
        return this.itemRepository.countAllItems();
    }
}
