package com.app.springboot.scrapyard.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.springboot.scrapyard.entity.Cart;
import com.app.springboot.scrapyard.entity.ScrapMaterial;
import com.app.springboot.scrapyard.entity.ScrapMaterialData;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

	//@Query(value= "SELECT name,price FROM scrap_material  where id IN(select scrap_material_id from Cart  where customer_id = :id)", nativeQuery = true )
	@Query("SELECT new com.app.springboot.scrapyard.entity.ScrapMaterial(sm.id,sm.name,sm.price) FROM ScrapMaterial sm WHERE sm.id IN(SELECT c.scrapMaterial.id FROM Cart c WHERE c.customer.id = :id)")
	public List<ScrapMaterial> getAllScrapMaterial(@Param("id") int id);
	
	@Modifying
	@Query("DELETE FROM Cart c WHERE c.scrapMaterial.id = :id")
	public int  deleteByScrapMaterialId(@Param("id") int id);
	
	@Modifying
	@Query(value="insert into cart values(:id,:customer_id,:scrap_material_id)",nativeQuery = true )
	public void saveToCart(@Param("id")int id,@Param("customer_id") int customer_id,@Param("scrap_material_id") int scrap_material_id );
}
