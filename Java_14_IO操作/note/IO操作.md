# IO文件操作

## IO流

1. 分类：字节流和字符流
2. 一开始只有字节流，为什么会有字符流？
   - ASCII(一个字节) => GB2312(中文) => GBK（中文扩容） => Unicode（世界语言，全二字节） => UTF-8（世界语言，合适的编码格式） 
   - 这就出现了一个问题：一个文字在两种编码中可能不一样，如何进行统一？
     - 为了解决这个问题，所以开发了字符流，用户可以指定自己选择GBK还是UTF-8
3. 流向分为输入流和输出流：
   - 输入流： 程序输入
   - 输出流：程序输出
4. 字节流和字符流的区别：
   1. 字节流操作的基本单位为字节；字符流操作的基本单位为Unicode码
   2. 字节流默认不使用缓冲区；字符流使用缓冲区
   3. 字节流通常用于处理二进制数据，实际上可以处理任意类型数据，并不支持直接写入或者读取Unicode码元；字符流通常处理文本信息，支持写入UniCode码元。

## 类别

-  基类：`write & read ` 
- 字节流：`InputStream & OutputStream`
- 字符流：`Reader & Writer`

## 文件读写复制操作

```java
package file;

import java.io.File;
import java.io.FileWriter;

/**
 * 1. 输入数据到文件中 使用字符流
 * @author asdw1
 *
 */

public class TestDemo1 {

	public static void main(String[] args) {
		//变量的指向必须给定！！
		FileWriter fw = null;
		String str = "\"Hello World!!\"";
		try {
			fw = new FileWriter("test1.txt");
//			fw = new FileWriter("src");
			fw.write(str.toCharArray());
			fw.write("\r\n");
			fw.write(str.toCharArray(),0,10);
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fw != null)
					fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

}

```

```java
package file;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符流文件复制操作
 * 先打开的先关闭
 * @author asdw1
 *
 */
public class TestDemo2 {

	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		try {
			fr = new FileReader("test1.txt");
			fw = new FileWriter("dsc.txt");
			//读一个，写一个
//			for(int ch = fr.read(); ch != -1; ch = fr.read())
//				fw.write(ch);
			
			//读一坨 写一坨
			char[] buff = new char[1024];
			int num = 0;
			while((num = fr.read(buff))!= -1) {
				fw.write(buff,0,num);
				//打印到控制台上
				System.out.println(new String(buff,0,num));
			}
				
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				fw.close();
				fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}


```

## 缓冲区技术

> 为了提高对数据的操作效率
>
> 对应类：BufferedWriter BufferedReader
>
> 缓冲区要和流一块使用
>
> 现有流，再有缓冲流
>
> 缓冲区的关闭其实关闭的是流对象
>
> 缓冲区的本质就是封装了数组
>
> BufferedReader.readLine() 只返回可显示数据

其实本质就是在操作文件的时候增加了数组操作

```java
package file;
/**
 * 缓冲区技术
 * 为了提高效率。加入缓冲技术。
 * 将字符读取流对象作为参数传递给缓冲对象的构造函数。
 * 自己实现了BufferedReader.readLine()的方法
 * 使用StringBuilder是因为这是一个可变长度的字符系列，线程不同步，效率高
 * @author asdw1
 *
 */
import java.io.*;

class MyBufferedReader {
	private FileReader fr = null;
	public MyBufferedReader(FileReader fr) {
		super();
		this.fr = fr;
	}
	
	public String myReadLine() throws IOException {
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		//遇到回车时的办法
		while((ch = fr.read()) != -1) {
			if((char)ch == '\r')
				continue;
			if((char)ch == '\n')
				return sb.toString();
			else 
				sb.append((char)ch);
		}
		//一行无回车时的办法
		if(sb.length() != 0)
			return sb.toString();
		return null;
	}
	
	public void myClose() throws IOException {
		fr.close();
	}
}


public class TestDemo3 {

	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		MyBufferedReader mbr = null;
		try {
			fr = new FileReader("test1.txt");
			fw = new FileWriter("dsc.txt");
			bw = new BufferedWriter(fw);
			br = new BufferedReader(fr);
			mbr = new MyBufferedReader(fr);
			String str = null;
			//readLine方法返回的时候只返回回车符之前的数据内容，并不返回回车符
			while((str = mbr.myReadLine()) != null) {
				bw.write(str);
				//提供了一个跨平台的换行符
				bw.newLine();
				//记住，只要用到缓冲区，就要记得刷新!!
				bw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				//关闭缓冲区，就是关闭缓冲区中的流对象
				br.close();
				bw.close();
				mbr.myClose();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}

```

