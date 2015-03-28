package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
	private static String filename="person.data";

	public static void main(String[] args) throws IOException {
		if(!new File(filename).exists()){
			List<Person> list=createPerson();
			save(list);
		}else{
			readPerson(filename);
		}	
	}	
	
	//构造对象
	private static List<Person> createPerson(){
		List<Person> list=new ArrayList<Person>();
		list.add(new Person("a", "a", "a", "a", "a"));
		list.add(new Person("b", "b", "b", "b", "b"));
		list.add(new Person("c", "c", "c", "c", "c"));
		list.add(new Person("d", "d", "d", "d", "d"));
		//封装四个对象
		return list;
	}
	//保存对象
	private static void save(List<Person> persons) throws IOException{
		String data ="";
		for (Person person : persons) {
			data+=person.toString()+"\n";
		}
		//保存文件
		FileWriter writer =new FileWriter(filename);
		writer.write(data);
		writer.close();
		System.out.println("对象保存完毕！");
	}
	
	//读取对象
	private static void readPerson(String filename) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader reader =new BufferedReader(new FileReader(filename));
		String line;
		while ((line=reader.readLine())!=null) {
			System.out.println(line);
		}
	}
}
