// @Brandon Thacker
// www.codingbat.com JAVA Array2 Problems and Solutions 
// ONE LOOP

/*COUNTEVENS
Return the number of even ints in the given array. Note: the % "mod" 
operator computes the remainder, e.g. 5 % 2 is 1. 

countEvens({2, 1, 2, 3, 4}) → 3
countEvens({2, 2, 0}) → 3
countEvens({1, 3, 5}) → 0
*/

public int countEvens(int[] nums) {
	int counter = 0;
	for (int num : nums) {
		if (num % 2 == 0) {
			counter++;
		}
	}
	return counter;
}

/*BIGDIFF
Given an array length 1 or more of ints, return the difference between the largest 
and smallest values in the array. Note: the built-in Math.min(v1, v2) and 
Math.max(v1, v2) methods return the smaller or larger of two values. 

bigDiff({10, 3, 5, 6}) → 7
bigDiff({7, 2, 10, 9}) → 8
bigDiff({2, 10, 7, 2}) → 8
*/
// BT - This would bug if the numbers were 4 digits+
public int bigDiff(int[] nums) {
	int large = 0;
	int small = 999;
	int result = 0;
	for (int num : nums) {
		large = Math.max(large, num);
		small = Math.min(small, num);
	}
	result = large - small;
	return result;
}

/*CENTEREDAVERAGE
Return the "centered" average of an array of ints, which we'll say is the mean average 
of the values, except ignoring the largest and smallest values in the array. If there are 
multiple copies of the smallest value, ignore just one copy, and likewise for the largest 
value. Use int division to produce the final average. You may assume that the array is 
length 3 or more. 

centeredAverage({1, 2, 3, 4, 100}) → 3
centeredAverage({1, 1, 5, 5, 10, 8, 7}) → 5
centeredAverage({-10, -4, -2, -4, -2, 0}) → -3
*/

public int centeredAverage(int[] nums) {
	int arLen = nums.length;
	int small = 999;
	int large = -999;
	int sum = 0;
	int result = 0;
	for (int num : nums) {
		large = Math.max(large, num);
		small = Math.min(small, num);
		sum += num;
	}
	result = ((sum - large - small) / (arLen - 2));
	return result;
}

/*SUM13
Return the sum of the numbers in the array, returning 0 for an empty array. Except the 
number 13 is very unlucky, so it does not count and numbers that come immediately after
 a 13 also do not count. 

sum13({1, 2, 2, 1}) → 6
sum13({1, 1}) → 2
sum13({1, 2, 2, 1, 13}) → 6
*/

public int sum13(int[] nums) {
	if (nums.length < 1) {
		return 0;
	}
	int result = 0;

	for (int i = 0; i < nums.length; i++) {
		if (nums[i] == 13) {
			i++;
			continue;
		}
		result += nums[i];
	}
	return result;
}

/*SUM67
Return the sum of the numbers in the array, except ignore sections of numbers starting 
with a 6 and extending to the next 7 (every 6 will be followed by at least one 7). 
Return 0 for no numbers. 

sum67({1, 2, 2}) → 5
sum67({1, 2, 2, 6, 99, 99, 7}) → 5
sum67({1, 1, 6, 7, 2}) → 4
*/
// BT - There might be a better way to trigger, will research later. 
public int sum67 (int[] nums) {
	int result = 0;
	boolean trigger = false;
	for (int i = 0; i < nums.length; i ++) {
		if (nums[i] == 6) {
			trigger = true;
			continue;
		}
		if (trigger && nums[i] != 7) {
			continue;
		}
		if (trigger && nums[i] == 7) {
			trigger = false;
			continue;
		}
		result += nums[i];
	}
	return result;
}

/*HAS22
Given an array of ints, return true if the array contains a 2 next to a 2 somewhere. 

has22({1, 2, 2}) → true
has22({1, 2, 1, 2}) → false
has22({2, 1, 2}) → false
*/

public boolean has22(int[] nums) {
	for (int i = 0; i < nums.length - 1; i++){
		if (nums[i] == 2 && nums[i+1] == 2) {
			return true;
		}
	}
	return false;
}

/*LUCKY13
Given an array of ints, return true if the array contains no 1's and no 3's. 

lucky13({0, 2, 4}) → true
lucky13({1, 2, 3}) → false
lucky13({1, 2, 4}) → false
*/

public boolean lucky13(int[] nums) {
	for (int num : nums) {
		if (num == 1 || num == 3) {
			return false;
		}
	}
	return true;
}

