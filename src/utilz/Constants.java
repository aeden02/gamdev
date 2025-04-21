package utilz;

public class Constants {
	
	public static class Directions{
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;

	}
	
	public static class PlayerConstants{
		public static final int DOUBLEJUMP = 0; 
		public static final int FALL = 1; 
		public static final int HIT = 2; 
		public static final int IDLE = 3; 
		public static final int JUMP = 4; 
		public static final int RUNNING = 5;
		public static final int WALLJUMP = 6;
		
		public static int getSpriteAmount(int player_action) {
			
			switch(player_action) {
			
			case DOUBLEJUMP:
				return 6;
			case FALL:
			case JUMP:
			default:
				return 1;
			case HIT:
				return 7;
			case IDLE: 
				return 11;
			case RUNNING:
				return 12;
			case WALLJUMP:
				return 5;
			}
		}
	}

}
