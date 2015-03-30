package main.domain;
/**
 * 
 * @author 张昊
 * 生成对象的实体类
 *
 */
public class Person {
	private String name;
	private String sex;
	private String weight;
	private String job;
	private String love;
	public Person(String name, String sex, String weight, String job,
			String love) {
		super();
		this.name = name;
		this.sex = sex;
		this.weight = weight;
		this.job = job;
		this.love = love;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", weight=" + weight
				+ ", job=" + job + ", love=" + love + "]";
	}
}
