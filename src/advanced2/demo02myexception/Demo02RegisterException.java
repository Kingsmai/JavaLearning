﻿package advanced2.demo02myexception;

import java.util.Scanner;

/*
 * 要求：我们模拟注册操作，如果用户名已存在，则抛出异常提示：亲，该用户名已被注册
 * 
 * 分析：
 *     1. 使用数组保存已经注册过的用户名（数据库）
 *     2. 使用Scanner获取用户输入的注册的用户名（前端，页面）
 *     3. 定义一个方法，对用户输入的注册的用户名进行判断
 *         3.1. 遍历存储已经注册过用户名的数组，获取每一个用户名
 *         3.2. 使用获取到的用户名和用户输入的用户名比较
 *             true：
 *                 用户名已经存在，抛出RegisterException异常，告知用户“亲，该用户名已被注册”
 *             false：
 *                 继续遍历比较
 *         3.3. 如果循环结束了，还没有找到重复的用户名，提示用户“恭喜您注册成功”
 */
public class Demo02RegisterException {

	static String[] usernames = {"张三", "李四", "王五"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要注册的用户名：");
		String username = sc.next();
		checkUsername(username);
	}
	
	public static void checkUsername(String username) {
		for (String name : usernames) {
			if(name.equals(username)) {
				throw new RegisterException("该用户已经被注册"); // 抛出运行期异常，无序处理，交给JVM处理 -> 中断处理
			}
		}
		System.out.println("恭喜您注册成功");
	}
}
