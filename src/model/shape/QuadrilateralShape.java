package model.shape;

import java.awt.*;

/**
 * Created by abhiramkadiyala on 3/10/18.
 */
public class QuadrilateralShape extends Shape {
    int height;
    int width;
    int x;
    int y;

    public QuadrilateralShape(Point p1, Point p2) {
        super(p1, p2);
    }

    @Override
    void setUp(Point p1, Point p2) {
        if (p1 != null && p2 != null) {
            if (p1.getX() < p1.getY()) {
                this.x = (int) p1.getX();
                this.y = (int) p1.getY();
                this.width = (int) Math.abs(p2.getX() - this.x);
                this.height = (int) Math.abs(p2.getY() - this.y);
            } else {
                this.x = (int) p2.getX();
                this.y = (int) p2.getY();
                this.width = (int) Math.abs(p1.getX() - this.x);
                this.height = (int) Math.abs(p1.getY() - this.y);
            }

        }
    }

    @Override
    public void clear(Graphics2D graphics2D) throws Exception {

    }
}
