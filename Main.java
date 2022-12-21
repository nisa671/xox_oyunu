import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class Merhaba {
    void yaz(){
        System.out.println("Oyunumuza hoşgeldiniz...");
    }


}
class Hosgeldiniz extends Merhaba {
    public void yaz(){
        System.out.println("Oyunumuza hoşgeldiniz...");

    }


}
class İyigunler extends Merhaba{
    public void yaz(){
        System.out.println("Oyunumuza katıldığınız için teşekkürler...");

    }



}
public class Main {


    static String[][] arrayMatris;
    static ArrayList<String> arrayHamleler;
    static boolean hamle = false;
    static boolean kazananvarMı = false;




    public static void main(String[] args) {


        Merhaba merhaba=new Hosgeldiniz();
        Merhaba iyigunler=new İyigunler();
        merhaba.yaz();


        arrayMatris = new String[3][3];
        OyunOyna();
        iyigunler.yaz();



    }


    public static void OyunOyna() {

        Random rnd = new Random();
        başla();
        olasıHamleler();
        for (int i = 0; i < 9; i++) {
            kazananvarMı = kazananvarMı();

            if (!kazananvarMı) {
                int rastgeleHamle = rnd.nextInt(arrayHamleler.size());
                String koordinat = arrayHamleler.get(rastgeleHamle);
                arrayHamleler.remove(rastgeleHamle);

                System.out.println(koordinat);
                int satır = Integer.parseInt("" + koordinat.charAt(0));
                int sütun = Integer.parseInt("" + koordinat.charAt(2));
                Oyna(!hamle, satır, sütun);
                yazdır();
            } else {
                String kazanan;
                if (hamle) {
                    kazanan = "o";
                } else {
                    kazanan = "x";
                }
                System.out.println("Oyunumuz bitmiştir.Kazanan: " + kazanan);
                return;
            }
            System.out.println("");
        }
        System.out.println("Oyunumuz bitmiştir.Durum berabere...");

    }


    public static void ikiKisilikOyunOyna() {

        Scanner giriş = new Scanner(System.in);

        başla();
        yazdır();
        for (int i = 0; i < 9; i++) {
            kazananvarMı = kazananvarMı();
            if (!kazananvarMı) {
                System.out.println("Lütfen hamle giriniz!");
                String koordinat = giriş.nextLine();
                System.out.println(koordinat);
                int satir = Integer.parseInt("" + koordinat.charAt(0));
                int sutun = Integer.parseInt("" + koordinat.charAt(2));
                System.out.println(satir + "," + sutun);
                Oyna(!hamle, satir, sutun);
                yazdır();
            } else {
                String kazanan;
                if (hamle) {
                    kazanan = "o";
                } else {
                    kazanan = "x";
                }
                System.out.println("Oyunumuz bitmiştir.Kazanan: " + kazanan);
                return;
            }

        }
        System.out.println("Oyunumuz bitmiştir.Durum berabere...");
    }
    public static void olasıHamleler() {
        arrayHamleler = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                String strHamle = i + " " + j;
                arrayHamleler.add(strHamle);

            }
        }
    }
    public static void yazdır() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arrayMatris[i][j]);
            }
            System.out.println("");
        }
    }
    public static void başla() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrayMatris[i][j] = "- ";
            }
        }
    }
    public static void Oyna(boolean x, int i, int j) {
        if (arrayMatris[i - 1][j - 1].equalsIgnoreCase("- ")) {
            if (x) {
                arrayMatris[i - 1][j - 1] = "o ";
            } else {
                arrayMatris[i - 1][j - 1] = "x ";
            }
            hamle = !hamle;
        } else {
            System.out.println("Yanlış yer,buraya hamle yapamazsın!");
        }
    }
    public static boolean kazananvarMı() {
        String harf = arrayMatris[1][1];
        if (!harf.equalsIgnoreCase("- ")) {
            if (arrayMatris[1][0].equals(harf) && arrayMatris[1][2].equals(harf)) {
                System.out.println("Kontrol edeceğin yer:orta yatay");
                return true;
            } else if (arrayMatris[2][0].equals(harf) && arrayMatris[0][2].equals(harf)) {
                System.out.println("Kontrol edeceğin yer:sağ üstten,sol alta çapraz");
                return true;
            } else if (arrayMatris[0][0].equals(harf) && arrayMatris[2][2].equals(harf)) {
                System.out.println("Kontrol edeceğin yer:sol üstten,sağ alta çapraz");
                return true;
            } else if (arrayMatris[0][1].equals(harf) && arrayMatris[2][1].equals(harf)) {
                System.out.println("Kontrol edeceğin yer:orta dikey");
                return true;
            }
            harf = arrayMatris[0][0];
            if (!harf.equalsIgnoreCase("- ")) {
                if (arrayMatris[0][1].equals(harf) && arrayMatris[0][2].equals(harf)) {
                    System.out.println("Kontrol edeceğin yer:üst yatay");
                    return true;
                } else if (arrayMatris[1][0].equals(harf) && arrayMatris[2][0].equals(harf)) {
                    System.out.println("Kontrol edeceğin yer:üst dikey");
                    return true;
                }
                }
            harf = arrayMatris[2][0];
            if (!harf.equalsIgnoreCase("- ")) {

                if (arrayMatris[2][1].equals(harf) && arrayMatris[2][2].equals(harf)) {
                    System.out.println("Kontrol edeceğin yer:alt yatay");
                    return true;
                }
                harf = arrayMatris[0][2];
                if (!harf.equalsIgnoreCase("- ")) {
                    if (arrayMatris[1][2].equals(harf) && arrayMatris[2][2].equals(harf)) {
                        System.out.println("Kontrol edeceğin yer:son dikey");
                        return true;
                    }
                }

            }
            }
        return false;
    }


}


