package com.app.springboot.scrapyard.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.springboot.scrapyard.entity.ScrapMaterial;

@Repository
public interface ScrapMaterialRepository extends JpaRepository<ScrapMaterial, Integer> {

	@Query(value= "SELECT name,price FROM scrap_material  where id IN(select scrap_material_id from Cart  where customer_id = :id)", nativeQuery = true )
	public List<ScrapMaterial> getAllScrapMaterial(@Param("id") int id);
	
	
}
