package user;

import java.util.Scanner;

import javax.swing.InputMap;

public class UserOpration {

	/**
	 * Description：创建新用户
	 * 
	 * @return UserInfo
	 */
	public UserInfo userCreate() {
		
		UserInfo user = new UserInfo();
		Scanner input = new Scanner(System.in);
		String userName;
		String userID;
		String userPassword;

		System.out.println("请输入新用户名：");
		userName = input.next();

		System.out.println("请输入新用户ID：");
		userID = input.next();
		while (true) {
			if (userCheakID(userID))
				break;
			System.out.println("ID已存在");
			System.out.println("请输入新用户ID：");
			userID = input.next();
		}

		System.out.println("请输入密码：");
		userPassword = input.next();

		user.setUserName(userName);
		user.setUserID(userID);
		user.setUserPassword(userPassword);
		user.setUserScore(0);
		
		return user;
	}

	/**
	 * Description:用户的检测
	 * 
	 * @return 成功返回true，失败返回false
	 */
	public boolean userCheak(UserInfo user) {
	
		for (int i = 0; i < ThridData.count; i++)
			if (user.getUserID().equals(ThridData.userArray[i].getUserID())&& 
				user.getUserPassword().equals(ThridData.userArray[i].getUserPassword())){
				ThridData.userInfo = ThridData.userArray[i];
				ThridData.where = i;
				return true;
			}
		return false;
	}

	/**
	 * Description:检测ID是否存在
	 * 
	 * @param ID
	 * @return 存在返回false，否则返回true
	 */
	public boolean userCheakID(String ID) {
		for (int i = 0; i < ThridData.count; i++) {
			if (ID.equals(ThridData.userArray[i].getUserID())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Description:当前用户信息显示
	 */
	public void show(UserInfo user) {
		System.out.println("当前用户名：" + user.getUserName());
		System.out.println("当前用户ID: " + user.getUserID());
		System.out.println("当前用户积分：" + user.getUserScore());
	}
}
