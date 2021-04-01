package day16;

import java.io.Serializable;
import java.rmi.Remote;

public interface TimeListener extends Serializable{
	void onTimeOut(int score);
}
