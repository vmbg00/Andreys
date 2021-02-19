package bg.softuni.andreys.services;

import bg.softuni.andreys.models.services.ItemAddServiceModel;
import bg.softuni.andreys.models.views.ItemViewModel;

import java.util.List;

public interface ItemService {
    void add(ItemAddServiceModel map);

    List<ItemViewModel> getAllItems();

    ItemViewModel findById(Long id);

    void deleteItem(Long id);

    int itemCount();
}
