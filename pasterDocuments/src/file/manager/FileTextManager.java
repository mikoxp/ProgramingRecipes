package file.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author michal.oles
 */
public class FileTextManager {

    private final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss";
    private final String DATE_FORMAT_WITHOUT_TIME = "dd-MM-yyyy";

    /**
     * @param dictionary dictionary
     * @param outputPath destination file path
     */
    public void pasteDocuments(String dictionary, String outputPath) throws IOException {
        PrintWriter writer = new PrintWriter(outputPath);
        File file = new File(dictionary);
        writeFileToDocuments(writer, file);
        writer.close();
    }

    /**
     * @param inputDictionary  inputDictionary
     * @param outputDictionary outputDictionary
     */
    public void pasteDocumentsByDate(String inputDictionary, String outputDictionary) throws FileNotFoundException {
        File in = new File(inputDictionary);
        File out = new File(outputDictionary);
        if (!out.isDirectory()) {
            out.mkdir();
        }
        List<PathWithDate> pathWithDates = groupsPath(in);
        writeToFiles(out.getAbsolutePath(), pathWithDates);
    }

    /**
     * @param outPath       out path
     * @param pathWithDates list of path with date
     * @throws FileNotFoundException file not found
     */
    private void writeToFiles(String outPath, List<PathWithDate> pathWithDates) throws FileNotFoundException {
        Set<String> fileNames = new HashSet<>();
        for (PathWithDate p : pathWithDates) {
            fileNames.add(p.getDate());
        }
        PrintWriter writer = null;
        for (String s : fileNames) {
            writer = new PrintWriter(outPath + "/" + s + ".txt");
            for (PathWithDate p : pathWithDates) {
                if (s.equals(p.getDate())) {
                    writeTextFromFile(writer, new File(p.getPath()));
                }
            }
            writer.close();

        }
    }

    /**
     * @param currentFile curent file
     * @return list of path with date
     */
    private List<PathWithDate> groupsPath(File currentFile) {
        List<PathWithDate> pathGrouperList;
        pathGrouperList = new LinkedList<>();
        findAndWriteFileInDictionary(pathGrouperList, currentFile);
        return pathGrouperList;
    }

    /**
     * @param pathGrouperList list of path with date
     * @param currentFile     current file
     */
    private void findAndWriteFileInDictionary(List<PathWithDate> pathGrouperList, File currentFile) {
        String date;
        String path;
        if (currentFile.isDirectory()) {
            addToListAllInDirectory(pathGrouperList, currentFile);
        } else {
            date = getDateToFormatWithoutTime(currentFile.lastModified());
            path = currentFile.getAbsolutePath();
            pathGrouperList.add(new PathWithDate(date, path));
        }
    }

    /**
     * @param pathGrouperList list of path with date
     * @param currentFile     current file
     */
    private void addToListAllInDirectory(List<PathWithDate> pathGrouperList, File currentFile) {
        File[] filesInDictionary;
        filesInDictionary = currentFile.listFiles();
        if (filesInDictionary != null) {
            for (File file : filesInDictionary) {
                findAndWriteFileInDictionary(pathGrouperList, file);
            }
        }
    }

    /**
     * @param writer      writer
     * @param currentFile current file
     */
    private void writeFileToDocuments(PrintWriter writer, File currentFile) {
        if (currentFile.isDirectory()) {
            findAndWriteFileInDictionary(writer, currentFile);
        } else {
            writeTextFromFile(writer, currentFile);
        }
    }

    /**
     * @param writer      writer
     * @param currentFile current file
     */
    private void findAndWriteFileInDictionary(PrintWriter writer, File currentFile) {
        File[] filesInDictionary = currentFile.listFiles();
        if (filesInDictionary != null) {
            for (File file : filesInDictionary) {
                writeFileToDocuments(writer, file);
            }
        }
    }

    /**
     * @param writer      writer
     * @param currentFile current file
     */
    private void writeTextFromFile(PrintWriter writer, File currentFile) {
        try {
            Scanner scanner = new Scanner(currentFile);
            writer.println("------------");
            writer.println(currentFile.getAbsolutePath());
            writer.println(getDateToFormat(currentFile.lastModified()));
            writer.println("------------");
            do {
                writer.println(scanner.next());
            } while (scanner.hasNext());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param lastModification last modification
     * @return data in format
     */
    private String getDateToFormat(Long lastModification) {
        Date date = new Date(lastModification);
        SimpleDateFormat dateFormater = new SimpleDateFormat(DATE_FORMAT);
        return dateFormater.format(date);
    }

    /**
     * @param lastModification last modification
     * @return data in format withut time
     */
    private String getDateToFormatWithoutTime(Long lastModification) {
        Date date = new Date(lastModification);
        SimpleDateFormat dateFormater = new SimpleDateFormat(DATE_FORMAT_WITHOUT_TIME);
        return dateFormater.format(date);
    }
}
