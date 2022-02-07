package menuserver.repository;

import org.springframework.data.repository.CrudRepository;

import menuserver.model.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {
}
