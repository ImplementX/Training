package algorithm.sort;

public class QuickSort {
//	static void quick_sort(int s[], int l, int r)  
//	{  
//	    if (l < r)  
//	    {  
//	        //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1  
//	        int i = l, j = r, x = s[l];  
//	        while (i < j)  
//	        {  
//	            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数  
//	                j--;    
//	            if(i < j)   
//	                s[i++] = s[j];  
//	              
//	            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数  
//	                i++;    
//	            if(i < j)   
//	                s[j--] = s[i];  
//	        }  
//	        s[i] = x;  
//	        quick_sort(s, l, i - 1); //  递归调用   
//	        quick_sort(s, i + 1, r);  
//	    }  
//	}  
	public static void quickSort(int nums[]){
		quickSort(nums, 0, nums.length-1);
	}
	
	private static void quickSort(int nums[],int l,int r) {

		if(l < r){
			int i = l,j = r,x = nums[l];
			
			
			while(i < j){

				while(i < j && x <= nums[j]){
					j--;
				}
				if(i < j){
					nums[i++]=nums[j];
				}
				
				while(i < j && x >= nums[i]){
					i++;
				}
				if(i < j){
					nums[j--]=nums[i];
				}
			}
			nums[i]=x;
			
			quickSort(nums, l, i-1);
			quickSort(nums, i+1, r);
		}
		
		
	}

	public static void main(String[] args) {
		int[] nums = {7 ,4, 8,7,5,11,33,6,78,9,2 };
		quickSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}


	}
}
 