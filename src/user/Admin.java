package user;




public class Admin {
		
		public static void main(String[] args){
			UserInfo[] userArray = new UserInfo[10];
			UserInfo[] userArrayss = new UserInfo[10];
			Data  data = new Data();
			
			userArray[0] = new UserInfo();
			userArray[0].setUserName("admin");
			userArray[0].setUserID("admin");
			userArray[0].setUserPassword("admin");
			userArray[0].setUserGrade(5);
			userArray[0].setUserScore(10000);
			
			userArray[1] = new UserInfo();
			userArray[1].setUserName("admin");
			userArray[1].setUserID("admin");
			userArray[1].setUserPassword("admin");
			userArray[1].setUserGrade(5);
			userArray[1].setUserScore(10000);
			
			data.delUser(userArray, "admin");
			data.show(userArray[0]);
			data.show(userArray[1]);
			
		
			
		}
}
