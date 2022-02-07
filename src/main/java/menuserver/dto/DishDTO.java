package menuserver.dto;

import java.util.Set;
import java.util.HashSet;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;

import menuserver.model.Dish;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class DishDTO {

    private Long id;

    private String name;

    public DishDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Set<DishDTO> fromModelSet(Set<Dish> models) {
        Set<DishDTO> dishes = new HashSet<>();

        for (Dish model : models) {
            dishes.add(DishDTO.fromModel(model));
        }

        return dishes;
    }

    public static DishDTO fromModel(Dish dish) {
        return new DishDTO().setId(dish.getId()).setName(dish.getName());
    }
}
