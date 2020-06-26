1、单机百万连接调优
```shell script
#模拟机器
client 4核8G
server 4核8G
#模拟百万连接
server 多端口 8000-8100
client 端口 1025-65535 约6w
连接总数 约100*6w
#突破局部（单进程）文件句柄限制

#突破全局文件句柄限制


```
2、netty整合ssl，客户端和服务端互调

3、c语言客户端

4、go语言服务端

5、netty-starter