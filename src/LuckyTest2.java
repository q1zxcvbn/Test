

import java.util.Scanner;

public class LuckyTest2 {
	public static void main(String[] args) {
		String yn = null;
		int index = 0;
		String[] registerNames = new String[5];
		
		String[] registerPassWords = new String[5];
		String loginName=null;
		String loginPassWord=null;
		int loginIndex=-1;
		
		
		int[] cardNos = new int[5];
		do {
			System.out.println("***********欢迎进入奖客富翁系统**********");
			System.out.println("1.注册");
			System.out.println("2.登陆");
			System.out.println("3.抽奖");
			System.out.println("****************************************");
			Scanner input = new Scanner(System.in);
			System.out.println("请输入你的选择：");
			int userSelect = input.nextInt();
			switch (userSelect) {
			case 1:
				Scanner input1 = new Scanner(System.in);
				if (index < registerNames.length) {
					int sybolize=0;
					
					System.out.println("[奖客富翁系统>注册]");
					System.out.println("请填写个人注册信息：");
					System.out.println("用户名：");
					String regName = input1.next();

					System.out.println("密码：");
					String regPass = input1.next();
					for (int i = 0; i < index; i++) {

						if (regName.equals(registerNames[i])
								&&regPass.equals(registerPassWords[i])) {
							System.out.println("该用户已注册！");
							sybolize=1;
						}

					}
					if(sybolize==1){
						continue;
					}
					registerNames[index] = regName;
					registerPassWords[index] = regPass;
				
				

					System.out.println("注册成功，请记好你的会员卡号");
					System.out.println("用户名\t密码\t会员卡号");
					cardNos[index] = (int) (Math.random() * 10);
					System.out.println(registerNames[index] + "\t" + registerPassWords[index] + "\t" + cardNos[index]);
					index++;
				} else {
					System.out.println("注册失败！用户数达到最大！");
				}

				break;
			case 2:

				System.out.println("[奖客富翁系统>登录]");
				System.out.println("请输入用户名：");
				loginName=input.next();
				
				System.out.println("请输入密码：");
				loginPassWord=input.next();
				boolean flag=false;
				for (int i = 0; i < cardNos.length; i++) {
					if(loginName.equals(registerNames[i])&&loginPassWord.equals(registerPassWords[i])){
						loginIndex=i;
						flag=true;
						break;
					}
					
						
				
			}
				if (flag) {
					System.out.println("欢迎您："+loginName);	
				}
				else {
					System.out.println("您输入的用户名或密码不对！");
				}
			
					
				break;
			case 3:
				System.out.println("[奖客富翁系统>抽奖]");
		    System.out.println("你的卡号："+cardNos[loginIndex]);
				int[] luckuNums=new int[4];
				for (int i = 0; i < luckuNums.length; i++) {
					int temp=(int)(Math.random()*10);
					boolean flag2=true;
				
					for (int j = 0; j < i; j++) {
						if(temp==luckuNums[j]){
							
							flag2=false;
						}
						
					}
					if (flag2) {
						luckuNums[i]=temp;
					}
					else{
						i--;
						continue;
					}
					
				}
				System.out.print("本日的幸运数字是：");
				for (int i = 0; i < luckuNums.length; i++) {
					System.out.print(luckuNums[i]+"\t");
				}
				System.out.println();
				boolean flag1=false;
				for (int i = 0; i < luckuNums.length; i++) {
					if (cardNos[loginIndex]==luckuNums[i]) {
						 flag1=true;
						 break;
					}
				}
				if (flag1) {
					System.out.println("恭喜您，你是今日的幸运会员！");
				} else {
     System.out.println("很遗憾，你不是今日的幸运会员！");
				}
				break;

			default:
				break;
			}
			System.out.println("继续吗？(y/n)");
			yn = input.next();
		} while (yn.equals("y"));
		System.out.println("系统退出，谢谢使用！");

	}
}
