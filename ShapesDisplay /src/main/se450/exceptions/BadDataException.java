package main.se450.exceptions;

public class BadDataException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String type = "Unknown";
	
	public BadDataException()
	{
		
	}
	public BadDataException(final String stype){
		type=stype;
	}
	
	public String getMessage()
	{
		return "Bad Data : "  + type;
	}
	
}
