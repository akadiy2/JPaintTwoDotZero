package model.shape;

import java.awt.*;

public interface IShape {
    void draw(Graphics2D graphics2D) throws Exception;
    void clear(Graphics2D graphics2D) throws Exception;

    Point getStartPoint();
    Point getEndPoint();
}
