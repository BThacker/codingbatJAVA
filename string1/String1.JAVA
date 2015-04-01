// @Brandon Thacker
// www.codingbat.com JAVA String1 Problems and Solutions

/*HELLONAME
Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!". 

helloName("Bob") → "Hello Bob!"
helloName("Alice") → "Hello Alice!"
helloName("X") → "Hello X!"
*/

public String helloName(String name) {
	return ("Hello " +name+ "!");
} 

/*MAKEABBA
Given two strings, a and b, return the result of putting them together in the 
order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi". 

makeAbba("Hi", "Bye") → "HiByeByeHi"
makeAbba("Yo", "Alice") → "YoAliceAliceYo"
makeAbba("What", "Up") → "WhatUpUpWhat"
*/

public String makeAbba(String a, String b) {
	String newString = (a + b + b + a);
	return newString;
}

/*MAKETAGS
The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. 
In this example, the "i" tag makes <i> and </i> which surround the word "Yay". Given 
tag and word strings, create the HTML string with tags around the word, e.g. "<i>Yay</i>". 

makeTags("i", "Yay") → "<i>Yay</i>"
makeTags("i", "Hello") → "<i>Hello</i>"
makeTags("cite", "Yay") → "<cite>Yay</cite>"
*/

public String makeTags(String tag, String word) {
	String newString = ("<"+tag+">"+word+"</"+tag+">");
	return newString;
}

/*MAKEOUTWORD
Given an "out" string length 4, such as "<<>>", and a word, return a new string where the 
word is in the middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) 
to extract the String starting at index i and going up to but not including index j. 

makeOutWord("<<>>", "Yay") → "<<Yay>>"
makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
makeOutWord("[[]]", "word") → "[[word]]"
*/

public String makeOutWord(String out, String word) {
	String sub1 = out.substring(0, 2);
	String sub2 = out.substring(2, 4);
	String newString = (sub1+word+sub2);
	return newString;
}

/*EXTRAEND
Given a string, return a new string made of 3 copies of the last 2 chars of the original 
string. The string length will be at least 2. 

extraEnd("Hello") → "lololo"
extraEnd("ab") → "ababab"
extraEnd("Hi") → "HiHiHi"
*/

public String extraEnd(String str) {
	int len = str.length();
	String sub = str.substring(len - 2, len);
	String newString = (sub+sub+sub);
	return newString;
}

/*FIRSTTWO
Given a string, return the string made of its first two chars, so the String "Hello" yields 
"He". If the string is shorter than length 2, return whatever there is, so "X" yields "X", 
and the empty string "" yields the empty string "". Note that str.length() returns the 
length of a string. 

firstTwo("Hello") → "He"
firstTwo("abcdefg") → "ab"
firstTwo("ab") → "ab"
*/

public String firstTwo(String str) {
	int len = str.length();
	String newString = "";
	if (len >= 2)
		newString = str.substring(0, 2);
	else if (len == 1)
		newString = str.substring(0, 1);
	return newString;
}

/*FIRSTHALF
Given a string of even length, return the first half. So the string "WooHoo" yields "Woo". 

firstHalf("WooHoo") → "Woo"
firstHalf("HelloThere") → "Hello"
firstHalf("abcdef") → "abc"
*/

public String firstHalf(String str) {
	int half = (str.length() / 2);
	String sub = str.substring(0, half);
	return sub;
}

/*WITHOUTEND
Given a string, return a version without the first and last char, so "Hello" yields 
"ell". The string length will be at least 2. 

withoutEnd("Hello") → "ell"
withoutEnd("java") → "av"
withoutEnd("coding") → "odin"
*/

public String withoutEnd(String str) {
	char[] strArray = str.toCharArray();
	String sub = "";
	for (int i = 0; i < str.length(); i++)
		if (i != 0 && i != str.length() - 1)
			sub += strArray[i];
	return sub;
}

/*COMBOSTRING
Given 2 strings, a and b, return a string of the form short+long+short, with the shorter 
string on the outside and the longer string on the inside. The strings will not be the 
same length, but they may be empty (length 0). 

comboString("Hello", "hi") → "hiHellohi"
comboString("hi", "Hello") → "hiHellohi"
comboString("aaa", "b") → "baaab"
*/

public String comboString(String a, String b) {
	String sLong;
	String sShort;
	if(a.length() < b.length()) {
		sShort = a;
		sLong = b;
	}
	else {
		sShort = b;
		sLong = a;
	}
	String newString = (sShort+sLong+sShort);
	return newString;
}

/*NONSTART
Given 2 strings, return their concatenation, except omit the first char of each. 
The strings will be at least length 1. 

nonStart("Hello", "There") → "ellohere"
nonStart("java", "code") → "avaode"
nonStart("shotl", "java") → "hotlava"
*/

