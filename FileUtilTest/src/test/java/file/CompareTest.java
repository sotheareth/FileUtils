package file;

public class CompareTest {
	
	public static void main(String[] args) {
		Person p1 = new Person("1", "test2");
		Person p2 = new Person("1", "test3");
		System.out.println(p1.compareTo(p2));
	}
}