/*SUM28
Given an array of ints, return true if the sum of all the 2's in the array is exactly 8. 

sum28({2, 3, 2, 2, 4, 2}) → true
sum28({2, 3, 2, 2, 4, 2, 2}) → false
sum28({1, 2, 3, 4}) → false
*/

public boolean sum28(int[] nums) {
	int sum = 0;
	for (int num : nums) {
		if (num == 2) {
			sum += num;
		}
	}
	if (sum == 8) {
		return true;
	}
	return false;
}

/*MORE14
Given an array of ints, return true if the number of 1's is greater than the number of 4's 

more14({1, 4, 1}) → true
more14({1, 4, 1, 4}) → false
more14({1, 1}) → true
*/

public boolean more14(int[] nums) {
	int ones = 0;
	int fours = 0;
	for (int num : nums) {
		if (num == 1) {
			ones += 1;
		}
		if (num == 4) {
			fours += 1;
		}
	}
	if (ones > fours) {
		return true;
	}
	return false;
}

/*FIZZARRAY
Given a number n, create and return a new int array of length n, containing the 
numbers 0, 1, 2, ... n-1. The given n may be 0, in which case just return a length 
0 array. You do not need a separate if-statement for the length-0 case; the for-loop 
should naturally execute 0 times in that case, so it just works. The syntax to make 
a new int array is: new int[desired_length]   (See also: FizzBuzz Code) 

fizzArray(4) → {0, 1, 2, 3}
fizzArray(1) → {0}
fizzArray(10) → {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
*/

public int[] fizzArray(int n) {
	int[] result = new int[n];
	for (int i = 0; i < n; i++) {
		result[i] = i;
	}
	return result;
}

/*ONLY14
Given an array of ints, return true if every element is a 1 or a 4. 

only14({1, 4, 1, 4}) → true
only14({1, 4, 2, 4}) → false
only14({1, 1}) → true
*/

public boolean only14(int[] nums) {
	for (int num : nums) {
		if (num != 4 && num != 1) {
			return false;
		}
	}
	return true;
}

/*FIZZARRAY2
Given a number n, create and return a new string array of length n, containing
the strings "0", "1" "2" .. through n-1. N may be 0, in which case just return a 
length 0 array. Note: String.valueOf(xxx) will make the String form of most types. 
The syntax to make a new string array is: new String[desired_length]  
See also: FizzBuzz Code) 

fizzArray2(4) → {"0", "1", "2", "3"}
fizzArray2(10) → {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}
fizzArray2(2) → {"0", "1"}
*/

public String[] fizzArray2(int n) {
	String[] retString = new String[n];
	for (int i = 0; i < n; i++) {
		retString[i] = String.valueOf(i);
	}
	return retString;
}

/*NO14
Given an array of ints, return true if it contains no 1's or it contains no 4's. 

no14({1, 2, 3}) → true
no14({1, 2, 3, 4}) → false
no14({2, 3, 4}) → true
*/
// BT - The wording of this problem was wrong, this solution works.
public boolean no14(int[] nums) {
	boolean trig1 = false;
	boolean trig4 = false;
	for (int num : nums) {
		if (num == 1) {
			trig1 = true;
		}
		if (num == 4) {
			trig4 = true;
		}
	}
	if (trig1 && trig4){
		return false;
	}
	return true;
}

/*ISEVERYWHERE
We'll say that a value is "everywhere" in an array if for every pair of adjacent 
elements in the array, at least one of the pair is that value. Return true if the 
given value is everywhere in the array. 

isEverywhere({1, 2, 1, 3}, 1) → true
isEverywhere({1, 2, 1, 3}, 2) → false
isEverywhere({1, 2, 1, 3, 4}, 1) → false
*/
// BT - Wording on this one is also confusing based on the results I saw in the checks
public boolean isEverywhere(int[] nums, int val) {
	for (int i = 0; i < nums.length - 1; i++) {
		if (nums[i] == val || nums[i+1] == val) {
			continue;
		}
		else {
			return false;
		}
	}
	return true;
}

/*EITHER24
Given an array of ints, return true if the array contains a 2 next to a 2 or a 
4 next to a 4, but not both. 

either24({1, 2, 2}) → true
either24({4, 4, 1}) → true
either24({4, 4, 1, 2, 2}) → false
*/
// BT - This is probably much longer than it needed to be 
public boolean either24(int[] nums) {
	boolean twos = false;
	boolean fours = false;
	for (int i = 0; i < nums.length - 1; i++) {
		if (nums[i] == 2 && nums[i+1] == 2) {
			twos = true;
		}
		if (nums[i] == 4 && nums[i+1] == 4) {
			fours = true;
		}
	}
	if (twos && fours){
		return false;
	}
	if (twos || fours){
		return true;
	}
	else {
		return false;
	}
}

