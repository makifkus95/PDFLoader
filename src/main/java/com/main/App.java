package com.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //"http://www.africau.edu/images/default/sample.pdf"
        //"https://www.resmigazete.gov.tr/eskiler/2020/01/20200125.pdf"
        Scanner scan = new Scanner(System.in);
        System.out.print("Link giriniz: ");
        //String url = scan.next();
        String[] array = { "http://www.africau.edu/images/default/sample.pdf" };
        int i=1;
        long beginTime = 0, endTime = 0;
        beginTime = System.currentTimeMillis();

        for (String array1 : array){
            downloadPDF(array1,i);
            i++;
        }


        endTime = System.currentTimeMillis();
        System.out.println("Download add time: " + ((double) (endTime - beginTime)) / 1000);
    }

    public static void downloadPDF(String link, int i){
        File dir = new File("E:\\indirilenler\\PDF");
        dir.mkdir();
        try {
            System.out.println("opening connection");
            URL url = new URL(link);
            InputStream in = url.openStream();
            FileOutputStream fos = new FileOutputStream(new File("E:\\indirilenler\\PDF\\"+i+"_download.pdf"));

            System.out.println("reading from resource and writing to file...");
            int length = -1;
            byte[] buffer = new byte[1024];// buffer for portion of data from connection
            while ((length = in.read(buffer)) > -1) {
                fos.write(buffer, 0, length);
            }
            fos.close();
            in.close();
            System.out.println("File downloaded");
        } catch (MalformedURLException e) {
            System.out.println(e);;
        } catch (IOException e) {
            System.out.println(e);;
        }
    }
}
