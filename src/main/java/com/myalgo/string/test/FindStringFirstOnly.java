package com.myalgo.string.test;

import java.util.ArrayList;

public class FindStringFirstOnly {

	public static void main(String[] args) {
		Insert('g');
		System.out.println(FirstAppearingOnce());
		Insert('o');
		System.out.println(FirstAppearingOnce());
		Insert('o');
		System.out.println(FirstAppearingOnce());
		Insert('g');
		System.out.println(FirstAppearingOnce());
		Insert('l');
		System.out.println(FirstAppearingOnce());
		Insert('e');
		System.out.println(FirstAppearingOnce());
		/*Insert('o');
		System.out.println(FirstAppearingOnce());
		Insert('o');
		System.out.println(FirstAppearingOnce());*/
	}
	static ArrayList start = new ArrayList();
    static ArrayList end = new ArrayList();
    //���뷽���������ַ������԰�˳����������
    public static void Insert(char ch){
        //��ÿһ�����ݶ�����end��
        end.add((char)ch);
        //���start��û�г��ֹ�������ݣ���ֱ��add��������֣����ҵ�����remove
        if(!start.contains((char)ch)){
        	System.out.println( "  " + ch);
            start.add((char)ch);
        }else{
            start.remove(start.indexOf((char)ch));
        }
    }
  //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce(){
        if(start.size() == 0){
        	start.add('#');
        }else{
        	if(start.indexOf('#') > -1){
        		start.remove(start.indexOf('#'));
        	}
        }
    	return (char)start.get(0);
    }
}
