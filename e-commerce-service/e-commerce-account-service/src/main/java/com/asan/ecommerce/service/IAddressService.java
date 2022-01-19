package com.asan.ecommerce.service;

import com.asan.ecommerce.account.AddressInfo;
import com.asan.ecommerce.common.TableId;

/**
 * <h1>用户地址相关服务接口定义</h1>
 *
 * @author mingkai yun
 * @date 2022/1/18
 */
public interface IAddressService {

    /**
     * <h2>创建用户地址信息</h2>
     *
     * @param addressInfo 用户地址信息
     * @return {@link TableId}
     */
    TableId createAddressInfo(AddressInfo addressInfo);

    /**
     * <h2>获取当前登录的用户地址信息</h2>
     *
     * @return {@link AddressInfo}
     */
    AddressInfo getCurrentAddressInfo();

    /**
     * <h2>通过 id 获取用户地址信息, </h2>
     *
     * @param id EcommerceAddress 表的主键
     * @return {@link AddressInfo}
     */
    AddressInfo getAddressInfoById(Long id);

    /**
     * <h2>通过 TableId 获取用户地址信息</h2>
     *
     * @param tableId 主键ID
     * @return {@link AddressInfo}
     */
    AddressInfo getAddressInfoByTableId(TableId tableId);
}
