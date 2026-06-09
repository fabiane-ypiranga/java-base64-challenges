import Util.ConsoleColors;

import java.awt.Desktop;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class ImageToBase64Html {

    public static void main(String[] args) {

        System.out.println(ConsoleColors.PURPLE +
                "\n==============================");
        System.out.println("   IMAGE TO BASE64 HTML");
        System.out.println("==============================" +
                ConsoleColors.RESET);

        try {

            // imagem
            Path imagePath = Path.of("image.png");

            System.out.println(ConsoleColors.CYAN +
                    "📂 Reading image: " + imagePath +
                    ConsoleColors.RESET);

            // detecta MIME TYPE automaticamente
            String mimeType =
                    Files.probeContentType(
                            imagePath
                    );

            // lê imagem
            byte[] imageBytes =
                    Files.readAllBytes(imagePath);

            // converte para Base64
            String base64 = Base64.getEncoder()
                    .encodeToString(imageBytes);

            // HTML com imagem embutida
            String html =
                    "<html>" +
                            "<head><title>Image Preview</title></head>" +
                            "<body style='text-align:center;font-family:Arial;'>" +
                            "<h2>🖼 Image Base64</h2>" +
                            "<img style='max-width:500px;' " +
                            "src='data:" + mimeType +
                            ";base64," + base64 + "'/>" +
                            "</body></html>";

            // salva HTML
            Path outputPath = Path.of("image.html");
            Files.writeString(outputPath, html);

            System.out.println(ConsoleColors.GREEN +
                    "\n✔ HTML gerado com sucesso!" +
                    ConsoleColors.RESET);

            System.out.println(ConsoleColors.YELLOW +
                    "📄 Arquivo: " + outputPath +
                    ConsoleColors.RESET);

            // abre navegador
            File htmlFile = new File("image.html");

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            }

        } catch (Exception e) {

            System.out.println(ConsoleColors.RED +
                    "✖ Erro: " + e.getMessage() +
                    ConsoleColors.RESET);
        }
    }
}