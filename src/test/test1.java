package test;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

public class test1 {

	private int max = 0;
	private String stationNo = "";
	private String date = "";
	
	protected Stream<Path> directoryAnalyze(String dirName) {
		Path path = Paths.get(dirName);
		try {
			if(Files.isDirectory(path)) {
				return Files.list(path);
			}
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected String decompressFile(Path file, int bufferSize) {
		ByteArrayOutputStream baos = null;
		try(BufferedInputStream zin = new BufferedInputStream(
										new GZIPInputStream(
											Files.newInputStream(file)));){
			baos = new ByteArrayOutputStream();
			byte[] buf = new byte[bufferSize];
			int len = 0;
			while((len = zin.read(buf,0,bufferSize)) != -1) {
				baos.write(buf, 0 ,len);
			}
			baos.toByteArray();
			String result = baos.toString("UTF-8");
			
			return result;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	protected String decompressFile(Path file) {
		return this.decompressFile(file, 1024);
	}
	
	protected String[] analyzeData(String rowData) {
		String[] tmp = rowData.split(" ");
		int index = 0;
		for(String item : tmp) {
			if(!"".equals(item)) {
				tmp[index] = item;
				index++;
			}
		}
		return tmp;
	}
	
	protected void analyzeReduceData(String[] data) {
		if(Integer.parseInt(data[3].replace(".", "")) > max) {
			this.max = Integer.parseInt(data[3].replace(".", ""));
			this.stationNo = data[0] + " " + data[1];
			this.date = data[2];
		}
	}

	public void analyzeAllFile(String dir) {
		Stream<Path> files = this.directoryAnalyze(dir);
		
		String result = "";
		String[] rows;
		String[] singleRow;
		for(Object path : files.toArray()) {
			result = this.decompressFile((Path)path);
			rows = result.split("\n");
			for(String row : rows) {
				if(!row.contains("STN")) {
					singleRow = this.analyzeData(row);
					this.analyzeReduceData(singleRow);
				}
			}
		}
		this.showResult();	
	}
	
	private void showResult() {
		System.out.println("Max temp. :" + this.max + ", Station : " + this.stationNo + ", Date : " + this.date);
	}
}
