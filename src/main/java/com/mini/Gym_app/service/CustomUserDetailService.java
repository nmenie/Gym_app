package com.mini.Gym_app.service;

import com.mini.Gym_app.domain.Customer;
import com.mini.Gym_app.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class CustomUserDetailService implements UserDetailsService {

    private final CustomerRepository  customerRepository;

    public CustomUserDetailService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Username not found with:" + email));

        return new User (customer.getEmail(), customer.getPassword(), Collections.emptyList());
    }
}
