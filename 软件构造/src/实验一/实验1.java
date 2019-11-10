package 实验一;
import java.util.Random;
public class 实验1 {
	
	public static void main(String[] args) {
	    short[] left=new short[50]; 
		short[] right=new short[50];
		short[] operate=new short[50];
		printHeader();              
		printExercise(left,right,operate);  
		printCalculations(left,right,operate); 
		}
	public static void printHeader() {
		System.out.println("-----------------------------------------");
		System.out.println("-程序输出50道100以内的加减法算式习题-");
		System.out.println("-每次运行程序可得到一套50道题的习题答案-");
		System.out.println("-----------------------------------------");
		}
		//生成算式
	public static void printExercise(short[] left,short[] right,short[] operate) {
		char plu='+';
		Random random=new Random();
		for(int i=0;i<50;i++) {
		    operate[i]=(short)random.nextInt(2);
			if((operate[i])==1) {
				while(true){
					short index1=(short)random.nextInt(101);
					short index2=(short)random.nextInt(101);
					if(index1+index2<=100) {
						left[i]=index1;
						right[i]=index2;
						break;//判断和不能超过一百
						}	
					}
					plu='+';
				}
			else {
				while(true){
					short index1=(short)random.nextInt(101);
					short index2=(short)random.nextInt(101);
					if(index1-index2>0) {
						left[i]=index1;
						right[i]=index2;
							break;//判断差不能小于零
						}	
					}
					plu='-';
				}
			for(int m=0;m<49;m++) {
				for(int n=m+1;n<50;n++) {
					if(left[m]==left[n]&&right[m]==right[n]&&operate[m]==operate[n]||operate[m]==1&&left[m]==right[n]&&right[m]==left[n]) {
						left[m]=(short)random.nextInt(101);
						right[m]=(short)random.nextInt(101);
						operate[m]=(short)random.nextInt(2);
						m=0;
						break;
						}
					}	
				}//判断重复
			if(i<9) System.out.print("("+(i+1)+")"+" :  "+left[i]+plu+right[i]+"="+"\t");
			else System.out.print("("+(i+1)+")"+":  "+left[i]+plu+right[i]+"="+"\t");
			if((i+1)%5==0)
				System.out.println();
			}
		}
		//生成答案
	public static void printCalculations(short[] left,short[] right,short[] operate) {
		System.out.println("-----------------------------------------");
		System.out.println("-下面是习题的参考答案-");
		System.out.println("-----------------------------------------");
		for(int i=0;i<50;i++) {
			if(operate[i]==1) {
				int answer=left[i]+right[i];
				if (i<9) System.out.print("("+(i+1)+")"+" :   "+answer+"\t");
				else System.out.print("("+(i+1)+")"+":   "+answer+"\t");
				if((i+1)%5==0) {
					System.out.println();
					}		
				}
			else {
				int answer=left[i]-right[i];
				if(i<9) System.out.print("("+(i+1)+")"+" :   "+answer+"\t");
				else System.out.print("("+(i+1)+")"+":   "+answer+"\t");
				if((i+1)%5==0) {
					System.out.println();
					}	
				}
			}
		}
	}