## 装饰器模式

- 单例模式
- 模板模式

对已有的对象进行功能对象增强时，

可以定义类，将已有的对象传入，基于已有的功能，并提供加强功能

那么自定义的类称之为装饰类

上述的BufferedReader就是一个装饰类

```java
package file;
/**
 * 装饰器模式
 * @author asdw1
 *
 */

class Person {
	public void eat() {
		System.out.println("eat...");
	}
}
class SuperPerson {
	private Person person;
	public SuperPerson(Person person) {
		super();
		this.person = person;
	}
	public void eat() {
		System.out.println("eat...");
		System.out.println("Drinking...");
	}
}
public class TestDemo4 {

	public static void main(String[] args) {
		Person person = new Person();
		person.eat();
		SuperPerson superPerson = new SuperPerson(new Person());
		superPerson.eat();

	}

}

```

```java
/*


MyReader//专门用于读取数据的类。
	|--MyTextReader
		|--MyBufferTextReader
	|--MyMediaReader
		|--MyBufferMediaReader
	|--MyDataReader
		|--MyBufferDataReader

class MyBufferReader
{
	MyBufferReader(MyTextReader text)
	{}
	MyBufferReader(MyMediaReader media)
	{}
}
上面这个类扩展性很差，同样都是使用缓冲区技术，为什么不重新定义一个类，然后将子类参数传入呢！
装饰器模式就是解决这个问题的！
找到其参数的共同类型。通过多态的形式。可以提高扩展性。

class MyBufferReader extends MyReader
{
	private MyReader r;
	MyBufferReader(MyReader r)
	{}
}	

MyReader//专门用于读取数据的类。
	|--MyTextReader
	|--MyMediaReader
	|--MyDataReader
	|--MyBufferReader

以前是通过继承将每一个子类都具备缓冲功能。
那么继承体系会复杂，并不利于扩展。

现在优化思想。单独描述一下缓冲内容。
将需要被缓冲的对象。传递进来。也就是，谁需要被缓冲，谁就作为参数传递给缓冲区。
这样继承体系就变得很简单。优化了体系结构。

装饰模式比继承要灵活。避免了继承体系臃肿。
而且降低了类于类之间的关系。

装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强功能。
所以装饰类和被装饰类通常是都属于一个体系中的。

*/


class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}

```

## LineNumberReader

```java
package file;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineNumberReader的用法
 * @author asdw1
 *
 */
class MyLineNumberReader  {
	private FileReader fr;
	private int cnt = 0;
	public MyLineNumberReader(FileReader fr) {
		this.fr = fr;
	}
	public String myReadLine() throws IOException {
		cnt ++;
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch = fr.read())!= -1) {
			if((char)ch == '\r')
				continue;
			else if((char)ch == '\n')
				return sb.toString();
			else 
				sb.append((char)ch);
		}
		if(sb.length() != 0)
			return sb.toString();
		return null;
	}
	public void mySetLineNumber(int cnt) {
		this.cnt = cnt;
	}
	public int myGetLineNumber(){
		return cnt;
	}
	public void close()throws IOException {
		fr.close();
	}
}

public class TestDemo5 {

	public static void main(String[] args) {
//		FileReader fr = null;
//		LineNumberReader lr = null;
//		try {
//			fr = new FileReader("./src/file/TestDemo4.java");
//			lr = new LineNumberReader(fr);
//			String str = null;
//			lr.setLineNumber(100);
//			while((str = lr.readLine()) != null) {
//				System.out.println(lr.getLineNumber()+" : " + str);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		FileReader fr = null;
		MyLineNumberReader lr = null;
		try {
			fr = new FileReader("./src/file/TestDemo4.java");
			lr = new MyLineNumberReader(fr);
			String str = null;
			lr.mySetLineNumber(100);
			while((str = lr.myReadLine()) != null) {
				System.out.println(lr.myGetLineNumber()+" : " + str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				lr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}

```

