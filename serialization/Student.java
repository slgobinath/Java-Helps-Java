import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Student class
 * 
 * @author gobinath
 *
 */
public class Student implements Serializable {
	// Serial version ID
	private static final long serialVersionUID = 5230549922091722630L;

	private String name;
	private transient int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	/**
	 * This method is called during serialization.
	 * 
	 * @param oos
	 */
	private void writeObject(ObjectOutputStream oos) {
		// Create a calendar object of current date
		Calendar current = Calendar.getInstance();
		// Get the current year
		int currentYear = current.get(Calendar.YEAR);
		// Calculate the birth year
		int birthYear = currentYear - age;

		try {
			// Write the default attributes first
			oos.defaultWriteObject();
			// Write the birth year
			oos.writeInt(birthYear);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is called during deserialization.
	 * 
	 * @param ois
	 */
	private void readObject(ObjectInputStream ois) {
		// Create a calendar object of current date
		Calendar current = Calendar.getInstance();
		// Get the current year
		int currentYear = current.get(Calendar.YEAR);

		try {
			// Read the default attributes first
			ois.defaultReadObject();
			// Read the birth year
			int birthYear = ois.readInt();
			// Calculate the age
			this.age = currentYear - birthYear;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
