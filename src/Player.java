import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    Vector2D position;
    int x,y;
    static int speed = 10;
    public Player() {
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position = new Vector2D(200,400);
    }

    public void run() {
        Vector2D oldPosition = new Vector2D(this.position.x,this.position.y);
        if (GameWindow.isUpPress) {
            this.position.addThis(0,-this.speed);
        }
        if (GameWindow.isDownPress) {
            this.position.addThis(0,this.speed);
        }
        if (GameWindow.isLeftPress) {
            this.position.addThis(-this.speed,0);
        }
        if (GameWindow.isRightPress) {
            this.position.addThis(this.speed,0);
        }
        //speed limit
        if (Math.abs(oldPosition.subtractThis(this.position.x,this.position.y).getLength())>speed) {
            this.position.addThis(oldPosition.x,oldPosition.y);
            oldPosition.setLength(speed).scaleThis(-1);
            this.position.addThis(oldPosition.x,oldPosition.y);
        }
        //limit
        if (this.position.x>GameWindow.width-this.image.getWidth()) {
            this.position = new Vector2D(GameWindow.width-this.image.getWidth(),this.position.y);
        }
        else if (this.position.x<0) {
            this.position = new Vector2D(0,this.position.y);
        }
        if (this.position.y>GameWindow.height-this.image.getHeight()) {
            this.position = new Vector2D(this.position.x,GameWindow.height-this.image.getHeight());
        }
        else if (this.position.y<0) {
            this.position = new Vector2D(this.position.x,0);
        }

    }

    public void render(Graphics g) {
        g.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);

    }
}
