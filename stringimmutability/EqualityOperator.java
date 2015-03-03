/**
 * The == operator is used to compare two primitive data types.
 * If it is used with references, it checks whether two references are refering the same object.
 *
 * @author L.Gobinath
 */
public class EqualityOperator {
    public static void main(String[] args) {
        Student stu1 = new Student(100);
        Student stu2 = new Student(100);
        Student stu3 = stu1;
        if (stu1 == stu2) { // false
            System.out.println("stu1 == stu2");
        }
        if (stu1.equals(stu2)) { // true
            System.out.println("stu1 equals stu2");
        }
        if (stu1 == stu3) { // true
            System.out.println("stu1 == stu3");
        }
    }
}

class Student {
    int index;

    public Student(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            if (stu.index == this.index) {
                return true;
            }
        }
        return false;
    }
}