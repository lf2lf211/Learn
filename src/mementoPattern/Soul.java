package mementoPattern;

import java.util.HashMap;
import java.util.Map;


public class Soul {
	private Map<Person, Memory> memoryMap = new HashMap<Person, Memory>();

	public void pullAwayMemory(Person person) {
		memoryMap.put(person, person.getMemory());
	}

	public void forceFixMemory(Person person) {
		if (memoryMap.containsKey(person)) {
			person.setMemory(memoryMap.get(person));
		}
	}
}
