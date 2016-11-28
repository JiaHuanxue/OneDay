package com.bw.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OneDayDemoTest {
	//基本类型
	int i = 2;
	boolean boo = false;
	float flo = (float) 1.1;
	long lo = 1;
	short sho = 9999;  
	public static void main(String[] args) throws IOException {
        
		 int[] arr = new int[] { 12, 23, 34, 45, 56, 67, 77, 89, 90 };

		//递归
		System.out.println(factorial(7));
		
		//调用非静态方法
		OneDayDemoTest oddt = new OneDayDemoTest();
		oddt.BufferedInputStreamDemo();
		oddt.MikiOperation();
		 System.out.println("\n二分法查找："+search(arr,12)+"\n");
		oddt.jisuan();
		 

		
    }
	 public static int factorial(int n){  
		  if (n < 0){
              return 0;
		  }
        else if ( n == 1){
              return 1;
        }
         else if (n > 1){
 
             return n * factorial(n-1);
         }
		return n;
	 }
	//读取本地文件
	public void BufferedInputStreamDemo()throws IOException {
		//获取本地文件
		FileInputStream file = new FileInputStream("f://bos.txt");
		//字节流读取
        //BufferedInputStream bis = new BufferedInputStream(file);
        
       // byte[] bys = new byte[1024];
        int len = 0;
/* 
        while ((len = bis.read(bys)) != -1) {
        	
            System.out.print(new String(bys, 0, len)+"\n\n");
            
        }*/

        //FileWriter写入
        String  str  = "写什么都行";
        File files = new File("f://bos.txt");
        if (!files.exists()) {
        	files.createNewFile();
           }

           FileWriter fw = new FileWriter(files.getAbsoluteFile());
           BufferedWriter bw = new BufferedWriter(fw);
           bw.write(str);
           bw.close();
           
           //文件字符流读取
           FileReader fileReader = new FileReader("f://bos.txt");
           
               while((len = fileReader.read())!=-1)  
               {  
                   System.out.print((char)len);  
                     
               }  
               
        // 释放资源
        fileReader.close();
       // bis.close();
	}
	//三目运算
	public void MikiOperation(){
		
		//输出运算结果
		System.out.println("\n"+"如果 i > lo 输出结果 i+lo 如果 i < lo 输出结果 i-lo"+"	最后结果："+
		(i>lo?i+lo:i-lo));
		//输出运算结果
				System.out.println("\n"+"如果 flo > sho 输出结果flo+sho 如果 flo < sho 输出结果flo-sho"+"	最后结果："+
				(flo>sho?flo+sho:flo-sho));
				//输出运算结果
		System.out.println("\n"+"如果 boo==true 输出结果flo+sho 如果 boo==false 输出结果flo-sho"+"	最后结果："+
				(boo?flo+sho:flo-sho));
		
	}
	//递归
	public void Recursion(){
		
	}
	//计算公基金
	public void jisuan(){
		//税前月工资×10％至12％×2（单位＋个人），
		//例：税前月工资5000，公积金率10％，
		//则月公积金=5000×10％×2＝1000，其中单位和个人各500。
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入税前工资：\n");
		while(scanner.hasNextInt())
		{
			int wages = scanner.nextInt();
			flo = (float) (wages * 0.1) ;
			System.out.print("公积金:"+ flo);
		}
	}
	//假设数据是按升序排序的，对于给定值 x，从序列的中间位置开始比较，如果当前位置值等于 x，
	//则查找成功；若 x 小于当前位置值，则在数列的前半段中查找；
	//若 x 大于当前位置值则在数列的后半段中继续查找，直到找到为止。
	public static int search(int[] arr, int key) {
	       int start = 0;
	       int end = arr.length - 1;
	       while (start <= end) {
	    	   //算中间的下标
	           int middle = (start + end) / 2;
	           if (key < arr[middle]) {
	               end = middle - 1;
	           } else if (key > arr[middle]) {
	               start = middle + 1;
	           } else {
	               return middle;
	           }
	       }
	       return -1;
	   }
	
}
