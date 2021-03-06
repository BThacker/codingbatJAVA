// @Brandon Thacker
// www.codingbat.com JAVA Recursion1 Problems and Solutions 

/*FACTORIAL
Given n of 1 or more, return the factorial of n, which is n * 
(n-1) * (n-2) ... 1. Compute the result recursively (without 
loops). 

factorial(1) → 1
factorial(2) → 2
factorial(3) → 6
*/

public int factorial(int n) {
	if (n == 1) {
		return 1;
	}

	return n * factorial(n-1);
}

/*BUNNYEARS
We have a number of bunnies and each bunny has two big floppy 
ears. We want to compute the total number of ears across all 
the bunnies recursively (without loops or multiplication). 

bunnyEars(0) → 0
bunnyEars(1) → 2
bunnyEars(2) → 4
*/

public int bunnyEars(int bunnies) {
	if (bunnies == 0) {
		return 0;
	}
	return 2 + bunnyEars(bunnies - 1);
}

/*FIBONACCI
The fibonacci sequence is a famous bit of mathematics, and it 
happens to have a recursive definition. The first two values 
in the sequence are 0 and 1 (essentially 2 base cases). Each 
subsequent value is the sum of the previous two values, so the
 whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. 
 Define a recursive fibonacci(n) method that returns the nth 
 fibonacci number, with n=0 representing the start of the sequence. 

fibonacci(0) → 0
fibonacci(1) → 1
fibonacci(2) → 1
*/

public int fibonacci(int n) {
	if (n == 0){
		return 0;
	}
	if (n == 1){
		return 1;
	}
	return fibonacci(n - 1) + fibonacci(n-2);
}

/*BUNNYEARS2
We have bunnies standing in a line, numbered 1, 2, ... The odd 
bunnies (1, 3, ..) have the normal 2 ears. The even bunnies 
(2, 4, ..) we'll say have 3 ears, because they each have a 
raised foot. Recursively return the number of "ears" in the bunny
line 1, 2, ... n (without loops or multiplication). 

bunnyEars2(0) → 0
bunnyEars2(1) → 2
bunnyEars2(2) → 5
*/

public int bunnyEars2(int bunnies) {
	if (bunnies == 0){
		return 0;
	}
	if (bunnies % 2 == 0){
		return 3 + bunnyEars2(bunnies - 1);
	}
	
	return 2 + bunnyEars2(bunnies - 1);
}

/*TRIANGLE
We have triangle made of blocks. The topmost row has 1 block, 
the next row down has 2 blocks, the next row has 3 blocks, 
and so on. Compute recursively (no loops or multiplication) 
the total number of blocks in such a triangle with the given 
number of rows. 

triangle(0) → 0
triangle(1) → 1
triangle(2) → 3
*/

public int triangle(int rows) {
	if (rows == 0) {
		return 0;
	}
	return rows + triangle(rows - 1);
}

/*SUMDIGITS
Given a non-negative int n, return the sum of its digits 
recursively (no loops). Note that mod (%) by 10 yields the 
rightmost digit (126 % 10 is 6), while divide (/) by 10 removes 
the rightmost digit (126 / 10 is 12). 

sumDigits(126) → 9
sumDigits(49) → 13
sumDigits(12) → 3
*/

public int sumDigits(int n) {
	if (n == 0) {
		return 0;
	}
	return (n % 10) + sumDigits(n / 10);
}

/*COUNT7
Given a non-negative int n, return the count of the occurrences 
of 7 as a digit, so for example 717 yields 2. (no loops). Note 
that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), 
while divide (/) by 10 removes the rightmost digit (126 / 10 is 
12). 

count7(717) → 2
count7(7) → 1
count7(123) → 0
*/

public int count7(int n) {
	if (n == 0) {
		return 0;
	}
	if (n % 10 == 7) {
		return 1 + count7(n / 10);
	}
	return count7(n / 10);
}

/*COUNT8
Given a non-negative int n, compute recursively (no loops) the 
count of the occurrences of 8 as a digit, except that an 8 with
 another 8 immediately to its left counts double, so 8818 yields 
 . Note that mod (%) by 10 yields the rightmost digit (126 % 10 
 is 6), while divide (/) by 10 removes the rightmost digit 
 (126 / 10 is 12). 

count8(8) → 1
count8(818) → 2
count8(8818) → 4
*/
// BT - I am having a hard time understanding recursion. 
public int count8(int n) {
	int x = 0;
	if (n == 0) {
		return 0;
	}
	if ((n / 10) % 10 == 8) {
		x = 1;
	}
	if (n % 10 == 8) {
		return x + 1 + count8(n / 10);
	}	

	return count8(n / 10);
}

/*POWERN
Given base and n that are both 1 or more, compute recursively 
(no loops) the value of base to the n power, so powerN(3, 2) 
is 9 (3 squared). 

powerN(3, 1) → 3
powerN(3, 2) → 9
powerN(3, 3) → 27
*/

public int powerN(int base, int n) {
	if (n == 0) {
		return 1;
	}
	return base * powerN(base, n - 1);
}

/*COUNTX
Given a string, compute recursively (no loops) the number of 
lowercase 'x' chars in the string. 

countX("xxhixx") → 4
countX("xhixhix") → 3
countX("hi") → 0
*/
// BT - This took me a while. == != .equals("")
public int countX(String str) {
	int strLen = str.length();
	int strStart = strLen - 1;
	if (strLen < 1){
		return 0;
	}
	int count = 0;
	String sub = str.substring(strStart, strLen);
	
	if (sub.equals("x")){
		count = 1;
	}
	return count + countX(str.substring(0, strLen - 1));
}

/*COUNTHI
Given a string, compute recursively (no loops) the number of 
times lowercase "hi" appears in the string. 

countHi("xxhixx") → 1
countHi("xhixhix") → 2
countHi("hi") → 1
*/

public int countHi(String str) {
	int strLen = str.length();
	int strStart = strLen - 1;
	if (strLen < 2){
		return 0;
	}
	int count = 0;
	String sub = str.substring(strStart - 1, strLen);
	
	if (sub.equals("hi")){
		count = 1;
	}
	return count + countHi(str.substring(0, strLen - 1));
}

/*CHANGEXY
Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars. 

changeXY("codex") → "codey"
changeXY("xxhixx") → "yyhiyy"
changeXY("xhixhix") → "yhiyhiy"
*/

public String changeXY(String str) {

}
