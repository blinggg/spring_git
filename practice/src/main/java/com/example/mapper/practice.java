package com.example.mapper;

public class practice {

	public static void main(String[] args) {
		
		/*int number[]={0,1,2,3,4,5};
		
		int max=number[0];
		int min=number[0];
		int sum=0;
		
		for(int i=0;i<number.length;i++) {
			if(max<number[i]) {
				max=number[i];
			}else if(min>number[i]) {
				min=number[i];
			}
			sum=sum+i;
		}
		System.out.println(sum);
		System.out.println((sum-max-min));
		System.out.println("최대값:"+max+"최소값:"+min);*/
		
		//0828 연습하기
		/*int a=5;
		int b=10;
		
		System.out.println(a+b);
		System.out.println(a/b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a%b);*/
		
		int array[]={0,20,30,40,50};
		int max=array[0];
		int min=array[0];
		int sum=0;
		
		for(int i=0;i<array.length;i++) {
			if(max<array[i]) {
				max=array[i];
			}else if(min>array[i]){
				min=array[i];
			}
			sum=sum+i;
		}
		System.out.println(array.length);
		System.out.println(max+"/"+min+"/"+sum);

		
		
		
	}

}
