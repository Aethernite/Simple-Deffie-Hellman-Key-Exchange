import java.util.Scanner;

public class CaesarCipherJava {

public static String encrypt(String message, int key){
            char ch;
            StringBuilder encryptedMessage = new StringBuilder();
            for (int i = 0; i < message.length(); ++i) {
                ch = message.charAt(i);

                if (ch >= 'a' && ch <= 'z') {
                    ch = (char) (ch + key);

                    if (ch > 'z') {
                        ch = (char) (ch - 'z' + 'a' - 1);
                    }

                    encryptedMessage.append(ch);
                } else if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch + key);

                    if (ch > 'Z') {
                        ch = (char) (ch - 'Z' + 'A' - 1);
                    }

                    encryptedMessage.append(ch);
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
}

public static String decrypt(String message, int key){
    char ch;
    StringBuilder decryptedMessage= new StringBuilder();
    for(int i = 0; i < message.length(); ++i){
        ch = message.charAt(i);

        if(ch >= 'a' && ch <= 'z'){
            ch = (char)(ch - key);

            if(ch < 'a'){
                ch = (char)(ch + 'z' - 'a' + 1);
            }

            decryptedMessage.append(ch);
        }
        else if(ch >= 'A' && ch <= 'Z'){
            ch = (char)(ch - key);

            if(ch < 'A'){
                ch = (char)(ch + 'Z' - 'A' + 1);
            }

            decryptedMessage.append(ch);
        }
        else {
            decryptedMessage.append(ch);
        }
    }
    return decryptedMessage.toString();
}
}

