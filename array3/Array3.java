// @Brandon Thacker
// www.codingbat.com JAVA Array3 Problems and Solutions
// Harder array problems -- 2 loops, more complex logic. 

/* MAXSPAN
Consider the leftmost and righmost appearances of some value in 
an array. We'll say that the "span" is the number of elements 
between the two inclusive. A single value has a span of 1. 
Returns the largest span found in the given array. 
(Efficiency is not a priority.) 

maxSpan({1, 2, 1, 1, 3}) → 4
maxSpan({1, 4, 2, 1, 4, 1, 4}) → 6
maxSpan({1, 4, 2, 1, 4, 4, 4}) → 6
*/

public int maxSpan(int[] nums) {
	boolean spanFound = false;
	int span = 0;
	int index = 0;
	if (nums.length == 0) {
		return 0;
	}
	while(!spanFound) {
		for (int i = index; i < nums.length; i++) {
			if (nums[i] == nums[index] && i - index > span) {
				span = i - index;
			}
		}
		if (index == nums.length) {
			spanFound = true;
		}
		index++;
	}
	return span + 1;
}

/*FIX34
Return an array that contains exactly the same numbers as the 
given array, but rearranged so that every 3 is immediately 
followed by a 4. Do not move the 3's, but every other number 
may move. The array contains the same number of 3's and 4's, 
every 3 has a number after it that is not a 3 or 4, and a 3 
appears in the array before any 4. 

fix34({1, 3, 1, 4}) → {1, 3, 4, 1}
fix34({1, 3, 1, 4, 4, 3, 1}) → {1, 3, 4, 1, 1, 3, 4}
fix34({3, 2, 2, 4}) → {3, 4, 2, 2}
*/

public int[] fix34(int[] nums) {
	boolean fixed = true;
	int fixIndex = 0;
	int fourIndex = 0;
	int tempVal = 0;
	for (int j = 0; j < nums.length * 3; j++) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 3 && nums[i+1] != 4) {
				fixIndex = i+1;
				fixed = false;
			}
			if (!fixed && nums[fixIndex] != 4 && nums[i] == 4) {
				fourIndex = i;
				tempVal = nums[fixIndex];
				nums[fixIndex] = 4;
				nums[fourIndex] = tempVal;
			}
		}
	}
	return nums;
}

/*FIX45

(This is a slightly harder version of the fix34 problem.) Return 
an array that contains exactly the same numbers as the given 
array, but rearranged so that every 4 is immediately followed by 
a 5. Do not move the 4's, but every other number may move. The 
array contains the same number of 4's and 5's, and every 4 has a 
number after it that is not a 4. In this version, 5's may appear 
anywhere in the original array. 

fix45({5, 4, 9, 4, 9, 5}) → {9, 4, 5, 4, 5, 9}
fix45({1, 4, 1, 5}) → {1, 4, 5, 1}
fix45({1, 4, 1, 5, 5, 4, 1}) → {1, 4, 5, 1, 1, 4, 5}
*/
// BT - My code from the previous worked with almost 0 changes
public int[] fix45(int[] nums) {
	boolean fixed = true;
	int fixIndex = 0;
	int fiveIndex = 0;
	int tempVal = 0;
	for (int j = 0; j < nums.length * 3; j++) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 4 && nums[i+1] != 5) {
				fixIndex = i+1;
				fixed = false;
			}
			if (!fixed && nums[fixIndex] != 5 && nums[i] == 5) {
				fiveIndex = i;
				tempVal = nums[fixIndex];
				nums[fixIndex] = 5;
				nums[fiveIndex] = tempVal;
			}
		}
	}
	return nums;
}

/*CANBALANCE
Given a non-empty array, return true if there is a place to split 
the array so that the sum of the numbers on one side is equal to 
the sum of the numbers on the other side. 

canBalance({1, 1, 1, 2, 1}) → true
canBalance({2, 1, 1, 2, 1}) → false
canBalance({10, 10}) → true
*/

public boolean canBalance(int[] nums) {
	int splitMark = 1; 
	int firstHalf = 0;
	int secondHalf = 0;
	for (int j = 0; j < nums.length; j++){
		for (int i = 0; i < nums.length; i++) {
			if (i < splitMark) {
				firstHalf += nums[i];
			}
			else {
				secondHalf += nums[i];
			}
			if (i == nums.length - 1) {
				if (firstHalf == secondHalf) {
					return true;
				}
				else {
					firstHalf = 0;
					secondHalf = 0;
					splitMark++;
					continue;
				}
			}
		}
	}
	return false;
}

/*LINEARIN
Given two arrays of ints sorted in increasing order, outer and 
inner, return true if all of the numbers in inner appear in 
outer. The best solution makes only a single "linear" pass of 
both arrays, taking advantage of the fact that both arrays are 
already in sorted order. 

linearIn({1, 2, 4, 6}, {2, 4}) → true
linearIn({1, 2, 4, 6}, {2, 3, 4}) → false
linearIn({1, 2, 4, 4, 6}, {2, 4}) → true
*/

public boolean linearIn(int[] outer, int[] inner) {
	boolean found = false;
	for (int i = 0; i < inner.length; i++) {
		for (int j = 0; j < outer.length; j++){
			if (outer[j] == inner[i]) {
				found = true;
			}
			if (j == outer.length - 1 && !found) {
				return false;
			}
		}
		found = false;
	}
	return true;
}

/*SQUAREUP

Given n>=0, create an array length n*n with the following 
pattern, shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} 
(spaces added to show the 3 groups). 

squareUp(3) → {0, 0, 1, 0, 2, 1, 3, 2, 1}
squareUp(2) → {0, 1, 2, 1}
squareUp(4) → {0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1}
*/
// BT - This one took me forever, not sure this is the best solution 
public int[] squareUp(int n) {
	int[] retArray = new int[n*n];
	int start = n - 1;
	int counter = 1;
	for (int i = 0; i < n; i++) {
		int result = i+1;
		for (int j = start * counter; j < start * counter + counter; j++) {
			retArray[j] = result;
			result--;
		}	
		counter++;	
	}
	return retArray;
}

/*SERIESUP

Given n>=0, create an array with the pattern {1,    1, 2,    
1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to show the grouping). 
Note that the length of the array will be 1 + 2 + 3 ... + n, 
which is known to sum to exactly n*(n + 1)/2. 

seriesUp(3) → {1, 1, 2, 1, 2, 3}
seriesUp(4) → {1, 1, 2, 1, 2, 3, 1, 2, 3, 4}
seriesUp(2) → {1, 1, 2}
*/
// BT - Ugly but functional
public int[] seriesUp(int n) {
	int length = n*(n+1)/2;
	int[] retArray = new int[length];
	int counter = 0;
	int count = n;
	int start = 0;
	for (int i = 0; i < n; i++) {
		int result = 1;
		for (int j = start; j < start + counter + 1; j++) {
			retArray[j] = result;
			result++;
		}
		counter++;
		start += counter;
	}
	return retArray;
}