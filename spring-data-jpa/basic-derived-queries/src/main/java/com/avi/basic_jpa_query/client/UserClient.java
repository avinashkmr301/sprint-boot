package com.avi.basic_jpa_query.client;

import com.avi.basic_jpa_query.entity.User;
import com.avi.basic_jpa_query.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserClient implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Save

        User user1 = new User("Ajay", LocalDate.now(),"ajay@gmail.com",1,true);
       // User savedUser = userRepository.save(user1);
       // System.out.println(savedUser);
    }
}
