package menuserver.service;

import java.util.Set;
import java.util.HashSet;

import menuserver.dto.MenuDTO;
import menuserver.model.Menu;
import menuserver.model.Dish;
import menuserver.repository.MenuRepository;
import menuserver.repository.DishRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateMenuService {

    private final MenuRepository menuRepository;

    private final DishRepository dishRepository;

    @Autowired
    public CreateMenuService(MenuRepository menuRepository, DishRepository dishRepository) {
        this.menuRepository = menuRepository;
        this.dishRepository = dishRepository;
    }

    @Transactional
    public MenuDTO createMenu(MenuDTO menuDto) {
        Menu menu = Menu.fromDto(menuDto);

        menu.setDishes(deduplicateDishByName(menu.getDishes()));

        menu = menuRepository.save(menu);

        return MenuDTO.fromModel(menu);
    }

    private Set<Dish> deduplicateDishByName(Set<Dish> dishes) {
        Set<Dish> dedupDishes = new HashSet<>();

        for (Dish dish : dishes) {
            Dish existingDish = dishRepository.findByName(dish.getName());

            if (existingDish == null) {
                existingDish = dish;
            }

            dedupDishes.add(existingDish);
        }

        return dedupDishes;
    }
}
