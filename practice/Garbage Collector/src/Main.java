import java.lang.Runtime;

public class Main {
	public static void main (String[] args){
		String in = null;
		changeString(in);
	}
	
	static void changeString(String inFunction){
		inFunction = "Won't be arround for long!";
		System.out.println("inFunction: " + inFunction);
	long i = 0;
	i = Runtime.getRuntime().freeMemory(); //Метод для получения количества свободной памяти
	System.out.println("We have only " + i + " bytes of memory");
	i = Runtime.getRuntime().availableProcessors(); //Метод для получения количества доступных процессоров
	System.out.println("We have " + i + " processor");
	i = Runtime.getRuntime().totalMemory(); //Метод для получения общего количества памяти
	System.out.println("We have " + i + " bytes of memory");
	Runtime.getRuntime().gc(); //Метод предлагающий запустить Garbage Collector для очистки памяти от не используемой информации
	System.out.println("After running Garbage Collector we have " + (i = Runtime.getRuntime().freeMemory()) + " bytes of memory");
	System.gc(); //Альтернативное предложения запуска Garbage Collector (Важно знать что это не запуск а именно предложения запуска запустится он или нет решать JVM.)
	System.out.println("After running Garbage Collector we have " + (i = Runtime.getRuntime().freeMemory()) + " bytes of memory");
	/* *****************************************************************
	 * Способы управлению памятью
	 * *****************************************************************
	 * 1) Минимизировать количество создаваемых объектов + повторное использование объектов
	 * 2) Что бы эффективно управлять памятью важно знать сколько памяти доступно java.lang.Runtime.freeMemory() как раз для этого подходит возвращает значение типа long
	 * 3) Так же при запуске приложения через командную строку можно запускать с параметрами:
	 * 	а)java -Xms256s MyApp -Initial heap size (Начальный размер динамической памяти)
	 * 	б)java -Xms256m MyApp -Maximum heap size (Максимальный размер динамической памяти)
	 * 	в)java -Xms256n MyApp -Heap size for young generation objects (размер динамической памяти для объектов молодого поколения */	
	/*
	 * *****************************************************************
	 * Результаты запуска приложения с параметром maximum heap size
	 * *****************************************************************
	 * 
	 * xtremere@Lenovo-B590:~/workspace/Garbage Collector/bin$ java -Xms256m Main
		inFunction: Won't be arround for long!
		We have only 255244136 bytes of memory
		We have that 2 processor
		We have 257949696 bytes of memory
		After running Garbage Collector we have 256361752 bytes of memory
		After running Garbage Collector we have 256361528 bytes of memory*/
	/* *****************************************************************
	 * Результаты запуска приложения без параметра (Скопировано из консоли Eclipse
	 * *****************************************************************
	 * inFunction: Won't be arround for long!
		We have only 54966064 bytes of memory
		We have that 2 processor
		We have 55574528 bytes of memory
		After running Garbage Collector we have 55035608 bytes of memory
		After running Garbage Collector we have 55038704 bytes of memory
	 */
	/*
	 * Полное описание класса Runtime: http://docs.oracle.com/javase/7/docs/api/
	 */
	}

}
