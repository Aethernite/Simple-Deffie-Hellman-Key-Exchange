import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class UserA {
    private int random;
    private int q;
    private int a;
    private int Ya;
    private int Yb;
    private int key;


    public UserA(int q, int a){
        Random r = new Random();
        this.random = r.nextInt(100) + 1;
        this.a = a;
        this.q = q;
        Ya = calculateYa();
    }

    private int calculateYa(){
        return (a^random)%q;
    }

    private void setYb(int yb) {
        Yb = yb;
    }

    public int getYa() {
        return Ya;
    }

    public void exchange(UserB user){
       setYb(user.getYb());
        calculateKey();
    }

    private void calculateKey(){
        key = (Yb^random)%q;
    }

    public int getKey() {
        return key;
    }

    public String getMessage(){
        String message = "This is simple Deffie-Hellman key exchange";
        return CaesarCipherJava.encrypt(message,key%26);
    }

    public String decryptMessageWithOwnKey(String message){
        return CaesarCipherJava.decrypt(message,key%26);
    }


}
