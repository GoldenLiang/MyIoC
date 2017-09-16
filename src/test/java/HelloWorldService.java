
public class HelloWorldService {

	private String text;
	
	private OutputService outputService;
	
	public void helloWorld() {
		System.out.println(text);
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setOutputService(OutputService outputService) {
		this.outputService = outputService;
	}
}
