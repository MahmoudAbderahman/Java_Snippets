import java.util.Scanner;
public class Numbers_Sum_Calculator {
	public static void main(String[] args)
	{
		int n, sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("The number: ");
		n = sc.nextInt();
		
		sum = digitsSumCalculator(n);
		System.out.println(" = " + sum);
	}
	public static int digitsSumCalculator(int n)
	{
		int sum = 0;
		int length = (int) Math.log10(n) + 1; 
		
		double pow = Math.pow(10, (length) - 1);
		
		//System.out.println(pow);
		
		System.out.print("Ziffersumme: ");
		for(int i = 0; i < length; i++)
		{
		
			int ziffer = n / (int) pow;
			n -= ziffer * pow;
			pow /= 10;
			sum += ziffer;
			System.out.print(ziffer);
			if(i < length - 1)
			{
				System.out.print(" + ");
			}
		}
		return sum;
	}
}