```java

/*
使用继承机制
*/
import java.io.*;

class MyLineNumberReader extends MyBufferedReader
{
	private int lineNumber;
	MyLineNumberReader(Reader r)
	{
		super(r);
	}

	public String myReadLine()throws IOException
	{

		lineNumber++;
		return super.myReadLine();
	}
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}
	public int getLineNumber()
	{
		return lineNumber;
	}
}

/*
class MyLineNumberReader 
{
	private Reader r;
	private int lineNumber;
	MyLineNumberReader(Reader r)
	{
		this.r = r;
	}

	public String myReadLine()throws IOException
	{

		lineNumber++;
		StringBuilder sb = new StringBuilder();

		int ch = 0;

		while((ch=r.read())!=-1)
		{
			if(ch=='\r')
				continue;
			if(ch=='\n')
				return sb.toString();
			else
				sb.append((char)ch);
		}
		if(sb.length()!=0)
			return sb.toString();
		return null;
	}
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}
	public int getLineNumber()
	{
		return lineNumber;
	}

	public void myClose()throws IOException
	{
		r.close();
	}
}
*/
class  MyLineNumberReaderDemo
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("copyTextByBuf.java");

		MyLineNumberReader mylnr = new MyLineNumberReader(fr);

		String line = null;
		mylnr.setLineNumber(100);
		while((line=mylnr.myReadLine())!=null)
		{
			System.out.println(mylnr.getLineNumber()+"::"+line);
		}

		mylnr.myClose();
	}
}

```

## 字节流

```java
字符流：
	FileReader
	FileWriter
字节流：
	FileInputStream
	FileOutputStream
```

```java
package zijie;

import java.io.*;

/**
 * 字节流对象
 * 1. 字符流和字节流关于刷新的不同：
 * 		字符流采用两个字节处理，需要进行写入刷新
 * 		字节流只是字节操作，遇见一个字节操作一个字节，不用刷新
 * 		字节流涉及缓冲区才可以刷新
 * 2. 关于字节流缓冲区的问题：
 * 		缓冲区调用fileInputStream的read方法从硬盘来获得一批数据到内存
 * 		的缓冲区中，缓冲区的read函数从内存中一个字节一个字节的读！
 * @author asdw1
 *
 */
public class TestDemo1 {

	public static void main(String[] args) {
		write();
		read1();
		read2();
		
	}
	public static void write() {
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("a.txt");
			fo.write("abcd".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fo.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static void read1() {
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("a.txt");
			int ch = 0;
			while((ch = fi.read()) != -1)
				System.out.println((char)ch);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fi.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public static void read2() {
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("a.txt");
			byte[] buff = new byte[1024];
			int len = 0;
			while((len = fi.read(buff)) != -1)
				System.out.println(new String(buff,0,len));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fi.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}

```

```java
package zijie;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * 复制图片
 */
public class TestDemo2 {

	public static void main(String[] args) {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			fi = new FileInputStream("test.png");
			fo = new FileOutputStream("dsc.png");
			byte[] buff = new byte[1024];
			int len = 0;
			while((len = fi.read(buff))!= -1) {
				fo.write(buff,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fo.close();
				fi.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
```

## 实现BufferedInputStream类

```java
package zijie;

import java.io.*;

/*
 * 实现自定义类
 * 
 * 1. 一开始缓冲区中没有东西，此时count = 0;
 * 2. 从硬盘读取数据，需要定义数组缓冲区
 * 3. 此时，需要定义游标来标定位置
 * 4. count --; pos ++;
 * 5. 读取完成以后返回-1
 */

class MyBufferedInputStream {
	private InputStream in;
	private byte[] buff = new byte[1024*4];
	private int pos = 0;
	private int count = 0;
	
	public int myRead() throws IOException {
		//从硬盘上存储数据到内存中
		if(count == 0) {
			count = in.read(buff);
			if(count < 0)
				return -1;
			pos = 0;
			byte b = buff[pos];
			count --;
			pos ++;
			return b&255;
		}
		else if(count > 0) {
			byte b = buff[pos];
			count --;
			pos ++;
			return b&0xff;
		}
		return -1;
	}
}
public class TestDemo4 {

	public static void main(String[] args) {
		
	}

}

/*
11111111-111111110000000000101001001010100101010010101001010


byte: -1  --->  int : -1;
00000000 00000000 00000000 11111111  255

11111111 11111111 11111111 11111111


11111111  -->提升了一个int类型 那不还是-1吗？是-1的原因是因为在8个1前面补的是1导致的。
那么我只要在前面补0，即可以保留原字节数据不变，又可以避免-1的出现。
怎么补0呢？

 11111111 11111111 11111111 11111111                        
&00000000 00000000 00000000 11111111 
------------------------------------
 00000000 00000000 00000000 11111111 

0000-0001
1111-1110
000000001
1111-1111  -1


结论：
字节流的读一个字节的read方法为什么返回值类型不是byte，而是int。
因为有可能会读到连续8个二进制1的情况，8个二进制1对应的十进制是-1.
那么就会数据还没有读完，就结束的情况。因为我们判断读取结束是通过结尾标记-1来确定的。
所以，为了避免这种情况将读到的字节进行int类型的提升。
并在保留原字节数据的情况前面了补了24个0，变成了int类型的数值。


而在写入数据时，只写该int类型数据的最低8位。
*/


```

