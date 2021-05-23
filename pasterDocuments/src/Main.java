import file.manager.FileTextManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FileTextManager fileTextManager=new FileTextManager();
        try {
            fileTextManager.pasteDocuments("data","out.txt");
            fileTextManager.pasteDocumentsByDate("data","out_data");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
