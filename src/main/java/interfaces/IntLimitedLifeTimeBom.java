package interfaces;

import java.util.Date;

public interface IntLimitedLifeTimeBom {

	/**
	 * @return the last_usage
	 */
	public abstract Date getLastUsage();
	
	public boolean isAccessMode();

	public void setAccessMode(boolean accessMode);
	
}