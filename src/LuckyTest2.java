

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
			System.out.println("***********��ӭ���뽱�͸���ϵͳ**********");
			System.out.println("1.ע��");
			System.out.println("2.��½");
			System.out.println("3.�齱");
			System.out.println("****************************************");
			Scanner input = new Scanner(System.in);
			System.out.println("���������ѡ��");
			int userSelect = input.nextInt();
			switch (userSelect) {
			case 1:
				Scanner input1 = new Scanner(System.in);
				if (index < registerNames.length) {
					int sybolize=0;
					
					System.out.println("[���͸���ϵͳ>ע��]");
					System.out.println("����д����ע����Ϣ��");
					System.out.println("�û�����");
					String regName = input1.next();

					System.out.println("���룺");
					String regPass = input1.next();
					for (int i = 0; i < index; i++) {

						if (regName.equals(registerNames[i])
								&&regPass.equals(registerPassWords[i])) {
							System.out.println("���û���ע�ᣡ");
							sybolize=1;
						}

					}
					if(sybolize==1){
						continue;
					}
					registerNames[index] = regName;
					registerPassWords[index] = regPass;
				
				

					System.out.println("ע��ɹ�����Ǻ���Ļ�Ա����");
					System.out.println("�û���\t����\t��Ա����");
					cardNos[index] = (int) (Math.random() * 10);
					System.out.println(registerNames[index] + "\t" + registerPassWords[index] + "\t" + cardNos[index]);
					index++;
				} else {
					System.out.println("ע��ʧ�ܣ��û����ﵽ���");
				}

				break;
			case 2:

				System.out.println("[���͸���ϵͳ>��¼]");
				System.out.println("�������û�����");
				loginName=input.next();
				
				System.out.println("���������룺");
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
					System.out.println("��ӭ����"+loginName);	
				}
				else {
					System.out.println("��������û��������벻�ԣ�");
				}
			
					
				break;
			case 3:
				System.out.println("[���͸���ϵͳ>�齱]");
		    System.out.println("��Ŀ��ţ�"+cardNos[loginIndex]);
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
				System.out.print("���յ����������ǣ�");
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
					System.out.println("��ϲ�������ǽ��յ����˻�Ա��");
				} else {
     System.out.println("���ź����㲻�ǽ��յ����˻�Ա��");
				}
				break;

			default:
				break;
			}
			System.out.println("������(y/n)");
			yn = input.next();
		} while (yn.equals("y"));
		System.out.println("ϵͳ�˳���ллʹ�ã�");

	}
}
