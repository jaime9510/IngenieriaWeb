package co.edu.udea.iw.exception;

public class MyException extends Exception {
	
	public MyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MyException(Throwable cause) {
		super(cause);
	}
	public MyException(String e){
		super(e);
	}
}
