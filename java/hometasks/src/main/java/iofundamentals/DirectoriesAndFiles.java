package iofundamentals;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoriesAndFiles {
    static String outputLine = "";

    public static void main(String[] args) throws IOException {
        String userDirectoryOrFile = args[0];
        if (userDirectoryOrFile.contains(".txt")) {
            readFromTextFile(userDirectoryOrFile);
        } else {
            Path directoryPath = Paths.get(userDirectoryOrFile);
            CustomFileVisitor visitor = new CustomFileVisitor(directoryPath);
            Files.walkFileTree(directoryPath, visitor);
            PrintWriter writer = new PrintWriter("TreeOfTheDirectory.txt", "UTF-8");
            System.out.println("Your file is done with name: TreeOfTheDirectory.txt");
            writer.println(outputLine);
            writer.close();
        }
    }

    private static class CustomFileVisitor extends SimpleFileVisitor<Path> {
        Path path;
        int levelFileOrDirectory = 0;
        double amountOfDirectories;
        double amountOfFiles;
        int lengthOfTheFileName;
        static final String PREFIX = "|";
        static final String FILE_PREFIX = "     ";
        static final String DIRECTORY_PREFIX = "-----";

        CustomFileVisitor(Path path) {
            this.path = path;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            outputLine = outputLine + PREFIX + setFileIndentation(levelFileOrDirectory) + FILE_PREFIX + path.getFileName() + "\n";
            lengthOfTheFileName += path.getFileName().toString().length();
            amountOfFiles ++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) {
            outputLine = outputLine + PREFIX + setDirectoryIndentation(levelFileOrDirectory) + DIRECTORY_PREFIX + path.getFileName() + "\n";
            amountOfDirectories ++;
            levelFileOrDirectory ++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path path, IOException exc) {
            levelFileOrDirectory--;
            return FileVisitResult.CONTINUE;
        }

        public String setDirectoryIndentation(int levelOfDirectory) {
            String outputIndent = "";
            for (int i = 0; i < levelOfDirectory; i++) {
                outputIndent += "--";
            }
            return outputIndent;
        }

        public String setFileIndentation(int levelOfFile) {
            String outputIndent = "";
            for (int i = 0; i < levelOfFile; i++) {
                outputIndent += "  ";
            }
            return outputIndent;
        }
    }

    private static void readFromTextFile(String path) throws IOException {
        double amountOfFilesInTextFile = 0;
        double amountOfDirectoriesInTextFile = 0;
        double fileNameLength = 0;
        String delimiters = "[| ]+";
        String textLine;
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((textLine = bufferedReader.readLine()) != null) {
            if (textLine.contains("| ")) {
                String[] tokens = textLine.split(delimiters);
                for (int i = 0; i < tokens.length; i++) {
                    fileNameLength +=(tokens[i].length());
                }
                amountOfFilesInTextFile ++;
            } else if (textLine.contains("|-")) {
                amountOfDirectoriesInTextFile ++;
            }
            System.out.println(textLine);
        }
        System.out.println("Amount of files: " + amountOfFilesInTextFile);
        System.out.println("Amount of directories: " + amountOfDirectoriesInTextFile);
        System.out.println("Average amount of files in directories: " + (amountOfFilesInTextFile / amountOfDirectoriesInTextFile));
        System.out.println("Average length of the files names: " + fileNameLength / amountOfFilesInTextFile);
    }
}