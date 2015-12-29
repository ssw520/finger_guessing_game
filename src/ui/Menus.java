package ui;

import game.PlayGame;

import java.io.IOException;
import java.util.Scanner;

import user.*;

public class Menus {

	static UserOpration uOpration = new UserOpration();

	public static void main(String[] args) throws IOException {
		menusInfo();
		ThridData.dataR();//默认读取本地用户信息
		while (true) {
			Scanner inputScanner = new Scanner(System.in);

			int select;
			select = inputScanner.nextInt();
			switch (select) {
			case 0:
				System.exit(0); //退出系统
			case 1:
				login(); //登陆
				break;
			case 2:
				register(); //注册
				break;
			case 33:
				ThridData.show(); //显示所有用户
				break;
			case 4:
				ThridData.data(); //保存所有用户信息
				break;
			case 55:
				ThridData.dataR(); //读取本地用户信息
				break;
			default:
				System.out.println("无此选项！！！");
				break;
			}
			menusInfo();
		}
	}
/**
 * Description:主菜单
 */
	public static void menusInfo() {
		System.out.println("****************************");
		System.out.println("######欢迎使用猜拳游戏#######");
		System.out.println("1, 登陆，  2， 注册      0，退出");
		System.out.println("4，保存所有信息  ");
		if (ThridData.userInfo.getUserID() != null){
			System.out.println();
			uOpration.show(ThridData.userInfo);
		}
			//System.out.println(ThridData.userInfo.getUserName());
		System.out.println("****************************");

	}
	/**
	 * Description: 游戏界面
	 */
	public static void gameMenus(){
		Scanner input=new Scanner(System.in);
		PlayGame playGame = new PlayGame();
		System.out.println("********************************************");
		System.out.println("\n1, 开始游戏 	2，返回上一级， 0，退出");
		System.out.println("********************************************");
		int key = input.nextInt();
		
		switch (key) {
		case 0:
			System.exit(0);
		case 1:
			ThridData.userInfo.setUserScore(ThridData.userInfo.getUserScore()+playGame.play());
			ThridData.userArray[ThridData.where] = ThridData.userInfo;
			uOpration.show(ThridData.userInfo);
			break;
		case 2:
			return ;

		default:
			System.out.println("无此选项！！");
			break;
		}
		
		gameMenus();
	}
/**
 * Description：登录，成功后进入游戏
 */
	public static void login() {
		Scanner input = new Scanner(System.in);

		String userID;
		String userPassword;

		System.out.println("请输入用户ID：");
		userID = input.next();
		System.out.println("输入密码：");
		userPassword = input.next();

		UserInfo tempInfo = new UserInfo();
		tempInfo.setUserID(userID);
		tempInfo.setUserPassword(userPassword);

		if (uOpration.userCheak(tempInfo)) {
			System.out.println("登陆成功！");
			gameMenus(); //进入游戏菜单
			return;
		} else {
			System.out.println("登陆失败！！");
		}
	}
/**
 * Description：注册
 */
	public static void register() {
		UserInfo temp = uOpration.userCreate();
		ThridData.userArray[ThridData.count++] = temp;
		System.out.print("注册成功\n");
	}
}
