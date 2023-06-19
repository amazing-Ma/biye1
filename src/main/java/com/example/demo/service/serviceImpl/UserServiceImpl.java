package com.example.demo.service.serviceImpl;

import com.example.demo.eneity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void deletedById(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public User findUser(User user) {
        return  userMapper.findUser(user);
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

}
