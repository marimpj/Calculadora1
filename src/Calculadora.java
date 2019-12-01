import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Pilha<Character> pilhaNPR = new Pilha<Character>();
		Pilha<Character> pilhaOP = new Pilha<Character>();

		String exp;
		char ch;
		String x = "";
		char aux;
		char aux2;
		char aux3;
		char aux4;
		String numero = "";
		System.out.println("Digite a expressão");
		exp = teclado.next();
		int j = 0;
		int k = 0;
		double a, b;

		for (int i = 0; i < exp.length(); i++) {
			ch = exp.charAt(i);
			while (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7'
					|| ch == '8' || ch == '9' || ch == '0') { //para concatenar o numero
				pilhaNPR.push(ch);
				numero = numero + pilhaNPR.pop();
				i++;
			}
			Integer.parseInt(numero);
			pilhaNPR.push(numero);
			if (ch != '0' || ch != '1' || ch != '2' || ch != '3' || ch != '4' || ch != '5' || ch != '6' || ch != '7'
					|| ch != '8' || ch != '9' || ch != '0') { //empilhar e calcular segundo as prioridades
				aux = pilhaOP.pop();
				if (ch == '*' && aux == '/') {
					a = pilhaNPR.pop();
					b = pilhaNPR.pop();
					a = a / b;
					pilhaNPR.push(a);
				}
				if (ch == '/' && aux == '*') {
					a = pilhaNPR.pop();
					b = pilhaNPR.pop();
					a = a * b;
					pilhaNPR.push(a);
				}
				if (ch == '+' && aux == '-') {
					a = pilhaNPR.pop();
					b = pilhaNPR.pop();
					a = a - b;
					pilhaNPR.push(a);
				}
				if (ch == '-' && aux == '+') {
					a = pilhaNPR.pop();
					b = pilhaNPR.pop();
					a = a + b;
					pilhaNPR.push(a);
				}
				if (ch == '-' && aux == '*' || aux == '/' || aux == '^') {
					a = pilhaNPR.pop();
					b = pilhaNPR.pop();
					if (aux == '*') {
						a = a * b;
					}
					if (aux == '/') {
						a = a / b;
					}
					if (aux == '^') {
						a = Math.pow(a, b);
					}
					pilhaNPR.push(a);
				}
				if (ch == '+' && aux == '*' || aux == '/' || aux == '^') {
					a = pilhaNPR.pop();
					b = pilhaNPR.pop();
					if (aux == '*') {
						a = a * b;
					}
					if (aux == '/') {
						a = a / b;
					}
					if (aux == '^') {
						a = Math.pow(a, b);
					}
					pilhaNPR.push(a);
				}
				if (ch == '/' && aux == '^') {
					a = pilhaNPR.pop();
					b = pilhaNPR.pop();
					a = Math.pow(a, b);
					pilhaNPR.push(a);
				}
				if (ch == '*' && aux == '^') {
					a = pilhaNPR.pop();
					b = pilhaNPR.pop();
					a = Math.pow(a, b);
					pilhaNPR.push(a);
				}
				if (ch == ')') {
					j = i;
					aux3 = ch;
					aux3 = exp.charAt(j);
					while (aux3 != '(') {
						aux2 = pilhaOP.pop();
						a = pilhaNPR.pop();
						b = pilhaNPR.pop();
						if (aux2 == '+') {
							a = a + b;
						} else if (aux2 == '-') {
							a = a - b;
						} else if (aux2 == '/') {
							a = a / b;
						} else if (aux2 == '*') {
							a = a * b;
						} else if (aux2 == '^') {
							a = Math.pow(a, b);
						}
						pilhaNPR.push(a);
						j--;
					}
				}
				if (ch == ')') {
					pilhaOP.push(ch);
					pilhaOP.pop();
				} else {
					pilhaOP.push(aux);
				}
				pilhaOP.push(ch);
			}

		}
		
		while (!pilhaOP.isEmpty()) {  //caso a pilha de operadores estiver cheia ainda executar o que é necessario
		aux4 = pilhaOP.pop();
		a = pilhaNPR.pop();
		b = pilhaNPR.pop();
		if (aux4 == '+') {
			a = a + b;
		} else if (aux4 == '-') {
			a = a - b;
		} else if (aux4 == '/') {
			a = a / b;
		} else if (aux4 == '*') {
			a = a * b;
		} else if (aux4 == '^') {
			a = Math.pow(a, b);
		}
		pilhaNPR.push(a);
		}
		
		System.out.println(a);
		
		

	}
	

}
