# algorithm

## 简单的时间复杂度分析

- O(1)，O(n)，O(lgn)，O(nlogn)，O(n^2)

- 大O描述的是算法的运行时间和输入数据之间的关系

- eg: 时间复杂度是O(n)，n是nums中的元素个数，算法和n呈线性关系

  ```jade
  public static int sum(int[] nums){
  	int sum = 0;
  	for(int num : nums){
  		sum += num;
  	}
  	return sum;
  }
  ```

## 均摊复杂度



## 复杂度震荡

- 同时调用addLast和remove