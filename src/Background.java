import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    BufferedImage image;
    Vector2D position;

    public Background() {
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.position = new Vector2D(0,600-this.image.getHeight()/2);

    }

    public void run() {
        if (this.position.y <0) {
            this.position.addThis(0,1);
        }
    }

    public void render(Graphics g) {
        g.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);

    }
}
