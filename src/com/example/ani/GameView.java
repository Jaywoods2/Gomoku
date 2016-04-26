package com.example.ani;

import com.example.util.Chess;
import com.example.util.Control;
import com.example.util.Status;
import com.example.wuziqi2.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

/**
 * 自定义棋盘
 * 
 * @author 11601
 *
 */

public class GameView extends View implements Status{
	protected static int GRID_SIZE = 10;
	protected static int GRID_SIZE_Y;
	protected static int GRID_WIDTH; // 棋盘格的宽度
	protected static int CHESS_DIAMETER; // 棋的直径
	protected static int mStartX;// 棋盘定位的左上角X
	protected static int mStartY;// 棋盘定位的左上角Y
	private Bitmap[] mChessBW; // 黑棋和白棋
	private static int[][] mGridArray; // 网格
	boolean key = false;
	int mWinFlag = 0;
	int wbflag = 1; // 该下白棋了=2，该下黑棋了=1.
	int mGameState = GAMESTATE_RUN;
	GestureDetector gd;
	Context contex;
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.contex=context;
		// TODO Auto-generated constructor stub
		this.setFocusable(true);
		this.setFocusableInTouchMode(true);
		init(context);
		gd=new GestureDetector(context, new GestureDetector.OnGestureListener() {
			
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onShowPress(MotionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onLongPress(MotionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean onDown(MotionEvent event) {
				// TODO Auto-generated method stub
				switch (mGameState) {
				case GAMESTATE_RUN: {
					int x;
					int y;
					float ex=event.getX();
					System.out.println(ex);
					
					float x0 =(event.getX() - mStartX) % GRID_WIDTH;
					float y0 =(event.getY() - mStartY) % GRID_WIDTH;
					if (x0 < GRID_WIDTH / 2) {
						x = (int) ((event.getX() - mStartX) / GRID_WIDTH);
					} else {
						x = (int) ((event.getX() - mStartX) / GRID_WIDTH)+1;
					}
					if (y0 < GRID_WIDTH / 2) {
						y = (int) ((event.getY() - mStartY) / GRID_WIDTH);
					} else {
						y = (int) ((event.getY() - mStartY) / GRID_WIDTH)+1;
					}
					 if ((x >= 0 && x <= GRID_SIZE)   
					&& (y >= 0 && y <=GRID_SIZE_Y)) { 
						 if (mGridArray[x][y] == 0) {
							 if (wbflag == BLACK) { 
								 putchess(x, y, BLACK);
								 if(Control.checkwin(mGridArray, x, y)){ //如果是黑棋赢了    
								 mGameState = GAMESTATE_END;  
								 Toast.makeText(contex, "黑棋赢", 0).show();
								}  
								 wbflag=WHITE;
								// GameView.this.mGridArray[x][y] = 1; 
							 }else if(wbflag==WHITE){
								 putchess(x, y, WHITE);
								 if(Control.checkwin(mGridArray, x, y)){ 
									 mGameState = GAMESTATE_END;  
									 Toast.makeText(contex, "白棋赢", 0).show();
									 
									}  
								 wbflag=BLACK;
								// GameView.this.mGridArray[x][y] = 2; 
							 }
						 }
						 
					 }

				}
				break;
				case GAMESTATE_END:
					if(wbflag==WHITE){
						 Toast.makeText(contex, "黑棋赢", 0).show();
					}else if(wbflag==BLACK){
						 Toast.makeText(contex, "白棋赢", 0).show();
					}
					break;

				}	
				GameView.this.invalidate();
				return true;
			}
		});

	}

	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public void init(Context context) {
		mGameState = 1; // 设置游戏为开始状态
		wbflag = BLACK; // 初始为先下黑棋
		mWinFlag = 0; // 清空输赢标志。
		
		mChessBW=new Bitmap[2];
		Bitmap white=BitmapFactory.decodeResource(context.getResources(), R.drawable.white_point);
		Bitmap balck=BitmapFactory.decodeResource(context.getResources(), R.drawable.black_point);
		mChessBW[0]=white;
		mChessBW[1]=balck;
		
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		GRID_WIDTH = w / (GRID_SIZE+2);
		GRID_SIZE_Y=h/GRID_WIDTH-2;
		mGridArray = new int[GRID_SIZE+1][GRID_SIZE_Y+1];		
		CHESS_DIAMETER=GRID_WIDTH/2;
		mStartX = w / 2 - GRID_SIZE * GRID_WIDTH / 2;
		mStartY = h / 2 - GRID_SIZE_Y * GRID_WIDTH / 2;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paintRect = new Paint();
		paintRect.setColor(Color.GRAY);
		paintRect.setStrokeWidth(2);
		paintRect.setStyle(Style.STROKE);

		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE_Y; j++) {
				int mLeft = i * GRID_WIDTH + mStartX;
				int mTop = j * GRID_WIDTH + mStartY;
				int mRright = mLeft + GRID_WIDTH;
				int mBottom = mTop + GRID_WIDTH;
				canvas.drawRect(mLeft, mTop, mRright, mBottom, paintRect);

			}

		}
		// 画棋盘的外边框
		paintRect.setStrokeWidth(5);
		canvas.drawRect(mStartX, mStartY, mStartX + GRID_WIDTH * GRID_SIZE, mStartY + GRID_WIDTH * GRID_SIZE_Y, paintRect);
		
		for (int i = 0; i <=GRID_SIZE; i++) {
			for (int j = 0; j <=GRID_SIZE_Y; j++) {
				int cx=mStartX + i * GRID_WIDTH-GRID_WIDTH/2;
				int cy=mStartY + j* GRID_WIDTH-GRID_WIDTH/2;
				new Chess(cx, cy,mChessBW)
				 	.ondrawSelf(mGridArray[i][j], canvas);
			}
		}
	}

	public void putchess(int x, int y, int blackwhite) {
		mGridArray[x][y] = blackwhite;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//int code=event.getAction();
		gd.onTouchEvent(event);
		return true;
	}

}
