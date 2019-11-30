package hu.szacs93.beadando.controllers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import hu.szacs93.beadando.Etel;

import java.util.List;

public interface JpaEtelRepo extends CrudRepository<Etel, Long> {
	
	public final static String GET_ETEL_BY_ID = "select et from Etel et where ID = :id";

    List<Etel> findByName(String name);
    
    @Query(GET_ETEL_BY_ID)
    Etel findById(@Param("id") int id);

}