package ar.edu.untref.aydoo;

import java.util.Arrays;
import java.util.List;

public class PrinterMain implements Printer {

    private final String[] args;
    private final List argsAsList;

    public PrinterMain(String[] args) {
        this.args = args;
        this.argsAsList = Arrays.asList(args);
    }

    public String print(String textToPrint) {

        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].matches("-o=[vhp][i]")) {
                textToPrint = new PrinterWithDirection('i').print(textToPrint);
            }
            if (args[i].matches("-o=[v][di]")) {
                textToPrint = new PrinterWithOrientation('v').print(textToPrint);
            }
            if (args[i].matches("-o=[p][di]")) {
                textToPrint = new PrinterWithProgress().print(textToPrint);
            }
        }
        return textToPrint;
    }

    String verifyPairs(String textToPrint){
        if (argsAsList.contains("-n=p")) {
            textToPrint = new PrinterOnlyPairs().print(textToPrint);
        }
        return textToPrint;
    }

    String verifyAdder(String newPrefix){
        if (containAdder()) {
            newPrefix += "s";
        }
        return newPrefix;
    }

    String implementAdder(String textToPrint) {
        if (containAdder()) {
            textToPrint = new PrinterAdder().print(textToPrint);
        }
        return textToPrint;
    }

    private boolean containAdder(){
        return argsAsList.contains("-m=s");
    }
}
