package test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	long start = System.currentTimeMillis();	
	List<String> list = new ArrayList<String>();
		try {
			BufferedInputStream  zin  = new BufferedInputStream (
					new GZIPInputStream(
							new FileInputStream("E:/data/010080-99999-2015.op.gz")));
			

			byte[] buf = new byte[1024];
			int len = 0 ;
			while((len = zin.read(buf,0,1024))!=-1){
				String result = new String(buf);
				
				list.add(result);
			}

			for(String x:list){
				System.out.println(x);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();	
		System.out.println(end-start);		
	}
	
}
