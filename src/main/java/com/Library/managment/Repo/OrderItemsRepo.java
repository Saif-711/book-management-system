package com.Library.managment.Repo;

import com.Library.managment.Model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepo extends JpaRepository<OrderItems, Long>  {
}
