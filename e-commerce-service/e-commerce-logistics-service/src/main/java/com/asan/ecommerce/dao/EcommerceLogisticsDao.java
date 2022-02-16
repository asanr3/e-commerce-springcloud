package com.asan.ecommerce.dao;

import com.asan.ecommerce.entity.EcommerceLogistics;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>EcommerceLogistics Dao 接口定义</h1>
 *
 * @author mingkai yun
 * @date 2022/2/16
 */
public interface EcommerceLogisticsDao extends JpaRepository<EcommerceLogistics, Long> {
}
