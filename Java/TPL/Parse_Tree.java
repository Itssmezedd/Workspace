import java.util.ArrayList;
import java.util.Scanner;

public class Parse_Tree {
    static String temp = "";
    private static ArrayList<String> coll_lexemes = new ArrayList<String>();
    private static final ArrayList<String> dataTypes = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String input = in.nextLine();
        // System.out.println(parser(input));
        System.out.println(parser(input));
        in.close();
    }

    public static String parser(String input) {
        String result = "";

        String[] data_types = { "int", "double", "boolean", "String", "char" };
        String[] operators = { "+", "-", "*", "/" };
        coll_lexemes = splitLexemes(coll_lexemes, input);
        String[] splitted = arrToList(coll_lexemes);
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
            } else if (isString(current, splitted, data_types)) {

                for (int j = 0; j < current.length(); j++) {
                    temp += current.charAt(j);
                }
                if (current.endsWith("\"")) {
                    if (row[rowcurr + 2].equals("")) {
                        row[rowcurr + 1] += repeat(" ", indent);
                        row[rowcurr + 2] += repeat(" ", indent);
                    }

                    String stri2 = "<value>";
                    int leng = stri2.length();
                    row[rowcurr] += centerthis(stri2, leng * 2);
                    row[rowcurr + 1] += centerthis("/", leng) +
                            centerthis("\\", leng);
                    row[rowcurr + 2] += centerthis(temp, leng);

                    rowcurr += 2;
                    indent = row[rowcurr].length();
                } else {
                    continue;
                }
            } else if (isInteger(current, splitted, data_types)) {
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
            } else if (isDouble(current, splitted, data_types)) {
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
            } else if (isChar(current, splitted, data_types)) {
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
            } else if (isBoolean(current, splitted, data_types)) {
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
            } else if (isAlphaNumeric(current) && current.contentEquals(splitted[1])) {
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

    public static String[] arrToList(ArrayList<String> lexemes) {
        String[] splitted = new String[lexemes.size()];

        for (int x = 0; x < splitted.length; x++) {
            splitted[x] = lexemes.get(x);
        }
        return splitted;
    }

    public static ArrayList<String> splitLexemes(ArrayList<String> coll_lexemes, String input) {
        String lexeme = "";

        for (int x = 0; x < input.length(); x++) {
            String temp = Character.toString(input.charAt(x));

            // if temp is equal to double or single quotation
            if (input.charAt(x) == '"' || temp.equals("'")) {
                int count = 1;// determine how many quotations
                String tempStr = "";
                /* Loop to store the String values */
                for (int y = x; y < input.length(); y++) {
                    char input_char = input.charAt(y);

                    // if it is the first double or single quotation
                    if ((input_char == '"' || Character.toString(input_char).equals("'")) && count == 1) {
                        count++;
                        tempStr += Character.toString(input_char);
                    }
                    // if it is the second double or single quotation
                    else if ((input_char == '"' || Character.toString(input_char).equals("'")) && count == 2) {
                        count++;
                        tempStr = tempStr + Character.toString(input_char);
                        coll_lexemes.add(tempStr);
                        x = y;
                        break;
                    } else {
                        tempStr += Character.toString(input_char);
                    }
                }
                lexeme = "";

            }
            // if temp is equal to assignment operator
            else if (temp.equals("=")) {
                setColl_Lexemes(lexeme);
                coll_lexemes.add("=");
                lexeme = "";
            }
            // if temp is equal to semi-colon
            else if (temp.equals(";")) {
                setColl_Lexemes(lexeme);
                coll_lexemes.add(";");
                lexeme = "";
            }
            // if x is at the last character of input
            else if (x == input.length() - 1) {
                lexeme += temp;
                setColl_Lexemes(lexeme);
            }
            // if lexeme is within the dataTypes
            // store the lexeme
            else if (dataTypes.contains(lexeme) && input.charAt(x + 1) == ' ') {
                setColl_Lexemes(lexeme);
                lexeme = "";
            }

            // if lexeme is an identifier
            else if (lexeme.isEmpty() == false && (temp.equals(" "))) {
                setColl_Lexemes(lexeme);
                lexeme = "";
            } else {

                if (temp.equals(" ")) {

                } else {
                    lexeme += temp;
                }

            }
        }
        return coll_lexemes;
    }

    public static void setColl_Lexemes(String lexeme) {
        if (lexeme.isEmpty() == false) {
            coll_lexemes.add(lexeme);
        }
    }

    public static boolean isIn(String search, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (search.equals(array[i])) {
                return true;
            }
        }

        return false;
    }

    public static boolean isChar(String s, String[] array, String[] dataType) {
        return s != null && s.length() == 3 && s.startsWith("\'") && s.endsWith("\'");
    }

    public static boolean isBoolean(String s, String[] array, String[] dataType) {
        return s != null && s.contentEquals("True") || s.contentEquals("true") || s.contentEquals("False")
                || s.contentEquals("false") && array[0].contentEquals(dataType[2]) && !(array[1].contentEquals("True"))
                        && !(array[1].contentEquals("true") && !(array[1].contentEquals("False"))
                                && !(array[1].contentEquals("false")));
    }

    public static boolean isInteger(String string, String[] array, String[] dataType) {
        int intValue;
        if (string == null || string.equals("")) {
            return false;
        }

        try {
            if (!(string.contains(".")) && array[0].contains(dataType[0])) {
                intValue = Integer.parseInt(string);
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String string, String[] array, String[] dataType) {
        double doubleValue;
        if (string == null || string.equals("")) {
            return false;
        }

        try {
            if (string.contains(".") && array[0].contains(dataType[1])) {
                doubleValue = Double.parseDouble(string);
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }

    public static boolean isString(String s, String[] array, String[] dataType) {
        if (s != null && s.startsWith("\"") && array[0].contains(dataType[3])) {
            return true;
        } else {
            return false;
        }

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