# AARON
[![React](https://img.shields.io/badge/react-^16.2.0-brightgreen.svg?style=flat-square)](https://github.com/facebook/react)
[![Ant Design](https://img.shields.io/badge/ant--design-^3.0.3-yellowgreen.svg?style=flat-square)](https://github.com/ant-design/ant-design)
[![dva](https://img.shields.io/badge/dva-^2.1.0-orange.svg?style=flat-square)](https://github.com/dvajs/dva)

[![MIT](https://img.shields.io/dub/l/vibe-d.svg?style=flat-square)](http://opensource.org/licenses/MIT)

## 项目介绍
基于react + spring boot + spring cloud开发系统架构
## 组织结构
    ``` lua
aaron
├── aaron-static
|    ├── /dist/           # 项目输出目录
     ├── /src/            # 项目源码目录
│    |     ├── /public/       # 公共文件，编译时copy至dist目录
│    |     ├── /components/   # UI组件及UI相关方法
│    |     ├── /routes/       # 路由组件
│    |     |     └── app.js       # 路由入口
│    |     ├── /models/       # 数据模型
│    |     ├── /services/     # 数据接口
│    |     ├── /themes/       # 项目样式
│    |     ├── /mock/         # 数据mock
│    |     ├── /utils/        # 工具函数
│    |     |      ├── config.js    # 项目常规配置
│    │     |      ├── menu.js      # 菜单及面包屑配置
│    │     |      ├── config.js    # 项目常规配置
│    │     |      ├── request.js   # 异步请求函数
│    │     |      └── theme.js     # 项目需要在js中使用到样式变量
│    |     ├── route.js       # 路由配置
│    |     ├── index.js       # 入口文件
│    |     └── index.html     
|    ├── package.json     # 项目信息
|    ├── .eslintrc        # Eslint配置
|    └── .roadhogrc.js    # roadhog配置
├── common -- SSM框架公共模块
├── upms -- 用户权限管理系统
|    ├── upms-common -- upms系统公共模块
|    ├── upms-dao -- 代码生成模块，无需开发
|    ├── upms-rpc-api -- rpc接口包
|    ├── upms-rpc-service -- rpc服务提供者
|    └── upms-server -- 用户权限系统及SSO服务端
```
## 技术选型

### 前端技术：

| 技术 |  官网 |
| ------------- | ----- |
| react | [https://reactjs.org/](https://reactjs.org/ "https://reactjs.org/") | 
| redux | [http://redux.js.org/](http://redux.js.org/ "http://redux.js.org/")
| Ant Design | [https://ant.design/index-cn](https://ant.design/index-cn "https://ant.design/index-cn")|

### 后端技术：
| 技术 | 官网 |
| ------------- | ----- |
| spring boot | [http://projects.spring.io/spring-boot/](http://projects.spring.io/spring-boot/ "http://projects.spring.io/spring-boot/") |
| spring cloud | [http://projects.spring.io/spring-cloud/](http://projects.spring.io/spring-cloud/ "http://projects.spring.io/spring-cloud/") |
| dubbo | [https://github.com/apache/incubator-dubbo](https://github.com/apache/incubator-dubbo/ "https://github.com/apache/incubator-dubbo/") |

## 参考项目资料

| 项目 |  官网 |
| ------------- | ----- |
| zheng | [https://github.com/shuzheng/zheng](https://github.com/shuzheng/zheng/ "https://github.com/shuzheng/zheng") | 
| antd-admin | [https://github.com/zuiidea/antd-admin](https://github.com/zuiidea/antd-admin "https://github.com/zuiidea/antd-admin") |
