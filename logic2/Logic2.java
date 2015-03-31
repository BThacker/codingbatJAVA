// @Brandon Thacker
// www.codingbat.com JAVA Logic2 Problems and Solutions 

/*MAKEBRICKS
We want to make a row of bricks that is goal inches long. We have a number of small bricks (1 inch each) and big bricks (5 inches each). Return true if it is possible to make the goal by choosing from the given bricks. This is a little harder than it looks and can be done without any loops. See also: Introduction to MakeBricks 

makeBricks(3, 1, 8) → true
makeBricks(3, 1, 9) → false
makeBricks(3, 2, 10) → true
*/
// BT - Way harder than it should have been

public boolean makeBricks(int small, int big, int goal) {
	// Check failure first
	// Not enough total bricks
	if (big * 5 + small < goal)
		return false;
	// not enough small bricks
	 if (small < goal % 5)
		return false;
	
	return true;
}

/*LONESUM
Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values, it does not count towards the sum. 

loneSum(1, 2, 3) → 6
loneSum(3, 2, 3) → 2
loneSum(3, 3, 3) → 0
*/
// BT - This is messy, but functional. Will need to figure out how to shorten algorithms like this.
public int loneSum (int a, int b, int c) {
	int result = a + b + c;
	if (a == b && b == c) {
		result = 0;
		return result;
	}
	if (a == b)
		result = c;
	if (a == c)
		result = b;
	if (b == c)
		result = a;
	return result;
}

/*LUCKYSUM
Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards the sum and values to its right do not count. So for example, if b is 13, then both b and c do not count. 

luckySum(1, 2, 3) → 6
luckySum(1, 2, 13) → 3
luckySum(1, 13, 3) → 1
*/

public int luckySum(int a, int b, int c) {
	int result = 0;
	if (a == 13) {
		result = 0;
		return result;
	}
	if (b == 13) {
		result = a;
		return result;
	}
	if (c == 13) {
		result = a + b;
		return result;
	}
	else
		result = a + b + c;
	return result;
}

/*NOTEENSUM
Given 3 int values, a b c, return their sum. However, if any of the values is a teen -- in the range 13..19 inclusive -- then that value counts as 0, except 15 and 16 do not count as a teens. Write a separate helper "public int fixTeen(int n) {"that takes in an int value and returns that value fixed for the teen rule. In this way, you avoid repeating the teen code 3 times (i.e. "decomposition"). Define the helper below and at the same indent level as the main noTeenSum(). 

noTeenSum(1, 2, 3) → 6
noTeenSum(2, 13, 1) → 3
noTeenSum(2, 1, 14) → 3
*/

public int noTeenSum(int a, int b, int c) {
	int sum = fixTeen(a) + fixTeen(b) + fixTeen(c);
	return sum;
}

public int fixTeen(int n) {
	if (n > 12 && n < 15 || n > 16 && n < 20)
		n = 0;
	else 
		n = n;
	return n;

/*ROUNDSUM
For this problem, we'll round an int value up to the next multiple of 10 if its rightmost digit is 5 or more, so 15 rounds up to 20. Alternately, round down to the previous multiple of 10 if its rightmost digit is less than 5, so 12 rounds down to 10. Given 3 ints, a b c, return the sum of their rounded values. To avoid code repetition, write a separate helper "public int round10(int num) {" and call it 3 times. Write the helper entirely below and at the same indent level as roundSum(). 

roundSum(16, 17, 18) → 60
roundSum(12, 13, 14) → 30
roundSum(6, 4, 4) → 10
*/

public int roundSum(int a, int b, int c) {
	int sum = round10(a) + round10(b) + round10(c);
	return sum;
}

public int round10(int num) {
	if (num % 10 >= 5) {
		num += (10 - num % 10);
		return num;
	}
	if (num % 10 < 5) {
		num -= (num % 10);
		return num;
	}
	return num;
}

/*CLOSEFAR
Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1), while the other is "far", differing from both other values by 2 or more. Note: Math.abs(num) computes the absolute value of a number. 

closeFar(1, 2, 10) → true
closeFar(1, 2, 3) → false
closeFar(4, 1, 3) → true
*/

public boolean closeFar(int a, int b, int c) {
	if (Math.abs(a - b) < 2 && Math.abs(b - c) >= 2 && Math.abs(a - c) >= 2)
			return true;
	if (Math.abs(a - c) < 2 && Math.abs(b - c) >= 2 && Math.abs(a - b) >= 2)
			return true;
	
	return false;
}

/*BLACKJACK
Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both go over. 

blackjack(19, 21) → 21
blackjack(21, 19) → 21
blackjack(19, 22) → 19
*/

public int blackjack(int a, int b) {
	if (a == 21 || b == 21)
		return 21;
	if (a > 21 && b <= 21)
		return b;
	if (a <= 21 && b > 21)
		return a;
	if (a + b >= 43)
		return 0;
	if (21 - a < 21 - b)
		return a;
	else
		return ;
}

/*EVENLYSPACED
Given three ints, a b c, one of them is small, one is medium and one is large. Return true if the three values are evenly spaced, so the difference between small and medium is the same as the difference between medium and large. 

evenlySpaced(2, 4, 6) → true
evenlySpaced(4, 6, 2) → tru
evenlySpaced(4, 6, 3) → false
*/
// BT - LOL @ this code. I found a stackoverflow recommendation for how to calculate the middle via math.min.
// Once again, LOL.

public boolean evenlySpaced(int a, int b, int c) {
	int small = Math.min(Math.min(a, b), c);
	int max = Math.max(Math.max(a, b), c);
	int middle = Math.max(Math.max(Math.min(a,b),Math.min(b,c)),(Math.max(Math.min(b,c),Math.min(a,c))));
	if (middle - small == max - middle)
		return true;
	else
		return false;
}

/*MAKECHOCOLATE
We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each). Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done. 

makeChocolate(4, 1, 9) → 4
makeChocolate(4, 1, 10) → -1
makeChocolate(4, 1, 7) → 2
*/
// BT - Much easier once I did the original problem
public int makeChocolate(int small, int big, int goal) {
	// Check failure first
	// Not enough total bricks
	if (big * 5 + small < goal)
		return -1;
	// not enough small bricks
	if (small < goal % 5)
		return -1;
	if (big*5 < goal)
		return goal - (big*5);
	else
		return goal % 5;
}
