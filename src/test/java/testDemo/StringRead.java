package testDemo;

public class StringRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ProgrammingJavaProgrammingPython";
		System.out.println("dfd");
		String [] s = str.split("Programming");
		int count =1;
		//int c=1;
		for(String s1 :s)
		{
			if(s1.equalsIgnoreCase("Programming"))
			{
				System.out.println(s1 + " =   no of occurrence Programming  = "+count);
				
				count++;
			}
			
			
			else
			{
				
			}
//			System.out.println(s1 + "   Number of words  " +c);
//			c++;
		}
		//System.out.println(count);
		
	}

}
