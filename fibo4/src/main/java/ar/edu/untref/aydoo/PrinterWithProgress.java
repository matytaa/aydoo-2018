package ar.edu.untref.aydoo;

public class PrinterWithProgress implements Printer {
    @Override
    public String print(String textToPrint) {
        //Se arma cadena para impresión progresiva
        StringBuilder lastElement = new StringBuilder();
        String[] splittedString = textToPrint.split(" ");
        String textReturn = "";
        for (int i = 1; i < splittedString.length; i++) {
            lastElement.append(" ").append(splittedString[i]);
            String element =
                    lastElement.
                            toString().substring(1, lastElement.length());
            textReturn += "\n" + element;
        }
        textToPrint = textReturn;

        return textToPrint;
    }
}