public String nonStart(String a, String b) {
	int aLen = a.length();
	int bLen = b.length();
	String sub1 = a.substring(1, aLen);
	String sub2 = b.substring(1, bLen);
	String newString = (sub1+sub2);
	return newString;
}

/*LEFT2
Given a string, return a "rotated left 2" version where the first 2 chars are moved 
to the end. The string length will be at least 2. 

left2("Hello") → "lloHe"
left2("java") → "vaja"
left2("Hi") → "Hi"
*/

public String left2(String str) {
	int strLen = str.length();
	String sub = str.substring(0, 2);
	String sub1 = str.substring(2, strLen);
	String newString = (sub1+sub);
	return newString;
}

/*RIGHT2
Given a string, return a "rotated right 2" version where the last 2 chars are 
oved to the start. The string length will be at least 2. 

right2("Hello") → "loHel"
right2("java") → "vaja"
right2("Hi") → "Hi"
*/

public String right2(String str) {
	int strLen = str.length();
	String sub = str.substring(strLen - 2, strLen);
	String sub1 = str.substring(0, strLen - 2);
	String newString = (sub+sub1);
	return newString;
}

/*THEEND

Given a string, return a string length 1 from its front, unless front is false, 
in which case return a string length 1 from its back. The string will be non-empty. 

theEnd("Hello", true) → "H"
theEnd("Hello", false) → "o"
theEnd("oh", true) → "o"
*/

public String theEnd(String str, boolean front) {
	int strLen = str.length();
	String newString = "";
	if (!front) {
		newString = str.substring(strLen -1, strLen);
	}
	else
		newString = str.substring(0, 1);
	return newString;
}

/*WITHOUEND2
Given a string, return a version without both the first and last char of the 
string. The string may be any length, including 0. 

withouEnd2("Hello") → "ell"
withouEnd2("abc") → "b"
withouEnd2("ab") → ""
*/

public String withouEnd2(String str) {
	int strLen = str.length();
	String newString = "";
	String sub1 = "";
	if (strLen > 2) {
		sub1 = str.substring(1, strLen - 1);
		return sub1;
	}
	else
		return "";
}

/*MIDDLETWO

Given a string of even length, return a string made of the middle two chars, 
so the string "string" yields "ri". The string length will be at least 2. 

middleTwo("string") → "ri"
middleTwo("code") → "od"
middleTwo("Practice") → "ct"
*/

public String middleTwo(String str) {
	int strLen = str.length();
	String sub1 = "";
	String sub2 = "";
	int half = 0;
	if (strLen % 2 == 0) {
		half = strLen / 2;
		sub1 = str.substring(half - 1, half + 1 );
		return sub1;
	}
	else
		return str;	
}

/*ENDSLY
Given a string, return true if it ends in "ly". 

endsLy("oddly") → true
endsLy("y") → false
endsLy("oddy") → false
*/

public boolean endsLy(String str) {
	int strLen = str.length();
	if (strLen > 1) {
		String sub = str.substring(strLen - 2, strLen);
		if (sub.equals("ly"))
		return true;
	}
	return false;
}

/*NTWICE
Given a string and an int n, return a string made of the first and last 
n chars from the string. The string length will be at least n. 

nTwice("Hello", 2) → "Helo"
nTwice("Chocolate", 3) → "Choate"
nTwice("Chocolate", 1) → "Ce"
*/

public String nTwice(String str, int n) {
	int strLen = str.length();
	String sub1 = str.substring(0, n);
	String sub2 = str.substring(strLen - n, strLen);
	String newString = (sub1+sub2);
	return newString;	
}

/*TWOCHAR
Given a string and an index, return a string length 2 starting at the given 
index. If the index is too big or too small to define a string length 2, use 
the first 2 chars. The string length will be at least 2. 

twoChar("java", 0) → "ja"
twoChar("java", 2) → "va"
twoChar("java", 3) → "ja"
*/

public String twoChar(String str, int index) {
	String sub = "";
	if (index >= 0 && index <= str.length() - 2) {
		sub = str.substring(index, index + 2);
	}
	else
		sub = str.substring(0, 2);
	
	return sub;
}

/*MIDDLETHREE
Given a string of odd length, return the string length 3 from its middle, 
so "Candy" yields "and". The string length will be at least 3. 

middleThree("Candy") → "and"
middleThree("and") → "and"
middleThree("solving") → "lvi"
*/

public String middleThree(String str) {
	int strLen = str.length();
	int half = 1;
	String sub = "";
	if (strLen % 2 != 0) {
		half = (strLen / 2) + 1;
		sub = str.substring(half - 2, half + 1);
		return sub;
	}
	else
		return str;	
}

