import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PuntoUno {
	private static BufferedReader in;
	private static BufferedWriter out;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] l = in.readLine().split(" ");
		int[] a = new int[l.length];
 		for (int i=0; i<l.length; i++) {
			a[i] = Integer.parseInt(l[i]);
		}
 		
 		mergeSort(a, 0, a.length-1);
 		
 		for (int i=0; i<a.length; i++) {
 			out.write(a[i] +"");
 			if (i<a.length-1) {
 				out.write(" ");
 			}
 		}
 		out.write("\n");
 		
 		out.close();
	}	
	
	public static void mergeSort(int[] a, int l, int r) {
		int m = l+(r-l)/2;
		if (l<r) {
			mergeSort(a, l, m);
			mergeSort(a, m+1, r);
			
			merge(a, l, m, r);
		}
	}
	
	public static void merge(int[] a, int l, int m, int r) {
		int ln = m-l+1;
		int rn = r-m;
		int[] left = new int[ln];
		int[] right = new int[rn];
		
		for (int i=0; i<ln; i++) left[i] = a[l+i];
		for (int i=0; i<rn; i++) right[i] = a[m+1+i];
		
		int i = 0, j=0, k=l;
		
		while (i<ln && j<rn) {
			if (left[i]<=right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			
			k++;
		}
		
		while (i<ln) {
			a[k] = left[i];
			i++;
			k++;
		}
		
		while (j<rn) {
			a[k] = right[j];
			j++;
			k++;
		}
	}
}
