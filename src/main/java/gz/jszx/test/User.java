package gz.jszx.test;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String pass;
	private int age;
	private String job;
	public User() {
	}
	public User(String name, String pass, int age, String job) {
		this.name = name;
		this.pass = pass;
		this.age = age;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