/*HASBAD
Given a string, return true if "bad" appears starting at index 0 or 1 in the 
string, such as with "badxxx" or "xbadxx" but not "xxbadxx". The string may 
be any length, including 0. Note: use .equals() to compare 2 strings. 

hasBad("badxx") → true
hasBad("xbadxx") → true
hasBad("xxbadxx") → false
*/

public boolean hasBad(String str) {
	char[] strArray = str.toCharArray();
	
	for (int i = 0; i < 2; i++) {
		if (i + 2 < str.length()) {
			if (strArray[i] == 'b' && strArray[i+1] == 'a' && strArray[i+2] == 'd')
				return true;
		}
	}
	return false;
}

/*ATFIRST

Given a string, return a string length 2 made of its first 2 chars. If the 
string length is less than 2, use '@' for the missing chars. 

atFirst("hello") → "he"
atFirst("hi") → "hi"
atFirst("h") → "h@"
*/

public String atFirst(String str) {
	int strLen = str.length();
	String sub = "@";
	String newString = "";
	if (strLen == 1) {
		newString = (str + "@");
	}
	else if (strLen == 0) {
		newString = (sub+sub);
	}
	else
		newString = str.substring(0, 2);
	return newString;
}

/*LASTCHARS
Given 2 strings, a and b, return a new string made of the first char of a 
and the last char of b, so "yo" and "java" yields "ya". If either string 
is length 0, use '@' for its missing char. 

lastChars("last", "chars") → "ls"
lastChars("yo", "java") → "ya"
lastChars("hi", "") → "h@"
*/

public String lastChars(String a, String b) {
	int strLenA = a.length();
	int strLenB = b.length();
	String subA = "@";
	String subB = "@";
	String newString = "";
	if (strLenA != 0) {
		subA = a.substring(0, 1);
	}	
	if (strLenB != 0) {
		subB = b.substring(strLenB -1, strLenB);
	}
	newString = (subA+subB);
	return newString;
}

/*CONCAT

Given two strings, append them together (known as "concatenation") and return 
the result. However, if the concatenation creates a double-char, then omit 
one of the chars, so "abc" and "cat" yields "abcat". 

conCat("abc", "cat") → "abcat"
conCat("dog", "cat") → "dogcat"
conCat("abc", "") → "abc"
*/

public String conCat(String a, String b) {
	int aLen = a.length();
	int bLen = b.length();
	String subA = "";
	String subB = "";
	String newString = "";
	if (aLen != 0)
		subA = a.substring(aLen -1, aLen);
	if (bLen != 0)
		subB = b.substring(0, 1);
	if (subA.equals(subB))
		newString = (a + b.substring(1, bLen));
	else
		newString = (a+b);
	return newString;
}

/*LASTTWO
Given a string of any length, return a new string where the last 2 chars, 
if present, are swapped, so "coding" yields "codign". 

lastTwo("coding") → "codign"
lastTwo("cat") → "cta"
lastTwo("ab") → "ba"
*/

public String lastTwo(String str) {
	int strLen = str.length();
	char[] strAr = str.toCharArray();
	String newString = "";
	if (strLen > 1) {
		char temp;
		temp = strAr[strLen - 1];
		strAr[strLen - 1] = strAr[strLen - 2];
		strAr[strLen - 2] = temp;
		newString = new String(strAr);
		return newString;
	}	
	else
		return str;
}

/*SEECOLOR

Given a string, if the string begins with "red" or "blue" return that 
color string, otherwise return the empty string. 

seeColor("redxx") → "red"
seeColor("xxred") → ""
seeColor("blueTimes") → "blue"
*/

public String seeColor(String str) {
	int strLen = str.length();
	String sub = "";
	if (strLen > 2) {
		sub = str.substring(0, 3);
		if (sub.equals("red"))
			return sub;
	}
	if (strLen > 3) {
		sub = str.substring(0, 4);
		if (sub.equals("blue"))
			return sub;
	}
	return "";
}

/*FRONTAGAIN
Given a string, return true if the first 2 chars in the string also 
appear at the end of the string, such as with "edited". 

frontAgain("edited") → true
frontAgain("edit") → false
frontAgain("ed") → true
*/

public boolean frontAgain(String str) {
	int strLen = str.length();
	String sub1 = "";
	String sub2 = "";
	if (strLen > 1) {
		sub1 = str.substring(0, 2);
		sub2 = str.substring(strLen - 2, strLen);
		if (sub1.equals(sub2))
			return true;
	}
	return false;
}

/*MINCAT
Given two strings, append them together (known as "concatenation") and return 
the result. However, if the strings are different lengths, omit chars from the 
longer string so it is the same length as the shorter string. So "Hello" and 
"Hi" yield "loHi". The strings may be any length. 

minCat("Hello", "Hi") → "loHi"
minCat("Hello", "java") → "ellojava"
minCat("java", "Hello") → "javaello"
*/

