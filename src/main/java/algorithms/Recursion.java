package algorithms;

public class Recursion {

  public String stripZeros(String numberString) {

    if (numberString.startsWith("0")) {
      numberString = numberString.substring(1);
      return stripZeros(numberString);
    }

    return numberString;
  }

}
