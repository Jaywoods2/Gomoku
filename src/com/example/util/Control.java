package com.example.util;

public class Control {
	/**
	 * @param c 棋子分布数组
	 * @param (x, y)为当前落子的位置
	 * @return boolean
	 */
public static boolean checkwin(int[][] c,int x,int y){
	//从落子点出发检测8个方向
	int cflag=c[x][y];//当前颜色 1 或 2
	int len_x=c.length;
	int len_y=c[0].length;
	int sum=1;
	
	//1、左右检测
		for(int i=x-1;i>0;i--){
			if(c[i][y]==cflag)
				sum+=1;	
			else
				break;
		}
		for(int i=x+1;i<len_x;i++){
			if(c[i][y]==cflag)
				sum+=1;
			else
				break;
		}
		if(sum>=5)
			return true;
		else
			sum=1;
	
	
	//2、上下检测
		for(int j=y-1;j>0;j--){
			if(c[x][j]==cflag)
				sum+=1;
			else
				break;
		}
		for(int j=y+1;j<len_y;j++){
			if(c[x][j]==cflag)
				sum+=1;
			else
				break;
		}
		if(sum>=5)
			return true;
		else
			sum=1;		
	
	//3、左下 右上检测
	
		int j=y+1;
		for(int i=x-1;i>0;i--,j++){
			if(j<len_y){
				if(c[i][j]==cflag){
					sum+=1;
				}
				else
					break;
			}
			else
				break;
		}
		
		int k=y-1;
		for(int i=x+1;i<len_x;i++,k--){
			if(k>0){
				if(c[i][k]==cflag){
					sum+=1;
				}
				else
					break;
			}
			else
				break;
		}
		if(sum>=5){
			return true;
		}
		else
			sum=1;		
	
	
	//4、左上右下检测
		int h=y-1;
		for(int i=x-1;i>0;i--,h--){
			if(h>0){
				if(c[i][h]==cflag){
					sum+=1;
				}else
					break;
			}else
				break;
		}
		//检测右下
		h=y+1;
		for(int i=x+1;i<len_x;i++,h++){
			if(h<len_y){
				if(c[i][h]==cflag){
					sum+=1;
				}else break;				
			}else break;
		}
		if(sum>=5){
			return true;
		}else
			sum=1;

	return false;

}
}
