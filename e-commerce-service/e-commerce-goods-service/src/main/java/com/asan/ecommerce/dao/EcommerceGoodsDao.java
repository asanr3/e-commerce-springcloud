package com.asan.ecommerce.dao;


import com.asan.ecommerce.constant.BrandCategory;
import com.asan.ecommerce.constant.GoodsCategory;
import com.asan.ecommerce.entity.EcommerceGoods;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * <h1>EcommerceGoods Dao 接口定义</h1>
 * PagingAndSortingRepository支持分页和排序
 *
 * @author mingkai yun
 * @date 2022/1/20
 */
public interface EcommerceGoodsDao extends PagingAndSortingRepository<EcommerceGoods, Long> {

    /**
     * <h2>根据查询条件查询商品表, 并限制返回结果</h2>
     * select * from t_ecommerce_goods where goods_category = ? and brand_category = ?
     * and goods_name = ? limit 1;
     *
     * @param goodsCategory 商品分类
     * @param brandCategory 品牌类别
     * @param goodsName     商品名称
     */
    Optional<EcommerceGoods> findFirst1ByGoodsCategoryAndBrandCategoryAndGoodsName(
            GoodsCategory goodsCategory, BrandCategory brandCategory,
            String goodsName
    );
}
