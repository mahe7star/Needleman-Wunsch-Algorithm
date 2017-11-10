import java.util.Scanner;

public class similarity {
	 	
	private static Scanner scan;
	public static void main(String[] args){
		 scan = new Scanner( System.in );
		 System.out.print("Enter first Code-Fragment: ");
		 String str1 = scan.nextLine();
		 System.out.println( "Code-Fragment 1 = " + str1.toUpperCase() );
		 System.out.print("Enter Second Code-Fragment: ");
		 String str2 = scan.nextLine();
		 System.out.println( "Code-Fragment 2 = " + str2.toUpperCase() );
		 
		 makeArray(str1,str2);
		
			} 
	 public static void makeArray(String strA,String strB){
		 int i,j;
		 int lenA=strA.length();
		 int lenB=strB.length();
		//System.out.println(lenA+" "+lenB);
		 char array[][]= new char[lenA+2][lenB+2];
		 array[0][0]=' ';
		 array[0][1]='-';
		 array[1][0]='-';
		 for(i=2;i<lenA+2;i++){
			 array[i][0]=strA.charAt(i-2);
			 for(j=2;j<lenB+2;j++){
				 array[0][j]=strB.charAt(j-2);
			 }
		 }
		 for(i=1;i<=lenA+1;i++){
			 for(j=1;j<=lenB+1;j++){
				 array[i][j]='0';
				 //System.out.println(i+" "+j);
			 }
		 }		
		 
		 match(array,lenA,lenB);
		 
	 }
	 //matching characters of provided strings
	 public static void match(char arrayF[][],int len1,int len2){
		 char val;
		 int i,j,upper,beside,daig;
		 int arrayR[][]=new int[len1+1][len2+1];
		 
		 int valInt=0;
		 arrayR[0][0]=0;
		 for(i=0;i<len1+1;i++){
			 for(j=0;j<len2+1;j++){
				 arrayR[i][0]=0;
				 arrayR[0][j]=0;
			 }
		 }
 		 for(i=2;i<len1+2;i++){
 			 for(j=2;j<len2+2;j++){
 				 if(arrayF[i][0]==arrayF[0][j]){
 					val='1';
 					valInt=1;
 				 }
 				 else{ val='-';
 				valInt=-1;}
 				 arrayF[i][j]=val;
 				 arrayR[i-1][j-1]=valInt;
 				 				 
 			 }
 		 }
 		print(arrayF);
 		
// 		for (int[] x : arrayR)
//		 {
//		    for (int y : x)
//		    {
//		         System.out.print(y + " "+" ");
//		    }
//		    System.out.println();
//		 }
 		
 		compare(arrayR,len1,len2);
	 }
	 
	 // for comparison
	 
	 public static void compare(int arraC[][],int lenX,int lenY){
		 int i,j,upper,beside,daig,max;
		 float sim=1;
		 int arrayC[][]=new int[lenX+1][lenY+1];
		 arrayC[0][0]=0;
		 for(i=1;i<lenX+1;i++){
 			 for(j=1;j<lenY+1;j++){
 				 arrayC[i-1][0]=0;
 				 arrayC[0][j-1]=0;
 				 upper=arraC[i-1][j];
 				 beside=arraC[i][j-1];
 				 daig=arrayC[i-1][j-1]+arraC[i][j];
 				 
 				 if(upper>beside && upper>daig){
 					 arrayC[i][j]=upper;
 				 }
 				 else if(beside>upper && beside>daig){
 					 arrayC[i][j]=beside;
 				 }
 				 else if(daig>upper && daig>beside){
 					arrayC[i][j]=daig;
 				 }
 			 	}
 			 }
		 System.out.println("******************************");
	     System.out.println("*** Global Alignment Matrix***");
	     System.out.println("******************************");
			 for (int[] x : arrayC)
			 {
			    for (int y : x)
			    {
			         System.out.print(y + " "+" ");
			    }
			    System.out.println();
			 }
		 System.out.println("******************************");
		 if(lenX>lenY){
			 max=lenX;
		 }
		 else max=lenY;
		 
		 int temp=arrayC[lenX][lenY];
		 System.out.println(temp);
		 System.out.println(max);
		 sim=(float)temp/max;
		 System.out.printf("Sim(A,B) = %.3f",sim);
	 }
	 
	 public static void print(char arr[][]){
		 System.out.println("******************************");
         System.out.println("****** Match Matrix **********");
		 System.out.println("******************************");
		 for (char[] x : arr)
		 {
		    for (char y : x)
		    {
		         System.out.print(y + " "+" ");
		    }
		    System.out.println();
		 }
	     System.out.println("******************************");
	 }
}
