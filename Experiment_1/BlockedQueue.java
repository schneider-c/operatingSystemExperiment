package process;

public class BlockedQueue<PCB> {
	public class Node{
		private PCB data;
		private Node next;
		public Node() {
			
		}
		public Node(PCB data, Node next) {
			this.data = data;
			this.setNext(next);
		}
		public PCB getData() {
			return data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	private Node frontNode;
	private Node rearNode;
	private int size;
	
	public BlockedQueue(){
		frontNode = null;
		rearNode = null;
		size = 0;
	}
	public BlockedQueue(PCB element) {
		frontNode = new Node(element, null);
		rearNode = frontNode;
		size = 1;
	}
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	public void clear() {
		frontNode = null;
		rearNode = null;
	}
	public String toString() {
		if(isEmpty()) return "[]";
		else {
			StringBuilder sb = new StringBuilder("[");
			Node current = frontNode;
			for(int i = 0; i < size && current != null; i++) {
				sb.append(current.data.toString() + ",");
				current = current.getNext();
			}
			sb.append("]");
			return sb.toString();
		}
	}
	// �����������ײ��Ƴ�Ԫ��
	public PCB removeFromFront(){
        if(isEmpty()){
            throw new RuntimeException("��������Ϊ�գ��޷��Ӿ����������Ƴ��������̡�");
        }else{
            Node del = frontNode;
            frontNode = del.getNext();
            PCB value = del.data;
            del = null;
            size--;
            return value;
        }
    }
    //��������е�β��������̣���Щ���̿�����timeout�Ľ��̣�Ҳ�����ǵ������Ľ���
    public void addAtRear(PCB element){
        if(frontNode == null){
            frontNode = new Node(element,null);
            rearNode = frontNode;
        }
        else{
            Node newNode = new Node(element,null);
            rearNode.setNext(newNode);
            rearNode = newNode;
        }
        size++;
    }
    
    public Node getFrontNode() {
    	return frontNode;
    }
    public void search(String idSearch) {
    	
    }
    
}
