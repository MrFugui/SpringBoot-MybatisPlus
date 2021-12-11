package com.wangfugui.mybatisplus.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.Date;

/**
 * @author masiyi
 * @version 1.0.0 2021/12/11
 * @since jdk 1.8.0
 */
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private Integer age;

    private Date createTime;


}
