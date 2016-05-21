/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafiles;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author human
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File project = null;

        try {
            project = new File("./nbproject/").getCanonicalFile();
            throw new IOException("SOME MESSAGE");
        } catch (IOException ex) {
//            String className = Main.class.getName();
//            Logger logger = Logger.getLogger(className);
//            logger.log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        System.out.println("Filtered:");
        File[] filteredFiles = project.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".txt") || file.getName().endsWith(".xml");
            }
        });

        for (File filteredFile : filteredFiles) {
            System.out.println(filteredFile);
        }

        System.out.println("List files:");
        File[] listFiles = project.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains("i");
            }
        });

        for (File listFile : listFiles) {
            System.out.println(listFile);
        }
    }

}
