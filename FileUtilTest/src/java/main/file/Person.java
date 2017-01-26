package file;

public class Person implements Comparable<Person> {
	private String id;
	private String name;

	Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name) + 
			this.id.compareTo(o.id);
	}

}
