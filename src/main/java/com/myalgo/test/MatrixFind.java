package com.myalgo.test;

public class MatrixFind {

	public static void main(String[] args) {
		char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
		char[] str = {'b','c','c','e','d'};
		System.out.println(hasPath(matrix,3,4,str));
	}
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        //每个字符被访问后，需要记录他的位置，以便回溯时使用
        char[][] index = new char[rows][cols];
        int z = 0;
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                index[i][j] = matrix[z];
                z ++;
            }
        }
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                //调用判断函数：
            	System.out.println("i is" + i + " j is " + j);
                if(hasPath(index,rows,i,cols,j,str)){
                    return true;
                }
            }
        }
        return false;
    }
    //输入起始位置的下标，以及二维数组，判断是否可行
    public static boolean hasPath(char[][] matrix, int rows, int startRow, int cols, int startCol, char[] str){
        //设置数组，保存访问过的节点
        int [][] hasFind = new int[rows*cols][2];
        int hasFindIndex = 0;
        System.out.println(hasFind.length);
        int index = 0;
        for(int i = startRow; i < rows;){
            for(int j = startCol; j < cols;){
                //添加判断,可不可以找到数值，先找上方
            	System.out.println("i is" + i + " j is " + j);
            	System.out.println(matrix[i][j]);
            	if(index == str.length){
                	return true;
                }
            	if(i - 1 >= 0 && !findPoint(hasFind,i-1,j) && matrix[i-1][j] == str[index]){
                    index ++;
                    hasFind[hasFindIndex][0] = i-1;
                    hasFind[hasFindIndex][1] = j;
                    i = i-1;
                }else if(i + 1 < rows && !findPoint(hasFind,i+1,j) && matrix[i+1][j] == str[index]){
                    index ++;
                    hasFind[hasFindIndex][0] = i+1;
                    hasFind[hasFindIndex][1] = j;
                    i = i +1;
                }else if(j - 1 >= 0 && !findPoint(hasFind,i+1,j) && matrix[i][j-1] == str[index]){
                    index ++;
                    hasFind[hasFindIndex][0] = i;
                    hasFind[hasFindIndex][1] = j-1;
                    j = j -1;
                }else if(j + 1 < cols && !findPoint(hasFind,i+1,j) && matrix[i][j+1] == str[index]){
        			index ++;
                    hasFind[hasFindIndex][0] = i;
                    hasFind[hasFindIndex][1] = j+1;
                    j = j +1;
                }else if(index == 0){
                	
                }
                else{
                	
                }
            }
        }
		return false;
    }
    public static boolean findPoint(int[][] hasFind,int row,int col){
        for(int i =0; i < hasFind.length; i ++){
            if(hasFind[i][0] == row){
                if(hasFind[i][1] == col){
                    return true;
                }
            }
        }
        return false;
    }
}
