package User_Story_U6;


public class Student {
	private int index;
	private long studentID;
	private String name;
	private String studyDegree;
	private String credit;
	private String grade;
	private int homework = 0, quiz = 0, midtermScore = 0, finalScore = 0,netHomeworkScore = 0, netQuizScore = 0, netMidtermScore = 0,
			netFinalScore = 0;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public long getStudentID() {
		return studentID;
	}

	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudyDegree() {
		return studyDegree;
	}

	public void setStudyDegree(String studyDegree) {
		this.studyDegree = studyDegree;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public int getHomework() {
		return homework;
	}

	public void setHomework(int homework) {
		this.homework = homework;
	}

	public int getQuiz() {
		return quiz;
	}

	public void setQuiz(int quiz) {
		this.quiz = quiz;
	}

	public int getMidtermScore() {
		return midtermScore;
	}

	public void setMidtermScore(int midtermScore) {
		this.midtermScore = midtermScore;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
	
	public int getNetHomeworkScore() {
		return netHomeworkScore;
	}

	public void setNetHomeworkScore(int netHomeworkScore) {
		this.netHomeworkScore = netHomeworkScore;
	}

	public int getNetQuizScore() {
		return netQuizScore;
	}

	public void setNetQuizScore(int netQuizScore) {
		this.netQuizScore = netQuizScore;
	}

	public int getNetMidtermScore() {
		return netMidtermScore;
	}

	public void setNetMidtermScore(int netMidtermScore) {
		this.netMidtermScore = netMidtermScore;
	}

	public int getNetFinalScore() {
		return netFinalScore;
	}

	public void setNetFinalScore(int netFinalScore) {
		this.netFinalScore = netFinalScore;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String toString() {
		return getIndex() + "," + getStudentID() + "," + getName() + "," + getHomework() +"," +getQuiz() +"," +getMidtermScore() + "," +getFinalScore()
			+","+getCredit()+ ","+getNetHomeworkScore()+","+getNetQuizScore()+","+getNetMidtermScore()+","+getNetFinalScore()+","+getGrade()+",,,,,,,,,,,";
	}

}
