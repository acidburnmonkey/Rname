import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        // ORIGINAL FILE
        String file1 = "here/second/newdir";
        File OriginalFile = new File(file1);

        // Builds the parent path
        Path path = Paths.get(file1);
        path = path.getParent();

//        System.out.println(path.resolve("aaa"));


        if ( OriginalFile.exists() & OriginalFile.isFile() ){
            System.out.println(" File exist");

            // RENAME To
            var user =  path.resolve("renamed");
            File file2 = new File(user.toString());
            OriginalFile.renameTo(file2);

        }

        else if ( OriginalFile.exists() & OriginalFile.isDirectory() ){
            System.out.println(" Directory exist");

            // RENAME To
            var user =  path.resolve("old");
            File file2 = new File(user.toString());
            OriginalFile.renameTo(file2);
        }

        else{
            System.out.println("File not Found");
        }

    }
}