
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    // HELP Switch
    public static void help(){
        String str = "usage this is the help page";
        System.out.println(str);
    }


    // Checks for switches -v or -h
    public static boolean switches(String zero){
        if (zero.equals("-v")){
            return true;
        }
        else if (zero.equals("-h")) {
            help();
        return false;
        }
        else{
            return false;
        }
    }


    // Does the renaming
    public static void renamingOperation(String[] args){
        boolean ok;

        // ORIGINAL FILE
        String file1 = args[0].trim();
        File OriginalFile = new File(file1);
        // Builds the parent path
        Path path = Paths.get(file1);
        path = path.getParent();

        // RENAME To
        var user = path.resolve(args[1].trim());
        File newName = new File(user.toString());


        //rename operation
        if (OriginalFile.exists() & OriginalFile.isFile()) {
            // Check if already exist
            if (OriginalFile.getPath().equals(newName.getPath())){
                System.out.println("files are same");
            }
            System.out.println(" File exist");
            OriginalFile.renameTo(newName);

        }

        //checks for directory !NOT IMPLEMENTED 🤡
        /*else if (OriginalFile.exists() & OriginalFile.isDirectory()) {
            System.out.println(" Directory exist");

            // RENAME To
            var user = path.resolve("old");
            File file2 = new File(user.toString());
            OriginalFile.renameTo(file2);
        } else {
            System.out.println("File not Found");
        }*/
    }

 // MAIN
    public static void main(String[] args) {

        String[] aggs = {"here/second/old/new", "new", "third"};
//        String[] aggs = {};

        if (aggs.length == 0 | aggs.length > 3) {
            help();
            return;
        }

        //Checks for -v , false by default
        boolean verbose = switches(aggs[0]);

       try {
           if (!verbose) {
               System.out.println(aggs[0]);

               renamingOperation(aggs);

           }//end if
           else {
               //copy args and pass it 1:2

               System.out.println(aggs[1] + " -> " );
           }

       }
       catch (Exception e){
           System.out.println("Something crashed :" + e.getMessage());
       }

    }
}