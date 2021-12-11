package com.wangfugui.mybatisplus.service;

import com.wangfugui.mybatisplus.dao.domain.User;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/11
 * @since JDK 1.8.0
 */
public interface UserService {
    /** 增
     * @Param: [user]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    String insert(User user);

    /** 改
     * @Param: [user]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    String update(User user);

    /** 查
     * @Param: [id]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    User getOne(Integer id);

    /** 删
     * @Param: [id]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    String delete(Integer id);
}
