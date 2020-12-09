package iofundamentals;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class DirectoriesAndFiles {
    static String outputLine = "";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Please enter directory to scan, example(D:/folder): ");
        String userDirectory = scanner.next();
        Path directoryPath = Paths.get(userDirectory);
        CustomFileVisitor visitor = new CustomFileVisitor(directoryPath);
        Files.walkFileTree(directoryPath, visitor);
        PrintWriter writer = new PrintWriter("TreeOfTheDirectory.txt", "UTF-8");
        writer.println(outputLine);
        writer.close();
        System.out.println(outputLine);
        System.out.println("Amount of directories: " + visitor.amountOfDirectories);
        System.out.println("Amount of files: " + visitor.amountOfFiles);
        System.out.println("Average amount of files in directories: " + visitor.amountOfFiles / visitor.amountOfDirectories);
        System.out.println("Average length of the files names: " + visitor.lengthOfTheFileName / visitor.amountOfFiles);
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
            outputLine = outputLine + PREFIX + setFileIndentation(levelFileOrDirectory) + FILE_PREFIX + path.getFileName() + " (" + (Files.size(path)/1024) + " kB)" + "\n";
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
}