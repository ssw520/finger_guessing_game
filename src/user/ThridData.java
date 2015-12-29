package user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;

public class ThridData {

	//public static UserInfo userInfo = new UserInfo();
	public static UserInfo userInfo ;//空的，设置一个当前用户

	public static UserInfo[] userArray = new UserInfo[200];

	public static int count = 0;

	public static int where;
/**
 * Description：输出所有用户信息
 */
	public static void show() {
		for (int i = 0; i < count; i++) {
			System.out.println("用户名：" + userArray[i].getUserID() + "  积分： "
					+ userArray[i].getUserScore());
		}
	}
/**
 * Description:存文件数据
 */
	public static void data() {
		String fileName = "Data.data";
		try {
			File dataFile = new File(fileName);
			if (!dataFile.exists()) {
				dataFile.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(dataFile);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for (int i = 0; userArray[i] != null; i++)
				printWriter.println(userArray[i].getUserName() + " "
						+ userArray[i].getUserID() + " "
						+ userArray[i].getUserPassword() + " "
						+ userArray[i].getUserScore());
			fileWriter.close();
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO: handle exception
		}

	}
/**
 * Description:读取文件数据
 * @throws IOException
 */
	public static void dataR() throws IOException {
		String fileName = "Data.data";
		File dataFile = new File(fileName);
		BufferedReader bufferedReader = null;
		try {
			if (!dataFile.exists()) {
				dataFile.createNewFile();
			}

			bufferedReader = new BufferedReader(new FileReader(dataFile));
			String s;
			while ((s = bufferedReader.readLine())!=null) {

				String tempName = new String();
				String tempID = new String();
				String tempPass = new String();
				int tempScore = 0;
				String[] temp = s.split(" ");
				tempScore = Integer.parseInt(temp[3]);
				
				UserInfo u = new UserInfo();
				u.setUserName(temp[0]);
				u.setUserID(temp[1]);
				u.setUserPassword(temp[2]);
				u.setUserScore(tempScore);
				userArray[count++] = u;
				
				
			}
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO: handle exception
		} finally {
			if(bufferedReader != null)
			bufferedReader.close();
		//	outputStream.close();
		}

	}
}
