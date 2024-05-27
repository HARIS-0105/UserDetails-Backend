package com.crud.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Repo extends JpaRepository<Users, String>

{

	List<Users> findAllByOrderByModifyDateDesc();
	
	
}
