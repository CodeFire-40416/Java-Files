/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaurl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author human
 */
public class JavaUrl {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException {
        // TODO: Create storage directory if not exists.
        // TODO: Print storage capacity.
        // TODO: Print already downloaded file names and sizes. "music.mp3 (12345 bytes); \n music.wav (41212 bytes)"

        List<URL> musicList = new ArrayList<>();

        // TODO: Request user to enter url's. (Stop when enter empty line)
        // Uniform Resource Locator
//        URL url = new URL("http", "www.ex.ua", 80, "/playlist/148363.m3u");
//        URL url = new URL("http", "www.ex.ua", "/playlist/148363.m3u");
        URL playlistUrl = new URL("http://www.ex.ua/playlist/148363.m3u");

        try (Scanner scanner = new Scanner(playlistUrl.openStream())) {

            while (scanner.hasNextLine()) {
                URL musicUrl = new URL(scanner.nextLine());
                musicList.add(musicUrl);
            }

        } catch (IOException ex) {
            Logger.getLogger(JavaUrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object str = "Line";
        
        assert str instanceof String;
        
        assert str instanceof Integer;
        
        //            System.out.println(musicUrl);
        // TODO: Download linked file to storage directory.
        // TODO: If file already exists, ask user for action (skip, rewrite).
        for (URL musicUrl : musicList) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(JavaUrl.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.printf("\r%25s", musicUrl);
        }
        
        // Example for one-line printing.
//        System.out.printf("\rDownloading: [%3d%]", 45);
//        System.out.printf("\n\r[%-25s]", "=======>");
        
        System.out.println();

    }

}
