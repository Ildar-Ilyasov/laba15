import java.io.*;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Для записи состояния объекта введите save ");
        System.out.println("Для записи состояния объекта введите upload");
        while(true) {
            String vvod = in.next();
            switch (vvod) {
                case "save" -> {
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result.txt"))) {
                        System.out.println("Введите x");
                        int x = in.nextInt();
                        Calculation calc = new Calculation(x);
                        calc.action();
                        oos.writeObject(calc);
                    }
                    catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case "upload" -> {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result.txt"))) {
                        Calculation calc = (Calculation)ois.readObject();
                        System.out.println("x=" + calc.x + " y=" + calc.y);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case "exit" -> {
                    return;
                }
                default -> System.out.println("не знаю такой команды");
            }
        }
    }
}