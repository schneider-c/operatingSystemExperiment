package process;

public class PCB {
	private String id;  // 进程名
	private String Priority;  // 优先级
	private int arrival_time;  // 目前已经运行的时间
	private int status;  // 状态 1表示运行态，2表示就绪态，3表示阻塞态
	private int next;  // 下一个pcb状态
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
