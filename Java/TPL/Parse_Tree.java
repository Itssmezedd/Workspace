import java.util.Scanner;

public class Parse_Tree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = "int x = 1 + 1 + 1 + 1 ;";
        System.out.println(parser(input));

    }

    public static String parser(String input) {
        String result = "";

        String[] data_types = { "int", "double" };
        String[] operators = { "+", "-", "*", "/" };

        String[] splitted = input.trim().split(" ");
        int len = splitted.length;

        String[] row = new String[len * 2];
        for (int i = 0; i < len * 2; i++) {
            row[i] = "";
        }

        int rowcurr = 0;
        int indent = 0;

        for (int i = 0; i < len; i++) {
            String current = splitted[i];

            if (current.equals("")) {
                continue;
            }
            if (current.equals(";")) {
                if (row[rowcurr + 2].equals("")) {
                    row[rowcurr + 1] += repeat(" ", indent);
                    row[rowcurr + 2] += repeat(" ", indent);
                }

                String stri2 = "<delimiter>";
                int leng = stri2.length();
                row[rowcurr] += centerthis(stri2, leng);
                row[rowcurr + 1] += centerthis("|", leng);
                row[rowcurr + 2] += centerthis(current, leng);
                rowcurr += 3;
            } else if (current.equals("=")) {
                row[rowcurr] += "=";
                row[rowcurr + 1] += " ";
                row[rowcurr + 2] += " ";
            } else if (isIn(current, data_types)) {
                String stri2 = "<data_type>";
                rowcurr += 2;
                row[rowcurr - 2] += centerthis("<assign>", stri2.length() * 2 + 3);
                row[rowcurr - 1] += centerthis("/      \\", stri2.length() * 2 + 3);
                row[rowcurr] += centerthis(stri2, stri2.length() + 3);
                row[rowcurr + 1] += centerthis("|", stri2.length() + 3);
                row[rowcurr + 2] += centerthis(current, stri2.length() + 3);
            } else if (isIn(current, operators)) {
                if (row[rowcurr + 2].equals("")) {
                    row[rowcurr + 1] += repeat(" ", indent);
                    row[rowcurr + 2] += repeat(" ", indent);
                }

                String stri2 = "<expression>";
                int leng = stri2.length();
                row[rowcurr] += centerthis(stri2, leng * 2);
                row[rowcurr + 1] += centerthis("/", leng) +
                        centerthis("\\", leng);
                row[rowcurr + 2] += centerthis(current, leng);

                rowcurr += 2;
                indent = row[rowcurr].length();
            } else if (isNumeric(current)) {
                if (row[rowcurr + 2].equals("")) {
                    row[rowcurr + 1] += repeat(" ", indent);
                    row[rowcurr + 2] += repeat(" ", indent);
                }

                String stri2 = "<value>";
                int leng = stri2.length();
                row[rowcurr] += centerthis(stri2, leng * 2);
                row[rowcurr + 1] += centerthis("/", leng) +
                        centerthis("\\", leng);
                row[rowcurr + 2] += centerthis(current, leng);

                rowcurr += 2;
                indent = row[rowcurr].length();
            } else if (isAlphaNumeric(current)) {
                String stri2 = "<identifier>";
                row[rowcurr] += centerthis(stri2, stri2.length() + 3);
                row[rowcurr + 1] += centerthis("|", stri2.length() + 3);
                row[rowcurr + 2] += centerthis(current, stri2.length() + 3);
            } else {
                return "Not Semantics";
            }
        }

        for (int i = 0; i < rowcurr; i++) {
            result += row[i] + "\n";
        }

        return result;
    }

    public static boolean isIn(String search, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (search.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String string) {
        int intValue;
        if (string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }

    public static String centerthis(String str, int spacing) {
        int count = spacing - str.length();

        return (repeat(" ", count / 2)
                + str +
                repeat(" ", (count / 2) + count % 2));
    }

    public static String repeat(String str, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += str;
        }
        return result;
    }
}