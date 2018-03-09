//package test;
//
//import java.io.BufferedInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.zip.GZIPInputStream;
//
//import org.apache.commons.lang3.ArrayUtils;
//
//public class test4 {
//	
////将字符串数据转为双精度数据的方法
//public  static double StringToDouble(String arrs){
//        double ints = Double.parseDouble(arrs);
//        return ints;
//}	
//
////返回一个气象站里所有温度中最高的温度的方法
//@SuppressWarnings({ "resource", "unchecked", "rawtypes", "unused" })
//public  static LinkedList oneHigh(String name){
//	
//	LinkedList link = new LinkedList();
//	ByteArrayOutputStream baos = null;
//	BufferedInputStream r;
//	try {
//		r = new BufferedInputStream(new GZIPInputStream(new FileInputStream(name)));
//		baos = new ByteArrayOutputStream();
//		
////		从硬盘中将文件转成字符串
//		byte[] buf = new byte[2048];  
//		int len = 0;
//				while((len=r.read(buf,0,2048))!=-1){
//					baos.write(buf,0,len);
//				}
//		baos.toByteArray();
//	    String rs = baos.toString("utf-8");
//	    
////	         将字符串中多余空格去除
//	    String[] tmp = rs.split(" ");
//		int index = 0;
//		for(String item:tmp){
//		     if(!"".equals(item)){
//						tmp[index] = item;
//						index++;
//					}
//				}
//				
////				将字符串数据按“,”分割成字符串数组并且去除开头“STN”固定数据
//				String[] n = String.join(",", ArrayUtils.subarray(tmp, 0, index)).substring(86).split("\\,");
//				
////              找出最高的温度的值，并添加到link表中去
//				
//				double max = StringToDouble(n[3]);
//				for(int i=3;i<n.length;i+=21){
//					double next = StringToDouble(n[i]);
//					if(max<next&&next!=9999.9){
//						double flag = max;
//						        max = next;
//						        next=flag;
//					}
//					link.add(max);
//				return link;
//				}	
//			    
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return null;
//}
//
////返回一个路径的字符串的方法
//public static String[] allPath(String name) {
//	
//	List<File> files =  new ArrayList<File>();
//	Path path = FileSystems.getDefault().getPath(name);
//	if(path.toFile().isDirectory()){
//		for(int i = 0;i<path.toFile().listFiles().length;i++){
//			files.add(path.toFile().listFiles()[i]);
//		}
//	}
//	String[] a=new String [files.size()];
//	     for(int i=0;i<files.size();i++){
//			a[i]=files.get(i).getAbsolutePath();
//			}
//			return a;
//}
//
////找最大值的方法 
//@SuppressWarnings("rawtypes")
//public static double theMax(String[] b) {
//  
//    double mm=0;
//   //循环添加路径       	    
//    for(int i=0;i<b.length;i++){
//   //返回所有气象站温度的最大值	    	
//	       LinkedList k = oneHigh(b[i]);
//   //将List型转为字符串型		       
//	       String[] a=new String [k.size()];
//           for(int j=0;j<k.size();j++){
//		       a[j]=k.get(j).toString();
//		   }
//   //将字符串型转为Double型	           
//          double m = StringToDouble(a[0]);
//   //比较温度最高的	           
//               if(mm<m){
//               	mm=m;
//               }
//	}
////  返回结果
//    return mm;
//}
//
//public static void main(String[] args) {
//	    
////	    定义开始运行时间戳
//	    long start=System.currentTimeMillis();
////	    接收返回出的最大值  
//	    double theMax = theMax(allPath("E:\\data"));
//	    System.out.println(theMax);
////	    定义结束运行时间戳  
//	    long end=System.currentTimeMillis();
////	    输出运行时间   
//	    System.out.println(end-start);
//    }
//}