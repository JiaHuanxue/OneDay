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
	//��������
	int i = 2;
	boolean boo = false;
	float flo = (float) 1.1;
	long lo = 1;
	short sho = 9999;  
	public static void main(String[] args) throws IOException {
        
		 int[] arr = new int[] { 12, 23, 34, 45, 56, 67, 77, 89, 90 };

		//�ݹ�
		System.out.println(factorial(7));
		
		//���÷Ǿ�̬����
		OneDayDemoTest oddt = new OneDayDemoTest();
		oddt.BufferedInputStreamDemo();
		oddt.MikiOperation();
		 System.out.println("\n���ַ����ң�"+search(arr,12)+"\n");
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
	//��ȡ�����ļ�
	public void BufferedInputStreamDemo()throws IOException {
		//��ȡ�����ļ�
		FileInputStream file = new FileInputStream("f://bos.txt");
		//�ֽ�����ȡ
        //BufferedInputStream bis = new BufferedInputStream(file);
        
       // byte[] bys = new byte[1024];
        int len = 0;
/* 
        while ((len = bis.read(bys)) != -1) {
        	
            System.out.print(new String(bys, 0, len)+"\n\n");
            
        }*/

        //FileWriterд��
        String  str  = "дʲô����";
        File files = new File("f://bos.txt");
        if (!files.exists()) {
        	files.createNewFile();
           }

           FileWriter fw = new FileWriter(files.getAbsoluteFile());
           BufferedWriter bw = new BufferedWriter(fw);
           bw.write(str);
           bw.close();
           
           //�ļ��ַ�����ȡ
           FileReader fileReader = new FileReader("f://bos.txt");
           
               while((len = fileReader.read())!=-1)  
               {  
                   System.out.print((char)len);  
                     
               }  
               
        // �ͷ���Դ
        fileReader.close();
       // bis.close();
	}
	//��Ŀ����
	public void MikiOperation(){
		
		//���������
		System.out.println("\n"+"��� i > lo ������ i+lo ��� i < lo ������ i-lo"+"	�������"+
		(i>lo?i+lo:i-lo));
		//���������
				System.out.println("\n"+"��� flo > sho ������flo+sho ��� flo < sho ������flo-sho"+"	�������"+
				(flo>sho?flo+sho:flo-sho));
				//���������
		System.out.println("\n"+"��� boo==true ������flo+sho ��� boo==false ������flo-sho"+"	�������"+
				(boo?flo+sho:flo-sho));
		
	}
	//�ݹ�
	public void Recursion(){
		
	}
	//���㹫����
	public void jisuan(){
		//˰ǰ�¹��ʡ�10����12����2����λ�����ˣ���
		//����˰ǰ�¹���5000����������10����
		//���¹�����=5000��10����2��1000�����е�λ�͸��˸�500��
		Scanner scanner=new Scanner(System.in);
		System.out.println("������˰ǰ���ʣ�\n");
		while(scanner.hasNextInt())
		{
			int wages = scanner.nextInt();
			flo = (float) (wages * 0.1) ;
			System.out.print("������:"+ flo);
		}
	}
	//���������ǰ���������ģ����ڸ���ֵ x�������е��м�λ�ÿ�ʼ�Ƚϣ������ǰλ��ֵ���� x��
	//����ҳɹ����� x С�ڵ�ǰλ��ֵ���������е�ǰ����в��ң�
	//�� x ���ڵ�ǰλ��ֵ�������еĺ����м������ң�ֱ���ҵ�Ϊֹ��
	public static int search(int[] arr, int key) {
	       int start = 0;
	       int end = arr.length - 1;
	       while (start <= end) {
	    	   //���м���±�
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
