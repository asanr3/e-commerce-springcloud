# e-commerce-springcloud
使用 SpringCloud 微服务开发框架，SpringCloud Alibaba 套件落地实践的电商微服务系统

## 开发环境（中间件的版本都是最新的）
  Windows、idea、MySQL5.7、Redis、kafka、zipkin server、nacos server、sentinel server、seata server
  
## 工程目录（http文件夹放的是功能服务请求的脚本，sql文件夹放的是工程需要的数据表脚本）
```
├─e-commerce-springcloud
│  ├─e-commerce-admin  --监控中心服务
│  ├─e-commerce-alibaba-nacos-client  --功能验证服务（和整个系统无关，作为一些功能的验证作用）
│  ├─e-commerce-authority-center --授权中心服务
│  ├─e-commerce-common --整个系统的公共模块
│  ├─e-commerce-gateway --网关服务
│  ├─e-commerce-hystrix-dashboard --hystrix熔断降级服务
│  ├─e-commerce-mvc-config --整个系统的公共配置模块
│  ├─e-commerce-sentinel-client --限流服务
│  ├─e-commerce-service --功能微服务父目录
│  │  ├─e-commerce-account-service --用户账户微服务（提供查看、创建用户地址功能，查看当前用户余额、扣减余额功能）
│  │  ├─e-commerce-goods-service --商品微服务（提供商品入库、查看商品详情信息、简单商品信息、扣减商品库存功能）
│  │  ├─e-commerce-logistics-service --物流微服务（提供订阅监听订单微服务发送的物流消息并入库功能）
│  │  ├─e-commerce-order-service --订单微服务（提供创建订单、查询订单信息功能）
│  │  ├─e-commerce-service-config --功能微服务公共配置模块
│  │  └─e-commerce-service-sdk --功能微服务的SDK模块（微服务之间传递的实体对象）
│  └─e-commerce-stream-client --SpringCloud Stream 消息驱动微服务（主要是将物流消息推送给物流服务）

```
