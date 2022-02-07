package menuserver.dto;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import menuserver.model.Menu;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class MenuDTO {

    private Long id;

    private String name;

    private Set<DishDTO> dishes;

    public MenuDTO(Long id, String name, Set<DishDTO> dishes) {
        this.id = id;
        this.name = name;
        this.dishes = dishes;
    }

    public static List<MenuDTO> fromModelIterable(Iterable<Menu> models) {
        List<MenuDTO> menus = new ArrayList<>();

        for (Menu model : models) {
            menus.add(MenuDTO.fromModel(model));
        }

        return menus;
    }

    public static MenuDTO fromModel(Menu menu) {
        return new MenuDTO()
                .setId(menu.getId())
                .setName("TEST TODO")
                .setDishes(DishDTO.fromModelSet(menu.getDishes()));
    }
}
