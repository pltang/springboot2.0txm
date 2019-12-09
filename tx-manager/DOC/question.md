5.0.2版本的严重问题
1.目前只支持8次重连尝试,超过需要重启服务
  建议:每次先启动tx-Manager
  解决:修改tx-Manager的代码
2.如果你想在SpringCloud项目中使用ThreadLocal就需要调整你的Hystrix隔离策略为Semaphore或关闭你Feign服务的Hystrix功能。