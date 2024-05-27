package com.crud.demo;
import com.crud.demo.Crud;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CrudTest {

    private static final Object users = null;

	@InjectMocks
    private Crud crud; 

    @Mock
    private Repo repo; 

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
         MockitoAnnotations.openMocks(this);    
    }

    @Test
    public void insertUserTest(){

    	Users users = new Users();

    	when(repo.save(users)).thenReturn(users);

    	Users result = crud.add(users);

    	Assertions.assertEquals(users,result);

    	}
    @Test
    public void displayallUserTest(){
     List<Users> users = null;
     when(repo.findAllByOrderByModifyDateDesc()).thenReturn(users);
     List<Users> result=crud.display();
     Assertions.assertEquals(users, result);
    }
    
    @Test
    public void emailExistTest() {
    	when(repo.findById("harismitar@gmail.com")).thenReturn(Optional.of(new Users()));

    	boolean result = crud.emailExist("harismitar@gmail.com");

    	Assertions.assertTrue(result);
    	
    }
    @Test
    public void emailNotExistTest() {
    	when(repo.findById("haris@gmail.com")).thenReturn(Optional.empty());

    	boolean result = crud.emailExist("haris@gmail.com");

    	Assertions.assertFalse(result);
    	
    }
    
    @Test
    public void deleteUserTest() {
    	
    	String result = crud.deleteuser("surya@kce.ac.in");

    	Assertions.assertEquals("found",result);
    	
    }
    
    @Test
    public void editUserTest() {
    	
    	Optional<Users> users=null;
    	when(repo.findById("harismitar@gmail.com")).thenReturn(users);
    	
    	Optional<Users> result=crud.editData("harismitar@gmail.com");
    	
    	 Assertions.assertEquals(users, result);
    }
//    
//	@Test
//    public void updateDataTest() {
//		
//		Date dob=new Date();
//    	Users existingUser = new Users("harismitar@gmail.com", "Harismita", "Ragupathy","8221234569", dob, "Coimbatore", new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()));
//    	
//    	when(repo.findById("harismitar@gmail.com")).thenReturn(Optional.of(existingUser));
//
//    	Users updatedUser=new Users("harismitaragupathy@gmail.com", "Harismita", "Ragupathy","8221234569", dob, "Coimbatore", new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()));
//    	System.out.println(dob);
//    	crud.updateData("harismitar@gmail.com", updatedUser);
//    	verify(repo, times(1)).save(updatedUser);
//	}
    
}