public class Chip {

	private int value ;
	private String color;


	public Chip(int value){
		this.value = value;
		if (value == 100){

		}else if (value == 25){
			color = "green";
		}else{
			color = "blue";
		}
	}

	public String getColor(){
		return color;
	}

	public int getValue(){
		return value;
	}

}