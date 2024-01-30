package com.example.Customer_Managment_service.sevice;

import com.example.Customer_Managment_service.dto.UserDto;
import com.example.Customer_Managment_service.mapper.UserMapper;
import com.example.Customer_Managment_service.mapper.UserToUserDetails;
import com.example.Customer_Managment_service.model.User;
import com.example.Customer_Managment_service.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SrcurityUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user=userRepo.findByEmail(email);
        return user.map(UserToUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found with email "+email));
    }
}