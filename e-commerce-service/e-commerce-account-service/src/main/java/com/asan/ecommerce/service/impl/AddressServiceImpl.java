package com.asan.ecommerce.service.impl;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.account.AddressInfo;
import com.asan.ecommerce.common.TableId;
import com.asan.ecommerce.dao.EcommerceAddressDao;
import com.asan.ecommerce.entity.EcommerceAddress;
import com.asan.ecommerce.filter.AccessContext;
import com.asan.ecommerce.service.IAddressService;
import com.asan.ecommerce.vo.LoginUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>用户地址相关服务接口实现</h1>
 *
 * @author mingkai yun
 * @date 2022/1/18
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class AddressServiceImpl implements IAddressService {

    private final EcommerceAddressDao addressDao;

    public AddressServiceImpl(EcommerceAddressDao addressDao) {
        this.addressDao = addressDao;
    }

    /**
     * <h2>创建用户地址信息</h2>
     *
     * @param addressInfo 用户地址信息
     * @return {@link TableId}
     */
    @Override
    public TableId createAddressInfo(AddressInfo addressInfo) {
        // 不能直接从参数中获取用户的 id 信息，防止数据包被修改导致出问题
        LoginUserInfo loginUserInfo = AccessContext.getLoginUserInfo();

        // 将传递的参数转换成实体对象
        List<EcommerceAddress> ecommerceAddresses = addressInfo.getAddressItems().stream()
                .map(a -> EcommerceAddress.to(loginUserInfo.getId(), a))
                .collect(Collectors.toList());

        // 保存到数据表并把返回记录的 id 给调用方
        List<EcommerceAddress> savedRecords = addressDao.saveAll(ecommerceAddresses);
        List<Long> ids = savedRecords.stream()
                .map(EcommerceAddress::getId).collect(Collectors.toList());
        log.info("create address info: [{}], [{}]", loginUserInfo.getId(),
                JSON.toJSONString(ids));

        return new TableId(
                ids.stream().map(TableId.Id::new).collect(Collectors.toList())
        );
    }

    /**
     * <h2>获取当前登录的用户地址信息</h2>
     *
     * @return {@link AddressInfo}
     */
    @Override
    public AddressInfo getCurrentAddressInfo() {
        LoginUserInfo loginUserInfo = AccessContext.getLoginUserInfo();

        // 根据 userId 查询到用户的地址信息, 再实现转换
        List<EcommerceAddress> ecommerceAddresses = addressDao.findAllByUserId(
                loginUserInfo.getId()
        );
        List<AddressInfo.AddressItem> addressItems = ecommerceAddresses.stream()
                .map(EcommerceAddress::toAddressItem)
                .collect(Collectors.toList());

        return new AddressInfo(loginUserInfo.getId(), addressItems);
    }

    /**
     * <h2>通过 id 获取用户地址信息, </h2>
     *
     * @param id EcommerceAddress 表的主键
     * @return {@link AddressInfo}
     */
    @Override
    public AddressInfo getAddressInfoById(Long id) {
        EcommerceAddress ecommerceAddress = addressDao.findById(id).orElse(null);
        if (null == ecommerceAddress) {
            throw new RuntimeException("address is not exist");
        }

        return new AddressInfo(
                ecommerceAddress.getUserId(),
                Collections.singletonList(ecommerceAddress.toAddressItem())
        );
    }

    /**
     * <h2>通过 TableId 获取用户地址信息</h2>
     *
     * @param tableId 主键ID
     * @return {@link AddressInfo}
     */
    @Override
    public AddressInfo getAddressInfoByTableId(TableId tableId) {
        List<Long> ids = tableId.getIds().stream()
                .map(TableId.Id::getId).collect(Collectors.toList());
        log.info("get address info by table id: [{}]", JSON.toJSONString(ids));

        List<EcommerceAddress> ecommerceAddresses = addressDao.findAllById(ids);
        if (CollectionUtils.isEmpty(ecommerceAddresses)) {
            return new AddressInfo(-1L, Collections.emptyList());
        }

        List<AddressInfo.AddressItem> addressItems = ecommerceAddresses.stream()
                .map(EcommerceAddress::toAddressItem)
                .collect(Collectors.toList());

        return new AddressInfo(
                ecommerceAddresses.get(0).getUserId(), addressItems
        );
    }
}
