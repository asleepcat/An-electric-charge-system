package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Controller;
import main.domain.Apple;
import main.domain.Person;

import org.junit.Test;

/**
 * 
 * @author zhanghao 测试类
 *
 */
public class TestController {
	// @Test
	// public void test(){
	// String filename="person.data";
	// if(!new File(filename).exists()){
	// List<Person> list=createPerson();
	// save(list);
	// }else{
	// readPerson(filename);
	// }
	//
	// }

	@Test
	public void test() throws IOException {
		/**
		 * 构造测试对象
		 */
		Controller c = new Controller();
		List<Object> Plist = new ArrayList<Object>();
		Plist.add(new Person("apple", "apple", "apple", "apple", "apple"));
		Plist.add(new Person("b", "b", "b", "b", "b"));
		Plist.add(new Person("c", "c", "c", "c", "c"));
		Plist.add(new Person("d", "d", "d", "d", "d"));
		c.executeSave(Plist);		
		c.executeRead("Person");
		
		List<Object> Alist = new ArrayList<Object>();
		Alist.add(new Apple("apple", "apple", "apple", "apple"));
		Alist.add(new Apple("b", "b", "b", "b"));
		Alist.add(new Apple("c", "c", "c", "c"));
		Alist.add(new Apple("d", "d", "d", "d"));
		c.executeSave(Alist);		
		c.executeRead("Apple");
	}
//	@Test
//	public void testdelete() throws IOException {
//		Controller c = new Controller();
//		c.delete("Person");
//	}
	
	
}
