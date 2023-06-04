import java.io.Serializable;

public class virajenie implements Serializable {
    double x;
    double y;
    virajenie(double x){
        this.x=x;
    }
    void count(){
        y = x-Math.sin(x);
    }
}