package org.cwvs.gfxu.worktime.dao;

import java.util.List;

import org.cwvs.gfxu.worktime.domain.Order;
import org.springframework.dao.DataAccessException;

public interface OrderDao {

  List getOrdersByUsername(String username) throws DataAccessException;

  Order getOrder(int orderId) throws DataAccessException;

  void insertOrder(Order order) throws DataAccessException;

}
