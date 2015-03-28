/**
 * 递归测试文件
 */
package test;

public class Recursion {
	static int multiply(int i){
		if(i!=1){
			return i*multiply(i-1);
		}else{
			return i;
		}	
	}

	public static void main(String[] arg){
		System.out.println(multiply(3));
	}
}

