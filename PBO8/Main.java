package PBO8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = Files.newBufferedWriter(
                     Paths.get("user_input.txt"), StandardCharsets.UTF_8)) {

            System.out.println("Masukkan teks per baris. Ketik 'exit' untuk selesai.");
            while (true) {
                System.out.print("> ");
                if (!scanner.hasNextLine()) {
                    break;
                }

                String text = scanner.nextLine();
                if ("exit".equalsIgnoreCase(text.trim())) {
                    break;
                }

                String timestamp = LocalDateTime.now().format(formatter);
                writer.write(timestamp + " - " + text);
                writer.newLine();
                writer.flush();
            }

            System.out.println("Input tersimpan di user_input.txt");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan input: " + e.getMessage());
        }
    }
}
