package com.example.sys.service.impl;

import com.example.sys.entity.User;
import com.example.sys.mapper.UserMapper;
import com.example.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuanzhikong
 * @since 2021-12-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