## 读取键盘录入

```java
package other;

import java.io.IOException;
import java.io.InputStream;

/*
 * 读取键盘录入：
 * 
 * System.out:对应的是标准输出设备，控制台。
 * System.in:对应的标准输入设备：键盘。
 * 需求：
	通过键盘录入数据。
	当录入一行数据后，就将该行数据进行打印。
	如果录入的数据是over，那么停止录入。
 */
public class TestDemo1 {

	public static void main(String[] args) throws IOException{
		InputStream ins = System.in;
		StringBuilder sbr = new StringBuilder();
		
		while(true) {
			int ch = ins.read();
			if((char)ch == '\r')
				continue;
			if((char)ch == '\n') {
				String str = sbr.toString();
				if("over".equals(str))
					break;
				System.out.println(str.toUpperCase());
				sbr.delete(0, sbr.length());
			}
			else {
				sbr.append((char)ch);
			}
		}
	}
}

```

```java
package other;

import java.io.*;

/**
 * 1. 上述代码实现了字节流读取一行代码，发现代码就是字符流的读取一行的代码
 * 2. 我们能不能直接使用字符流的readLine方法来读取键盘录入
 * 3. 涉及字符流和字节流之间的转换
 * @author asdw1
 *
 */
public class TestDemo2 {

	public static void main(String[] args) throws IOException {
		
		myTransStreamReadLine();

	}
	
	public static void myInputStreamReadLine() throws IOException {
		
		InputStream ins = System.in;
		StringBuilder sb = new StringBuilder();
		while(true) {
			int ch = ins.read();
			if((char)ch == '\r')
				continue;
			if((char)ch == '\n') {
				String str = sb.toString();
				if("over".equals(str))
					break;
				System.out.println(str.toUpperCase());
				sb.delete(0, sb.length());
			}
			else {
				sb.append((char)ch);
			}
		}
	}
	
	public static void myTransStreamReadLine() throws IOException {
		InputStream ins = System.in;
		InputStreamReader isr = new InputStreamReader(ins);
		BufferedReader br = new BufferedReader(isr);
		//常用写法
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String lineString = null;
		while((lineString = br.readLine()) != null) {
			if("over".equals(lineString))
				break;
			bw.write(lineString);
			bw.newLine();
			//必须要有刷新操作
			//字符流一定要刷新
			//字节流不需要刷新
			bw.flush();
		}
		bw.close();
	}

}

```

## 流的操作规律

