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
Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not. 

xyzThere("abcxyz") → true
xyzThere("abc.xyz") → false
xyzThere("xyz.abc") → true
*/
// BT - For some reason this was a lot harder than it looked
public boolean xyzThere(String str) {
	boolean result = false;
	for (int i = 0; i < str.length() - 2; i++) {
		if (str.substring(i, i+3).equals("xyz")) {
			result = true;
			if (i > 0 && str.substring(i-1,i).equals(".")) {
				result = false;
			}
		}	
	}
	return result;
}

/*BOBTHERE
Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char. 

bobThere("abcbob") → true
bobThere("b9b") → true
bobThere("bac") → false
*/

public boolean bobThere(String str) {
	for (int i = 0; i < str.length() - 2; i++)
		if (str.substring(i,i+1).equals("b") && str.substring(i+2,i+3).equals("b"))
			return true;

		return false;


/*XYBALANCE
We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced. 

xyBalance("aaxbby") → true
xyBalance("aaxbb") → false
xyBalance("yaaxbb") → false
*/

public boolean xyBalance(String str) {
	boolean xBal = true;
	boolean yBal = true;
	for(int i = 0; i < str.length(); i++) {
		if (str.substring(i,i+1).equals("x")) {
			xBal = true;
		}
		if (xBal && str.substring(i,i+1).equals("y")) {
			yBal = true;
		}
		if (yBal && str.substring(i,i+1).equals("x")){
			yBal = false;
		}
	}
	if (xBal && yBal) {
		return true;
	}
	return false;
}

/*MIXSTRING
Given two strings, A and B, create a bigger string made of the first char of A, the first char of B, the second char of A, the second char of B, and so on. Any leftover chars go at the end of the result. 

mixString("abc", "xyz") → "axbycz"
mixString("Hi", "There") → "HTihere"
mixString("xxxx", "There") → "xTxhxexre"
*/

public String mixString(String a, String b) {
	char[] aAr = a.toCharArray();
	char[] bAr = b.toCharArray();
	int aLen = a.length();
	int bLen = b.length();
	String retString = "";
	for (int i = 0; i < Math.max(aLen, bLen); i++) {
		if (i <= aLen - 1) {
			retString += aAr[i];
		}
		if (i <= bLen - 1) {
			retString += bAr[i];
		}
	}
	return retString;
}

/*REPEATEND
Given a string and an int N, return a string made of N repetitions of the last N characters of the string. You may assume that N is between 0 and the length of the string, inclusive. 

repeatEnd("Hello", 3) → "llollollo"
repeatEnd("Hello", 2) → "lolo"
repeatEnd("Hello", 1) → "o"
*/

public String repeatEnd(String str, int n) {
	int strLen = str.length();
	String retString = "";
	for (int i = 0; i < n; i ++) {
		retString += str.substring(strLen - n, strLen);
	}
	return retString;
}

/*REPEATFRONT
Given a string and an int n, return a string made of the first n characters of the string, followed by the first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()). 

repeatFront("Chocolate", 4) → "ChocChoChC"
repeatFront("Chocolate", 3) → "ChoChC"
repeatFront("Ice Cream", 2) → "IcI"
*/

public String repeatFront (String str, int n) {
	int strLen = str.length();
	String retString = "";
	int decrement = n;
	for (int i = 0; i < n; i++) {
		retString += str.substring(0, decrement);
		decrement--;
	}
	return retString;
}

/*REPEATSEPERATOR
Given two strings, word and a separator, return a big string made of count occurences of the word, separated by the separator string. 

repeatSeparator("Word", "X", 3) → "WordXWordXWord"
repeatSeparator("This", "And", 2) → "ThisAndThis"
repeatSeparator("This", "And", 1) → "This"
*/

public String repeatSeparator(String word, String sep, int count) {
	String retString = "";
	for (int i = 0; i < count; i++) {
		retString += word;
		if (i != count - 1)
			retString += sep;
	}
	return retString;
}

/*PREFIXAGAIN
Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length(). 

prefixAgain("abXYabc", 1) → true
prefixAgain("abXYabc", 2) → true
prefixAgain("abXYabc", 3) → false
*/

public boolean prefixAgain(String str, int n) {
	String sub = str.substring(0, n);
	for (int i = n; i <= str.length() - n; i++) {
		if (str.substring(i, i + n).equals(sub)) {
			return true;
		}
	}
	return false;
}

/*XYZMIDDLE
Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks. 

xyzMiddle("AAxyzBB") → true
xyzMiddle("AxyzBB") → true
xyzMiddle("AxyzBBB") → false
*/
// BT - This was major trial and error. I believe I wrote way too much code, but meh. I will check it again later.
public boolean xyzMiddle(String str) {
	int half = 0;
	if (str.length() < 3)
		return false;
	if (str.length() % 2 == 0)
		half = str.length() / 2 - 2;
	else if (str.length() % 2 != 0)
		half = str.length() / 2 - 1;

	for (int i = half; i < str.length() - half - 2; i++)
		if (str.substring(i, i+3).equals("xyz"))
			return true;
	return false;
}

/*GETSANDWICH
A sandwich is two pieces of bread with something in between. Return the string that is between the first and last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread. 

getSandwich("breadjambread") → "jam"
getSandwich("xxbreadjambreadyy") → "jam"
getSandwich("xxbreadyy") → ""
*/
// This was a really weird problem. I keep initializing to 0 which resulted in my markers being way off and the concatenation to fail.
public String getSandwich(String str) {
	int b1 = 99;
	int b2 = 99;
	String retString = "";
	for (int i = 0; i < str.length() - 4; i++){
		if (str.substring(i, i+5).equals("bread")) {
			if (b1 == 99){
				b1 = i;
				continue;
			}
			if (b1 != 99) {
				b2 = i;
			}
		}
	}
	if (b1 != 99 && b2 != 99){
		retString = str.substring(b1+5, b2);
	}
	return retString;
 }

 /*SAMESTARCHAR
Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same. 

sameStarChar("xy*yzz") → true
sameStarChar("xy*zzz") → false
sameStarChar("*xa*az") → true
*/

public boolean sameStarChar(String str) {
	char[] strAr = str.toCharArray();
	boolean result = true;
	for(int i = 1; i < str.length() - 1; i++) {
		if (strAr[i] == '*' && strAr[i-1] == strAr[i+1]) {
			result = true;
		}
		else if (strAr[i] == '*'){
			result = false;
		}
	}
	return result;
}

/*ZIPZAP
Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp". 

zipZap("zipXzap") → "zpXzp"
zipZap("zopzop") → "zpzp"
zipZap("zzzopzop") → "zzzpzp"
*/

public String zipZap(String str) {
	char[] strAr = str.toCharArray();
	String retString = "";
	if (str.length() < 3) {
		return str;
	}
	for(int i = 0; i < str.length(); i++) {
		if (strAr[i] == 'z' && strAr[i+2] == 'p') {
			retString += "zp";
			i += 2;
			continue;
		}
		retString += strAr[i];

	}
	return retString;
}

/*STAROUT
Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad". 

starOut("ab*cd") → "ad"
starOut("ab**cd") → "ad"
starOut("sm*eilly") → "silly"
*/
// BT - Took forever.
public String starOut(String str) {
	String retString = "";
	char[] strAr = str.toCharArray();

	for(int i = 0; i < str.length(); i++) {
		if (strAr[i] == '*') {
			continue;
		}
		if (i > 0 && strAr[i-1] == '*') {
			continue;
		}
		if (i < str.length() - 1 && strAr[i+1] == '*') {
			continue;
		}
		retString += strAr[i];
	}
	return retString;
}

/*PLUSOUT
Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged. 

plusOut("12xy34", "xy") → "++xy++"
plusOut("12xy34", "1") → "1+++++"
plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
*/
// BT - This was fun. Not.
public String plusOut(String str, String word) {
	String retString = "";
	int wLen = word.length();
	for (int i = 0; i < str.length(); i++) {
		if (i < str.length() - wLen + 1 && str.substring(i, i+wLen).equals(word)) {
			retString += word;
			i += wLen - 1;
		}
		else {
			retString += '+';
		}
	}
	return retString;
}


/*WORDENDS
Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words. 

wordEnds("abcXY123XYijk", "XY") → "c13i"
wordEnds("XY123XY", "XY") → "13"
wordEnds("XY1XY", "XY") → "11"
*/
// BT - Proud of this one, took a lot of time in the Eclipse debugger
public String wordEnds(String str, String word) {
	String retString = "";
	char[] strAr = str.toCharArray();
	int wLen = word.length();
	int sLen = str.length();
	for (int i = 0; i < str.length(); i++) {
		if (i < str.length() - wLen && str.substring(i,i+wLen).equals(word)){
			retString += strAr[i+wLen];
		}
		if (i < str.length() - wLen && str.substring(i+1,i+1+wLen).equals(word)){
			retString += strAr[i];
		}
		else {
			continue;
		}

	}
	return retString;
}