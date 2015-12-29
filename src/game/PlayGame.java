package game;

import java.util.Scanner;

public class PlayGame {
	
	/*
	 * flag[0][1]//第一个人石头第二个人剪刀
	 */
	
/**
 * Description：游戏
 * @return int 积分
 */
	public  int  play() {
		int[][] flag = { { 0, 1, -1 }, { -1, 0, 1 }, { 1, -1, 0 } };
		int n=0;
		int ComputerCount = 0;
		int PeopleCount = 0;
		System.out.println("游戏规则：玩三局，电脑赢扣1分，玩家赢得1分，平局不扣也不加分");
		while (n < 3) {
			n++;
			Scanner inputScanner= new Scanner(System.in);
			System.out.println("\n请选择：0,石头       1，剪刀      2，布");
			int people = inputScanner.nextInt();
			/**
			 * 玩家的选择
			 */
			System.out.print("你的选择是：");
			switch (people) {
			case 0:
				System.out.print("石头");
				break;

			case 1:
				System.out.print("剪刀");
				break;
			case 2:
				System.out.print("布");
				break;
			}
		/**
		 * 电脑的选择
		 */
			System.out.print("\n电脑随机出： ");
			int computer = (int) (Math.random() * 3);
			switch (computer) {
			case 0:
				System.out.print("石头");
				break;

			case 1:
				System.out.print("剪刀");
				break;
			case 2:
				System.out.print("布");
				break;
			}	
			/**
			 * 判断谁赢
			 */
			System.out.print("\n第"+n+"局: ");
			switch (flag[people][computer]) {
			case 0:
				System.out.println("平局");
				break;

			case 1:
				System.out.println("玩家赢");
				PeopleCount++;
				break;
			case -1:
				System.out.println("电脑赢");
				ComputerCount++;
				break;
			}
			
			
		}
		if(PeopleCount > ComputerCount) return 1;
		if(PeopleCount < ComputerCount) return -1;
		return 0;
 	}
	
}
