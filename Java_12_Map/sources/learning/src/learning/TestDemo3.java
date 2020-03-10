package learning;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/*
��ϰ��
"sdfgzxcvasdfxcvdf"��ȡ���ַ����е���ĸ���ֵĴ�����

ϣ����ӡ�����a(1)c(2).....

ͨ��������֣�ÿһ����ĸ���ж�Ӧ�Ĵ�����
˵����ĸ�ʹ���֮�䶼��ӳ���ϵ��

ע���ˣ���������ӳ���ϵʱ������ѡ��map���ϡ�
��Ϊmap�����д�ž���ӳ���ϵ��


ʲôʹ��map�����أ�
������֮�������ӳ���ϵʱ����Ҫ����map���ϡ�

˼·��
1�����ַ���ת�����ַ����顣��ΪҪ��ÿһ����ĸ���в�����

2������һ��map���ϣ���Ϊ��ӡ�������ĸ��˳������ʹ��treemap���ϡ�

3�������ַ����顣
	��ÿһ����ĸ��Ϊ��ȥ��map���ϡ�
	�������null��������ĸ��1���뵽map�����С�
	������ز���null��˵������ĸ��map�����Ѿ����ڲ��ж�Ӧ������
	��ô�ͻ�ȡ�ô�����������������Ȼ�󽫸���ĸ��������Ĵ������뵽map�����С����ǵ���ԭ�������Ӧ��ֵ��

4����map�����е����ݱ��ָ�����ַ�����ʽ���ء�



*/


public class TestDemo3 {

	public static void main(String[] args) {
		String str = "ak+abAf1c,dCkaAbc-defa";
		String s= charCount(str);
		System.out.println(s);
	}
	public static String charCount(String str) {
		char[] ch = str.toCharArray();
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
		
		int count = 0;
		for(int i = 0; i < ch.length; i++) {
			if(!(ch[i] >= 'a' && ch[i] <= 'z' || ch[i] >= 'A' && ch[i] <= 'Z'))
				continue;
			Integer value = tm.get(ch[i]);
			if(value != null) {
				count = value;
			}
			count ++;
			tm.put(ch[i], count);
			count = 0;
		}
		
		StringBuilder sb = new StringBuilder();
		
		Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Character,Integer>>  it = entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<Character,Integer> me = it.next();
			Character chh = me.getKey();
			Integer value = me.getValue();
			sb.append(chh+"("+value+")");
		}
		
		return sb.toString();
	}

}
