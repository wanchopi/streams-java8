package com.wanchopi.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestStream {
	
	static List<String> nombres = Arrays.asList("oscar", "maria", "eva", "alvaro", "catalina", "juan");
	static List<Integer> numeros = Arrays.asList(32, 1, 100, 45, 34, 100, 2, 8, 2);
	static IntSummaryStatistics stats = numeros.stream().mapToInt((x) ->x).summaryStatistics();

	public static void main(String[] args) {
		
		System.out.println( "Lista de nombres " + nombres );
		
		System.out.println( "\tEn mayúsculas " + nombres.stream().map(String::toUpperCase).collect(Collectors.toList()) );
		
		System.out.println( "\tOrdenados " + nombres.stream().sorted().collect(Collectors.toList()) );
		
		Predicate<String> predicate = string -> string.length() > 3;
		System.out.println( "\tDe nás de tres letras " + nombres.stream().filter(predicate).collect(Collectors.toList()) );
		
		System.out.println( "\tHay " + nombres.stream().filter(predicate).count() + " nombres de mas de tres letras" );
		
		predicate = string -> string.length() < 5;
		System.out.println( "\tDe menos de cinco letras " + nombres.stream().filter(predicate).collect(Collectors.toList()) );
		
		predicate = string -> !string.isEmpty();
		System.out.println( "\tSin corchetes " + nombres.stream().filter(predicate).collect(Collectors.joining(", ")) );
		
		System.out.println("====================================");
		
		System.out.println( "Lista de números " + numeros );
		
		System.out.println( "\tSin repetidos " + numeros.stream().distinct().collect(Collectors.toList()) );
		
		System.out.println( "\tOrdenados " + numeros.stream().sorted().collect(Collectors.toList()) );
		
		System.out.println( "\tOrdenados de mayor a menor y sin repeticiones " + 
				numeros.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
		
		System.out.println( "\nCuadrado de los números " + 
				numeros.stream().distinct().map(n -> n*n).collect(Collectors.toList()) );
		
		System.out.println("====================================");
		
		System.out.println( "\tNúmero menor " + stats.getMin() );
		
		System.out.println( "\tNúmero mayor " + stats.getMax() );
		
		System.out.println( "\tSuma de todos los números " + stats.getSum()) ;
		
		System.out.println( "\tMedía de todos los números " + stats.getAverage() );
	}

}
