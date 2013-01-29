package org.cwvs.gfxu.worktime.domain.logic;

import java.util.List;

import org.cwvs.gfxu.worktime.domain.Account;
import org.cwvs.gfxu.worktime.domain.Category;
import org.cwvs.gfxu.worktime.domain.Item;
import org.cwvs.gfxu.worktime.domain.Order;
import org.cwvs.gfxu.worktime.domain.Product;

/**
 * JPetStore's central business interface.
 *
 * @author Juergen Hoeller
 * @since 30.11.2003
 */
public interface PetStoreFacade {

	Account getAccount(String username);

	Account getAccount(String username, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);

	List getUsernameList();


	List getCategoryList();

	Category getCategory(String categoryId);
	

	List getProductListByCategory(String categoryId);

	List searchProductList(String keywords);

	Product getProduct(String productId);


	List getItemListByProduct(String productId);

	Item getItem(String itemId);

	boolean isItemInStock(String itemId);


	void insertOrder(Order order);

	Order getOrder(int orderId);

	List getOrdersByUsername(String username);

}
