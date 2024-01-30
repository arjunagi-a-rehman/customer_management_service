package com.example.Customer_Managment_service.mapper;

import com.example.Customer_Managment_service.dto.UserDto;
import com.example.Customer_Managment_service.model.User;

public class UserMapper {
    public static User UserDtoToUser(UserDto userDto,User user){
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setRole(userDto.getRole());
        return user;
    }
    public static UserDto UserToUserDto(User user,UserDto userDto){
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setName(user.getName());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
