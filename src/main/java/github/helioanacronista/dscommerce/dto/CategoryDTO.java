package github.helioanacronista.dscommerce.dto;

import github.helioanacronista.dscommerce.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(Category entity) {
        id =  entity.getId();
        name = entity.getName();
    }
}
