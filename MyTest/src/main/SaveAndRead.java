package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 * 数据存取功能实现类
 */
public class SaveAndRead {

	//保存对象
	public static void save(List<Object> persons,String filename) throws IOException{
		String data ="";
		for (Object person : persons) {
			data+=person.toString()+"\n";
		}
		//保存文件
		FileWriter writer =new FileWriter(filename);
		writer.write(data);
		writer.close();
		System.out.println("对象保存完毕！");
	}
	
	//读取对象
	public static void read(String filename) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader reader =new BufferedReader(new FileReader(filename));
		String line;
		while ((line=reader.readLine())!=null) {
			System.out.println(line);
		}
	}
	
	//删除对象
	public static Boolean delete(String name){
		File f=new File(name);
		return f.delete();
	}
	
}
