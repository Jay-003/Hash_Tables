//Hash Table Experiment
//This is a simple demo program that
//creates an ArrayList of LinkedList of Integer objects
//It first displays the empty linked lists
//It then hashes some keys and displays the linked lists again
//It uses the generic LinkedList class and the generic Node class

//MODIFY THIS PROGRAM TO DO EXERCISE 1
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HashTableExperiment
{
	public static void main(String[] args)
	{
		//prompt the user to enter the table size
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the hash table size: ");
		int n = keyboard.nextInt();
		System.out.print("Enter the number of keys to be hashed: ");
		int count = keyboard.nextInt();
		
		//create an Arraylist of size n
		//The ArrayList holds a LinkedList object 
		//The LinkedList consists of nodes that hold integer objects
		ArrayList<LinkedList<Integer>> hashtable = new ArrayList<>();
		for (int i=0; i<n; i++)
		{
			hashtable.add(i, new LinkedList<>());
		}

		//Add random keys to the appropriate linked list.
		//Generating random keys using ThreadLocalRandom.
		//Calculating the index using the hash function key%(table_size).
		for (int i=0; i<count; i++) {
			int key = ThreadLocalRandom.current().nextInt(1,10000);
			int index = key%n;
			hashtable.get(index).add(key);
		}

		//Calculating the required results.
		double loadFactor = (double)count/n;
		int longestList = hashtable.get(0).size();
		int collisionCount = 0;

		//Calculating the longest list size and the no. of collisions.
		for (LinkedList<Integer> keyList : hashtable) {
			if (longestList < keyList.size()) {
				longestList = keyList.size();
			}
			if (keyList.size() > 1) {
				collisionCount += keyList.size()-1;
			}
		}

		//Display the arraylist of linked lists
		System.out.println();
		System.out.println("After the keys are hashed");

		for (int i=0; i<n; i++)
		{
			System.out.print(i + ": ");
			hashtable.get(i).enumerate();
		}

		//Display the required outcomes.
		System.out.println();
		System.out.println("Load Factor: " + loadFactor);
		System.out.println("Number of Collisions: " + collisionCount);
		System.out.println("Longest List Length: " + longestList);

	}
}
			
		