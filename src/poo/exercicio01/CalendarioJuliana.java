package poo.exercicio01;

import javax.swing.JOptionPane;

public class CalendarioJuliana {
	public static void main(String[] args) {
		int ano = -1, mes = -1, dia = -1;
		float dataJuliana = 0;
		ano = anoValida(ano);
		mes = mesValida(mes);
		dia = diaValida(ano, mes, dia);
		dataJuliana = functionJulianaCalendario(dataJuliana, ano, mes, dia);
		System.out.println("Os dias são : " + dataJuliana);
		
	}
	public static int anoValida(int ano) {
		while(ano <= 0) {
			ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano desejado!"));
			if(ano <= 0) {
				System.out.println("Ano invalido!");
			}
		}
		return ano;
	}
	
	public static int mesValida(int mes) {
		while(mes <= 0 || mes > 12) {
			mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o Mes desejado!"));
			if(mes <= 0 || mes > 12) {
				System.out.println("Mes invalido!");
			}
		}
		return mes;
	}
	
	public static int diaValida(int ano, int mes, int dia) {
		int maxDay = 0;
		maxDay = maxDia(mes, ano);
		while(dia <= 0 || dia > maxDay) {
			dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia desejado!"));
			if(dia <= 0 || dia > maxDay) {
				System.out.println("Dia invalido!");
			}
		}
		return dia;
		
	}
	public static int maxDia(int mes, int ano) {
		int dia = 0;
		if(mes == 1 && mes == 3 && mes == 5 && mes == 6 && mes == 7 && mes == 10 && mes == 12) {
			dia = 31;
		}else if(mes != 2){
			dia = 30;
		}else {
			if(ano % 4 == 0 && (ano % 400 == 0 || ano % 100 != 0)) {
				dia = 29;
			}else {
				dia = 28;
			}
		}
		return dia;
	}
	
	public static float functionJulianaCalendario(float dataJuliana, int ano, int mes, int dia) {
		dataJuliana =  ( 1461 * ( ano + 4800 + ( mes - 14)/12 ) ) / 4 +
				( 367 * ( mes - 2- 12 * ( ( mes - 14)/12 ) ) ) /12 -
				( 3 * ( ( ano + 4900 + ( mes - 14 ) / 12 ) / 100 ) ) / 4 + dia - 32075;
        return dataJuliana; 
	}
}
