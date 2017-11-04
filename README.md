# pandafertService
配料系统的服务器，包含一个简单的后台数据管理系统


## 使用方式
- 方式1:使用eclipse创建dynamic web project，然后导出为war部署至tomcat服务器
- 方式2:使用编译工具将java编译为对应的class文件，然后存至WEB-INF/classes下,将webContent部署至服务器

## 注意事项
- 数据库链接地址在c3p0-config.xml中修改

## 功能介绍

### app端功能描述

- 注册登录	
- 配肥	
- 查询正在配置订单	
- 查询配置完成的订单	
- 查询个人信息

### zigbee端功能描述

- 查询ordering订单
- 完成订单向服务器报告

### 管理员功能

- 登录	
- 注册	
- 删除记录	
- 增加记录	
- 修改记录	
- 查阅所有记录

- 详细描述请参见index.html
