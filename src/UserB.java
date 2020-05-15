import java.util.Random;

public class UserB {
    private int random;
    private int q;
    private int a;
    private int Ya;
    private int Yb;
    private int key;


    public UserB(int q, int a){
        Random r = new Random();
        this.random = r.nextInt(100) + 1;
        this.a = a;
        this.q = q;
        Yb = calculateYb();
    }

    private void calculateKey(){
        key = (Ya^random)%q;
    }

    public int getKey() {
        return key;
    }

    private int calculateYb(){
        return (a^random)%q;
    }

    private void setYa(int ya) {
        Ya = ya;
    }

    public int getYb() {
        return Yb;
    }

    public void exchange(UserA user){
        setYa(user.getYa());
        calculateKey();
    }

    public String getMessage(){
        String message = "Cryptography is so cool!";
        return CaesarCipherJava.encrypt(message,key%26);
    }

    public String decryptMessageWithOwnKey(String message){
        return CaesarCipherJava.decrypt(message,key%26);
    }
}