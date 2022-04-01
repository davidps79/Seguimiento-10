import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PuntoDos {
	private static BufferedReader in;
	private static BufferedWriter out;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		hanoi(n, 'A', 'C', 'B');
		out.close();
	}	
	
	public static void hanoi(int n, char from, char to, char aux) throws IOException {
		if (n==1) out.write("Mover disco de la posición " + from + " a la posición " + to + "\n");
		else {
			hanoi(n-1, from, aux, to);
			out.write("Mover disco de la posición " + from + " a la posición " + to + "\n");
			hanoi(n-1, aux, to, from);
		}
	}
}
