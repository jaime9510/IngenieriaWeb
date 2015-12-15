package co.edu.udea.iw.exception;

public class MyException extends Exception {
	
	public MyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public MyException(String e){
		super(e);
	}
}
