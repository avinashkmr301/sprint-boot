package com.avi.basic_jpa_query.repository;

import com.avi.basic_jpa_query.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLabRepository extends JpaRepository<User,Long> {

    //Task 1: find all users with their level ordered in descending order
    //Task 2: find just first 2 users with their level ordered in descending order
    //Task 3: find just first user from users ordered by their level in descending order
    //Task 4: find all users who are either inactive or 1st level.
    //Task 5: find all users whose email contains the String "else" in it.

    User findByUsername(String name);

    
}
