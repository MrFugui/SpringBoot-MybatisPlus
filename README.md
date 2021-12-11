
## 啦啦啦啦啦，富贵同学又开始开坑了，出了个免费的专栏，主要给大家从0基础开始用springBoot集成第三方的插件或者功能，如果这篇专栏能帮到你，一定不要忘了点一个赞哦！！欢迎大家收藏分享
![在这里插入图片描述](https://img-blog.csdnimg.cn/385dc942abfc4a019d845055328814c1.png#pic_center)
**富贵同学发现好多人都不喜欢看官方文档，怕看不懂，其实我也是这样，有没有和我一样喜欢看博客而不看官方文档的。**
官方文档：
[快速开始](https://mp.baomidou.com/guide/quick-start.html#%E5%88%9D%E5%A7%8B%E5%8C%96%E5%B7%A5%E7%A8%8B)
既然这样今天给大家讲一下springboot集成mybatisplus，其实在这个前面我还写了一篇文章，是将controller层给抽取出来，只要继承了basecontrol类就可以实现增删改查，分页查询，条件查询等复杂的功能，请大家移至这篇文章上观看
[MybatisPlus不好用，帅小伙一气之下写了个MybatisPlusPro](https://blog.csdn.net/csdnerM/article/details/121565202)
## 第一步，导入jar包

```java
		<!--Mybatis-Plus-->
		<dependency>
			<groupId>com.baomidou</groupId>
			<artifactId>mybatis-plus-boot-starter</artifactId>
			<version>3.4.2</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.22</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```

## 第二步，编写dao类，其实mybatisplus很简单，就是dao层实现basemapper就可以实现增删改查了

```java
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

```

```java
对，就完了。。。。
```

## 第三步，调用他的方法

```java
package com.wangfugui.mybatisplus.service.impl;

import com.wangfugui.mybatisplus.dao.UserDao;
import com.wangfugui.mybatisplus.dao.domain.User;
import com.wangfugui.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/11
 * @since JDK 1.8.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 增
     *
     * @param user
     * @Param: [user]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    @Override
    public String insert(User user) {
        userDao.insert(user);
        return "ok";
    }

    /**
     * 改
     *
     * @param user
     * @Param: [user]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    @Override
    public String update(User user) {
        userDao.update(user,null);
        return "ok";
    }

    /**
     * 查
     *
     * @param id
     * @Param: [id]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    @Override
    public User getOne(Integer id) {
        return userDao.selectById(id);
    }

    /**
     * 删
     *
     * @param id
     * @Param: [id]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    @Override
    public String delete(Integer id) {
        userDao.deleteById(id);
        return "ok";
    }
}

```
## 第四步，controller测试

```java
import com.wangfugui.mybatisplus.dao.domain.User;
import com.wangfugui.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/11
 * @since JDK 1.8.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public String insert(@RequestBody User user) {
        return userService.insert(user);

    }


    @PostMapping("/update")
    public String update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/getOne")
    public User getOne(@RequestParam Integer id) {
        return userService.getOne(id);
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        return userService.delete(id);
    }

}

```
## 最后附上我的`“mybatispluspro”`的类：

```java

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangfugui.apprentice.common.util.ApprenticeUtil;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.dto.PageParamDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/** 核心公共controller类
 * @Param:
 * @return:
 * @Author: MaSiyi
 * @Date: 2021/11/26
 */
public class BaseController<S extends IService<E>, E> {

    @Autowired
    protected S baseService;

    @ApiOperation("增")
    @PostMapping("/insert")
    public ResponseUtils insert(@RequestBody E entity) {
        baseService.save(entity);
        return ResponseUtils.success("添加成功");
    }

    @ApiOperation("删")
    @PostMapping("/deleteById")
    public ResponseUtils delete(@RequestBody List<Integer> ids) {

        baseService.removeByIds(ids);
        return ResponseUtils.success("添加成功");
    }

    @ApiOperation("改")
    @PostMapping("/updateById")
    public ResponseUtils updateById(@RequestBody E entity) {
        baseService.updateById(entity);
        return ResponseUtils.success("添加成功");
    }

    @ApiOperation("查")
    @GetMapping("/getById")
    public ResponseUtils getById(@RequestParam Integer id) {

        return ResponseUtils.success(baseService.getById(id));
    }

    @ApiOperation("存")
    @PostMapping("/save")
    public ResponseUtils save(@RequestBody E entity) {
        baseService.saveOrUpdate(entity);
        return ResponseUtils.success("添加成功");
    }

    @ApiOperation("list查")
    @PostMapping("/list")
    public ResponseUtils list(@RequestBody E entity) {
        QueryWrapper<E> queryWrapper = ApprenticeUtil.getQueryWrapper(entity);
        List<E> list = baseService.list(queryWrapper);
        return ResponseUtils.success(list);
    }

    @ApiOperation("page查")
    @PostMapping("/page")
    public ResponseUtils page(@RequestBody PageParamDto<E> pageParamDto) {
        //限制条件
        if (pageParamDto.getPage() < 1) {
            pageParamDto.setPage(1);
        }

        if (pageParamDto.getSize() > 100) {
            pageParamDto.setSize(100);
        }
        Page<E> page = new Page<>(pageParamDto.getPage(), pageParamDto.getSize());
        QueryWrapper<E> queryWrapper = new QueryWrapper<>();
        //升序
        String asc = pageParamDto.getAsc();
        if (!StrUtil.isEmpty(asc) && !"null".equals(asc)) {
            String[] split = asc.split(",");
            queryWrapper.orderByAsc(split);
        }
        //降序
        String desc = pageParamDto.getDesc();
        if (!StrUtil.isEmpty(desc) && !"null".equals(desc)) {
            String[] split = desc.split(",");
            queryWrapper.orderByDesc(split);
        }
        Page<E> ePage = baseService.page(page, queryWrapper);
        return ResponseUtils.success(ePage);
    }

    @ApiOperation("获取数量")
    @PostMapping("/count")
    public ResponseUtils count(@RequestBody E entity) {
        QueryWrapper<E> queryWrapper = ApprenticeUtil.getQueryWrapper(entity);
        long count = baseService.count(queryWrapper);
        return ResponseUtils.success(count);
    }


}


```

好了，就是这么的简单，完整代码请移至[SpringBoot+MybatisPlus ](https://gitee.com/WangFuGui-Ma/spring-boot-kafka)查看
![在这里插入图片描述](https://img-blog.csdnimg.cn/a866736dfb41420f8d8a8484d1e9abb7.jpg?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5o6J5aS05Y-R55qE546L5a-M6LS1,size_10,color_FFFFFF,t_70,g_se,x_16#pic_center)