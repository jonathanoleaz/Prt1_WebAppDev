package src;

import java.io.File;

public class Prueba {
    public static void main(String[] args) {
        File miDir = new File (".");
        try {
            Email email = new Email();
            email.sendEmailMultimedia("luchofig28@gmail.com", "Asunto", "Texto del correo",miDir.getCanonicalPath()+"\\pdf\\imagen.jpg","TítuloImagen.jpg",
                    miDir.getCanonicalPath()+"\\pdf\\JavaServlet.pdf","TítulPDF.pdf");
        }
        catch(Exception e) {
            e.printStackTrace();
       }
    }
}
