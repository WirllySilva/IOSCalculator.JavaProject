package javacalculatorproject.model;

import java.util.List;
import java.util.ArrayList;


public class Memory {

    private enum CommandType {
        All_CLEAR, NUMBER, COMMA, ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, EQUAL, SIGN
    };

    private static final Memory instance =  new Memory();

    private final List<MemoryObserver> observers = new ArrayList<>();

    private CommandType lastOperation = null;
    private boolean replaceText = false;
    private String currentText = "";
    private String textBuffer = "";

    private Memory() {

    }

    public String getCurrentText() {
        return currentText.isEmpty() ? "0" : currentText;
    }

    public void carryOutCommand(String text) {

        CommandType commandType = detectCommandType(text);
        
        if(commandType == null) {
            return;
        } else if(commandType == CommandType.All_CLEAR) {
            currentText = "";
            textBuffer = "";
            replaceText = false;
            lastOperation = null;
        } else if(commandType == CommandType.SIGN && currentText.contains("-")) {
            currentText = currentText.substring(1);
        } else if(commandType == CommandType.SIGN && currentText.contains("")) {
            currentText = "-" + currentText;
        } else if(commandType == CommandType.NUMBER || commandType == CommandType.COMMA) {
            currentText = replaceText ? text : currentText + text;
            replaceText = false;
        } else {
            replaceText = true;
            currentText = getResultOperation();
            textBuffer = currentText;
            lastOperation = commandType;
        }
        observers.forEach(o -> o.changedValue(getCurrentText()));
    } 

      private String getResultOperation() {
        if(lastOperation == null || lastOperation == CommandType.EQUAL) {
            return currentText;
        }

        double numberBuffer = Double.parseDouble(textBuffer.replace(",", "."));
        double currentNumber = Double.parseDouble(currentText.replace(",", "."));
         
        double result = 0;

        if(lastOperation == CommandType.ADDITION) {
            result = numberBuffer + currentNumber;
        } else if(lastOperation == CommandType.SUBTRACTION) {
            result = numberBuffer - currentNumber;
        } else if(lastOperation == CommandType.MULTIPLICATION) {
            result = numberBuffer * currentNumber;
        } else if(lastOperation == CommandType.DIVISION) {
            result = numberBuffer / currentNumber;
        } 

        String stringResult = Double.toString(result).replace(".", ",");
        boolean integerNumber = stringResult.endsWith(",0");
        return integerNumber ?  stringResult.replace(",0", "") : stringResult;  
    }

    private CommandType detectCommandType(String text) {
        if(currentText.isEmpty() && text == "0") {
            return null;
        }
    try {
        Integer.parseInt(text);
        return CommandType.NUMBER;
    } catch (NumberFormatException exception) {
        // When the command is not a number.
        if("AC".equals(text)) {
            return CommandType.All_CLEAR;
        } else if("/".equals(text)) {
            return CommandType.DIVISION;
        } else if("+".equals(text)) {
            return CommandType.ADDITION;
        } else if("-".equals(text)) {
            return CommandType.SUBTRACTION;
        } else if("X".equals(text)) {
            return CommandType.MULTIPLICATION;
        } else if("=".equals(text)) {
            return CommandType.EQUAL;
        } else if("±".equals(text)) {
            return CommandType.SIGN;
        } else if(",".equals(text) && !currentText.contains(",")) {
            return CommandType.COMMA;
        } 
    }
        return null;
    }

    public void addObserver(MemoryObserver observer) {
        observers.add(observer);
    }

    public static Memory getInstance() {
        return instance;
    }
    
}