public String minCat(String a, String b) {
	int lenA = a.length();
	int lenB = b.length();
	String subA = "";
	String subB = "";
	String retString = "";
	
	if (lenA > lenB) {
		retString = (a.substring(lenA - lenB, lenA) + b);
		return retString;
	}
	if (lenB > lenA) {
		retString = (a + b.substring(lenB - lenA, lenB));
		return retString;
	}
	else
		retString = (a+b);
	return retString;
}

/*EXTRAFONT
Given a string, return a new string made of 3 copies of the first 2 chars of 
the original string. The string may be any length. If there are fewer than 2 
chars, use whatever is there. 

extraFront("Hello") → "HeHeHe"
extraFront("ab") → "ababab"
extraFront("H") → "HHH"
*/

public String extraFront(String str) {
	int strLen = str.length();
	String sub = "";
	String newString = "";
	if (strLen > 1) {
		sub = str.substring(0, 2);
		newString = (sub+sub+sub);
		return newString;
	}
	else
		newString = (str+str+str);
	return newString;
}

/*WITHOUT2
Given a string, if a length 2 substring appears at both its beginning and end, 
return a string without the substring at the beginning, so "HelloHe" yields "lloHe". 
The substring may overlap with itself, so "Hi" yields "". Otherwise, return the 
original string unchanged. 

without2("HelloHe") → "lloHe"
without2("HelloHi") → "HelloHi"
without2("Hi") → ""
*/

public String without2(String str) {
	String sub1 = "";
	String sub2 = "";
	int strLen = str.length();
	String newString = "";
	if (strLen >= 2) {
		sub1 = str.substring(0, 2);
		sub2 = str.substring(strLen - 2, strLen);
		if (sub1.equals(sub2)) {
			newString = str.substring(2, strLen);
			return newString;
		}
		return str;
	}
	return str;
}

/*DEFRONT
Given a string, return a version without the first 2 chars. Except keep the 
first char if it is 'a' and keep the second char if it is 'b'. The string may 
be any length. Harder than it looks. 

deFront("Hello") → "llo"
deFront("java") → "va"
deFront("away") → "aay"
*/

public String deFront(String str) {
	int strLen = str.length();
	String retString = "";
	
	char[] strAr = str.toCharArray();
	
	for(int i = 0; i < strLen; i++) {
		if (strAr[0] == 'a' && i == 0) {
			retString += strAr[0];
		}
		if (strAr[1] == 'b' && i == 1) {
			retString += strAr[1];
		}
		if (i > 1)
			retString += strAr[i];
	}
	return retString;
}

/*STARTWORD
Given a string and a second "word" string, we'll say that the word matches the 
string if it appears at the front of the string, except its first char does not 
need to match exactly. On a match, return the front of the string, or otherwise 
return the empty string. So, so with the string "hippo" the word "hi" returns "hi" 
and "xip" returns "hip". The word will be at least length 1. 

startWord("hippo", "hi") → "hi"
startWord("hippo", "xip") → "hip"
startWord("hippo", "i") → "h"
*/

public String startWord(String str, String word) {
	int strLen1 = str.length();
	int strLen2 = word.length();
	if (strLen1 >= strLen2) {
		String sub1 = str.substring(1, strLen2);
		String sub2 = word.substring(1, strLen2);
		String retString = "";
		if (sub1.equals(sub2)) {
			retString = str.substring(0, strLen2);
			return retString;
		}
	}
	return "";
}

/*WITHOUTX
Given a string, if the first or last chars are 'x', return the string without 
those 'x' chars, and otherwise return the string unchanged. 

withoutX("xHix") → "Hi"
withoutX("xHi") → "Hi"
withoutX("Hxix") → "Hxi"
*/

public String withoutX(String str) {
	int strLen = str.length();
	char[] strArray = str.toCharArray();
	String retString = "";
	for (int i = 0; i < strLen; i++) {
		if (strArray[0] == 'x' && i == 0)
			continue;
		if (strArray[strLen - 1] == 'x' && i == strLen - 1)
			break;
		else
			retString += strArray[i];
	}
	return retString;
}

/*WITHOUTX2

Given a string, if one or both of the first 2 chars is 'x', return the string 
without those 'x' chars, and otherwise return the string unchanged. This is a 
little harder than it looks. 

withoutX2("xHi") → "Hi"
withoutX2("Hxi") → "Hi"
withoutX2("Hi") → "Hi"
*/

public String withoutX2(String str) {
	int strLen = str.length();
	char[] strArray = str.toCharArray();
	String retString = "";
	for (int i = 0; i < strLen; i++) {
		if (strArray[i] == 'x' && i == 0) {
			continue;
		}
		else if (strArray[i] == 'x' && i == 1) {
			continue;
		}
		else {
			retString += strArray[i];
		}
	}
	return retString;
}