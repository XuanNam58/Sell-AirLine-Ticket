package com.example.sell_airline_ticket.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
// Dùng để bất websocket server
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /*Dùng STOMP để:
    Xác định cách gửi thư chỉ cho nhưững người dùng đã đăng ký một chủ để cụ thể
    	cách gửi thư đến một người cụ thể*/
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }

    /*Định cấu hình nhà môi giới tin nhắn sẽ được sử dụng để
    định tuyến thư từ một khách hàng này đến ứng dụng khách khác.*/
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /*Định nghĩa rằng các thông điệp có đích bắt đầu bằng “/topic”
        nên được định tuyến tới nhà môi giới tin nhắn*/
        registry.enableSimpleBroker("/topic");
        /*Xác định rằng các thư có đích bắt đầu bằng “/app” sẽ được
        định tuyến đến các phương thức xử lý tin nhắn*/
        registry.setApplicationDestinationPrefixes("/app");
    }
}
