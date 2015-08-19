/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg120222c_imageeditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

    public void showBrightnessChanger(Image image, JLabel lable) {

        ImageBrightness ib = new ImageBrightness(image, lable);
        ib.enableSlider(true);

    }
    public void showSizeChanger(Image image, JLabel lable) {

        ImageResize ir = new ImageResize(image, lable);
        ir.enableComponents(true);

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

    //this method is used to rotate image
    public void getRotate() {

        int width = picture.getWidth();
        int height = picture.getHeight();
        Color c;
        BufferedImage temp = new BufferedImage(height, width, picture.getType());

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                c = new Color(picture.getRGB(j, i));
                temp.setRGB(i, j, c.getRGB());
            }
        }
        this.setImage(temp);
    }

    public void getVeticallyFlipped() {

        int width = picture.getWidth();
        int height = picture.getHeight();
        Color c;

        BufferedImage temp = new BufferedImage(width, height, picture.getType());

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                c = new Color(picture.getRGB(j, i));
                temp.setRGB((width - 1 - j), i, c.getRGB());
            }
        }
        this.setImage(temp);

    }

    public void getHorizontallyFlipped() {

        int width = picture.getWidth();
        int height = picture.getHeight();
        Color c;
        BufferedImage temp = new BufferedImage(height, width, picture.getType());

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                c = new Color(picture.getRGB(j, i));
                temp.setRGB(i, (width - 1 - j), c.getRGB());
            }
        }
        this.setImage(temp);

    }

    public void printHistorgram() {

        int width = picture.getWidth();
        int height = picture.getHeight();
        int[] intensity = new int[256];
        int[][] graph;
        int maxHeight = 0;
        Color c;
        int grey;

        for (int n = 0; n < intensity.length; n++) {
            intensity[n] = 0;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                c = new Color(picture.getRGB(j, i));
                grey = c.getRed();
                intensity[grey]++;
            }
        }

        for (int n = 0; n < intensity.length; n++) {
            if (intensity[n] > maxHeight) {
                maxHeight = intensity[n];
            }
        }

        graph = new int[maxHeight][256];

        for (int n = graph.length - 1; n >= 0; n--) {
            for (int m = 0; m < graph[n].length; m++) {
                if (n >= intensity[m]) {
                    graph[n][m] = 1;
                } else {
                    graph[n][m] = 0;
                }
            }

        }
        new Histogram(graph);

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

    public class ImageBrightness extends JFrame implements ChangeListener {

        JSlider slider;
        Image image;
        JLabel lable;
        BufferedImage temp;
        Boolean changed = false;

        ImageBrightness(Image image, JLabel lable) {
            this.image = image;
            this.lable = lable;
            temp = new BufferedImage(picture.getWidth(), picture.getHeight(), picture.getType());

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    if (changed) {
                        picture = temp;
                    }
                    dispose();

                }
            });

            Container cont = getContentPane();
            slider = new JSlider(-255, 255, 0);
            slider.setEnabled(false);
            slider.addChangeListener(this);
            cont.add(slider, BorderLayout.CENTER);
            slider.setEnabled(true);
            setTitle("Image brightness");
            setPreferredSize(new Dimension(300, 100));
            setVisible(true);
            pack();
            enableSlider(false);
        }

        public void enableSlider(boolean enabled) {
            slider.setEnabled(enabled);
        }

        public void stateChanged(ChangeEvent e) {
            changed = true;
            changeBrightness(slider.getValue(), temp);
            image = temp;
            lable.setIcon(new ImageIcon(image));

        }

        //this method is used to change the brightness of the image
        public void changeBrightness(int brightness, BufferedImage temp) {

            float factor = (float) brightness;
            System.out.println("......." + factor);
            int width = picture.getWidth();
            int height = picture.getHeight();
            int red, green, blue;
            Color c, newcolor;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {

                    c = new Color(picture.getRGB(j, i));
                    red = roundoff(factor + c.getRed());
                    blue = roundoff(factor + c.getBlue());
                    green = roundoff(factor + c.getGreen());
                    newcolor = new Color(red, green, blue);
                    temp.setRGB(j, i, newcolor.getRGB());
                }
            }

        }

    } ////end of the ImageBrightness class

    public class ImageResize extends JFrame implements ActionListener {

        JPanel panel;
        JTextField txtWidth;
        JTextField txtHeight;
        JButton btnUp;
        JButton btnDown;
        BufferedImage temp;
        Image image;        
        JLabel lable;

        ImageResize(Image image, JLabel lable) {
            setTitle("Image resize");
            //setDefaultCloseOperation(EXIT_ON_CLOSE);
            setPreferredSize(new Dimension(400, 100));

            btnUp = new JButton("Up");
            btnUp.addActionListener(this);

            btnDown = new JButton("Down");
            btnDown.addActionListener(this);

//            txtWidth = new JTextField(4);
//            txtWidth.addKeyListener(new KeyList());
//            txtHeight = new JTextField(4);
//            txtHeight.addKeyListener(new KeyList());
            panel = new JPanel();
            panel.setLayout(new FlowLayout());
//            panel.add(new JLabel("Width:"));
//            panel.add(txtWidth);
//            panel.add(new JLabel("Height:"));

           // panel.add(txtHeight);
            panel.add(btnUp);
            panel.add(btnDown);
            panel.setBackground(Color.GRAY);
            add(panel, BorderLayout.CENTER);
            setVisible(true);
            pack();
            enableComponents(false);

            this.image = image;
            this.lable = lable;
            picture=(BufferedImage)image;

        }

        //This method can be invoked to  enable the text boxes of image width and height
        public void enableComponents(boolean enabled) {
//            txtWidth.setEnabled(enabled);
  //          txtHeight.setEnabled(enabled);
            btnUp.setEnabled(enabled);
            btnDown.setEnabled(enabled);
        }

        //This method works when you click the OK button to resize the image
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnUp) {

            }
            if (e.getSource() == btnDown) {
                temp = new BufferedImage(picture.getWidth() / 2, picture.getHeight() / 2, picture.getType());
               // image = temp;
               // picture=temp;
                //sizeDown();
                lable.setIcon(new ImageIcon(temp));
            }
        }

        //Restrict the key presses
        //Only number, backspace, and delete keys are allowed
        public class KeyList extends KeyAdapter {

            public void keyTyped(KeyEvent ke) {

                char c = ke.getKeyChar();
                int intkey = (int) c;
                if (!(intkey >= 48 && intkey <= 57 || intkey == 8 || intkey == 127)) {
                    ke.consume(); //hide the unwanted key

                }

            }

        }

        public void sizeDown() {
            int width = picture.getWidth();
            int height = picture.getHeight();
            int red, green, blue;
            Color c, newcolor;

            for (int i = 0; i < height; i += 2) {
                for (int j = 0; j < width; j += 2) {
                    c = new Color(picture.getRGB(j, i));
                    red = c.getRed();
                    blue = c.getBlue();
                    green = c.getGreen();
                    newcolor = new Color(red, green, blue);
                  //  System.out.println(j/2+" "+i/2+" "+ red+" "+green+" "+blue);
                    temp.setRGB(j/2, i/2, newcolor.getRGB());
                }
            }

        }
    }////end of the ImageResize class

}
