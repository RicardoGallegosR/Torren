/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Merino
 */

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileWriter {
    private static final FileWriter inst= new FileWriter();
	
    private FileWriter() {
        super();
    }
    //Escribe los datos al archivo final
    public synchronized int writeToFile(String path, byte[] data, int start){
        int bytes_written = 0;
    	try {
    		File dest = new File(path);
    		if (!dest.exists())
    			dest.createNewFile();
        	RandomAccessFile file = new RandomAccessFile(path, "rw");
        	file.seek(start);
        	file.write(data);
        	bytes_written = data.length;
        	file.close();
        	System.out.println("Write Hecho.");
        	return bytes_written;
        } catch (IOException e){
        	return bytes_written;
        }
    }

    public static FileWriter getInstance() {
        return inst;
    }
}
