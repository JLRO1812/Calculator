import java.util.Scanner;

public class LabCalculator{
	
	public static int operation;
	public static int num;
	
	public static double n1, n2;
	public static double suppRoot = 30;	
	public static final double pi =3.1416;
	
	public static String hexadecimal;
	
	public static Integer operationMode;

	public static Scanner reader;
	public static Scanner words;
	
	public static Double result= null;
	public static Double[]memory;
	
	public static String operationMenu = "Enter the number of the operation you wish to perform \n"+
									"1. Sum \n"+
									"2. Subtraction \n"+
									"3. Division \n"+
									"4. Multiplication \n"+
									"5. Module \n"+
									"6. Squere root \n"+
									"7. Empowerment \n"+
									"8. The factorial of a number\n"+
									"9. Conversion from degrees to radians and vice versa \n"+
									"10. The conversion between binaries, n1s and hexadecimals \n"+
									"11. Memory of the results of the last 10 operations \n"+
									"12. scientific notation \n"+
									"13. Sin \n"+
									"14. Cos \n"+
									"15. Tan \n"+
									"16. base logarithm 10 \n"+
									"17. base logarithm n \n"+
									"18. nth root \n"+
									"0.  Exit";
	public static void main (String []args){
		memory = new Double[10];
		reader= new Scanner(System.in);
		do{
			try{
				if(operationMode == null){
					System.out.println ("");
					System.out.println ("WELCOME TO THE CALCULATOR MADE TO YOUR TASTE");
					System.out.println ("");
					System.out.println ("Which mode do you want to use?\n"+ "1. One operation at a time \n"+ "2. Operations flow");
					operationMode= reader.nextInt();
				}
				System.out.println (operationMenu);
				operation= reader.nextInt();
				if(result != null){
					n1  = result;
				}
				switch(operation){
					case 0:
						operationMode = null;
					break;
					case 1:
						if(result == null){
							System.out.println ("Enter the numbers you wish to operate");
							n1 = reader.nextDouble();
						}
						else{
							System.out.println ("Enter the other number");
						}
						n2 = reader.nextDouble();
						result = Sum (n1, n2);
						PrintResult();
					break;
					case 2:
						if(result == null){
							System.out.println ("Enter the numbers you wish to operate");
							n1 = reader.nextDouble();
						}
						else{
							System.out.println ("Enter the other number");
						}
						n2 = reader.nextDouble();
						result = Subtraction( n1, n2);
						PrintResult();
					break;
					case 3:
						if(result == null){
							System.out.println ("Enter the dividend");
							n1= reader.nextDouble();
						}
						System.out.println ("Enter the divisor");
						n2= reader.nextDouble();
						while(n2==0)
						{
						System.out.println ("0 is not a valid value. Enter the divisor");
						n2= reader.nextDouble();
						};
						result = Division(n1, n2);
						PrintResult();
					break;
					case 4:
						if(result == null){
							System.out.println ("Enter the numbers you wish to operate");
							n1 = reader.nextDouble();
						}
						else{
							System.out.println ("Enter the other number");
						}
						n2= reader.nextDouble();
						result = Multiplication(n1, n2);
						PrintResult();
					break;
					case 5:
						if(result == null){
							System.out.println ("Number to which you want to get the module");
							n1= reader.nextDouble();
							System.out.println ("Module value");
						}
						else{
							System.out.println ("Module value");
						}
						n2= reader.nextDouble();
						result =  Module ( n1, n2);
						PrintResult();
					break;
					case 6:
						System.out.println ("Enter the number to be channeled");
						n1= reader.nextDouble();
						result= squareRoot(n1);
						PrintResult();
					break;
					case 7:
						if(result == null){
							System.out.println ("Enter the base value");
							n1= reader.nextDouble();}
						else{
							n1=empowerment(n1, n2);
						}
						System.out.println ("Enter the exponent");
						n2= reader.nextDouble();
						result= empowerment(n1, n2);
						PrintResult();
					break;
					case 8:
						if(result == null){
							System.out.println ("Enter the number you wish to operate");
							n1= reader.nextDouble();
						}
						else{
							n1= Factorial (n1);
						}
						result= Factorial (n1);
						PrintResult();
					break;
					case 9:
						System.out.println ("What conversion do you want to do?\n"+ "1. From degrees to radian\n"+"2. From radian to degrees");
						double option;
						option=reader.nextDouble();
						if(result == null){
							if (option==1){
								System.out.println ("Enter the number you wish to operate");
								n1= reader.nextDouble();
								result= Radians(n1);
							}
							else{
								System.out.println ("Enter the number you wish to operate");
								n1= reader.nextDouble();
								result= Degrees(n1);
							}
						}
						else{
							if (option==1){
								n1=result;
								result= Radians(n1);
							}
							else{
								n1=result;
								result= Degrees(n1);
							}
						}
						PrintResult();
					break;
					case 10:
						int ch;
						System.out.println ("What conversion do you want to do \n"+ "1. Decimal to hexadecimal \n"+ "2. Decimal to binary \n"+
						"3. Hexadecimal to decimal \n"+ "4. Binary to decimal \n" + "5. Hexadecimal to binary \n" +"6. Binary to hexadecimal" );
						ch= reader.nextInt();
						switch(ch){
							case 1:
								System.out.println ("Enter the number you wish to operate");
								n1= reader.nextDouble();
								String total= decimalToHexadecimal(n1);
								System.out.println (total);
							break;
							case 2:
								System.out.println ("Enter the number you wish to operate");
								num= reader.nextInt();
								System.out.println (decimalToBinary(num));
							break;
							case 3:
								String hexadecimal;
								System.out.println ("Enter the value");
								hexadecimal=reader.next(); 
								result=hexadecimalToDecimal(hexadecimal);
								System.out.println (result);
							break;
							case 4:
								String binary;
								System.out.println ("Enter the value");
								binary=reader.next(); 
								result=binaryToDecimal(binary);
								System.out.println (result);
							break;
							case 5:
								String hex, igual;
								System.out.println ("Enter the value");
								hex=reader.next(); 
								igual=hexadecimalToBinary(hex);
								System.out.println (igual);
							break;
							case 6:
								String resultx;
								System.out.println ("Enter the value");
								binary=reader.next(); 
								resultx= binaryToHexadecimal(binary);
								System.out.println (resultx);
						}
					break;
					case 11:
						result = null;
						PrintMemory();
						System.out.println ("Seleccione una posicion de memoria de 0 a 9" );
						int memoryOption= reader.nextInt();						
						result = memory[memoryOption];	
					break;
					case 12:
						System.out.println ("Enter the value");
						n1= reader.nextDouble();
						System.out.println (Notation(n1));	
					break;
					case 13:
						if(result == null){
							System.out.println ("Enter the number you wish to operate");
							n1 = reader.nextDouble();
						}
						result = Sin(n1);
						PrintResult();
					break;
					case 14:
						if(result == null){
							System.out.println ("Enter the number you wish to operate");
							n1= reader.nextDouble();
						}
						result = Cos(n1);
						PrintResult();
					break;
					case 15:
						if(result == null){
							System.out.println ("Enter the numbers you wish to operate");
							n1 = reader.nextDouble();
						}
						result = Tan(n1);
						PrintResult();	
					break;
					case 16:
						if(result == null){
							System.out.println ("Enter the number you wish to operate");
							n1= reader.nextDouble();
						}
						else {
							n1= Log10(n1);
						}
						result= Log10(n1);
						PrintResult();
					break;
					case 17:
						if(result == null){
							System.out.println ("Enter the value that will log");
							n1= reader.nextDouble();
						}
						else{
							n1=Logn(n1);
						}
						result= Logn(n1);
						PrintResult();
					break;
					case 18:
						if(result == null){
							System.out.println ("Enter the number to be channeled");
							n1= reader.nextDouble();}
						else{
							n1=Rootn(n1,n2);
						}
						System.out.println ("Enter the index");
						n2= reader.nextDouble();
						result= Rootn(n1,n2);
						PrintResult();
					break;
					default:
						System.out.println("");
						System.out.println("Enter a valid operation option");
						System.out.println("");
					break;
				}
				
				switch(operationMode){
					case 1:
						if (result != null && operation != 15 && operation != 18 && operation != 14){
							StoreInMemory(result);
							result = null;
						}
						reader.nextLine();						
					break;
					case 2:
					break;
				}
			}
			catch(Exception exc){
				
				System.out.println("");
				System.out.println ("Error: You have entered an invalid option");
				System.out.println("");
				reader.nextLine();
			}
		}
		while(operationMode!=null);
	}
	//memoria
	public static void StoreInMemory(double result){
		for (int i = (memory.length-1); i>0; i--){
			memory[i] = memory[i-1];
		}
		memory[0] = result;		
	}
	//imprimir memoria
	public static void PrintMemory(){
		try{
			for(int i = 0; i<memory.length; i++){
				System.out.println ("["+i+"]="+memory[i]+"  ");
			}
		}
		catch(Exception e){
			System.out.println (e.getMessage());
		}
	}
	//imprimir resultados
	public static void PrintResult(){
		if(result.isInfinite()){
			result = null;
			throw new IllegalArgumentException("Invalid Value");
		}
		System.out.println ("="+result);
	}
	/**
	*This method allows you to make sums
	
	*<b>pre:</b> The variables to add are valid
	*<b>post:</b> The sum was made
	
	*@param double(n1, n2)
	*@return double TotalSum
	*/
	public static double Sum (double n1, double n2){
		double TotalSum;
		TotalSum= n1+n2;
		return TotalSum;
	}
	/**
	*This method allows you to make subtraction
	
	*<b>pre:</b> The variable to subtraction are valid
	*<b>post:</b> The subtraction was made
	
	*@param double (n1, n2)
	*@return double TotalSubtraction
	*/
	public static double Subtraction(double n1, double n2){
		double TotalSubtraction;
		TotalSubtraction= n1-n2;
		return TotalSubtraction;
	}
	/**
	*This mothod allows you to make division
	
	*<b>pre:</b> The variable to division are valid, n2 !=0
	*<b>post:</b> The division was made
	
	*@param double (n1, n2)
	*@return double totalDiv
	*/
	public static double Division( double n1, double n2){
		double totalDiv;
		totalDiv= n1/n2;
		return totalDiv;
	}
	/**
	*This method allows you to make multiplication
	
	*<b>pre:</b> The variable to division are valid
	*<b>post:</b> The multiplication was made
	
	*@param double (n1, n2)
	*@return double totalMult
	*/
	public static double Multiplication( double n1, double n2){
		double totalMult;
		totalMult= n1*n2;
		return totalMult;
	}
	/**
	*This method allows you to make module
	
	*<b>pre:</b> The variable to module are valid
	*<b>post:</b> The module was made
	
	*@param double (n1, n2)
	*@return double totalMod
	*/
	public static double Module( double n1, double n2){
		double totalMod;
		totalMod= n1%n2;
		return totalMod;
	}	
	/**
	*This method allows you to make squareRoot
	
	*<b>pre:</b> The variable to squareRoot are valid, n1 must be positive
	*<b>post:</b> The squareRoot was made
	
	*@param doble n1
	*@return  double totalroot
	*/
	public static double squareRoot(double n1){
		double totalroot = 0;
		for(double i=0;i<=12;i++){
			totalroot = (suppRoot/2)+(n1/(2*suppRoot));
			suppRoot = totalroot;
		}
		return totalroot;
	}
	/**
	*This method allows you to make empowerment
	
	*<b>pre:</b> The variable to empowermentare are valid
	*<b>post:</b> The empowerment was made
	
	*@param double (n1, n2)
	*@return double totalEmp
	*/
	public static double empowerment(double n1, double n2){
		double totalEmp;
		totalEmp= 1;
        for (double i = 1; i <= n2; i++) {
            totalEmp = totalEmp * n1;
        }
        return totalEmp;
	}	
	/**
	*This method allows you to make factorial of a number
	
	*<b>pre:</b>The variable to factorial are valid
	*<b>post:</b> The factorial was made
	
	*@param double n1
	*@return double totalFact
	*/
	public static double Factorial (double n1){
		double totalFact =1;
		while ( n1!=0) {
			totalFact=totalFact*n1;
			n1--;
		}
		return totalFact;
	}
	/**
	*This method allows you to pass numbers to letters for the hexadecimal system
	
	*<b>pre:</b> The numbers must be between 0 and 9
	*<b>post:</b>The convertion was made
	
	*@param double n1
	*@return String hexadecimal
	*/
	public static String DecToHex(double n1){
		String hexadecimal = "";
		if(n1>=0 && n1<=9){
			hexadecimal += n1;
			hexadecimal = hexadecimal.replace(".0","");			
		}else if(n1==10){
			hexadecimal = "A";
		}else if(n1==11){
			hexadecimal = "B";
		}else if(n1==12){
			hexadecimal = "C";
		}else if(n1==13){
			hexadecimal = "D";
		}else if(n1==14){
			hexadecimal = "E";
		}else if(n1==15){
			hexadecimal = "F";
		}
		return hexadecimal;
	}
	//decimal a	hexadecimal
	public static String decimalToHexadecimal(double n1){
		String hexadecimal="";
		double division, residue;
		if(n1<16){
			hexadecimal= DecToHex (n1);
		}
		else{
			do{
				division= Math.floor(n1/16);
				residue= Math.floor(n1%16);
				hexadecimal= DecToHex(residue)+ hexadecimal;
				n1= division;
			}
			while (n1>=16);
			hexadecimal= DecToHex(n1)+ hexadecimal;
		}
		return hexadecimal;
	}
	//hexadecimal a decimal
	public static double hexadecimalToDecimal(String hexadecimal){
		String notation = "0123456789ABCDEF";
		hexadecimal = hexadecimal.toUpperCase();
		double decimal = 0;
		double total = 0;
		int i = hexadecimal.length()-1;
		int j = 0;
		while(i>=0){
			char select = hexadecimal.charAt(j);
			int evaluate = notation.indexOf(select);
			total = evaluate*(double)(Math.pow(16,i));
			decimal += total;
			i--;
			j++;
		}
		return decimal;
	}
	//decimal a binario
	public static String decimalToBinary(int num){
		String binary = "";
		int total = 1;
		do{
			total = num/2;
			int evaluate = num%2;
			num = total;
			if(evaluate==0){
				binary = "0"+binary;
			}else{
				binary = "1"+binary;
			}
		}while(total!=0);
		return binary;
	}
	//binario a decimal
	public static double binaryToDecimal(String binary){
		double decimal = 0;
		double posicion = 0;
		for (int x = binary.length() - 1; x >= 0; x--) {
			short digito = 1;
			if (binary.charAt(x) == '0') {
				digito = 0;
			}
			double multiplicador = Math.pow(2, posicion);
			decimal += digito * multiplicador;
			posicion++;
		}
		return decimal;
	}
	//binario a hexadecimal
	public static String binaryToHexadecimal(String binary){
		double decimal = binaryToDecimal(binary);
		String hexadecimal = decimalToHexadecimal(decimal);
		return hexadecimal;
	}
	/**
	*This method converts hexadecimal numbers to binary
		
	*<b>pre:</b The hexadecimal number has alphanumeric characters, in the case of the letters,
	they must be in capital letters, if not, they will not be read
	*<b>post:</b> The hexadecimal number became binary
	
	*@param double decimal
	*@return String binary
	*/
	
