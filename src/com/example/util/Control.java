package com.example.util;

public class Control {
	/**
	 * @param c ���ӷֲ�����
	 * @param (x, y)Ϊ��ǰ���ӵ�λ��
	 * @return boolean
	 */
public static boolean checkwin(int[][] c,int x,int y){
	//�����ӵ�������8������
	int cflag=c[x][y];//��ǰ��ɫ 1 �� 2
	int len_x=c.length;
	int len_y=c[0].length;
	int sum=1;
	
	//1�����Ҽ��
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
	
	
	//2�����¼��
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
	
	//3������ ���ϼ��
	
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
	
	
	//4���������¼��
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
		//�������
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
