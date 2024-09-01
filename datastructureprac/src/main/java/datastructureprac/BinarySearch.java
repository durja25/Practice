package datastructureprac;

public class BinarySearch {

	public static void main(String[] args) {
		
		// create sample array of integers		
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		
		int findValue = 8;
		
		int result = binarySearch(a, a.length,findValue);
		
		
		if (result == -1) {
			System.out.println("value not found");
		}else {
			
		System.out.println("index of found at :"+ result);
		
		System.out.println("index of found value :"+ a[result]);
		}
		
		
	}

	private static int binarySearch(int[] a, int length, int findValue) {

		int start = 0;
		int end = length - 1;
//		int mid = 0;
		while (start <= end) {
			int mid = (start + end )/2;

			if (a[mid] == findValue) {
				return mid;
			} else if (a[mid] < findValue) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return -1;
	}
	
	

}
