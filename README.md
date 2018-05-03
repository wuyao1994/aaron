# AARON
[![React](https://img.shields.io/badge/react-^16.2.0-brightgreen.svg?style=flat-square)](https://github.com/facebook/react)
[![Ant Design](https://img.shields.io/badge/ant--design-^3.0.3-yellowgreen.svg?style=flat-square)](https://github.com/ant-design/ant-design)
[![dva](https://img.shields.io/badge/dva-^2.1.0-orange.svg?style=flat-square)](https://github.com/dvajs/dva)

[![MIT](https://img.shields.io/dub/l/vibe-d.svg?style=flat-square)](http://opensource.org/licenses/MIT)

## 项目介绍
基于react + spring boot + dubbo 前后端分离开发系统架构.
演示地址 <https://tainfu.club>
## 组织结构 

```bash
aaron
├── aaron-static
|    ├── /dist/           # 项目输出目录
|    ├── /src/            # 项目源码目录
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
│    |     └── entry.ejs     
|    ├── package.json     # 项目信息
|    ├── .eslintrc        # Eslint配置
|    ├── version.js
|    ├── wepack.config.js #webpack配置
|    ├── theme.config.js  #theme配置        
|    ├── .roadhogrc.mock.js #mock        
|    └── .roadhogrc.js    # roadhog配置
├── common -- SSM框架公共模块
└── upms -- 用户权限管理系统
     ├── upms-common -- upms系统公共模块
     ├── upms-dao -- 代码生成模块，无需开发
     ├── upms-rpc-api -- rpc接口包
     ├── upms-rpc-service -- rpc服务提供者
     └── upms-server -- 用户权限系统及SSO服务端
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
## 环境搭建
Mysql5.7+  
Zookeeper  
Node  
Java1.8  
Redis  
## 快速开始
本机安装Jdk1.8、Mysql、Redis、Zookeeper并**启动相关服务**，使用默认配置默认端口即可  
**推荐使用IntelliJ IDEA**，本地编译并安装到本地maven仓库  
克隆项目文件:
```bash
git clone https://github.com/wuyao1994/aaron.git
```

安装依赖:
前端：
```bash
#开始前请确保没有安装roadhog、webpack到NPM全局目录
npm i 或者 yarn install
```
后台：
```bash
根据 pom.xml 配置下载 maven 依赖包
```
构建项目
前端：
```bash
npm run build
```
后台：
```bash
mvn clean install
```
开发
前端
```bash
npm run build:dll #第一次npm run dev时需运行此命令，使开发时编译更快
npm run dev
```
后台:
```bash
直接运行 com.upms.rpc.service.UpmsRpcServiceApplication和com.upms.server.UpmsServerApplication main()方法启动后台服务
启动顺序，先启动upm-rpc-service,再启动upm-server
```
访问：
```bash
打开 http://localhost:8000
```
## 服务器部署
前端, 使用nginx代理指向dist目录  
参考配置
```bash
     server{
                listen       80;
                server_name 111.231.191.63;
                 root  /home/xxx/workspace/aaron/aaron-static/dist;
                 gzip on;
                 gzip_buffers 32 4k;
                 gzip_comp_level 6;
                 gzip_min_length 200;
                 gzip_types text/css text/xml application/javascript;
                 gzip_vary on;
 
                 location /api {
                           proxy_pass http://localhost:8000/api;
                 }
  
                 location / {
                                 index  index.html;
                                 try_files $uri $uri/ /index.html;
                 }
         }

```
后台
```bash
java -jar upms-rpc-service-1.0.0.jar
java -jar upms-server-1.0.0.jar
```


## 参考项目资料

| 项目 |  官网 |
| ------------- | ----- |
| zheng | [https://github.com/shuzheng/zheng](https://github.com/shuzheng/zheng/ "https://github.com/shuzheng/zheng") | 
| antd-admin | [https://github.com/zuiidea/antd-admin](https://github.com/zuiidea/antd-admin "https://github.com/zuiidea/antd-admin") |
