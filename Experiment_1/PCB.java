package process;

public class PCB {
	private String id;  // ������
	private String Priority;  // ���ȼ�
	private int arrival_time;  // Ŀǰ�Ѿ����е�ʱ��
	private int status;  // ״̬ 1��ʾ����̬��2��ʾ����̬��3��ʾ����̬
	private int next;  // ��һ��pcb״̬
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		this.Priority = priority;
	}
	public int getTime() {
		return arrival_time;
	}
	public void setTime(int time) {
		this.arrival_time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public String toString() {
		return "PCB : " + id + " Priority : " + Priority + " Run time : " + arrival_time + " Status : " + status;
	}
}
