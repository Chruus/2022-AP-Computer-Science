
//Christopher Petty
import java.awt.*;

public abstract class Particle {
    int r, c;
    int type;
    Color color;
    ParticleGrid grid;
    public final int BARRIER = -1;
    public final int EMPTY = 0;
    public final int METAL = 1;
    public final int SAND = 2;
    public final int WATER = 3;
    public final int BALL = 4;

    public Particle(int r_, int c_, int type_, ParticleGrid grid_) {
        r = r_;
        c = c_;
        grid = grid_;
    }

    public int type() {
        return type;
    }

    public Color color() {
        return color;
    }

    public boolean isSolid() {
        if (type == METAL || type == SAND)
            return true;
        return false;
    }

    public abstract void update();

}
