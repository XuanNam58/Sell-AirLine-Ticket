package com.example.sell_airline_ticket.controller.admin;

import com.example.sell_airline_ticket.dto.response.CustomerResponse;
import com.example.sell_airline_ticket.service.admin.SeatService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/admin/seat-rest")
public class SeatRestController {
    SeatService seatService;
    @GetMapping("/customer-info/{flightID}/{seatID}")
    public ResponseEntity<CustomerResponse> getCustomerInfo(@PathVariable Integer flightID, @PathVariable String seatID) {
        CustomerResponse customerResponse = seatService.getCustomerInfo(flightID, seatID);
        if (customerResponse == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customerResponse);
    }

}
