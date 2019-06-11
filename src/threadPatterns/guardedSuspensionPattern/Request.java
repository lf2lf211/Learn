package threadPatterns.guardedSuspensionPattern;

//GuardedObject (被守護的對象) : 
//GuardedObject 是一個擁有被防衛的方法的類. 當線程執行 guardedMethod時, 只要滿足警戒條件便會馬上執行. 但若警戒條件不成立, 就要開始等候. 
//警戒條件的成立與否會隨 GuardedObject 的狀態進行變化. 在Java 語言中, 是使用 while 語句與 wait 方法來實現 guardedMethod 的.
//而使用 notify/notifyAll 方法來實現 stateChangingMethod.
public class Request {
	private final String name;

	public Request(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "[ Request " + name + " ]";
	}
}
