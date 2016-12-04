
public class Question {

	String question;
	String answer1;
	String answer2;
	String answer3;
	public Question(String question, String answer1, String answer2, String answer3){
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}
	public String getQuestion(){
		return question;		
	}
	public String getAnswer(int num){
		if(num ==0){	
			return answer1;
		} else if(num ==1){
			return answer2;
		}
		else{
			return answer3;
		}			
	}
	
}