package com.tidyup.OrderService.service;

import com.tidyup.OrderService.domain.item.entity.ItemEntity;
import com.tidyup.OrderService.domain.order.dto.CreateOrderDTO;
import com.tidyup.OrderService.domain.order.dto.CreatedOrderDTO;
import com.tidyup.OrderService.domain.order.dto.ListOrderDTO;
import com.tidyup.OrderService.domain.order.entity.OrderEntity;
import com.tidyup.OrderService.domain.order.entity.OrderStatusEntity;
import com.tidyup.OrderService.domain.order.model.OrderStatus;
import com.tidyup.OrderService.repository.ItemRepository;
import com.tidyup.OrderService.repository.OrderRepository;
import com.tidyup.OrderService.repository.OrderStatusRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private ItemRepository itemRepository;

    public CreatedOrderDTO create(CreateOrderDTO dto) {
        OrderStatusEntity orderStatusEntity = orderStatusRepository.findByStatus(OrderStatus.WAITING_CONFIRMATION.toString()).orElseThrow(EntityNotFoundException::new);

        List<ItemEntity> itemEntityList = dto.items().stream().map(ItemEntity::new).toList();
        //Validates with stock service if product with productId exists, is available and price matches or else throws an exception
        itemEntityList.forEach(item -> itemRepository.save(item));

        var orderEntity = new OrderEntity(dto.retailerId(), dto.customerId(), itemEntityList, orderStatusEntity);
        orderEntity = orderRepository.save(orderEntity);
        return new CreatedOrderDTO(orderEntity);
    }

    public Page<ListOrderDTO> getAll(Pageable pageable) {
        return orderRepository.findAll(pageable).map(ListOrderDTO::new);
    }

    public ListOrderDTO getById(UUID id) {
        return orderRepository.findById(id).map(ListOrderDTO::new).orElseThrow(EntityNotFoundException::new);
    }
}