// @Brandon Thacker
// www.codingbat.com JAVA Warmup 2 Problems and Solutions

/*STRINGTIMES
Given a string and a non-negative int n, return a larger string that is n copies of the original string. 

stringTimes("Hi", 2) → "HiHi"
stringTimes("Hi", 3) → "HiHiHi"
stringTimes("Hi", 1) → "Hi"
*/

public String stringTimes(String str, int n) {
	String newString = "";

	for (int i = 1; i <= n; i++)
		newString += (str);
	return newString;
}

/*FRONTTIMES
Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front; 

frontTimes("Chocolate", 2) → "ChoCho"
frontTimes("Chocolate", 3) → "ChoChoCho"
frontTimes("Abc", 3) → "AbcAbcAbc"
*/

public String frontTimes(String str, int n) {
	String sub = "";
	String newString = "";
	if (str.length() < 3) {
		sub = str.substring(0, str.length());
		for(int i = 1; i <= n; i++)
			newString += sub;
	}
	else {
		sub = str.substring(0, 3);
		for (int i = 1; i <= n; i++)
			newString += sub;
	}
	return newString;
}

/*COUNTXX
Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx". 

countXX("abcxx") → 1
countXX("xxx") → 2
countXX("xxxx") → 3
*/

int countXX(String str) {
		int counter = 0;
		int c2 = 2;
		String sub = "";
		String check = "xx";
		String check2 = "XX";
		for (int i = 0; i < str.length(); i++) {
			sub = str.substring(i, c2);
			if ((c2 + 1) <= str.length())
				c2++;
			if (sub.equals(check))
				counter++;
			if (sub.equals(check2))
				counter++;
		}
	return counter;
}
	
/*DOUBLEX

Given a string, return true if the first instance of "x" in the string is immediately followed by another "x". 

doubleX("axxbb") → true
doubleX("axaxax") → false
doubleX("xxxxx") → true
*/

boolean doubleX(String str) {
	char[] tester = str.toCharArray();

	for (int i = 0; i < str.length(); i++)
	{
		if (tester[i] == 'x' && (i + 1) < str.length())
			if (tester[i + 1] == 'x')
				return true;
			else
				return false;
	}
	return false;
}

/*STRINGBITS

Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo". 

stringBits("Hello") → "Hlo"
stringBits("Hi") → "H"
stringBits("Heeololeo") → "Hello"
*/

public String stringBits (String str) {
	char[] chArray = str.toCharArray();
	String sub = "";
	for (int i = 0; i < str.length(); i += 2) {
		sub += chArray[i];
	}
	return sub;
}

/*STRINGSPLOSION
Given a non-empty string like "Code" return a string like "CCoCodCode". 

stringSplosion("Code") → "CCoCodCode"
stringSplosion("abc") → "aababc"
stringSplosion("ab") → "aab"
*/

public String stringSplosion(String str) {
	int count = 1;
	String sub = "";
	for (int i = 0; i < str.length(); i++) {
		sub += str.substring(0, count);
		count++;
	}
	return sub;
}

/*LAST2
Given a string, return the count of the number of times that a substring length 2 appears in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring). 

last2("hixxhi") → 1
last2("xaxxaxaxx") → 1
last2("axxxaaxx") → 2
*/

public int last2(String str) {
	int strLen2 = str.length() - 2;
	String check = "";
	int counter = 2;
	int result = 0;
	if (str.length() >= 2) {
		String sub = str.substring(strLen2, str.length());

		for (int i = 0; i < str.length() - 2; i++) {
		check = str.substring(i, counter);
		counter++;
		
		if (check.equals(sub))
			result++;
		}	
	}
	return result;
}

/*ARRAYCOUNT9
Given an array of ints, return the number of 9's in the array. 

arrayCount9({1, 2, 9}) → 1
arrayCount9({1, 9, 9}) → 2
arrayCount9({1, 9, 9, 3, 9}) → 3
*/

public int arrayCount9 (int[] nums) {
	int counter = 0;
	for (int noms : nums) {
			if (noms == 9)
				counter++;
		}
	return counter;
}

/*ARRAYFRONT9
Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4. 

arrayFront9({1, 2, 9, 3, 4}) → true
arrayFront9({1, 2, 3, 4, 9}) → false
arrayFront9({1, 2, 3, 4, 5}) → false
*/

public boolean arrayFront9(int[] nums) {
	int counter = 0;
	for (int i = 0; i < nums.length; i++) {
		if (i > 3){
			break;
		}
		else
			if (nums[i] == 9)
				return true;
	}
	return false;
}

