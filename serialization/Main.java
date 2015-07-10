import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Student stu = createStudent();
		System.out.println("Name: " + stu.getName());
		System.out.println("Age: " + stu.getAge());

		// Convert the object to stream
		byte[] stream = toStream(stu);

		// Print the array
		System.out.println(Arrays.toString(stream));

		Student convertedStu = toStudent(stream);
		System.out.println("Name: " + convertedStu.getName());
		System.out.println("Age: " + convertedStu.getAge());
		// Give any filename
		save(stu, "/home/gobinath/student.xxx");

		Student newStu = read("/home/gobinath/student.xxx");
		System.out.println("Name: " + newStu.getName());
		System.out.println("Age: " + newStu.getAge());
	}

	/**
	 * Create a sample Student object.
	 * 
	 * @return a Student object.
	 */
	public static Student createStudent() {
		// Create a Student object
		Student stu = new Student();
		stu.setName("Alice");
		stu.setAge(24);

		return stu;
	}

	/**
	 * Convert a Student object into stream of bytes.
	 * 
	 * @param stu
	 *            Student object.
	 * @return stream of bytes
	 */
	public static byte[] toStream(Student stu) {
		// Reference for stream of bytes
		byte[] stream = null;
		// ObjectOutputStream is used to convert a Java object into OutputStream
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);) {
			oos.writeObject(stu);
			stream = baos.toByteArray();
		} catch (IOException e) {
			// Error in serialization
			e.printStackTrace();
		}
		return stream;
	}

	/**
	 * Convert stream of bytes to Student.
	 * 
	 * @param stream
	 *            byte array
	 * @return Student object
	 */
	public static Student toStudent(byte[] stream) {
		Student stu = null;

		try (ByteArrayInputStream bais = new ByteArrayInputStream(stream);
				ObjectInputStream ois = new ObjectInputStream(bais);) {
			stu = (Student) ois.readObject();
		} catch (IOException e) {
			// Error in de-serialization
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// You are converting an invalid stream to Student
			e.printStackTrace();
		}
		return stu;
	}

	/**
	 * Save a student into a file using Serialization.
	 * 
	 * @param stu
	 *            the Student to save.
	 * @param fileName
	 *            the location to save.
	 */
	public static void save(Student stu, String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(stu);
		} catch (FileNotFoundException e) {
			// Error in accessing the file
			e.printStackTrace();
		} catch (IOException e) {
			// Error in converting the Student
			e.printStackTrace();
		}
	}

	/**
	 * Reading Student object from the given file.
	 * 
	 * @param fileName
	 *            location of the file.
	 * @return converted Student object.
	 */
	public static Student read(String fileName) {
		Student stu = null;
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			stu = (Student) ois.readObject();
		} catch (FileNotFoundException e) {
			// Error in accessing the file
			e.printStackTrace();
		} catch (IOException e) {
			// Error in converting the Student
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// You are converting an invalid stream to Student
			e.printStackTrace();
		}
		return stu;
	}
}
