package com.app.springboot.scrapyard.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.springboot.scrapyard.entity.Order;
import com.app.springboot.scrapyard.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
//	@Modifying
//	@Query(value="insert into customer_order values(:id,:price, :quantity, :name, :total_price, :user_id)",nativeQuery = true )
//	public void saveCustomerOrder(@Param("id") int id,@Param("price")int price,@Param("quantity") double quantity,@Param("name") String name,@Param("total_price")double total_price,@Param("user_id") int user_id );
	
	@Query(value="select user_id from customer_order group by user_id",nativeQuery = true)
	public List<Integer> getAllUser();
	
	@Query(value="select * from customer_order where user_id = :user.id ",nativeQuery = true)
	public List<Order> getCustomerOrder(@Param("user.id") User user);
	
}

