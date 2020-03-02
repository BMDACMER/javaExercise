package com.csdn.base01;

import java.util.ArrayList;
import java.util.List;

/**
 * java的基本操作，eclipse快捷键
 * @author guohao
 *
 */
//Alt+/
//Ctrl+/
//Ctrl+1
//Ctrl+Shift+F
//Ctrl+Shift+O
//F5 F6 F7 F8
public class Hello {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Tom");
		list.add("kite");
		list.add("rose");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
	}

}
