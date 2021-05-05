package nLayeredDemo.core;

import jLogger.JLoggerManager;

public class JLoggerManagerAdapter implements LoggerService{

	@Override
	public void logToSystem(String message) {
		// TODO Auto-generated method stub
		JLoggerManager logtut= new JLoggerManager();
		logtut.log(message);
		
	}

}
