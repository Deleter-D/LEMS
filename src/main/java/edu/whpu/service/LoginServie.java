package edu.whpu.service;

import edu.whpu.pojo.User;
import org.springframework.stereotype.Service;

public interface LoginServie {
    // 认证账号信息
    public User login(String loginname, String password);
}
