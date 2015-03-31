// @Brandon Thacker
// www.codingbat.com JAVA String2 Problems and Solutions 
// MAX OF ONE LOOP

/*DOUBLECHAR
Given a string, return a string where for every char in the original, there are two chars. 

doubleChar("The") → "TThhee"
doubleChar("AAbb") → "AAAAbbbb"
doubleChar("Hi-There") → "HHii--TThheerree"
*/

public String doubleChar(String str) {
	char[] strAr = str.toCharArray();
	String retString = "";
	for (int i = 0; i < str.length(); i++) {
		retString += strAr[i];
		retString += strAr[i];
	}
	return retString;
}

/*COUNTHI
Return the number of times that the string "hi" appears anywhere in the given string. 

countHi("abc hi ho") → 1
countHi("ABChi hi") → 2
countHi("hihi") → 2
*/

public int countHi(String str) {
	char[] strAr = str.toCharArray();
	int counter = 0;
	for (int i = 0; i < str.length() - 1; i++) {
		if (strAr[i] == 'h' & strAr[i+1] == 'i') {
			counter++;
		}
	}
	return counter;
}

/*CATDOG
Return true if the string "cat" and "dog" appear the same number of times in the given string. 

catDog("catdog") → true
catDog("catcat") → false
catDog("1cat1cadodog") → true
*/

public boolean catDog(String str) {
	int dogCount = 0;
	int catCount = 0;
	for (int i = 0; i < str.length() - 2; i++) {
		if (str.substring(i, i+3).equals("dog"))
			dogCount++;
		if (str.substring(i, i+3).equals("cat"))
			catCount++;
	}
	if (dogCount == catCount)
		return true;
	else
		return false;
}

/*COUNTCODE
Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count. 

countCode("aaacodebbb") → 1
countCode("codexxcode") → 2
countCode("cozexxcope") → 2
*/

public int countCode(String str) {
	int codeCount = 0;
	for (int i = 0; i < str.length() - 3; i++) {
		if (str.substring(i, i+2).equals("co") && str.substring(i+3, i+4).equals("e"))
			codeCount++;
	}
	return codeCount;
}

/*ENDOTHER
Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string. 

endOther("Hiabc", "abc") → true
endOther("AbC", "HiaBc") → true
endOther("abc", "abXabc") → true
*/
// BT - This is messy. Blah.
public boolean endOther(String a, String b) {
	String lowerA = a.toLowerCase();
	String lowerB = b.toLowerCase();
	int aLen = a.length();
	int bLen = b.length();
	if (aLen >= bLen)
		if (lowerA.substring(aLen-bLen, aLen).equals(lowerB))
			return true;
	if (bLen > aLen)
		if (lowerB.substring(bLen-aLen, bLen).equals(lowerA))
			return true;
	
	return false;
}

/*XYZTHERE
