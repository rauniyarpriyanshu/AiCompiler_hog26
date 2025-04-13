package com.hog26.aicompiler.controller.menu;

import bsh.EvalError;
import bsh.Interpreter;
import com.hog26.aicompiler.component.CodeEditorJava;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;


public class RunCodeListener {
    private CodeEditorJava codeArea;

    public RunCodeListener(CodeEditorJava area) {
        codeArea = area;
    }

    public void runCode(TextArea console) {
        Interpreter interpreter = new Interpreter();
        PrintStream outStream = new PrintStream(new ConsoleOutStream(console), true);
       /* interpreter.setOut(outStream);
        interpreter.setErr(outStream);*/

        System.setOut(outStream);
        System.setErr(outStream);
        try {
            interpreter.eval( codeArea.getCodeArea().getText().trim());
        } catch (EvalError e) {
           // interpreter.eval()
            console.appendText(" Error: "+e+"\n");
            console.appendText(">>> ");

        }
    }

    static class ConsoleOutStream extends OutputStream {
        private TextArea consolePrinter;

        public ConsoleOutStream(TextArea consoleView) {
            consolePrinter = consoleView;
        }

        @Override
        public void write(int b) {
            Platform.runLater(() -> {
                if (b == '\n') {
                    consolePrinter.appendText(String.valueOf((char) b));
                    consolePrinter.appendText(">>> ");
                } else {
                    consolePrinter.appendText(String.valueOf((char) b));
                }

            });
        }

        @Override
        public void write(byte[] b, int off, int len) {
            String text = new String(b, off, len);
            Platform.runLater(() -> {
                if (text.charAt(text.length() - 1) == '\n') {
                    consolePrinter.appendText(text);
                    consolePrinter.appendText(">>> ");
                } else {
                    consolePrinter.appendText(text);
                }
            });
        }
    }
}
