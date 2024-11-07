import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class BogoSort {

  static boolean isSorted(ArrayList<Integer> vectorOfInts){
    for(int i = 0; i < vectorOfInts.size() - 1; i ++){
      if(vectorOfInts.get(i) > vectorOfInts.get(i+1)){
        return false;
      }
    }
    return true;
  }

  static void printArray(ArrayList<Integer> vectorOfInts) { 
      for (int i = 0; i < vectorOfInts.size(); i++) 
          System.out.print(vectorOfInts.get(i) + " "); 
      System.out.println(); 
  } 

  public static void main(String[] args){ 
    Scanner input = new Scanner(System.in);
    Random numberGenerator = new Random(15212031);
    int userInput = 0, randomIndex = 0, tempNumber = 0;
    System.out.println("Diga a quantidade de elementos do vetor: ");
    userInput = input.nextInt();
    ArrayList <Integer> arrayOfInts = new ArrayList<Integer>();
        
    for(int i = 0; i < userInput; i++){
      arrayOfInts.add(numberGenerator.nextInt(10));
    }
    System.out.println("Vetor: ");
    printArray(arrayOfInts);
    if(isSorted(arrayOfInts)){
      System.out.println("O vetor está ordenado");
      System.exit(0);
    }
    else{
      System.out.println("O vetor não está ordenado, mas vamos ordenar");  
      do{
        for(int i = 0; i < arrayOfInts.size(); i++){
          randomIndex = numberGenerator.nextInt(arrayOfInts.size());
          tempNumber = arrayOfInts.get(i);
          arrayOfInts.set(i, arrayOfInts.get(randomIndex));
          arrayOfInts.set(randomIndex, tempNumber);
        }
      }while(!isSorted(arrayOfInts));
      System.out.println("O vetor ordenado: ");
      printArray(arrayOfInts);
    }
    input.close();
    }  
}
