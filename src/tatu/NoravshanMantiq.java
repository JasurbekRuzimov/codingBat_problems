package tatu;

public class NoravshanMantiq{

//A: Bugun ob-havo yaxshi (haqiqiy yoki yolg’on)
//  B: Men ishga boraman (haqiqiy yoki yolg’on)
 // C: Men do’stim bilan uchrashaman (haqiqiy yoki yolg’on)


  public static void main(String[] args) {

    // Endi biz quyidagi ifodalar bo’yicha mantiqiy xulosalar chiqaramiz:
    //
    //A && B && C: Agar bugun ob-havo yaxshi bo’lsa, men ishga boraman va do’stim bilan uchrashaman.
    //A || B || C: Agar bugun ob-havo yaxshi bo’lsa yoki men ishga boraman yoki do’stim bilan uchrashaman.
    //(A && B) || C: Agar bugun ob-havo yaxshi bo’lsa va men ishga boraman, yoki men do’stim bilan uchrashaman.

    System.out.println("  A\t    B\t    C\t      A && B && C  \tA || B || C  \t(A && B) || C");
    boolean[] values = {false, true};
    for (boolean A : values) {
      for (boolean B : values) {
        for (boolean C : values) {
          System.out.println(A + "\t" + B + "\t" + C + "        \t" + (A && B && C) + "        \t" + (A || B || C) + "      \t" + ((A && B) || C));
        }
      }
    }
  }
}