/*ARRAY123
Given an array of ints, return true if .. 1, 2, 3, .. appears in the array somewhere. 

array123({1, 1, 2, 3, 1}) → true
array123({1, 1, 2, 4, 1}) → false
array123({1, 1, 2, 1, 2, 3}) → true
*/

public boolean array123(int[] nums) {
	int num1 = 0;
	int num2 = 1;
	
	for(int i = 2; i < nums.length; i++) {
		if (nums[num1] == 1 && nums[num2] == 2 && nums[i] == 3)
			return true;
		num1++;
		num2++;
	}
	return false;
}

/*STRINGMATCH
Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings. 

stringMatch("xxcaazz", "xxbaaz") → 3
stringMatch("abc", "abc") → 2
stringMatch("abc", "axc") → 0
*/

public int stringMatch(String a, String b) {
	String sub1 = "";
	String sub2 = "";
	int j = 2;
	int counter = 0;
	int strLen = 0;
	if (a.length() > b.length())
		strLen = b.length();
	else
		strLen = a.length();

	for (int i = 0; i < strLen - 1; i++) {
		sub1 = a.substring(i, j);
		sub2 = b.substring(i, j);
		j++;
		if (sub1.equals(sub2))
			counter++;
		else 
			continue;
	}
	return counter;
}

/*STRINGX
Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed. 

stringX("xxHxix") → "xHix"
stringX("abxxxcd") → "abcd"
stringX("xabxxxcdx") → "xabcdx"
*/

public String stringX(String str) {
	char[] strAr = str.toCharArray();
	String newString = "";

	for (int i = 0; i < str.length(); i++) {
		if ((i == 0 || i == str.length() - 1 && strAr[i] == 'x'))
			newString += strAr[i];
		else if (strAr[i] == 'x')
			continue;
		else
			newString += strAr[i];
	}
	return newString;
}

/*ALTPAIRS
Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien". 

altPairs("kitten") → "kien"
altPairs("Chocolate") → "Chole"
altPairs("CodingHorror") → "Congrr"
*/

public String altPairs(String str) {
	char[] strAr = str.toCharArray();
	String newString = "";
	int count = 0;
	for (int i = 0; i < str.length(); i += 4) {
		newString += strAr[i];
		
		if (i + 1 < str.length())
			newString += strAr[i+1];
	}
	return newString;
}

/*STRINGYAK
Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed, but the "a" can be any char. The "yak" strings will not overlap. 

stringYak("yakpak") → "pak"
stringYak("pakyak") → "pak"
stringYak("yak123ya") → "123ya"
*/

public String stringYak(String str) {
	String sub = "";
	char[] strAr = str.toCharArray();
	String newString = "";
	for(int i = 0; i < str.length(); i++) {
		if (i+2 < str.length()) {
			if (strAr[i] == 'y' && strAr[i+2] == 'k') {
				i += 2;
				continue;
			}
		}
		newString += strAr[i];
	}
	return newString;
}

/*ARRAY667

Given an array of ints, return the number of times that two 6's are next to each other in the array. Also count instances where the second "6" is actually a 7. 

array667({6, 6, 2}) → 1
array667({6, 6, 2, 6}) → 1
array667({6, 7, 2, 6}) → 1
*/

public int array667(int[] nums) {
	int counter = 0;
	for (int i = 0; i < nums.length - 1; i++) {
		if (nums[i] == 6 && nums[i+1] == 6 || nums[i+1] == 7)
			counter++;
		else
			continue;
	}
	return counter;
}

/*NOTRIPLES
Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array. Return true if the array does not contain any triples. 

noTriples({1, 1, 2, 2, 1}) → true
noTriples({1, 1, 2, 2, 2, 1}) → false
noTriples({1, 1, 1, 2, 2, 2, 1}) → false
*/

public boolean noTriples(int[] nums) {
	for (int i = 0; i < nums.length -2; i++) {
		if (nums[i] == nums[i+1] && nums[i+1] == nums[i+2])
			return false;

	}
	return true;
}

/*HAS271
Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a value, followed by the value plus 5, followed by the value minus 1. Additionally the 271 counts even if the "1" differs by 2 or less from the correct value. 

has271({1, 2, 7, 1}) → true
has271({1, 2, 8, 1}) → false
has271({2, 7, 1}) → true
*/

public boolean has271(int[] nums) {

	for (int i = 0; i < nums.length - 2; i++) {
		boolean isInRange = (nums[i+2] == nums[i] - 2 || nums[i+2] == nums[i] - 1 || nums[i+2] == nums[i] + 1 || nums[i+2] == nums[i] - 3);

		if (nums[i+1] == nums[i] + 5 && isInRange)
			return true;
	}
	return false;
}