	//hexadecimal a binario
	public static String hexadecimalToBinary(String hex){
		double decimal= hexadecimalToDecimal(hex);
		int decimalx=(int)decimal;
		String binary=decimalToBinary(decimalx);
		return binary;
	}
	/**
	*This method takes the value Entered by the user type double and converts it to scientific notation
	
	*<b>pre:</b>
	*<b>post:</b> 
	
	*@param This method only accepts numeric characters
	*@return String convertion
	*/

	public static String Notation(double n1){
		String convertion;
		convertion=(String.format("%9.2E",n1));
		return convertion;
	}
	//Grados
	public static double Degrees(double n1){
		 double totalDeg;
		totalDeg= Math.toDegrees(n1);
		return totalDeg;
	}
	//radianes
	public static double Radians (double n1){
		double totalRad;
		totalRad= Math.toRadians(n1);
		return totalRad;
	}
	//Sin
	public static double Sin(double n1){
		return Math.sin(n1);
	}
	//tan
	public static double Tan(double n1){
		return Math.tan(n1);
	}
	//cos
	public static double Cos(double n1){
		return Math.cos(n1);
	}
	//Log 10
	public static double Log10(double n1){
		double totalLogb;
		totalLogb= Math.log10(n1);
		return totalLogb;
	}
	//Log n
	public static double Logn ( double n1){
		double totalLog;
		totalLog= Math.log(n1)/Math.log (2.71828);
		return totalLog;
	}
	//Raiz n-esima
	public static double Rootn(double n1, double n2){
		double rootTotal;
		rootTotal= Math.pow(n1, 1/n2);
		return rootTotal;
	}
}
