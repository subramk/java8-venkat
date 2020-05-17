package lambda1.examples.from.sai;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class JollyDhaan {
    public static void main(String[] args) throws Exception {
        // @Kasi You should change it to yours.
        String myLocalMavenRepoDir = "/Users/Admin/mvn_repo/repository";
        String fileToSearch = "_remote.repositories";

        Files.walkFileTree(Paths.get(myLocalMavenRepoDir), new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().equals(fileToSearch)) {
                    file.toFile().delete();
                    System.out.println("Deleting: " + file.toFile().getAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
