package github.helioanacronista.dscommerce.repository;

import github.helioanacronista.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);
}
