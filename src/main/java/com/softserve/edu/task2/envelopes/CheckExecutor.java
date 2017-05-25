package com.softserve.edu.task2.envelopes;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

/**
 * check if possible insert one envelope into the another one
 * Created by cdc89 on 25.05.2017.
 */
public class CheckExecutor {
    /**
     * check if possible insert one envelope into the another one
     */
    public void execute(){
        while (true){
            System.out.println("Insert width of the first envelope :");
            double firstWidth=getSide();
            System.out.println("Insert length of the first envelope :");
            double firstLength=getSide();
            Envelope firstEnvelope=new Envelope(firstLength,firstWidth);
            System.out.println("Insert width of the second envelope :");
            double secondWidth=getSide();
            System.out.println("Insert length of the second envelope :");
            double secondLength=getSide();
            Envelope secondEnvelope=new Envelope(secondLength,secondWidth);
            if (firstEnvelope.isCanInsert(secondEnvelope)){
                System.out.println("Second envelope can be inserted into the first one");
            } else {
                System.out.println("Second envelope can not be inserted into the first one");
            }
            checkExit();
        }
    }

    private void checkExit() {
        System.out.println("Do you want to proceed ?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!input.equalsIgnoreCase("yes")&&!input.equalsIgnoreCase("y")){
            System.exit(0);
        }
    }

    private double getSide(){
        Scanner scanner = new Scanner(System.in);
        double side=-1;
        String input = scanner.nextLine();
        NumberFormat numberFormat=NumberFormat.getNumberInstance(Locale.ENGLISH);
        try {
            side=numberFormat.parse(input).doubleValue();
            if (side<=0){
                throw new ParseException("incorrect value",0);
            }
        } catch (ParseException e) {
            System.out.println("Inserted incorrect value! Please try again !");
            side=getSide();
        }
        return side;
    }
}
