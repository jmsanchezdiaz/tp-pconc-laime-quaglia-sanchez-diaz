package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageHelper {

    public static byte[] transformToCsv(String filePath) throws IOException {
        File imgPath = new File( filePath );
        BufferedImage bufferedImage = ImageIO.read(imgPath);
        WritableRaster raster = bufferedImage.getRaster();
        byte[] datos = ((DataBufferByte) raster.getDataBuffer()).getData();
        return datos;
    }

    public static void transformToImage(byte[] datos, String output){
        BufferedImage imagen = new BufferedImage (28,28,BufferedImage.TYPE_BYTE_GRAY);
        imagen.getRaster().setDataElements (0 , 0 , 28 , 28 , datos);
        File outputfile = new File ("K:\\UNQ\\concu\\tp-pconc-laime-quaglia-sanchez-diaz\\tp-conc\\" + "output");
        try {
            ImageIO.write( imagen,"png", outputfile);
        } catch (IOException e) {
            return;
        }
    }
}