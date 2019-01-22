/*
 * Programmer: Victor Pineda
 * Date: 4/21/18
 * Program Description: This class is used to generate arrays of different 
data types. The arrays will be filled with randomly generated values specified
by the user. 
 */

package Tools;
import java.util.Random;
import java.lang.Math;s

public class ArrayGenerator {
    
    private final Random ran = new Random();    
    private int intArray[];
    private double doubleArray[];
    private long longArray[];
    private String stringArray[];   
    private final char charArray[] = {'A', 'a', 'B', 'b', 'C', 'c',
                                'D', 'd', 'E', 'e', 'F', 'f',
                                'G', 'g', 'H', 'h', 'I', 'i',
                                'J', 'j', 'K', 'k', 'L', 'l',
                                'M', 'm', 'N', 'n', 'O', 'o',
                                'P', 'p', 'Q', 'q', 'R', 'r',
                                'S', 's', 'T', 't', 'U', 'u',
                                'V', 'v', 'W', 'w', 'X', 'x',
                                'Y', 'y', 'Z', 'z'};       
    
    public int[] generateIntArray(int size, int min, int max){        
        checkValidity(size, min, max);
        intArray = new int[size];
        for(int i = 0; i < intArray.length; i++){
            intArray[i] = ran.nextInt((max - min) + 1) + min;
        }        
        return intArray;                
    }
    
    public double[] generateDoubleArray(int size, int min, int max){           
        checkValidity(size, min, max);
        doubleArray = new double[size];
        for(int i = 0; i < doubleArray.length; i++ ){
            doubleArray[i] = (ran.nextInt((max - min) + 1) + min) + getRandomDouble(3);
        }
        return doubleArray;
    }
    
    public long[] generateLongArray(int size){
        if(size < 1){
            throw new IllegalArgumentException("Error: Array size must be greater than 1.");
        }      
        longArray = new long[size];
        for(int i =  0; i < longArray.length; i++){
            longArray[i]  = ran.nextLong() >>> 1;
        }
        return longArray;
    }
    
    public char[] generateCharArray(int size){
        if(size < 1){
            throw new IllegalArgumentException("Error: Array size must be greater than zero.");
        }
        char Array[] = new char[size];
        for(int i = 0; i < size; i++){
            Array[i] = charArray[ran.nextInt(51)];
        }
        return Array;
    }    

    public  String[] generateStringArray(int arraySize, int elementSize){        
                
        stringArray = new String[arraySize];
        
        for(int index = 0; index < arraySize; index++){
            String send = getString(elementSize);
            stringArray[index] = send;
        }        
        return stringArray;        
    }
    
    public String[] generateStringNumberArray(int size, int minNumber, int maxNumber){
        
        stringArray = new String[size];
        intArray = generateIntArray(size, minNumber, maxNumber);
        for(int index = 0; index < size; index++){
            stringArray[index] = Integer.toString(intArray[index]);
        }
        return stringArray;
    }
    
    private String getString(int elementSize){
        
        if(elementSize < 1){
            throw new IllegalArgumentException("Error: Element size must greater than zero.");
        }        
        
        char ar[] = generateCharArray(elementSize);

        String n = "";
        for(int i = 0; i < elementSize; i++){            
            n += ar[i];
        }
        return n;        
    }
    
    
    private double getRandomDouble(int numberOfDecimals){        
        double precision = Math.pow(10.0, (double)numberOfDecimals);
        return Math.round(ran.nextDouble() * precision) / precision;        
    }
    
    private void checkValidity(int size, int min, int max){
        if(size < 1){
            throw new IllegalArgumentException("Error: Array size must be greater than 1.");
        }
        if(min > max){
            throw new IllegalArgumentException("Error: Minimum value must be less than maximum value.");
        }
    }                           
}
