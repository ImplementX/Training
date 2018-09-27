package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamMustClosedSafe {


    public  static void openFile(String fileName){
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            Wasn't open so don't close it.
        } catch (Exception e ){
//            All other exception must be closed
            try {
                bis.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                System.out.println("closed unsuccessful");

            }
//          Rethrow exception.
            throw e;
        }finally {
//                Don't close it here!
        }
    }


}
