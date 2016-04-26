package com.example.util;


import com.example.wuziqi2.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Chess implements Status{
	private int sx;
	private int sy;

	private Bitmap[] b=new Bitmap[2];
	public Chess(int sx, int sy,Bitmap[] b) {
		this.sx = sx;
		this.sy = sy;
		this.b=b;

	}

	public void ondrawSelf(int x,Canvas canvas){
		if (x == BLACK) {
			Paint paintCircle = new Paint();
			canvas.drawBitmap(b[1], sx, sy, paintCircle);
			/*paintCircle.setColor(Color.BLACK);
			canvas.drawCircle(sx, sy,r, paintCircle);*/
		} else if (x == WHITE) {
			Paint paintCircle = new Paint();
			canvas.drawBitmap(b[0], sx, sy, paintCircle);
			/*paintCircle.setColor(0xffE2D5E2);
			canvas.drawCircle(sx, sy,r, paintCircle);*/
		}
	}

}
