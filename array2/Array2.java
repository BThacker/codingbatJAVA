// @Brandon Thacker
// www.codingbat.com JAVA Array2 Problems and Solutions 
// ONE LOOP

/*COUNTEVENS
Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1. 

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
Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values. 

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
Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more. 

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
Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count. 

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
Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6 and extending to the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers. 

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

/*