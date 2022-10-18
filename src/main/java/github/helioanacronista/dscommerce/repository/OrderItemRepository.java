package github.helioanacronista.dscommerce.repository;

import github.helioanacronista.dscommerce.entities.OrderItem;
import github.helioanacronista.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
