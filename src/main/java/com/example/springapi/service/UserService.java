package com.example.springapi.service;


import com.example.springapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

        private List<User> userList;

        public UserService() {
            userList = new ArrayList<>();

            User user1;
            user1 = new User(1, "João Victor", "joao.silva@gmail.com", "61 9442-1611");
            User user2 = new User(2, "Guilherme", "guilherme.nunes@gmail.com", "61 9442-1611");

            userList.addAll(Arrays.asList(user1, user2));
        }
        public Optional<User> getUser (Integer id) {
            Optional optional = Optional.empty();
            for (User user: userList){
                if(id == user.getId()){
                    optional = Optional.of(user);
                    return optional;
                }
            }
            return optional;
        }
}
