package test;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;


public class test2 {
	static double max = 0;

	public static String fun(String s) {
		if (s != null) {
			String s1 = "";
			String[] s2 = s.split(" ");
			s1 = s1 + s2[0];
			 for(int i = 1;i<s2.length-1;i++){
					if(!s2[i].isEmpty()){
					//System.out.println("|"+s2[i]+"|");
					s1= s1+","+s2[i];}
			 }
			s1 = s1.replace("STN---,WBAN,YEARMODA,TEMP,DEWP,SLP,STP,VISIB,WDSP,MXSPD,GUST,MAX,MIN,PRCP,SNDP,FRSHTT",
					"");

			return s1;
		} else
			return null;

	}

	public static List<File> getPath(String s) {
		List<File> files = new ArrayList<File>();
		Path path = FileSystems.getDefault().getPath(s);
		if (path.toFile().isDirectory()) {
			for (int i = 0; i < path.toFile().listFiles().length; i++) {
				files.add(path.toFile().listFiles()[i]);
			}

		}
		return files;
	}

	public static double FindMax(String s1) {
		double temp = 0;
		String[] s2 = s1.split("\\n");
		for (String x : s2) {
			String[] x1 = x.split(",");
			if (x1.length > 21 && !x1[3].isEmpty())
				temp = Double.parseDouble(x1[3]);
			if (max < temp && temp != 99.9) {
				max = temp;
			}
		}
		return max;
	}

	public static String Decompress(File file) {
		String s1 = "";
		ByteArrayOutputStream baos = null;
		try {
			BufferedInputStream zin = new BufferedInputStream(new GZIPInputStream(new FileInputStream(file)));
			baos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = zin.read(buf, 0, 1024)) != -1) {
				baos.write(buf, 0, 1024);
				String ss = new String();
			}
			baos.toByteArray();
			
			
			
			String result = baos.toString("UTF-8");
			s1 = s1 + result;
			s1 = fun(s1);
			zin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s1;
		

	}

	public static void main(String[] args) {
		List<File> files = getPath("E:/data");
		String x = "";
		for (File f : files) {
			x = Decompress(f);
			//System.out.print(x);
			max = FindMax(x);
		}
		System.out.println("\n----------------------------------------max = " + max
				+ "----------------------------------------\n");

	}

}
