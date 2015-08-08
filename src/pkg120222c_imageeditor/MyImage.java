/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg120222c_imageeditor;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Manoj
 */
//this class is used to make changes to the image.
public class MyImage {

    private BufferedImage picture;
    private String fileName;

//constructor
    public MyImage() {
    }

    //the filename getter   
    public String getFileName() {
        return fileName;
    }
//finel name setter

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

//return the currnet image
    public BufferedImage getImage() {
        //return the bufferde image
        return picture;
    }

    //set the picture from the file as a Buffered image
    public void setImage(String filename) {
        try {
            // try to read from file in working directory            
            File file = new File(filename);
            if (file.isFile()) {
                this.fileName = filename;
                picture = ImageIO.read(file);
                System.out.println("image loaded");
            } // now try to read from file in same directory as this .class file
            else {
                URL url = getClass().getResource(filename);
                if (url == null) {
                    url = new URL(filename);
                }
                picture = ImageIO.read(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not open file: " + filename);
        }

        // check that image was read in
        if (picture == null) {
            throw new RuntimeException("Invalid image file: " + filename);
        }
    }
//assign the parameter as the buffered image

    public void setImage(BufferedImage picture) {
        this.picture = picture;
    }
//using this method we can see the RGB componet valuse of each and every pixel 

    public void getImageData() {
        int width = picture.getWidth();
        int height = picture.getHeight();
        Color c;

        for (int i = 190; i < height; i++) {
            for (int j = 250; j < width; j++) {
                c = new Color(picture.getRGB(j, i));
                System.out.print(c.getRed() + "," + c.getBlue() + "," + c.getGreen() + " ");

            }
            System.out.println("");
        }

    }
//this mathod gives the gray scale mode of the image

    public void getGrascale() {
        int width = picture.getWidth();
        int height = picture.getHeight();
        int red, green, blue, grey;
        Color c, newcolor;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                c = new Color(picture.getRGB(j, i));
                grey = (int) (c.getRed() + c.getBlue() + c.getGreen()) / 3;
                newcolor = new Color(grey, grey, grey);
                picture.setRGB(j, i, newcolor.getRGB());

            }
        }
    }
//this method is used to change the contrast of the image

    public void changeContrast(int contrast) {   //we can provide contrast value from 0 to 255
        int factor = (259 * (contrast + 255)) / (255 * (259 - contrast));
        System.out.println("......." + factor);
        int width = picture.getWidth();
        int height = picture.getHeight();
        int red, green, blue;
        Color c, newcolor;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                c = new Color(picture.getRGB(j, i));
                red = roundoff(factor * (c.getRed() - 128) + 128);
                blue = roundoff(factor * (c.getBlue() - 128) + 128);
                green = roundoff(factor * (c.getGreen() - 128) + 128);
                newcolor = new Color(red, green, blue);
                picture.setRGB(j, i, newcolor.getRGB());
            }
        }

    }
//this method is used to make the picture black and white

    public void blackwhite() {

        int width = picture.getWidth();
        int height = picture.getHeight();
        int red, green, blue, grey;
        Color c, newcolor;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                c = new Color(picture.getRGB(j, i));
                red = c.getRed();
                green = c.getGreen();
                blue = c.getBlue();

                int black = (int) (.3 * red + .59 * green + .11 * blue);
                newcolor = new Color(black, black, black);
                picture.setRGB(j, i, newcolor.getRGB());
            }
        }
    }
//this method is used to change the brightness of the image

    public void changeBrightness(int brightness) {
        float factor = (float) brightness / 100;
        System.out.println("......." + factor);
        int width = picture.getWidth();
        int height = picture.getHeight();
        int red, green, blue;
        Color c, newcolor;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                c = new Color(picture.getRGB(j, i));
                red = roundoff(factor * c.getRed());
                blue = roundoff(factor * c.getBlue());
                green = roundoff(factor * c.getGreen());
                newcolor = new Color(red, green, blue);
                picture.setRGB(j, i, newcolor.getRGB());
            }
        }

    }
//this mathod is used to get the negative of the image

    public void getNegative() {

        int width = picture.getWidth();
        int height = picture.getHeight();
        int red, green, blue;
        Color c, newcolor;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                c = new Color(picture.getRGB(j, i));
                red = 255 - c.getRed();
                blue = 255 - c.getBlue();
                green = 255 - c.getGreen();
                newcolor = new Color(red, green, blue);
                picture.setRGB(j, i, newcolor.getRGB());
            }
        }
    }

    //this method can be used to get the red image
    public void getRed() {
        int width = picture.getWidth();
        int height = picture.getHeight();
        int red, green, blue;
        Color c, newcolor;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                c = new Color(picture.getRGB(j, i));
                red = c.getRed();
                blue = 0;
                green = 0;
                newcolor = new Color(red, green, blue);
                picture.setRGB(j, i, newcolor.getRGB());
            }
        }

    }

    //this method can be used to get the green image
    public void getGreen() {
        int width = picture.getWidth();
        int height = picture.getHeight();
        int red, green, blue;
        Color c, newcolor;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                c = new Color(picture.getRGB(j, i));
                red = 0;
                blue = 0;
                green = c.getGreen();
                newcolor = new Color(red, green, blue);
                picture.setRGB(j, i, newcolor.getRGB());
            }
        }

    }

    //this method can be used to get the blue image
    public void getBlue() {
        int width = picture.getWidth();
        int height = picture.getHeight();
        int red, green, blue;
        Color c, newcolor;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                c = new Color(picture.getRGB(j, i));
                red = 0;
                blue = c.getBlue();
                green = 0;
                newcolor = new Color(red, green, blue);
                picture.setRGB(j, i, newcolor.getRGB());
            }
        }

    }

    public int roundoff(float value) {
        if (value > 255) {
            value = 255;
        }
        if (value < 0) {
            value = 0;
        }
        return (int) value;
    }

}
