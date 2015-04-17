// @Brandon Thacker
// www.codingbat.com JAVA Array-3 Problems and Solutions
// Harder array problems -- 2 loops, more complex logic. 

/* MAXSPAN
Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest span found in the given array. (Efficiency is not a priority.) 

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

/*