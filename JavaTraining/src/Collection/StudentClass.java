package Collection;

public class StudentClass {
String name,address;
int age;
public StudentClass(String name,String address,int age) {
	this.name=name;
	this.address=address;
	this.age=age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public static void main(String args[]) {
	StudentClass student=new StudentClass("sreekumar","chakkamallissery",12);
	System.out.println("Student name  :-"+student.getName());
}

}
