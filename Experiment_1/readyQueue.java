package process;
/*
 * Author ： 191491603 曹宇宸
 * 进程就绪队列，处理器从就绪队列选择进程，使进程从就绪状态转为运行状态
 * 数据结构 ： 队列（链式存储）
 */
public class readyQueue<T> {
	private class Node {
		private T data;
		private Node next;

		public Node() {

		}
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node frontNode;
	private Node rearNode;
	private int size;

	// 初始化就绪队列，队列为空，没有程序在就绪队列中
	public readyQueue() {
		frontNode = null;
		rearNode = null;
		size = 0;
	}

	// 初始化非空的就绪队列，以进程element初始化队列
	public readyQueue(T element) {
		frontNode = new Node(element, null);
		rearNode = frontNode;
		size = 1;
	}

	// 返回目前队列的进程个数
	public int getSize() {
		return size;
	}

	// 返回最后一个就绪队列中最后一个进程
	public T getRear() {
		return rearNode.data;
	}

	// 判断是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 清空队列
	public void clear() {
		frontNode = null;
		rearNode = null;
		size = 0;
	}

	// 进程就绪队列从首部移除元素，即处于就绪队列头部的进程由就绪态转为运行态
	public T removeFromFront() {
		if (isEmpty()) {
			throw new RuntimeException("就绪队列为空，无法从就绪队列中移除就绪进程，");
		} else {
			Node del = frontNode;
			frontNode = del.next;
			T value = del.data;
			del = null;
			size--;
			return value;
		}
	}

	// 向就绪队列的尾部插入进程，这些进程可能是timeout的进程，也可能是调度来的进程
	public void addAtRear(T element) {
		if (frontNode == null) {
			frontNode = new Node(element, null);
			rearNode = frontNode;
		} else {
			Node newNode = new Node(element, null);
			rearNode.next = newNode;
			rearNode = newNode;
		}
		size++;
	}

	// 将进程就绪队列中的所有进程的信息打印处理
	public String toString() {
		if (isEmpty())
			return "[]";
		else {
			StringBuilder sb = new StringBuilder("[");
			Node current = frontNode;
			for (int i = 0; i < size && current != null; i++) {
				sb.append(current.data.toString() + ",");
				current = current.next;
			}
			sb.append("]");
			return sb.toString();
		}
	}
}
