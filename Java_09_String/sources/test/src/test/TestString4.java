package test;

 /*
 3，获取一个字符串在另一个字符串中出现的次数。
 	"abkkcdkkefkkskk"


 	思路：
 	1，定义个计数器。
 	2，获取kk第一次出现的位置。
 	3，从第一次出现位置后剩余的字符串中继续获取kk出现的位置。
 		每获取一次就计数一次。
 	4，当获取不到时，计数完成。
 */
 
public class TestString4 {
	public static void sop(String str){
		System.out.println(str);
	}
	public static int  getSubCount(String str,String key) {
		int count = 0;
		int index = 0;
		//第一次出现key字符的索引值
		while((index=str.indexOf(key))!= -1) {
			str = str.substring(index+key.length());
//			sop(str);
			count ++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		String string = "abkkcdkkefkkskk";
		int count = getSubCount(string,"k");
		System.out.println(count);
	}

}
