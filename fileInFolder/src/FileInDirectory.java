import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by moles on 2016-11-13.
 * @author moles
 */
public class FileInDirectory {
    /**
     *
     * @param folderPath path to mapped folder
     * @return list of file path
     */
    public static List<String> getFilePath(String folderPath){
        List<String> paths=new ArrayList<>();
        File folder=new File(folderPath);
        if(!folder.isDirectory()){
            throw new IllegalArgumentException("This is not directory");
        }
        while(folderPath.charAt(folderPath.length()-1)=='/'){
            folderPath=folderPath.substring(0,folderPath.length()-2);
        }
        String currentPath;
        for(File f:folder.listFiles()){
            currentPath=folderPath+"/"+f.getName();;
            if(f.isFile()){
                paths.add(currentPath);
            }
            else{
                paths.addAll(getFilePath(currentPath));
            }
        }
        return paths;
    }
}
