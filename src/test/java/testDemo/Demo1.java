package testDemo;

public class Demo1 {
	public static boolean isPrime(int n)
	{
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPrime(4));
		//Swap to value
		/*int a=10, b=30;
		System.out.println("A is value = "+a +"    B is value = "+b);
		b = b+a; //40
		a = b-a; //30
		b = b-a; //10
		System.out.println("A is after swap value = "+a +"    B is after swap value = "+b);
		*/
//Revrese String
		/*
		String str = "Ramdhani";
		String reverse ="";
		char []ch = str.toCharArray();
		for(int i=ch.length-1; i>=0; i--)
		{
			reverse +=ch[i];
		}
		System.out.println(reverse);
		*/
		
//Vowel is present in String
//		String str = "Ramdhani";
//		
//		char[] ch1 = str.toCharArray();
//		for(int i =0;  i<ch1.length; i++)
//		{
//			if(ch1[i] == 'a' || ch1[i] == 'e' ||ch1[i] == 'i' ||ch1[i] == 'o' ||ch1[i] == 'u')
//			{
//				System.out.println("this is vowel char = "+ch1[i] +"   and index no.=  "+i);
//			}
//		}
//		output
//		this is vowel char = a   and index no.=  1
//		this is vowel char = a   and index no.=  5
//		this is vowel char = i   and index no.=  7
		
// prime number	
		int n=11;
		
		for (int i = 1; i <= n ; i++) {
			boolean isPrime = true;
			if(i>1)
			{
				for(int j=2; j<i; j++)
				{
					if(i%j==0)
					{
						isPrime = false;
					}
				}
			}
			else{
				isPrime =true;
			}
			if(isPrime)
			{
				System.out.println(i);
			}
			
		}
		
// Fibonacci sequence using recursion		
		int a=0, b=1,c;
		int n=50;
		
		for(int i =2; i<n; i++)
		{
			c =a+b;
			if(c>=50)
			{
				break;
			}
			System.out.println(c);
			a=b;
			b=c;
			
		}
		
//odd numbers in Java?
//		int n=11;
//		if(n%2==0)
//		{
//			System.out.println("even");
//		}
//		{
//			System.out.println("odd");
//		}
////		
//occurence all string charactor
		String str = "Ramdhani";
		int count[] = new int[256];
		for(int i=0; i<str.length(); i++)
		{
			count[str.charAt(i)]++;
			
		}
		for(int i=0; i<=256; i++)
		{
			if(count[i] !=0)
			{
				System.out.println((char) i +" no occ " +count[i]);
			}
		}
			
		
		
		
	}

}
