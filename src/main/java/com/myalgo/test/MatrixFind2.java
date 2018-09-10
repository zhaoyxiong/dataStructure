package com.myalgo.test;

import java.util.LinkedList;

public class MatrixFind2 {

	private static char[][] data;
	private static int row;
	private static int col;
	private static LinkedList<Integer> path = new LinkedList<Integer>();
	private static boolean isFinished = false;
	
	public static void main(String[] args) {
		char[] matrix = "ABCESFCSADEE".toCharArray();
		char[] str = "BCCED".toCharArray();
		char[] str1 = "ABCB".toCharArray();
		char[] str2 = "ABCD".toCharArray();
		char[] str4 = "ABCB".toCharArray();
		char[] str3 = "ABCB".toCharArray();
		char[] str5 = "ABCB".toCharArray();
		char[] str7 = "ABCB".toCharArray();
		char[] str6 = "ABCB".toCharArray();
		char[] str8 = "ABCB".toCharArray();
		char[] str9 = "ABCB".toCharArray();
		System.out.println(hasPath(matrix,3,4,str));
		System.out.println(hasPath(matrix,3,4,str1));
		System.out.println(hasPath(matrix,3,4,str2));
		System.out.println(hasPath(matrix,3,4,str3));
		System.out.println(hasPath(matrix,3,4,str4));
		System.out.println(hasPath(matrix,3,4,str5));
		System.out.println(hasPath(matrix,3,4,str6));
		System.out.println(hasPath(matrix,3,4,str7));
		System.out.println(hasPath(matrix,3,4,str8));
		System.out.println(hasPath(matrix,3,4,str9));
	}
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		
		row = rows;
		col = cols;
		data = new char[row][col];
		for (int i = 0, z = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// 初始化为二维数组
				data[i][j] = matrix[z++];
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i] == str[0] && !isFinished) {
				tryPath(i / col, i % col, str, 0);
			}
		}
		return isFinished;
	}

	public static void tryPath(int i, int j, char[] str, int index) {
		if (isFinished || path.contains(i * col + j)) {
			return;
		}
		path.addLast(i * col + j );
		if (index == str.length - 1) {
			isFinished = true;
		} else {
			for (int z = 0; z < 4; z++) {
				switch (z) {
				case 0:
					if (i - 1 >= 0 && data[i - 1][j] == str[index + 1]) {
						tryPath(i - 1, j, str, index + 1);
					}
					break;
				case 1:
					if (i + 1 < row && data[i + 1][j] == str[index + 1]) {
						tryPath(i + 1, j, str, index + 1);
					}
					break;
				case 2:
					if (j - 1 >= 0 && data[i][j - 1] == str[index + 1]) {
						tryPath(i, j - 1, str, index + 1);
					}
					break;
				case 3:
					if (j + 1 < col && data[i][j + 1] == str[index + 1]) {
						tryPath(i, j + 1, str, index + 1);
					}
					break;
				}
			}
		}
		path.removeLast();
	}
}