```java

import java.io.*;


/*
1,
源：键盘录入。
目的：控制台。

2，需求：想把键盘录入的数据存储到一个文件中。
源：键盘。
目的：文件。

3，需求：想要将一个文件的数据打印在控制台上。
源：文件。
目的：控制台。

流操作的基本规律：
最痛苦的就是流对象有很多，不知道该用哪一个。

通过三个明确来完成。

1，明确源和目的。
	源：输入流。InputStream  Reader
	目的：输出流。OutputStream  Writer。
2，操作的数据是否是纯文本。
	是：字符流。
	不是：字节流。

3，当体系明确后，在明确要使用哪个具体的对象。
	通过设备来进行区分：
	源设备：内存，硬盘。键盘
	目的设备：内存，硬盘，控制台。

	
1，将一个文本文件中数据存储到另一个文件中。复制文件。
	源：因为是源，所以使用读取流。InputStream Reader 
	是不是操作文本文件。
	是！这时就可以选择Reader
	这样体系就明确了。

	接下来明确要使用该体系中的哪个对象。
	明确设备：硬盘。上一个文件。
	Reader体系中可以操作文件的对象是 FileReader

	是否需要提高效率：是！。加入Reader体系中缓冲区 BufferedReader.


	FileReader fr = new FileReader("a.txt");
	BufferedReader bufr = new BufferedReader(fr);




	目的：OutputStream Writer
	是否是纯文本。
	是！Writer。
	设备：硬盘，一个文件。
	Writer体系中可以操作文件的对象FileWriter。
	是否需要提高效率：是！。加入Writer体系中缓冲区 BufferedWriter
	
	FileWriter fw = new FileWriter("b.txt");
	BufferedWriter bufw = new BufferedWriter(fw);


练习：将一个图片文件中数据存储到另一个文件中。复制文件。要按照以上格式自己完成三个明确。


---------------------------------------

2，需求：将键盘录入的数据保存到一个文件中。
	这个需求中有源和目的都存在。
	那么分别分析
	源：InputStream Reader
	是不是纯文本？是！Reader
	
	设备：键盘。对应的对象是System.in.
	不是选择Reader吗？System.in对应的不是字节流吗？
	为了操作键盘的文本数据方便。转成字符流按照字符串操作是最方便的。
	所以既然明确了Reader，那么就将System.in转换成Reader。
	用了Reader体系中转换流,InputStreamReader

	InputStreamReader isr = new InputStreamReader(System.in);

	需要提高效率吗？需要！BufferedReader
	BufferedReader bufr = new BufferedReader(isr);



	目的：OutputStream  Writer
	是否是存文本？是！Writer。
	设备：硬盘。一个文件。使用 FileWriter。
	FileWriter fw = new FileWriter("c.txt");
	需要提高效率吗？需要。
	BufferedWriter bufw = new BufferedWriter(fw);


	**************
	扩展一下，想要把录入的数据按照指定的编码表（utf-8），将数据存到文件中。
	
	目的：OutputStream  Writer
	是否是存文本？是！Writer。
	设备：硬盘。一个文件。使用 FileWriter。
	但是FileWriter是使用的默认编码表。GBK.
	
	但是存储时，需要加入指定编码表utf-8。而指定的编码表只有转换流可以指定。
	所以要使用的对象是OutputStreamWriter。
	而该转换流对象要接收一个字节输出流。而且还可以操作的文件的字节输出流。FileOutputStream

	OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d.txt"),"UTF-8");

	需要高效吗？需要。
	BufferedWriter bufw = new BufferedWriter(osw);

	所以，记住。转换流什么使用。字符和字节之间的桥梁，通常，涉及到字符编码转换时，
	需要用到转换流。


练习：将一个文本数据打印在控制台上。要按照以上格式自己完成三个明确。



*/

class  TransStreamDemo2
{
	public static void main(String[] args) throws IOException
	{
        //可以进行设置输入和输出
		System.setIn(new FileInputStream("PersonDemo.java"));

		System.setOut(new PrintStream("zzz.txt"));

		//键盘的最常见写法。
		BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(System.in));

		
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}

		bufr.close();

	}
}

```

## 日志文件

```java
package other;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
import java.text.*;

/**
 * 1. 获取异常信息到指定位置
 * @author asdw1
 *
 */
public class TestDemo4 {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			int[] arr = new int[2];
			System.out.println(arr[3]);
		} catch (Exception e) {
			try {
				Date date = new Date();
				System.setOut(new PrintStream("exlog.txt"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String str = sdf.format(date);
				System.out.println(str);
			} catch (Exception e2) {
				throw new RuntimeException("异常文件创建失败");
			}
			e.printStackTrace(System.out);
		}
		
	}

}
/*
	好的工具包log4j
*/
```

## properties配置文件

```java
package property;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
Properties是hashtable的子类。
也就是说它具备map集合的特点。而且它里面存储的键值对都是字符串。

是集合中和IO技术相结合的集合容器。

该对象的特点：可以用于键值对形式的配置文件。

那么在加载数据时，需要数据有固定格式：键=值。
 */

public class TestDemo1 {
	public static void main(String[] args) throws IOException{
//		setAndGet();
//		method1();
		method2();
	} 
	//使用properties的方法读取和保存配置文件
	public static void method2() throws IOException{
		Properties pr = new Properties();
		FileInputStream fr = new FileInputStream("info.txt");

		pr.load(fr);
		System.out.println(pr);
		pr.setProperty("aaa", "70");
		//这个位置有讲究的！！！！！！！！！！！
		FileOutputStream fw = new FileOutputStream("info.txt");
		pr.store(fw,"haha");
		pr.list(System.out);
		fw.close();
		fr.close();
	}
	//从文件读取配置文件
	public static void method1() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("info.txt"));
		
		String line = null;
		Properties pr = new Properties();
		while((line = br.readLine()) != null) {
			String[] arr = line.split("=");
			pr.setProperty(arr[0], arr[1]);
		}
		System.out.println(pr);
		br.close();
	
	}
	
	//初始化并且遍历
	public static void setAndGet() {
		Properties pr = new Properties();
		pr.setProperty("zhangsan", "30");
		pr.setProperty("lisi", "40");
		
		System.out.println(pr);
		
		System.out.println(pr.getProperty("lisi"));
		
		//遍历
		Set<String> names = pr.stringPropertyNames();
		for(String s : names)
			System.out.println(s +" : "+ pr.getProperty(s));

	}
}

```





