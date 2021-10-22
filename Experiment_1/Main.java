package process;

import java.util.Scanner;

import process.BlockedQueue.Node;

public class Main {
	static readyQueue<PCB> readyQueue = new readyQueue<PCB>();
	static BlockedQueue<PCB> blockedQueue = new BlockedQueue<PCB>();
	PCB runPCB = new PCB();
	
	public int mainView() {
		int choose = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("-----start-----");
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. ��ֹ");
		System.out.println("5. ��ʾ");
		System.out.println("0. �˳�");
		System.out.print("ѡ�� : ");
		choose = input.nextInt();
		switch(choose) {
		case 0 : break;
		case 1 : CreatePCB(); break;
		case 2 : blockedPCB(); break;
		case 3 : break;
		case 4 : break;
		case 5 : break;
		default : System.out.println("Input Error");break;
		}
		return choose;
	}
	public static void main(String[] args) {
		while(true){
			int choose = 0;
			choose = new Main().mainView();
			if(choose == 0) break;
		}
		
	}
	public void CreatePCB() {
		Scanner input = new Scanner(System.in);
		PCB p = new PCB();
		System.out.print("����PCB�����Ϣ : \n������ : "); p.setId(input.nextLine());
		System.out.print("���ȼ� : ");p.setPriority(input.nextLine());
		System.out.print("����ʱ�� : ");p.setTime(input.nextInt());
		p.setStatus(2);
		readyQueue.addAtRear(p);
		System.out.println("�����Ѿ������������");
		//System.out.println(readyQueue.toString());
	}
	public void blockedPCB() {
		Scanner input = new Scanner(System.in);
		String idSearch = input.nextLine();
		if( runPCB != null && runPCB.getId().equals(idSearch)) {
			blockedQueue.addAtRear(runPCB);
			runPCB.setStatus(3);
		}else if(blockedQueue.getFrontNode() != null){
			Node pNode;
			pNode = blockedQueue.getFrontNode();
			String pString = ((PCB) pNode.getData()).getId();
			while(pNode != null) {
				if(pString.equals(idSearch)) System.out.println("����������������");
				else pNode = pNode.getNext();
			}
		}
		
	}
}
