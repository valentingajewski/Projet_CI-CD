package menuserver.model;

import java.util.Set;

import menuserver.dto.MenuDTO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import menuserver.dto.MenuDTO;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Dish> dishes;

    public Menu(Long id, String name, Set<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.dishes = dishes;
    }

    public static Menu fromDto(MenuDTO menuDto) {
        return new Menu()
                .setId(menuDto.getId())
                .setName(menuDto.getName())
                .setDishes(Dish.fromDtoSet(menuDto.getDishes()));
    }
}