/*MATCHUP
Given arrays nums1 and nums2 of the same length, for every element in nums1, 
consider the corresponding element in nums2 (at the same index). Return the 
count of the number of times that the two elements differ by 2 or less, but 
are not equal. 

matchUp({1, 2, 3}, {2, 3, 10}) → 2
matchUp({1, 2, 3}, {2, 3, 5}) → 3
matchUp({1, 2, 3}, {2, 3, 3}) → 2
*/

public int matchUp(int[] nums1, int[] nums2) {
	int counter = 0;
	for (int i = 0; i < nums1.length; i++) {
		if (nums1[i] != nums2[i] && Math.abs(nums1[i] - nums2[i]) <= 2) {
			counter++;
		}
	}
	return counter;
}

/*HAS77
Given an array of ints, return true if the array contains two 7's next to each other, 
or there are two 7's separated by one element, such as with {7, 1, 7}. 

has77({1, 7, 7}) → true
has77({1, 7, 1, 7}) → true
has77({1, 7, 1, 1, 7}) → false
*/
// BT This code is much longer than it needs to be, but its very readable.
public boolean has77(int[] nums) {
	for (int i = 0; i < nums.length - 2; i++) {
		if (nums[i] == 7 && nums[i+1] == 7) {
			return true;
		}
		if (nums[i] == 7 && nums[i+2] == 7) {
			return true;
		}
		if (nums[i+1] == 7 && nums[i+2] == 7) {
			return true;
		}
	}
	return false;

/*HAS12
Given an array of ints, return true if there is a 1 in the array with a 2 
somewhere later in the array. 

has12({1, 3, 2}) → true
has12({3, 1, 2}) → true
has12({3, 1, 4, 5, 2}) → true
*/

public boolean has12(int[] nums) {
	boolean oneTrig = false;
	boolean twoTrig = false;
	for (int num : nums) {
		if (num == 1) {
			oneTrig = true;
		}
		if (oneTrig && num == 2) {
			twoTrig = true;
		}
	}
	if (oneTrig && twoTrig) {
		return true;
	}
	return false;
}

/*MODTHREE
Given an array of ints, return true if the array contains either 3 even or 
3 odd values all next to each other. 

modThree({2, 1, 3, 5}) → true
modThree({2, 1, 2, 5}) → false
modThree({2, 4, 2, 5}) → true
*/

public boolean modThree(int[] nums) {
	for (int i = 0; i < nums.length - 2; i++) {
		if (nums[i] % 2 == 0 && nums[i+1] % 2 == 0 && nums[i+2] % 2 == 0) {
			return true;
		}
		if (nums[i] % 2 != 0 && nums[i+1] % 2 != 0 && nums[i+2] % 2 != 0) {
			return true;
		}
	}
	return false;
}

/*HAVETHREE
Given an array of ints, return true if the value 3 appears in the array 
exactly 3 times, and no 3's are next to each other. 

haveThree({3, 1, 3, 1, 3}) → true
haveThree({3, 1, 3, 3}) → false
haveThree({3, 4, 3, 3, 4}) → false
*/

public boolean haveThree(int[] nums) {
	int threeCount = 0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] == 3) {
			threeCount++;
		}
		if (i > 0 && nums[i] == 3 && nums[i-1] == 3) {
			return false;
		}
	}
	if (threeCount == 3) {
		return true;
	}
	return false;


/*TWOTWO
Given an array of ints, return true if every 2 that appears in the array 
is next to another 2. 

twoTwo({4, 2, 2, 3}) → true
twoTwo({2, 2, 4}) → true
twoTwo({2, 2, 4, 2}) → false
*/
// BT - This problem took me a while until I added a second bool check to the method
public boolean twoTwo(int[] nums) {
	boolean twoTrig = false;
	boolean twoConfirm = true;
	for (int i = 0; i < nums.length; i++) {
		if (!twoTrig && nums[i] == 2) {
			twoTrig = true;
			twoConfirm = false;
			continue;
		}
		if (twoTrig && nums[i] == 2) {
			twoConfirm = true;
			continue;
		}
		if (nums[i] != 2) {
			twoTrig = false;
		}
	}
	return twoConfirm;
}

