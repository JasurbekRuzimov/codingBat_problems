package tatu;

public class Main111 {
  public static void main(String[] args) {

    double uzoqYashaganInsonlarSoni = 40;
    double jami80Kam = 60;
    double erkaklarSoniUzoqYashagan = 18;
    double ayollarSoniUzoqYashagan = 22;
    double kam80Erkaklar = 36;
    double kam80Ayollar = 24;

    double UzoqYashagan = uzoqYashaganInsonlarSoni / jami80Kam;

    double UzoqYashagan_Erkak = (erkaklarSoniUzoqYashagan / uzoqYashaganInsonlarSoni) * (kam80Erkaklar / jami80Kam);
    double UzoqYashagan_Ayol = (ayollarSoniUzoqYashagan / uzoqYashaganInsonlarSoni) * (kam80Ayollar / jami80Kam);

    System.out.println("1) Aprior imkoniyat (Uzoq yashagan): " + UzoqYashagan);
    System.out.println("2) O'xshashlik munosabatlari:");
    System.out.println("   Uzoq yashagan: Erkak: " + UzoqYashagan_Erkak);
    System.out.println("   Uzoq yashagan: Ayol: " + UzoqYashagan_Ayol);

    System.out.println(" ---  XULOSA ---");
    if (UzoqYashagan>1){
      System.out.println("Gipotezalar foydasiga ishlaydi");
    } else if (UzoqYashagan < 1) {
      System.out.println("Gipotezalar foydasina ishlamidi");
    } else {
      System.out.println("Gipotezalar o'xshashligina ta'sir qilmidi");
    }

  }
}
