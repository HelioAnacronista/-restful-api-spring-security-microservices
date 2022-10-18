package github.helioanacronista.dscommerce.services;

import github.helioanacronista.dscommerce.dto.OrderDTO;
import github.helioanacronista.dscommerce.dto.OrderItemDTO;
import github.helioanacronista.dscommerce.entities.Order;
import github.helioanacronista.dscommerce.entities.OrderItem;
import github.helioanacronista.dscommerce.entities.Product;
import github.helioanacronista.dscommerce.entities.User;
import github.helioanacronista.dscommerce.enums.OrderStatus;
import github.helioanacronista.dscommerce.repository.OrderItemRepository;
import github.helioanacronista.dscommerce.repository.OrderRepository;
import github.helioanacronista.dscommerce.repository.ProductRepository;
import github.helioanacronista.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public  OrderDTO findById(Long id)  {
        Order order = repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for (OrderItemDTO itemDTO : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
