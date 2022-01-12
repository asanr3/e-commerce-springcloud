package com.asan.ecommerce.dao;

import com.asan.ecommerce.entity.EcommerceUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>EcommerceUser Dao 接口定义</h1>
 *
 * @author mingkai yun
 * @date 2022/1/12
 */
public interface EcommerceUserDao extends JpaRepository<EcommerceUser, Long> {

    /**
     * <h2>根据用户名查询 EcommerceUser 对象</h2>
     * select * from t_ecommerce_user where username = ?
     *
     * @param username 用户名
     * @return {@link EcommerceUser}
     */
    EcommerceUser findByUsername(String username);

    /**
     * <h2>根据用户名和密码查询实体对象</h2>
     * select * from t_ecommerce_user where username = ? and password = ?
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link EcommerceUser}
     */
    EcommerceUser findByUsernameAndPassword(String username, String password);
}
