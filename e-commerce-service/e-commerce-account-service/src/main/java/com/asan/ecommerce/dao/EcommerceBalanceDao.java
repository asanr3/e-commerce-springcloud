package com.asan.ecommerce.dao;

import com.asan.ecommerce.entity.EcommerceBalance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>EcommerceBalance Dao 接口定义</h1>
 *
 * @author mingkai yun
 * @date 2022/1/18
 */
public interface EcommerceBalanceDao extends JpaRepository<EcommerceBalance, Long> {

    /**
     * 根据 userId 查询 EcommerceBalance 对象
     */
    EcommerceBalance findByUserId(Long userId);
}
