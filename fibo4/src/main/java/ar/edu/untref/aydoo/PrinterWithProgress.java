package ar.edu.untref.aydoo;

public class PrinterWithProgress extends Printer {
    @Override
    public String print(String textToPrint) {
        //Se arma cadena para impresión progresiva
        StringBuilder lastElement = new StringBuilder();
        String[] splittedString = textToPrint.split(" ");
        String textReturn = "\n";
        for (int i = 1; i < splittedString.length; i++) {
            lastElement.append(" ").append(splittedString[i]);
            String element =
                    lastElement.
                    toString().substring(1, lastElement.length());
            textReturn += element + "\n";
        }
        textToPrint = textReturn;

        return textToPrint;
    }
}
