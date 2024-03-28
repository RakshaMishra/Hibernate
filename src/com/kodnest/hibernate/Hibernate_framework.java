package com.kodnest.hibernate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Hibernate_framework {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		int age=sc.nextInt();
		Student s=new Student(age,name);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost/kodnest1";
		String username="root";
		String password="qwerty";
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql="insert into student1 values(?,?)";
	    PreparedStatement st= connection.prepareStatement(sql);
	    st.setString(1,name);
	    st.setInt(2, age);
	    
	    
	   // st.execute("create table student1(id int,name varchar(20))");
	  
		int executeUpdate =st.executeUpdate();
	
		
	}

}
class Student
{
	String name;
	int age;
	public Student(int age,String name)
	{
		this.age=age;
		this.name=name;
	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getAge() {
		return age;
	}
//	public void setAge(int age) {
//		this.age = age;
//	}
	
}
