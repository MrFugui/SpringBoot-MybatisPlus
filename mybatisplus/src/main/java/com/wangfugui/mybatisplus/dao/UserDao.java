package com.wangfugui.mybatisplus.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangfugui.mybatisplus.dao.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/11
 * @since JDK 1.8.0
 */
@Repository
public interface UserDao extends BaseMapper<User> {
}
