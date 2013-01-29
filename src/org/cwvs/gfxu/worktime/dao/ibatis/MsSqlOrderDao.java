package org.cwvs.gfxu.worktime.dao.ibatis;

import org.cwvs.gfxu.worktime.domain.LineItem;
import org.cwvs.gfxu.worktime.domain.Order;
import org.springframework.dao.DataAccessException;
import org.cwvs.gfxu.worktime.dao.ibatis.SqlMapOrderDao;

public class MsSqlOrderDao extends SqlMapOrderDao {

  /**
   * Special MS SQL Server version to allow the Item ID
	 * to be retrieved from an identity column.
   */
  public void insertOrder(Order order) throws DataAccessException {
    Integer orderId = (Integer) getSqlMapClientTemplate().queryForObject("msSqlServerInsertOrder", order);
    order.setOrderId(orderId.intValue());
    getSqlMapClientTemplate().insert("insertOrderStatus", order);
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      lineItem.setOrderId(order.getOrderId());
      getSqlMapClientTemplate().insert("insertLineItem", lineItem);
    }
  }
  
}
