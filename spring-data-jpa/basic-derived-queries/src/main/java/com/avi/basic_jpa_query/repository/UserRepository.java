package com.avi.basic_jpa_query.repository;

import com.avi.basic_jpa_query.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByLevelIn(Collection<Integer> levels);
    List<User> findByLevelNotIn(Collection<Integer> levels);

    List<User> findByLevelLessThan(Integer level);
    List<User> findByLevelLessThanEqual(Integer level);
    List<User> findByLevelGreaterThan(Integer level);
    List<User> findByLevelGreaterThanEqual(Integer level);

    List<User> findByUsernameStartingWith(String start);
    List<User> findByUsernameEndingWith(String end);

    List<User> findByUsernameContaining(String contains);
    List<User> findByUsernameContainingIgnoreCase(String contains);

    List<User> findByUsernameIsNull();
    List<User> findByUsernameNull();
    List<User> findByUsernameIsNotNull();
    List<User> findByUsernameNotNull();

    // both same
    List<User> findByLevelIsNot(Integer level);
    List<User> findByLevelNot(Integer level);

    //True,False
    List<User> findByIsActiveTrue();
    List<User> findByIsActiveFalse();

}
