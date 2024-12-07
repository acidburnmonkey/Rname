
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void help(){
        String str = "usage this is the help page";
        System.out.println(str);
    }

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

    public static void main(String[] args) {

        String[] aggs = {"-v","two ", "third" };
//        String[] aggs = {};

        if (aggs.length == 0 | aggs.length >3 ) {
            help();
            return;
        }

        //Checks for -v , false by default
        boolean verbose = switches(aggs[0]);


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