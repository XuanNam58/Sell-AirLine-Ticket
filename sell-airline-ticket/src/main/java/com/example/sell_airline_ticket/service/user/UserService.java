package com.example.sell_airline_ticket.service.user;


import com.example.sell_airline_ticket.dto.request.UserCreationRequest;
import com.example.sell_airline_ticket.dto.response.UserCreationResponse;
import com.example.sell_airline_ticket.entity.User;
import com.example.sell_airline_ticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    public User createUser(UserCreationRequest request){
//        User user = new User();
//
//        user.setName(request.getName());
//        user.setEmail(request.getEmail());
//        user.setPhoneNum(request.getPhoneNum());
//        user.setCitizenID(request.getCitizenID());
//        user.setCreditNum(request.getCreditNum());
//        user.setStatus(request.getStatus());
//
//        return userRepository.save(user);
//    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
