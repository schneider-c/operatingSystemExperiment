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
		System.out.println("1. 创建");
		System.out.println("2. 阻塞");
		System.out.println("3. 唤醒");
		System.out.println("4. 终止");
		System.out.println("5. 显示");
		System.out.println("0. 退出");
		System.out.print("选择 : ");
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
		System.out.print("输入PCB相关信息 : \n进程名 : "); p.setId(input.nextLine());
		System.out.print("优先级 : ");p.setPriority(input.nextLine());
		System.out.print("运行时间 : ");p.setTime(input.nextInt());
		p.setStatus(2);
		readyQueue.addAtRear(p);
		System.out.println("进程已经加入就绪队列");
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
				if(pString.equals(idSearch)) System.out.println("进程在阻塞队列中");
				else pNode = pNode.getNext();
			}
		}
		
	}
}
