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
cat /proc/sys/fs/file-max #查看系统级的最大限制
cat /proc/$pid/limits
ll /proc/$pid/fd | wc -l #查看打开文件句柄数
ulimit -a
vim /etc/security/limits.conf
* soft nofile 65535  
用户名 hard nofile 65535 
#突破全局文件句柄限制

#linux内核参数
vim /etc/sysctl.conf
net.ipv4.tcp_syncookies = 1
net.ipv4.tcp_tw_reuse = 1
net.ipv4.tcp_tw_recycle = 1
net.ipv4.tcp_fin_timeout = 30
net.ipv4.tcp_keepalive_time = 1200
net.ipv4.ip_local_port_range = 1024 65000
net.ipv4.tcp_max_syn_backlog = 8192
net.ipv4.ip_conntrack_max = 655360
net.ipv4.netfilter.ip_conntrack_tcp_timeout_established = 180
/sbin/sysctl -p让参数生效

#查看端口状态
netstat -ntp | grep 8000
netstat -s | grep "SYNs to LISTEN"
ss -ltn
netstat -s | grep "listen queue"
```
2、netty整合ssl，客户端和服务端互调

3、c语言客户端

4、go语言服务端

5、netty-starter