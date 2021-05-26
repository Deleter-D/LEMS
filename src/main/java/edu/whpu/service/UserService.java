package edu.whpu.service;

import edu.whpu.pojo.User;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> getUserList();
}
