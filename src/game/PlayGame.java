package game;

import java.util.Scanner;

public class PlayGame {
	
	/*
	 * flag[0][1]//��һ����ʯͷ�ڶ����˼���
	 */
	
/**
 * Description����Ϸ
 * @return int ����
 */
	public  int  play() {
		int[][] flag = { { 0, 1, -1 }, { -1, 0, 1 }, { 1, -1, 0 } };
		int n=0;
		int ComputerCount = 0;
		int PeopleCount = 0;
		System.out.println("��Ϸ���������֣�����Ӯ��1�֣����Ӯ��1�֣�ƽ�ֲ���Ҳ���ӷ�");
		while (n < 3) {
			n++;
			Scanner inputScanner= new Scanner(System.in);
			System.out.println("\n��ѡ��0,ʯͷ       1������      2����");
			int people = inputScanner.nextInt();
			/**
			 * ��ҵ�ѡ��
			 */
			System.out.print("���ѡ���ǣ�");
			switch (people) {
			case 0:
				System.out.print("ʯͷ");
				break;

			case 1:
				System.out.print("����");
				break;
			case 2:
				System.out.print("��");
				break;
			}
		/**
		 * ���Ե�ѡ��
		 */
			System.out.print("\n����������� ");
			int computer = (int) (Math.random() * 3);
			switch (computer) {
			case 0:
				System.out.print("ʯͷ");
				break;

			case 1:
				System.out.print("����");
				break;
			case 2:
				System.out.print("��");
				break;
			}	
			/**
			 * �ж�˭Ӯ
			 */
			System.out.print("\n��"+n+"��: ");
			switch (flag[people][computer]) {
			case 0:
				System.out.println("ƽ��");
				break;

			case 1:
				System.out.println("���Ӯ");
				PeopleCount++;
				break;
			case -1:
				System.out.println("����Ӯ");
				ComputerCount++;
				break;
			}
			
			
		}
		if(PeopleCount > ComputerCount) return 1;
		if(PeopleCount < ComputerCount) return -1;
		return 0;
 	}
	
}
