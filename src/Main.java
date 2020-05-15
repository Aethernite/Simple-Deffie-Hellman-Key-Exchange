import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ИЗПОЛЗВАЙТЕ МНОГО ГОЛЕМИ ЧИСЛА КАТО 50000!");
        System.out.println("Въведете q:");
        int q = Integer.parseInt(sc.nextLine());
        System.out.println("Въведете a:");
        int a = Integer.parseInt(sc.nextLine());


        UserB userb = new UserB(q,a); //Създават се обектите с публичните стойности на q и а
        UserA usera = new UserA(q,a);//При създаване на обектите се изчисляват стойностите за UserA - Ya и UserB - Yb
        usera.exchange(userb);        //Обектите обменят съответните стойности на Yb и Ya
        userb.exchange(usera);        //При обмяна те сами си изчисляват ключа според тези стойности


        //За да бъде алгоритъма устойчив срещу атаки - трябва да се ползва BigInteger и то числа, които са много
        // големи и на всичкото отгоре да са прости числа
        //Реализацията на произволното число в момента е направена така, че да изчислява производно число но в границите от 1 до 100
        //Възможно е да се получат ключовете различни ако не се ползва достатъчно голямо число!
        System.out.println("KEY UserA: " + usera.getKey()); //
        System.out.println("KEY UserB: " + userb.getKey());

        System.out.println("Encrypted message UserA:" + usera.getMessage());
        System.out.println("Encrypted message UserB:" + userb.getMessage());
        String userbMsg = userb.getMessage();
        String useraMsg = usera.getMessage();
        System.out.println("UserA decrypts UserB message with his key: " + usera.decryptMessageWithOwnKey(userbMsg));
        System.out.println("UserB decrypts UserA message with his key: "+ userb.decryptMessageWithOwnKey(useraMsg));




    }
}
