package ui;

import game.PlayGame;

import java.io.IOException;
import java.util.Scanner;

import user.*;

public class Menus {

	static UserOpration uOpration = new UserOpration();

	public static void main(String[] args) throws IOException {
		menusInfo();
		ThridData.dataR();//Ĭ�϶�ȡ�����û���Ϣ
		while (true) {
			Scanner inputScanner = new Scanner(System.in);

			int select;
			select = inputScanner.nextInt();
			switch (select) {
			case 0:
				System.exit(0); //�˳�ϵͳ
			case 1:
				login(); //��½
				break;
			case 2:
				register(); //ע��
				break;
			case 33:
				ThridData.show(); //��ʾ�����û�
				break;
			case 4:
				ThridData.data(); //���������û���Ϣ
				break;
			case 55:
				ThridData.dataR(); //��ȡ�����û���Ϣ
				break;
			default:
				System.out.println("�޴�ѡ�����");
				break;
			}
			menusInfo();
		}
	}
/**
 * Description:���˵�
 */
	public static void menusInfo() {
		System.out.println("****************************");
		System.out.println("######��ӭʹ�ò�ȭ��Ϸ#######");
		System.out.println("1, ��½��  2�� ע��      0���˳�");
		System.out.println("4������������Ϣ  ");
		if (ThridData.userInfo.getUserID() != null){
			System.out.println();
			uOpration.show(ThridData.userInfo);
		}
			//System.out.println(ThridData.userInfo.getUserName());
		System.out.println("****************************");

	}
	/**
	 * Description: ��Ϸ����
	 */
	public static void gameMenus(){
		Scanner input=new Scanner(System.in);
		PlayGame playGame = new PlayGame();
		System.out.println("********************************************");
		System.out.println("\n1, ��ʼ��Ϸ 	2��������һ���� 0���˳�");
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
			System.out.println("�޴�ѡ���");
			break;
		}
		
		gameMenus();
	}
/**
 * Description����¼���ɹ��������Ϸ
 */
	public static void login() {
		Scanner input = new Scanner(System.in);

		String userID;
		String userPassword;

		System.out.println("�������û�ID��");
		userID = input.next();
		System.out.println("�������룺");
		userPassword = input.next();

		UserInfo tempInfo = new UserInfo();
		tempInfo.setUserID(userID);
		tempInfo.setUserPassword(userPassword);

		if (uOpration.userCheak(tempInfo)) {
			System.out.println("��½�ɹ���");
			gameMenus(); //������Ϸ�˵�
			return;
		} else {
			System.out.println("��½ʧ�ܣ���");
		}
	}
/**
 * Description��ע��
 */
	public static void register() {
		UserInfo temp = uOpration.userCreate();
		ThridData.userArray[ThridData.count++] = temp;
		System.out.print("ע��ɹ�\n");
	}
}
