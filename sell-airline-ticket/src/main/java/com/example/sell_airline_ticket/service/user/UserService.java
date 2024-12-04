package com.example.sell_airline_ticket.service.user;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.sell_airline_ticket.dto.response.FlightTicketResponse;
import com.example.sell_airline_ticket.entity.Account;
import com.example.sell_airline_ticket.entity.Flight;
import com.example.sell_airline_ticket.entity.Ticket;
import com.example.sell_airline_ticket.repository.AccountRepository;
import com.example.sell_airline_ticket.repository.FlightRepository;
import com.example.sell_airline_ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sell_airline_ticket.entity.User;
import com.example.sell_airline_ticket.repository.UserRepository;

import javax.swing.text.html.Option;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FlightRepository flightRepository;

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

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUserByUsername(String username){
        Optional<Account> accountOtp = accountRepository.findByUsername(username);
        if (accountOtp.isPresent()){
            return accountOtp.get().getUser();
        }
        return null;
    }

    public List<FlightTicketResponse> getFlightByUsername(String username){
        Optional<Account> accountOtp = accountRepository.findByUsername(username);
        if (accountOtp.isPresent()){
            List<Ticket> tickets = ticketRepository.getAllTicketOfCus(accountOtp.get().getUser().getUserID());

            List<FlightTicketResponse> flightTicketResponses = tickets.stream().map(ticket -> {
                Flight flight = ticket.getFlight();
                return new FlightTicketResponse(ticket, flight);
            }).toList();
            return flightTicketResponses;
        }
        return Collections.emptyList();
    }
}
