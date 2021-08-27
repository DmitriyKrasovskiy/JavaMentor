import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение [2+2] цифры от 1 до 10 " +
                "или два римских числа от I до X:[V+V] + Enter");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line = line.replaceAll(" ", "");
        List<Character> operators = (List<Character>) Arrays.asList('+', '-', '*');
        String[] strNumbers = line.split("[-*+/]");
        BigDecimal a, b, c = new BigDecimal(0.0);
        if(isDouble(strNumbers[0]) || isDouble(strNumbers[1])) throw new MyExeption("введены вещественные числа");
        if(strNumbers.length > 2) throw new MyExeption("слишком длинная операция");
        try {
            if (strNumbers[0].matches("[-+]?\\d+") && strNumbers[1].matches("[-+]?\\d+")
                    || !strNumbers[0].matches("[-+]?\\d+") && !strNumbers[1].matches("[-+]?\\d+")) {
                if (strNumbers[0].matches("[-+]?\\d+")) {
                    a = new BigDecimal(Integer.parseInt(strNumbers[0]));
                    b = new BigDecimal(Integer.parseInt(strNumbers[1]));
                } else {
                    a = new BigDecimal(new RomanNumbers(strNumbers[0]).getInt());
                    b = new BigDecimal(new RomanNumbers(strNumbers[1]).getInt());
                }
                if (a.intValue() > 10 || a.intValue() < 1 || b.intValue() < 1 || b.intValue() > 10) throw new MyExeption("вышло за границы");
                if (line.indexOf('+') != -1) {
                    c = a.add(b);
                } else if (line.indexOf('-') != -1) {
                    c = a.subtract(b);
                } else if (line.indexOf('*') != -1) {
                    c = a.multiply(b);
                } else if (line.indexOf('/') != -1) {
                    MathContext mc = new MathContext(1, RoundingMode.HALF_DOWN);
                    c = a.divide(b, mc);
                }


                //if(isDouble(c)) throw new MyExeption("недопустимый тип");
                if (!strNumbers[0].matches("[-+]?\\d+")) {
                    System.out.println(new RomanNumbers(c.intValue()));
                } else {
                    System.out.println(c);
                }

            } else {
                throw new MyExeption("разные типы чисел");
            }
        }catch (ArrayIndexOutOfBoundsException e ) {
            throw new MyExeption("не найдена операция");
        }
    }

    private static boolean isDouble(BigDecimal d) {
        int i = d.intValue();
        if(!d.subtract(new BigDecimal(i)).equals(new BigDecimal(0.0))) {
            return true;
        }
        else return false;
    }

    private static boolean isDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            if(s.contains(".")) return true;
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


