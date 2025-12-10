package main

import (
	"bufio"
	"flag"
	"fmt"
	"os"
	"path/filepath"
	"strings"
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

	args := flag.Args()

	if len(args) < 2 {
		fmt.Println(help())
		os.Exit(1)
	}

	workDir, _ := filepath.Abs(filepath.Dir(args[0]))

	inputFile := filepath.Base(args[0])
	var oldName string = inputFile
	var newName string = args[1]

	oldPath := filepath.Join(workDir, oldName)
	newPath := filepath.Join(workDir, newName)

	// Safe checks
	if _, err := os.Stat(oldPath); os.IsNotExist(err) {
		fmt.Println("That file does not exist")
		os.Exit(1)
	}

	//rename
	doRename(&oldPath, &newPath)

}

func doRename(oldPath *string, newPath *string) {

	//renaming operation
	err := os.Rename(*oldPath, *newPath)
	if err != nil {
		fmt.Println("error renaming ", err.Error())
		os.Exit(1)
	}

	if *verboseF {
		fmt.Printf(" %s -> %s\n", *oldPath, *newPath)
	}
}

func askOverwrite() bool {

	fmt.Print("File already exist , overwrite? y/n :")

	reader := bufio.NewReader(os.Stdin)
	response, _ := reader.ReadString('\n')
	response = strings.TrimSpace(strings.ToLower(response))

	return response == "y" || response == "yes"
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