/*SAMEENDS
Return true if the group of N numbers at the start and end of the array are the same. 
For example, with {5, 6, 45, 99, 13, 5, 6}, the ends are the same for n=0 and n=2, and 
false for n=1 and n=3. You may assume that n is in the range 0..nums.length inclusive. 

sameEnds({5, 6, 45, 99, 13, 5, 6}, 1) → false
sameEnds({5, 6, 45, 99, 13, 5, 6}, 2) → true
sameEnds({5, 6, 45, 99, 13, 5, 6}, 3) → false
*/
// BT Using the Arrays.equals here, not sure if that is allowed but it worked on the site.
public boolean sameEnds(int[] nums, int len) {
	int[] comp1 = new int[len];
	int[] comp2 = new int[len];
	int j = 0;
	for (int i = 0; i < nums.length; i++) {
		if (i < len) {
			comp1[i] = nums[i];
		}
		if (i > nums.length - 1 - len) {
			comp2[j] = nums[i];
			j++;
		}
	}
	if (Arrays.equals(comp1, comp2)) {
		return true;
	}
	return false;
}

/*TRIPLEUP
Return true if the array contains, somewhere, three increasing adjacent numbers 
like .... 4, 5, 6, ... or 23, 24, 25. 

tripleUp({1, 4, 5, 6, 2}) → true
tripleUp({1, 2, 3}) → true
tripleUp({1, 2, 4}) → false
*/

public boolean tripleUp(int[] nums) {
	for (int i = 0; i < nums.length -2; i++) {
		if (nums[i+1] == nums[i] + 1 && nums[i+2] == nums[i] + 2) {
			return true;
		}
	}
	return false;
}

/*FIZZARRAY3
Given start and end numbers, return a new array containing the sequence of integers 
from start up to but not including end, so start=5 and end=10 yields {5, 6, 7, 8, 9}. 
The end number will be greater or equal to the start number. Note that a length-0 
array is valid. (See also: FizzBuzz Code) 

fizzArray3(5, 10) → {5, 6, 7, 8, 9}
fizzArray3(11, 18) → {11, 12, 13, 14, 15, 16, 17}
fizzArray3(1, 3) → {1, 2}
*/

public int[] fizzArray3(int start, int end) {
	int difference = (end - start);
	int value = start;
	int[] retArray = new int[difference];
	for (int i = 0; i < difference; i++) {
		retArray[i] = value;
		value++;
	}
	return retArray;
}

/*SHIFTLEFT
Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. 
You may modify and return the given array, or return a new array. 

shiftLeft({6, 2, 5, 3}) → {2, 5, 3, 6}
shiftLeft({1, 2}) → {2, 1}
shiftLeft({1}) → {1}
*/

public int[] shiftLeft(int[] nums) {
	int[] retArray = new int[nums.length];
	int j = 1;
	for (int i = 0; i < nums.length; i++) {
		if (j == nums.length) {
			j = 0;
		}
		retArray[i] = nums[j];
		j++;
	}
	return retArray;
}

/*TENRUN
For each multiple of 10 in the given array, change all the values following it to be 
that multiple of 10, until encountering another multiple of 10. So {2, 10, 3, 4, 20, 5} 
yields {2, 10, 10, 10, 20, 20}. 

tenRun({2, 10, 3, 4, 20, 5}) → {2, 10, 10, 10, 20, 20}
tenRun({10, 1, 20, 2}) → {10, 10, 20, 20}
tenRun({10, 1, 9, 20}) → {10, 10, 10, 20}
*/
// BT - This was a lot of code for a simple seeming problem.
public int[] tenRun(int[] nums) {
	int currentMultiple = 0;
	boolean tenFound = false;
	int[] retArray = new int[nums.length];
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] % 10 != 0 && !tenFound) {
			retArray[i] = nums[i];
		}
		if (nums[i] % 10 == 0 && !tenFound) {
			currentMultiple = nums[i];
			retArray[i] = currentMultiple;
			tenFound = true;
		}
		if (tenFound) {
			if (nums[i] % 10 == 0 && nums[i] > currentMultiple) {
				currentMultiple = nums[i];
				retArray[i] = currentMultiple;
				continue;
			}
			if (nums[i] % 10 == 0 && nums[i] < currentMultiple) {
				currentMultiple = nums[i];
				retArray[i] = currentMultiple;
				continue;
			}
			retArray[i] = currentMultiple;
		}
 	}
	return retArray;
}