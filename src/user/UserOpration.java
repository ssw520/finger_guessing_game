package user;

import java.util.Scanner;

import javax.swing.InputMap;

public class UserOpration {

	/**
	 * Description���������û�
	 * 
	 * @return UserInfo
	 */
	public UserInfo userCreate() {
		
		UserInfo user = new UserInfo();
		Scanner input = new Scanner(System.in);
		String userName;
		String userID;
		String userPassword;

		System.out.println("���������û�����");
		userName = input.next();

		System.out.println("���������û�ID��");
		userID = input.next();
		while (true) {
			if (userCheakID(userID))
				break;
			System.out.println("ID�Ѵ���");
			System.out.println("���������û�ID��");
			userID = input.next();
		}

		System.out.println("���������룺");
		userPassword = input.next();

		user.setUserName(userName);
		user.setUserID(userID);
		user.setUserPassword(userPassword);
		user.setUserScore(0);
		
		return user;
	}

	/**
	 * Description:�û��ļ��
	 * 
	 * @return �ɹ�����true��ʧ�ܷ���false
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
	 * Description:���ID�Ƿ����
	 * 
	 * @param ID
	 * @return ���ڷ���false�����򷵻�true
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
	 * Description:��ǰ�û���Ϣ��ʾ
	 */
	public void show(UserInfo user) {
		System.out.println("��ǰ�û�����" + user.getUserName());
		System.out.println("��ǰ�û�ID: " + user.getUserID());
		System.out.println("��ǰ�û����֣�" + user.getUserScore());
	}
}
