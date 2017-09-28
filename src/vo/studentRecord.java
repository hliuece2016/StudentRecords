package vo;

public class studentRecord {

	private String Name;
	private int ID;
	private int homework;
	private int midterm;
	private int finalExam;
	private String password;
	
	public studentRecord() {
		
	}
	
	public studentRecord(studentRecord s) {
		this.ID = s.getId();
		this.Name = s.getName();
		this.homework = s.getHomework();
		this.midterm = s.getMidterm();
		this.finalExam = s.getFinal();
	}
	
	public String toString() {
		return "" + '\t' + ID + '\t' + Name + '\t' + homework + '\t' + midterm + '\t' + finalExam;
	}
	public void setId(int id){
		this.ID = id;
	}
	
	public int getId() {
		return ID;
	}
	
	public void setPassword(String password){
		this.password = new StringBuffer(password).toString();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setName(String name){
		this.Name = new StringBuffer(name).toString();
	}
	
	public String getName() {
		return Name;
	}
	
	public void setHomework(int score){
		this.homework = score;
	}
	
	public int getHomework() {
		return homework;
	}
	
	public void setMidterm(int score){
		this.midterm = score;
	}
	
	public int getMidterm() {
		return midterm;
	}
	
	public void setFinal(int score) {
		this.finalExam = score;
	}
	
	public int getFinal() {
		return finalExam;
	}
}
