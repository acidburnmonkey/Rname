// https://github.com/acidburnmonkey/Jname

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
public class globals {

    static boolean verbose = false;

    public static boolean isEmptyDirectory(File directory) {
        if (directory.isDirectory()) {
            // create a stream and check for files
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream( directory.toPath())) {
                // return false if there is a file
                return !directoryStream.iterator()
                        .hasNext();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        // return true if no file is present
        return true;
    }
}
