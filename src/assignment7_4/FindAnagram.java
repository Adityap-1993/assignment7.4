package assignment7_4;     //package declaration 


//importing java classes


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAnagram {                                            //class definition 
	public static Set<String> anagramSet=new HashSet<String>();
	public static List<String> anagramList=new ArrayList<String>();
	public static List<String> stringList=new ArrayList<String>();
	
public static void main(String[] args) throws IOException {                //main starts here 
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//taking input string 
	System.out.println("Enter the input : ");
	String input=br.readLine();
	
	String stringArray[]=input.split(",");
	
	
	for (String string : stringArray) {               //adding string array elements in string list 
		stringList.add(string);
	}
	
	for(int i=0;i<stringList.size();i++){      
		String test= stringList.get(i);
		
		for(int j=i+1;j<stringList.size();j++){
			
			String testWith=stringList.get(j);
			
			
			if(isAnagram(test,testWith)){                     //if anagrams then add both strings to Hashset 
							
				addToAnagramSet(test,testWith);
				deleteFromStringList(testWith);               //if traced string is removed 
				
			}
			
		}
		
		addToAnagramList(anagramSet);                        //adding pair of anagram to anagram list 
		anagramSet.clear();
		
	}
	
	//display Anagrams:
	displayAnagramList();
	
}

private static void addToAnagramList(Set<String> anagramSet) {            //method for adding anagram in list 
	
	if(anagramSet.size()==0){
		return;
	}
	String finalString="{";
	for(String string: anagramSet){
		finalString+=string + " ";
	}
	finalString+="}";
	
	
	anagramList.add(finalString);
	
}

private static void displayAnagramList() {        //method for displaying anagram  list 
	// TODO Auto-generated method stub
	
	System.out.println("Anagram list as below:");
	for(String string: anagramList){
		System.out.println(string);
	}
	
}

private static void deleteFromStringList(String testWith) {             //method for removing traced string 
	// TODO Auto-generated method stub
	stringList.remove(testWith);
	
}

private static void addToAnagramSet(String string, String testWith) {           //method for adding anagrams in set     
	// TODO Auto-generated method stub
	anagramSet.add(string);
	anagramSet.add(testWith);
}

private static boolean isAnagram(String test, String testWith) {                    //method for checking anagrams
	// TODO Auto-generated method stub
	
	
	if(test.length()!=testWith.length()){
		return false;
	}
	
	char charArray1[]=test.toLowerCase().toCharArray();
	char charArray2[]=testWith.toLowerCase().toCharArray();
	
	Arrays.sort(charArray1);
	Arrays.sort(charArray2);
	
	if(Arrays.equals(charArray1, charArray2)){
		return true;
	}
	
	else{return false;}
	
}
}


