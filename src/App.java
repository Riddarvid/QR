public class App {
    private void run() {
        Model model = new Model("Hejsan!", ECL.H);
        View view = new View(model);
        view.repaint();
    }

    public static void main(String[] args) {
        new App().run();
    }
}