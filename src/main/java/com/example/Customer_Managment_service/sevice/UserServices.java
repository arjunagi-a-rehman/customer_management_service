package com.example.Customer_Managment_service.sevice;

import com.example.Customer_Managment_service.dto.UserDto;
import com.example.Customer_Managment_service.mapper.UserMapper;
import com.example.Customer_Managment_service.mapper.UserToUserDetails;
import com.example.Customer_Managment_service.model.User;
import com.example.Customer_Managment_service.repo.IUserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
@NoArgsConstructor
public class UserServices {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private PasswordEncoder encoder;
    public void registerUser(UserDto userDto) {
        User user= UserMapper.UserDtoToUser(userDto,new User());
        user.setPassword(encoder.encode(user.getPassword()));
        if(userRepo.findByEmail(user.getEmail()).isPresent())throw new RuntimeException("email "+user.getEmail()+" already exist");
        userRepo.save(user);
    }


}
