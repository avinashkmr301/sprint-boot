package com.avi.basic_jpa_query.repository;

import com.avi.basic_jpa_query.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.lang.model.element.NestingKind;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    // Is, Equals
    User findByUsername(String userName);
    User findByUsernameIs(String userName);
    User findByUsernameEquals(String userName);

    // OrderBy
    List<User> findAllByOrderByRegistrationDate();
    List<User> findAllByOrderByRegistrationDateAsc();
    List<User> findAllByOrderByRegistrationDateDesc();

    // Q1. find all users by "registration_date" and order the result by their "username"
    List<User> findByRegistrationDateOrderByUsername(LocalDate registrationDate);

    //Between
    List<User> findByRegistrationDateBetween(LocalDate start, LocalDate end);

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

    List<User> findFirst2ByIsActiveAndUsernameEndingWith(boolean isActive, String username);
    List<User> findFirst2ByIsActiveTrueAndUsernameEndingWith(String username);

}
