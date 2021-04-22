package tasks;

import lombok.Builder;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@Builder(toBuilder = true)
public class FileUtils {

    void withoutDuplicate(File file) throws IOException {
        try (
                PrintWriter pw = new PrintWriter("out/" + file.getName());
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))
        ) {
            String line = br.readLine();
            Set<String> hs = new HashSet<>();

            while (br.ready()) {
                if (hs.add(line))
                    pw.println(line);
                line = br.readLine();
            }
            pw.flush();
        }
    }

    public static void main(String[] args) {
        //System.out.println(System.getProperty("user.dir"));
        FileUtils build = new FileUtils().toBuilder().build();
        try {
            build.withoutDuplicate(new File("test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
