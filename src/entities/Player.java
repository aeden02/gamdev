package entities;

import static utilz.Constants.Directions.DOWN;
import static utilz.Constants.Directions.LEFT;
import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.Directions.UP;
import static utilz.Constants.PlayerConstants.IDLE;
import static utilz.Constants.PlayerConstants.RUNNING;
import static utilz.Constants.PlayerConstants.DOUBLEJUMP;
import static utilz.Constants.PlayerConstants.getSpriteAmount;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import utilz.LoadSave;

public class Player extends Entity {
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 15;
	private int playerAction = IDLE;
	private int playerDir = -1;
	private boolean moving = false, dblJumping = false;
	private boolean left,up,right,down; 
	private float playerSpeed = 2.0f;
	
	public Player(float x, float y, int width, int heigth) {
		super(x, y, width, heigth);	
		loadAnimations();
	}
	
	public void update() {
		
		updatePos();
		updateAnimationTick();
		setAnimation();
		
	}
	
	public void render(Graphics g) {
		g.drawImage(animations[playerAction][aniIndex], (int)x, (int)y, width, heigth, null);
	}
	

	private void updateAnimationTick() {
		
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= getSpriteAmount(playerAction)) {
				aniIndex = 0;
				dblJumping = false; 
			}
		}
	}
	
	private void setAnimation() {
		
		int startAni = playerAction; 
		
		if(moving)
			playerAction = RUNNING;
		else
			playerAction = IDLE;
		
		if(dblJumping)
			playerAction = DOUBLEJUMP;
		
		
		if(startAni != playerAction) {
			resetAniTick(); 
		}
	}
	
	private void resetAniTick() {
		aniTick = 0;
		aniIndex = 0; 
		
	}

	private void updatePos() {
		
		moving = false; 
		
		if(left &&!right) {
			x-=playerSpeed;
			moving=true;
		}else if(right &&!left){
			x+=playerSpeed;
			moving=true;
		}
	
		if(up && !down) {
			y-=playerSpeed;
			moving=true;
		}else if (down && !up) {
			y+=playerSpeed;
			moving=true;
		}
	}
	
	private void loadAnimations() { 
		
			BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
			
			animations = new BufferedImage[7][12];
			
			for(int j = 0; j < animations.length; j++) {
				for(int i = 0; i < animations[j].length; i++) {
					animations[j][i] = img.getSubimage(i*32, j*32, 32, 32);
				}
			}
	}

	public void resetDirBooleans() {
		left = false; 
		right = false; 
		up = false; 
		down = false; 
	}
	
	public void setDoubleJumping(boolean dblJumping) {
		this.dblJumping=dblJumping; 
	}
	
	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
	
	
	
}

