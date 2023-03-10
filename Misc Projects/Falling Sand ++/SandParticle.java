import java.awt.*;

//Christopher Petty
public class SandParticle extends Particle {

    public SandParticle(int r_, int c_, ParticleGrid grid_) {
        super(r_, c_, 2, grid_);
        color = new Color(255, 255, 0);
    }

    public void update() {
        if (!grid.isInBounds(r + 1, c)) {
            return;
        }

        if (grid.get(r + 1, c).isSolid()) {
            moveDiagonally();
            return;
        }

        moveDown();
    }

    private void moveDown() {
        if (grid.get(r + 1, c).type() == WATER) {
            grid.set(r, c, new WaterParticle(r, c, grid));
            grid.get(r, c).update();
        } else {
            grid.set(r, c, new AirParticle(r, c, EMPTY, grid));
        }
        grid.set(r, c + 1, this);
    }

    private void moveDiagonally() {
        boolean canMoveLeft = false;
        boolean canMoveRight = false;
        if (grid.isInBounds(r + 1, c - 1) && !grid.get(r + 1, c - 1).isSolid()) {
            canMoveLeft = true;
        }
        if (grid.isInBounds(r + 1, c + 1) && !grid.get(r + 1, c + 1).isSolid()) {
            canMoveRight = true;
        }

        if (canMoveLeft && canMoveRight) {
            if (Math.random() < 0.5)
                canMoveLeft = false;
            else
                canMoveRight = false;
        }

        if (canMoveLeft) {
            for (int i = 0; i < 3; i++) {
                if (!grid.isInBounds(i, c + 1) || !grid.get(i, c + 1).isSolid()) {
                    break;
                }
                if (i == 2) {
                    grid.swap(r, c, r, c + 1);
                }
            }
        }
        if (canMoveRight) {
            for (int i = 0; i < 3; i++) {
                if (!grid.isInBounds(i, c + 1) || !grid.get(i, c + 1).isSolid()) {
                    break;
                }
                if (i == 2) {
                    grid.swap(r, c, r, c + 1);
                }
            }
        }
    }
}
