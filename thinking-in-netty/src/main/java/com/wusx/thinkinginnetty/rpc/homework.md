1、集成注册中心
exporter
把所有的服务列表注册到zookeeper、nacos
/dubbo
    /interface:com.xxx
        /providers
            /ip:port
            /ip:port
        /comsumers
            /ip:port
            /ip:port

2、rapid-rpc整合spring
参考：dubbo @service
SPI