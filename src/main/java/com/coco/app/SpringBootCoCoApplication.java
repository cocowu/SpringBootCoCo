package com.coco.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCoCoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoCoApplication.class, args);
	}

}


/*
 * Spring Boot 学习工程
 * 
 * 1.首先安装STS插件，参考 https://blog.csdn.net/pavel101/article/details/79314208/
 *   相关安装包已下载，放于 java8eclipse 目录中。
 * 
 * 2.创建 Spring Boot 工程
 *   New -> 选择Spring -> 选择 Spring Starter Project，本工程初始只选择了 spring web starter 依赖。
 * 
 * 3.第一次运行
 *   选中本文件，右键 Run As ... Spring Boot App 或 Java Application
 * 
 * */

/*
 * 采用 github 同步本工程
 * https://github.com/    用户：wmc_zd@foxmail.com
 * 参考网页 ： https://www.cnblogs.com/r360/p/4931432.html
 * 
 * 1. github 网站创建新仓库。
 * 
 * 2. 安装Git后，在 GitBash中运行  ssh-keygen -t rsa -C "wmc_zd@foxmail.com"， c/Users/dell/.ssh/id_rsa
 *    参考：https://blog.csdn.net/baidu_30809315/article/details/76687063
 * 
 * 3. github 网站添加生成的 SSH 公钥
 * 
 * 4. Git GUI commit 再强制 push 成功
 * 
 * 5. Eclipse 中使用 Git
 *    参考：https://www.cnblogs.com/wangshouchang/p/6219833.html
 *    Eclipse 已安装 EGit 插件
 * */
