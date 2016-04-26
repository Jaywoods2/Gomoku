package com.example.util;

public interface Status {
	public static final int BLACK = 1;
	public static final int WHITE = 2;
	// 游戏阶段：0=尚未游戏，1=正在进行游戏，2=游戏结束
	public static final int GAMESTATE_RUN = 1;
	public static final int GAMESTATE_PRE = 0;
	public static final int GAMESTATE_PAUSE = 2;
	public static final int GAMESTATE_END = 3;
	

}
