import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View extends Frame {

    public View(Model model) {
        int width = 500;
        int height = 500;
        setSize(width, height);
        Canvas c = new QRCanvas(model, width, height);
        add(c);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
}
