package uz.pdp.CodingBatProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main55 {

  private static final int OTA_BOYLIK_RANGE_MIN = 140;
  private static final int OTA_BOYLIK_RANGE_MAX = 200;
  private static final int OTA_YOSH_RANGE_MIN = 20;
  private static final int OTA_YOSH_RANGE_MAX = 30;
  private static final int OTA_BMI_RANGE_MIN = 20;
  private static final int OTA_BMI_RANGE_MAX = 50;
  private static final int OTA_TIRNAGI_aytgan_range_MIN = 80;
  private static final int OTA_TIRNAGI_aytgan_range_MAX = 130;
  private static final int OTA_BOYNIGI_aytgan_range_MIN = 90;
  private static final int OTA_BOYNIGI_aytgan_range_MAX = 130;

  private static final int BOBOYLIK_RANGE_MIN = 140;
  private static final int BOBOYLIK_RANGE_MAX = 200;
  private static final int BOYOSH_RANGE_MIN = 50;
  private static final int BOYOSH_RANGE_MAX = 80;
  private static final int BOBMI_RANGE_MIN = 20;
  private static final int BOBMI_RANGE_MAX = 50;
  private static final int BOTIRNAGI_aytgan_range_MIN = 80;
  private static final int BOTIRNAGI_aytgan_range_MAX = 130;
  private static final int BOBOYNIGI_aytgan_range_MIN = 90;
  private static final int BOBOYNIGI_aytgan_range_MAX = 130;


  private static final int TESTOSTERON_DARAJASI_MIN = 5;
  private static final int TESTOSTERON_DARAJASI_MAX = 30;

  public static Map<String, Integer> otaningMalumotlariniGeneratsiyaQilish() {
    Map<String, Integer> otaningMalumotlari = new HashMap<>();
    Random random = new Random();
    otaningMalumotlari.put("boylik",
        random.nextInt((OTA_BOYLIK_RANGE_MAX - OTA_BOYLIK_RANGE_MIN) + 1) + OTA_BOYLIK_RANGE_MIN);
    otaningMalumotlari.put("yosh",
        random.nextInt((OTA_YOSH_RANGE_MAX - OTA_YOSH_RANGE_MIN) + 1) + OTA_YOSH_RANGE_MIN);
    otaningMalumotlari.put("BMI",
        random.nextInt((OTA_BMI_RANGE_MAX - OTA_BMI_RANGE_MIN) + 1) + OTA_BMI_RANGE_MIN);
    otaningMalumotlari.put("tirnagi_aytganlik",
        random.nextInt((OTA_TIRNAGI_aytgan_range_MAX - OTA_TIRNAGI_aytgan_range_MIN) + 1)
            + OTA_TIRNAGI_aytgan_range_MIN);
    otaningMalumotlari.put("boyningi_aytganlik",
        random.nextInt((OTA_BOYNIGI_aytgan_range_MAX - OTA_BOYNIGI_aytgan_range_MIN) + 1)
            + OTA_BOYNIGI_aytgan_range_MIN);
    return otaningMalumotlari;
  }

  public static Map<String, Integer> babaMalumotlariniGeneratsiyaQilish() {
    Map<String, Integer> babaMalumotlari = new HashMap<>();
    Random random = new Random();
    babaMalumotlari.put("boylik",
        random.nextInt((BOBOYLIK_RANGE_MAX - BOBOYLIK_RANGE_MIN) + 1) + BOBOYLIK_RANGE_MIN);
    babaMalumotlari.put("yosh",
        random.nextInt((BOYOSH_RANGE_MAX - BOYOSH_RANGE_MIN) + 1) + BOYOSH_RANGE_MIN);
    babaMalumotlari.put("BMI",
        random.nextInt((BOBMI_RANGE_MAX - BOBMI_RANGE_MIN) + 1) + BOBMI_RANGE_MIN);
    babaMalumotlari.put("tirnagi_aytganlik",
        random.nextInt((BOTIRNAGI_aytgan_range_MAX - BOTIRNAGI_aytgan_range_MIN) + 1)
            + BOTIRNAGI_aytgan_range_MIN);
    babaMalumotlari.put("boyningi_aytganlik",
        random.nextInt((BOBOYNIGI_aytgan_range_MAX - BOBOYNIGI_aytgan_range_MIN) + 1)
            + BOBOYNIGI_aytgan_range_MIN);
    return babaMalumotlari;
  }

  public static String bolaTestosteronDarajasiniAniqlash(int testosteronDarajasi) {
    if (testosteronDarajasi < 10) {
      return "Defitsit";
    } else if (testosteronDarajasi >= 10 && testosteronDarajasi <= 20) {
      return "Norma";
    } else {
      return "Izbuchon";
    }
  }

  public static void main(String[] args) {
    Map<String, Integer> otaningMalumotlari = otaningMalumotlariniGeneratsiyaQilish();
    Map<String, Integer> babaMalumotlari = babaMalumotlariniGeneratsiyaQilish();

    int bolaTestosteronDarajasi =
        new Random().nextInt((TESTOSTERON_DARAJASI_MAX - TESTOSTERON_DARAJASI_MIN) + 1)
            + TESTOSTERON_DARAJASI_MIN;
    String bolaTestosteronDarajasiSifati = bolaTestosteronDarajasiniAniqlash(
        bolaTestosteronDarajasi);

    System.out.println("Otamning ma'lumotlari: " + otaningMalumotlari);
    System.out.println("Bobo ma'lumotlari: " + babaMalumotlari);
    System.out.println("Bola testosteron darajasi: " + bolaTestosteronDarajasiSifati);
  }
}

