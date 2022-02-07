package menuserver.service;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import menuserver.repository.MenuRepository;
import menuserver.dto.MenuDTO;

@Service
public class ListMenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public ListMenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuDTO> listMenus() {
        return MenuDTO.fromModelIterable(menuRepository.findAll());
    }
}
