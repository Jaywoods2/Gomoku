package com.example.util;

public interface Status {
	public static final int BLACK = 1;
	public static final int WHITE = 2;
	// ��Ϸ�׶Σ�0=��δ��Ϸ��1=���ڽ�����Ϸ��2=��Ϸ����
	public static final int GAMESTATE_RUN = 1;
	public static final int GAMESTATE_PRE = 0;
	public static final int GAMESTATE_PAUSE = 2;
	public static final int GAMESTATE_END = 3;
	

}
