import java.io.*;
import java.io.ObjectOutputStream;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            String coms = in.next();
            if (Objects.equals(coms, "save")){
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result.txt"))) {
                    function urav = new function(in.nextInt());
                    urav.count();
                    oos.writeObject(urav);
                }
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
            else if (Objects.equals(coms, "upload")){
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result.txt"))) {
                    function calc = (function)ois.readObject();
                    System.out.println("y=" + calc.y);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            else{
                System.out.println("такой команды нет");
            }
        }
    }
}