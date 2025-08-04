package com.think41.interview.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.think41.interview.model.UsersModel;
import com.think41.interview.repository.OrderRepository;
import com.think41.interview.repository.UserRepository;
import com.think41.interview.dto.UserResponseDTO;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        try{
            Optional<UsersModel> userOpt = usersRepository.findById(id);
            if (userOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Customer not found"));
            }

            UsersModel user = userOpt.get();
            UserResponseDTO dto = new UserResponseDTO();
            dto.id = user.getId();
            dto.firstName = user.getFirstName();
            dto.lastName = user.getLastName();
            dto.email = user.getEmail();
            dto.age = user.getAge();
            dto.gender = user.getGender();
            dto.city = user.getCity();
            dto.country = user.getCountry();
            dto.createdAt = user.getCreatedAt();
            dto.orderCount = orderRepository.countByUserId(user.getId());

            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Internal Server Error"));
        }
}

    @GetMapping("/get/all")
public ResponseEntity<?> getAllCustomers(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
    try {
        Pageable pageable = PageRequest.of(page, size);
        Page<UsersModel> userPage = usersRepository.findAll(pageable);

        List<UserResponseDTO> userDTOs = userPage.getContent().stream().map(user -> {
            UserResponseDTO dto = new UserResponseDTO();
            dto.id = user.getId();
            dto.firstName = user.getFirstName();
            dto.lastName = user.getLastName();
            dto.email = user.getEmail();
            dto.age = user.getAge();
            dto.gender = user.getGender();
            dto.city = user.getCity();
            dto.country = user.getCountry();
            dto.createdAt = user.getCreatedAt();
            dto.orderCount = orderRepository.countByUserId(user.getId());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(userDTOs);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of(
                "error", "Failed to fetch customers",
                "details", e.getMessage()
            ));
    }
}
    
    
}
