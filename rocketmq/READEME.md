# 启动 nameservice 命令
```
windows:
.\bin\mqnamesrv.cmd  --> 需配置rocketMQ 的环境变量
linux:
nohup sh bin/mqnamesrv & tail -f ~/logs/rocketmqlogs/namesrv.log
```
# 启动broker 
```
windows: 
.\bin\mqbroker.cmd -n localhost:9876 autoCreateTopicEnable=true -->自动创建topic
linux:
nohup sh bin/mqbroker -n localhost:9876 & tail -f ~/logs/rocketmqlogs/broker.log 
```
# linux 关闭 nameserver broker
```
sh bin/mqshutdown broker
sh bin/mqshutdown namesrv
```
# 注意
发送或者消费消息时， 所依赖的rocketmq jar 必须和rocketmq 版本一致

