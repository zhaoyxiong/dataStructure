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
    //插入方法，插入字符，可以按顺序输入数据
    public static void Insert(char ch){
        //将每一个数据都插入end中
        end.add((char)ch);
        //如果start中没有出现过这个数据，则直接add，如果出现，则找到，在remove
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
