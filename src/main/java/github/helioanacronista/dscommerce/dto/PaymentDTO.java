package github.helioanacronista.dscommerce.dto
        ;
import github.helioanacronista.dscommerce.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PaymentDTO {

    private Long id;
    private Instant moment;

    public PaymentDTO(Payment entity) {
        id = entity.getId();
        moment = entity.getMoment();
    }
}
