package github.helioanacronista.dscommerce.dto;

import github.helioanacronista.dscommerce.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDTO {

    private Long id;
    private String name;

    public ClientDTO(User entity) {
        id  = entity.getId();
        name = entity.getName();
    }

}
