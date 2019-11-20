import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class QRCanvas extends Canvas {
    private final Model model;
    private final int sizeReal;

    public QRCanvas(Model model, int width, int height) {
        this.model = model;
        sizeReal = model.grid.length;
        setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        int sizeG = 20;
        for (int r = 0; r < sizeReal; r++) {
            for (int c = 0; c < sizeReal; c++) {
                switch (model.grid[r][c]) {
                    case BLACK:
                        g.setColor(BLACK);
                        break;
                    case WHITE:
                        g.setColor(WHITE);
                        break;
                    case NEUTRAL:
                        g.setColor(Color.RED);
                        break;
                }
                g.fillRect(c * sizeG, r * sizeG, sizeG, sizeG);
            }
        }
    }
}
