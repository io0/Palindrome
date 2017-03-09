import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		
		for (int i=0; i<k; i++){
			String number = s.next();
			int digits = number.length();
			
			int[] a = new int[digits];
			for (int j=0; j<number.length(); j++){
				a[j] = number.charAt(j) - '0';
			}
			
			int[] b = removeTens(generate(a, 0, digits), (digits+1)/2-1);
			for (int j=0; j<digits; j++){
				System.out.print(b[j]);
			}
			System.out.println();
			
		}
		s.close();
	}
	
	public static int[] generate(int[] a, int i, int digits){
		if (a[i] == a[digits-i-1] && i<digits-i-1){
			return generate(a, i+1, digits);
		} else if (2*i==digits){
			if (a[i] == a[digits-i-1]){
				a[digits-i-1]++; a[i]++;
			} else {
				a[i] = Math.max(a[i], a[digits-i-1]);
				a[digits-i-1] = a[i];
			}
			return a;
		} else if (i==digits-i-1){
			a[i]++;
			return a;
		} else if (a[i] < a[digits-i-1]){
		
			a[digits-i-1] = a[i];
			a[digits-i-2]++;
			return generate(a, i+1, digits);
		} else if (a[i] > a[digits-i-1]){
			a[digits-i-1] = a[i];
			if (i+1 == digits-i-1){
				return a;
			} else {
				return generate(a, i+1, digits);
			}
		}
		return null;
	}
	
	public static int[] removeTens(int[] a, int i){
		while (i>0){
			if (a[i]>9){
				a[i] = 0;
				a[a.length-i-1] = 0;
				a[i-1]++;
				a[a.length-i]++;
			}
			i--;
		}
		if (a[0]<10) return a;
		else {
			a[a.length-1]=1;
			return a;
		}
	}
}
