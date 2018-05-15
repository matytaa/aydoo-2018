package ar.edu.untref.aydoo;

public class PrinterOnlyPairs implements Printer {
    @Override
    public String print(String textToPrint) {
        //Solo se retornan los numeros pares
        StringBuilder newText = new StringBuilder();
        String[] splittedString = textToPrint.split(" ");
        for (int i = 1; i < splittedString.length; i++) {
            int number = Integer.parseInt(splittedString[i]);
            if (number % 2 == 0) {
                newText.append(" ").append(splittedString[i]);
            }
        }
        textToPrint = newText.toString();

        return textToPrint;
    }
}
