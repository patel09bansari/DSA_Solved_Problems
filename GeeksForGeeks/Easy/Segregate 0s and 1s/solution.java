class Solution {
	void segregate0and1(int[] arr) {
		// Arrays.sort(arr)
		
		// two pointer approach
		int s = 0;
		int e = arr.length - 1;
		
		while (s<e) {
			if (arr[s] == 0) {
				s++;
			}
			else if (arr[e] == 1) {
				e--;
			}
			else {
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
				s++;
				e--;
			}
		}
	}
}



// void segregate0and1(int[] arr) {
// 	int zeros = 0;
	
// 	// 1. Count the zeros using a simple for loop
// 	for (int i = 0; i < arr.length; i++) {
// 		if (arr[i] == 0) {
// 			zeros++;
// 		}
// 	}
// 	// 2. Fill the first 'zeros' positions with 0
// 	for (int i = 0; i < zeros; i++) {
// 		arr[i] = 0;
// 	}
	
// 	// 3. Fill the remaining positions with 1
// 	for (int i = zeros; i < arr.length; i++) {
// 		arr[i] = 1;
// 	}
// }
