package com.avi.basic_jpa_query;

import com.avi.basic_jpa_query.entity.User;
import com.avi.basic_jpa_query.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class BasicDerivedQueriesApplicationTests {

	@Autowired
	private UserRepository userRepository;

	/*@Test
	void contextLoads() {
	}*/

	@BeforeAll
	void populateDB(){
		User user1 = new User("john", LocalDate.of(2021,8,04),"john@somewhr.com",1,true);
		User user2 = new User("jane", LocalDate.of(2019,3,18),"jane@somewhrelse.com",2,true);
		User user3 = new User("nicole", LocalDate.of(2017,7,21),"nicole@somewhr.com",1,false);
		User user4 = new User("ravi", LocalDate.of(2028,6,15),"ravi@somewhrelse.com",1,false);
		User user5 = new User("alissa", LocalDate.of(2014,4,05),"alissa@somewhr.com",2,true);
		User user6 = new User("thanuja", LocalDate.of(2014,4,05),"thanuja@somewhrelse.com",3,true);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
		userRepository.save(user6);
	}

	@AfterAll
	void dePopulate(){
		userRepository.deleteAll();
	}

	@Test
	void testFindByLevelIn(){
		List<User> byLevelIn = userRepository.findByLevelIn(List.of(2, 3));
		assertEquals(3,byLevelIn.size());
		System.out.println(byLevelIn);
	}
	@Test
	void testFindByLevelNotIn(){
		List<User> byLevelIn = userRepository.findByLevelNotIn(List.of(2, 3));
		assertEquals(3,byLevelIn.size());
		System.out.println(byLevelIn);
	}

}
