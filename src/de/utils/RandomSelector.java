package de.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSelector<T> {
	private Random rdm = new Random();

	public List<T> RandomSelect(List<T> liste, int count) throws BoundException {
		if (count > liste.size()) {
			throw new BoundException();
		}
		List<T> returnList = new ArrayList<T>();
		while (count > 0) {
			int Index = rdm.nextInt(liste.size());
			if (!returnList.contains(liste.get(Index))) {
				returnList.add(liste.get(Index));
				count--;
			}
		}
		return returnList;
	}

}


@SuppressWarnings("serial")
class BoundException extends Exception {
	public BoundException() {
		super("Die eingegebene Zahl war größer als die Anzahl an Elementen, die sich in der Liste befindet");
	}
}
