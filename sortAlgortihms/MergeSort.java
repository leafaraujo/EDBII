import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class MergeSort{

  static void merge(ArrayList<Integer> array, int l, int m, int r){
      int n1 = m - l + 1;
      int n2 = r - m;

      ArrayList<Integer> L = new ArrayList<Integer>(n1);
      ArrayList<Integer> R = new ArrayList<Integer>(n2);

      for (int i = 0; i < n1; ++i){
        L.add(array.get(l + i));
      }
    
      for (int j = 0; j < n2; ++j){
        R.add(array.get(m+1+j));
      }

      int i = 0, j = 0;

      int k = l;
      while (i < n1 && j < n2) {
          if (L.get(i) <= R.get(j)) {
              array.set(k, L.get(i));
              i++;
          }
          else {
            array.set(k, R.get(j));
            j++;
          }
          k++;
      }

      while (i < n1) {
        array.set(k, L.get(i));
        i++;
        k++;
      }

      while (j < n2) {
        array.set(k, R.get(j));
        j++;
        k++;
      }
  }

  static void mergeSort(ArrayList<Integer> vector, int begin, int end){
    int mid;
    if(begin<end){
      mid = (begin+end)/2;
      mergeSort(vector, begin, mid);
      mergeSort(vector, mid+1, end);
      merge(vector, begin, mid, end);
    }
  }

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
    Random numberGenerator = new Random();
    int userInput = 0;
    System.out.println("Diga a quantidade de elementos do vetor: ");
    userInput = input.nextInt();
    ArrayList <Integer> arrayOfInts = new ArrayList<Integer>();
        
    for(int i = 0; i < userInput; i++){
      arrayOfInts.add(numberGenerator.nextInt(100));
    }
    System.out.println("Vetor: ");
    printArray(arrayOfInts);
    if(isSorted(arrayOfInts)){
      System.out.println("O vetor está ordenado");
      System.exit(0);
    }
    else{
      System.out.println("O vetor não está ordenado, mas vamos ordenar");  
      mergeSort(arrayOfInts,0, arrayOfInts.size() - 1);
      System.out.println("O vetor ordenado: ");
      printArray(arrayOfInts);
    }
    input.close();
    }  
}
