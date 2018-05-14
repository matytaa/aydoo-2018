package ar.edu.untref.aydoo;

public class PrinterAdder extends Printer {
    @Override
    public String print(String textToPrint) {
        //Se retorna sumatoria de valores
        String[] splittedString = textToPrint.split(" ");
        int number = 0;
        for (int i = 1; i < splittedString.length; i++) {
            number += Integer.parseInt(splittedString[i]);
        }
        textToPrint = " " + number;

        return textToPrint;
    }
}
