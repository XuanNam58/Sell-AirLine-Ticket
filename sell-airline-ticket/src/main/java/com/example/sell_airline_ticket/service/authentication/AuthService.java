package com.example.sell_airline_ticket.service.authentication;

import com.example.sell_airline_ticket.dto.request.RegisterRequest;
import com.example.sell_airline_ticket.dto.response.RegisterResponse;
import com.example.sell_airline_ticket.entity.Account;
import com.example.sell_airline_ticket.dto.request.AuthenticationRequest;
import com.example.sell_airline_ticket.dto.response.AuthenticationResponse;
import com.example.sell_airline_ticket.entity.User;
import com.example.sell_airline_ticket.repository.AccountRepository;
import com.example.sell_airline_ticket.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.Authentication;

import java.util.Optional;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final JavaMailSender javaMailSender;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            String token = jwtService.generateToken(authentication);

            return AuthenticationResponse.builder()
                    .token(token)
                    .message("Đăng nhập thành công")
                    .success(true)
                    .build();

        } catch (AuthenticationException e) {
            return AuthenticationResponse.builder()
                    .message("Tên đăng nhập hoặc mật khẩu không đúng")
                    .success(false)
                    .build();
        }
    }

    public RegisterResponse registerNewAccount(RegisterRequest request){
        String message="Đăng ký thành công";
        boolean success=true;

        Optional<Account> accountOptional = accountRepository.findByUsername(request.getUsername());
        if (accountOptional.isPresent()){
            message="Username đã tồn tại";
            success=false;
        }

        User user = new User();
        try{
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPhoneNum(request.getPhoneNum());
            user.setCitizenID(request.getCitizenID());
            user.setCreditNum(request.getCreditNum());
            user.setStatus(true);
            userRepository.save(user);
        } catch (Exception e) {
            message="Không thể tạo user";
            success=false;
        }

        try{
            Account account = new Account();
            account.setUsername(request.getUsername());
            account.setPassword(passwordEncoder.encode(request.getPassword()));
            account.setUser(user);
            account.setStatus(true);
            accountRepository.save(account);
        } catch (Exception e) {
            message="Không thể tạo tài khoản";
            success=false;
        }
        try {
             return RegisterResponse.builder()
                     .message(message)
                     .success(success)
                     .build();
        } catch (Exception e) {
            return
            RegisterResponse.builder()
                    .message("Đã xảy ra sự cố")
                    .success(false)
                    .build();
        }
    }

    public void sendSimpleMail(String to, String subject, String text){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }

    private String generateRandomPassword(){
        int length = 10;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i<length;i++){
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public void forgotPassword(String email){
        Optional<User> userOp = userRepository.findUserByEmail(email);
        if (userOp.isEmpty()){
            throw new RuntimeException("Email không tồn tại.");
        }
        User user = userOp.get();

        Optional<Account> accountOp = accountRepository.findByUser(user);
        if (accountOp.isEmpty()){
            throw new RuntimeException("Tài khoản cho email không tồn tại.");
        }
        Account account = accountOp.get();
        String newPassword = generateRandomPassword();
        account.setPassword(passwordEncoder.encode(newPassword));
        accountRepository.save(account);

        String subject = "Reset mật khẩu thành công";
        String text = "Mật khẩu mới của bạn là: " + newPassword + "\nVui lòng đăng nhập và thay đổi mật khẩu ngay lập tức.";
        sendSimpleMail(email, subject, text);
    }
}