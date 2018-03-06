# springboot-jfinal-activerecord-boilerplate

## 项目说明

jfinal的`ActiveRecordPlugin`非常好用，所以将其集成到spring-boot中，但是集成之后，却不能支持
spring的声明式事务，于是稍微修改了jfinal的代码，使其支持spring的声明式事务。

lib目录下的jfinal-2.4.jar就是修改后的jfinal源码打成的Jar。
