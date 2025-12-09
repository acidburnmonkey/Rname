package main

import (
	"flag"
	"fmt"
	"os"
	"path/filepath"
)

var verboseF *bool

func main() {

	verboseF = flag.Bool("v", true, "verbose output")
	helpFlag := flag.Bool("h", false, "Prints help message")

	flag.Parse()

	if *helpFlag {
		fmt.Println(help())
		os.Exit(0)
	}

	// args := flag.Args()

	// if len(args) < 2 {
	// 	fmt.Println(help())
	// 	os.Exit(1)
	// }

	workDir, _ := filepath.Abs(filepath.Dir("../testing/"))

	var oldName string = "one"
	var newName string = "newName"

	oldPath := filepath.Join(workDir, oldName)
	newPath := filepath.Join(workDir, newName)

	fmt.Println("workDir: ", workDir)

	doRename(oldPath, newPath)

}

func doRename(oldPath string, newPath string) {

	err := os.Rename(oldPath, newPath)
	if err != nil {
		fmt.Println("error renaming ", err.Error())
		os.Exit(1)
	}

	if *verboseF {
		fmt.Printf(" %s -> %s", oldPath, newPath)
	}
}

func help() string {

	documentation := `
Rname , rename files in place.

Usage:
rname /path/to/file newName

Options:
  -h      Display this help message.
  -v      Display verbose.

Note it will ask to overwrite if the file already exist, but It won't overwrite a directory that is not empty.
        `
	return documentation
}
