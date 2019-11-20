public class Model {
    private int side;
    Status[][] grid;

    public Model(String message, ECL ecl) {

        generateCode(message, ecl);
    }

    private int determineVersion(String message, ECL ecl, Mode mode) {
        int version = 1;
        switch (mode) {
            case NUMERIC:
                //somecode
                break;
            case ALPHANUMERIC:
                //dfwads
                break;
            case BYTE:
                switch (ecl) {
                    case L:
                        break;
                    case M:
                        break;
                    case Q:
                        break;
                    case H:
                        break;
                }
                break;
            case KANJI:
                //byhbyr
                break;
        }
        return version;
    }

    private void generateCode(String message, ECL ecl) {
        Mode mode = determineMode(message);
        int version = determineVersion(message, ecl, mode);
        side = (version - 1) * 4 + 21;
        grid = new Status[side][side];
        for (int r = 0; r < side; r++) {
            for (int c = 0; c < side; c++) {
                grid[r][c] = Status.NEUTRAL;
            }
        }
        generatePosSquare(0, 0);
        generatePosSquare(0, side - 7);
        generatePosSquare(side - 7, 0);
    }

    private Mode determineMode(String message) {
        boolean isNumeric = true;
        boolean isAlphaNumeric = true;
        boolean isBytes = true;
        boolean isKanji = true; //TODO Add kanji support
        String alphaNumeric = " $%*+-./:";
        for (char c : message.toCharArray()) {
            if (isNumeric && !Character.isDigit(c)) {
                isNumeric = false;
            }
            if (isAlphaNumeric && (!Character.isDigit(c) && !Character.isUpperCase(c) && !contains(alphaNumeric, c))) {
                isAlphaNumeric = false;
            }
            if (!isNumeric && !isAlphaNumeric) {
                break;
            }
        }
        /*
        if (isNumeric) {
            return Mode.NUMERIC;
        }
        if (isAlphaNumeric) {
            return Mode.ALPHANUMERIC;
        }*/
        return Mode.BYTE;
    }

    private boolean contains(String string, char c) {
        for (char t : string.toCharArray()) {
            if (c == t) {
                return true;
            }
        }
        return false;
    }

    private void generatePosSquare(int x, int y) {
        generateSquare(x, y, 7, 7, Status.BLACK);
        generateSquare(x + 1, y + 1, 5, 5, Status.WHITE);
        generateSquare(x + 2, y + 2, 3, 3, Status.BLACK);
    }

    private void generateSquare(int x, int y, int width, int height, Status status) {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                grid[y + r][x + c] = status;
            }
        }
    }
}
