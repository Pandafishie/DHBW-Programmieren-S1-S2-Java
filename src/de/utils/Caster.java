package de.utils;

// Vgl. Peter's util package

/**
 * Enthaelt Methoden zum casten von Datentypen
 * Widening Caster (automatically) - converting a smaller type to a larger type size
 * byte -> short -> char -> int -> long -> float -> double
 * Narrowing Caster (manually) - converting a larger type to a smaller size type
 * double -> float -> long -> int -> char -> short -> byte 
 * Byte 	- 8 Bit
 * Short 	- 16 Bit
 * Int		- 32 Bit
 * Long		- 64 Bit
 * Float	- 32 Bit
 * Double	- 64 Bit
 */


public class Caster {
	
	// Byte To:
	public static short byteToShort(byte value) {
		return (short) value;
	}
	public static char byteToChar(byte value) {
		return (char) value;
	}
	public static int byteToInt(byte value) {
		return (int) value;
	}
	public static long byteToLong(byte value) {
		return (long) value;
	}
	public static float byteToFloat(byte value) {
		return (float) value;
	}
	public static double byteToDouble(byte value) {
		return (double) value;
	}
	
	//double to int
	public static int doubleToInt(double value) {
		return (int) value;
	}
	
	//String to:
	public static int stringToInt(String value) throws NumberFormatException {
		int i = Integer.parseInt(value);
		return i;
	}
	public static Integer stringToInteger(String value) throws NumberFormatException {
		int i = Integer.valueOf(value);
		return i;
	}
	public static float stringToFloat(String value) throws NumberFormatException {
		float f = Float.valueOf(value);
		return f;
	}
	public static double stringToDouble(String value) throws NumberFormatException {
		double d = Double.valueOf(value);
		return d;
	}
	
	

}
