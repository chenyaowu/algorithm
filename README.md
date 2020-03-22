# algorithm

## 数组

- 把数据码成一排进行存放

  ![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary1.png)

- 数组最大的有点：快速查询。
- 数组最好应用于“索引有语义”的情况，但并非所有有语意的索引都适用于数组。（例如，身份证号）

### 向数组末尾添加元素
![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary2.png)

![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary3.png)
```java
data[size] = e;
size++
```
### 向数组指定位置添加元素
![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary4.png)

![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary5.png)

![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary6.png)

![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary7.png)

![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary8.png)

```java
data[size] = data[size-1];
data[size-1] = data[size-2];
...
data[index] = e;
size++
```

### 获取指定索引元素

### 更新指定索引元素

### 查找数组中是否有某元素

### 查找数组中某元素索引

### 删除指定位置元素
![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary9.png)

![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary10.png)

![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary11.png)

![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary12.png)

```java
data[index] = data[index +1 ];
data[index + 1] = data[index + 2];
...
data[size-2] = data[size-1];
size--;
```

### 动态数组

- 原来数组空间不够，增加数组容量
  ![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary13.png)
  
  ![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary14.png)
  
  ![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Arrary15.png)

```java
resize(newCapacity);
E[] newData = (E[])new Object[newCapacity];
data = newData;
```

### 分析动态数组的时间复杂度

- 添加操作(O(n))

  addLast(e);	 O(1)

  addFirst(e);	 O(1)

  add(e);		    O(n)

  最坏情况需要rezise(). O(n)

- 删除操作(O(n))

  removeLast(e); 		O(1)
  
  removeFirst(e);		O(n)
  
  remove(e);				O(n)
  
  最坏情况需要rezise(). O(n)
  
- 修改操作(O(1))

  set(index, e);		O(1)

- 查找操作

  get(index) 			O(1)

  contains(e)			O(n)

  find(e)					O(n)

#### 均摊复杂度

- resize的复杂度分析

  假设capacity = n ，n+1次addLast，触发resize，总共进行2n+1次基本操作，平均，每次addLast操作，进行2次基本操作。这样均摊计算，时间复杂度是O(1)。

  addLast和removeLast，均摊复杂度为O(1)
#### 复杂度震荡

- addLast扩容后，调用remove，缩容，再addLast扩容，此时复杂度为O(n)；
- 解决方法：Lazy
- size == capacity/4时，才将capacity减半

​	

## 栈

- 栈是一种线性结构
- 相比数组，栈对应的操作是数组的子集
- 只能从一端添加元素，也只能从一端取出元素
- 这一端称为栈顶
![Arrary](https://github.com/chenyaowu/algorithm/blob/master/img/Stack1.png)

- 栈是一种后进先出的数据结构（LIFO）

### 栈的应用

- Undo操作
- 程序调用系统栈

## 队列

- 队列是一种线性结构

- 相比数组，队列对应的操作是数组的子集

- 只能从一端（队尾）添加元素，只能从另一端（队首）取出元素
  ![Queue](https://github.com/chenyaowu/algorithm/blob/master/img/Queue.png)

  ### 数组队列的复杂度分析
  
   入队		 			enqueue(E)			O(1) 
  
   出队 					dequeue()	  		O(n)
  
  查看队首元素		 front()					O(1)
  
  - 出队O(n)复杂度原因：移除队首元素，所有元素需要前移一位
  
  - 解决出队O(n)复杂度方法：循环队列
  
  ### 循环队列
  ![Queue](https://github.com/chenyaowu/algorithm/blob/master/img/Queue2.png)
  
  ![Queue](https://github.com/chenyaowu/algorithm/blob/master/img/Queue3.png)
  
  ![Queue](https://github.com/chenyaowu/algorithm/blob/master/img/Queue4.png)
  
  ![Queue](https://github.com/chenyaowu/algorithm/blob/master/img/Queue5.png)
  
  ![Queue](https://github.com/chenyaowu/algorithm/blob/master/img/Queue6.png)
  
  ### 循环队列的复杂度分析
  
  入队		 			enqueue(E)			O(1) 
  
   出队 					dequeue()	  		O(1)（均摊）
  
  查看队首元素		 front()					O(1)

## 链表

- 最简单的动态数据结构

- 数据存储在“节点”中

  ```java
  class Node{
      E e;
      Node next;
  }
  ```
  ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList.png)

- 优点：真正的动态，不需要处理固定容量的问题

- 缺点：丧失了随机访问的能力

- 最大的优点：动态

  ### 在链表头添加元素

   ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList2.png)
  
   ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList3.png)
  
   ```java
  node.next = head;
  head = node;
   ```
  
  ### 在链表中间添加元素
  ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList4.png)
  
  ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList5.png)
  
  ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList6.png)
  
  ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList7.png)
  
  ```java
  node.next = prev.next;
  prev.next = node;
  ```
  
  ### 链表虚拟头节点
  
  ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList8.png)
  
  ```java
  Node dummyHead = new Node(null);
  ```
  
  ### 删除元素
  ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList9.png)
  
  ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList10.png)
  
  ![LinkedList](https://github.com/chenyaowu/algorithm/blob/master/img/LinkedList11.png)
  
  ```java
  prev.next = delNode.next;
  delNode.next = null;
  ```
  
  ### 链表复杂度分析
  
  增加	O(n)
  
  删除	O(n)
  
  修改	O(n)
  
  查找    O(n)

## 二叉树

- 和链表一样，动态数据结构

![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree.png)



## 二分搜素树

- 二分搜素树是二叉树
- 二分搜素树的每个节点的值
  - 大于其左子树的所有节点的值
  - 小于其右子树的所有节点的值
- 存储的元素必须有可比较性
![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree2.png)

### 添加元素

![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree3.png)

![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree4.png)

![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree5.png)

![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree6.png)

### 遍历操作
- 对于遍历操作

  - 前序遍历（递归）

  ```java
  function traverse(node){
      if(node == null){
          return;
      }
      访问该节点
  	traverse(node.left);
  	traverse(node.right);
  }
  
  ```

  - 前序遍历（非递归）
  
	 ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree7.png)
	
	 ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree8.png)
	
	 ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree9.png)
	
	 ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree10.png)
  
  
  
  ```java
stack.push(root);
  while (!stack.isEmpty()) {
    Node cur = stack.pop();
      // 访问该节点
      if (cur.right != null) {
          stack.push(cur.right);
      }
      if (cur.left != null) {
          stack.push(cur.left);
      }
  }
  ```
  

  

  
  - 中序遍历
  
  ```java
  function traverse(node){
      if(node == null){
          return;
      }
  	traverse(node.left);
      访问该节点
	traverse(node.right);
  }
  ```
```
  
  - 后序遍历
  
  ```java
    function traverse(node){
        if(node == null){
            return;
        }
    	traverse(node.left);
    	traverse(node.right);
        访问该节点
    }
```

  - 层序遍历
  
    ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree11.png)
    
    ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree12.png)
    
    ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree13.png)
    
    
  
    ```java
    queue.add(root);
    while (!queue.isEmpty()) {
        Node cur = queue.remove();
        访问该节点
        if (cur.left != null) {
            queue.add(cur.left);
        }
        if (cur.right != null) {
            queue.add(cur.right);
        }
    }
    ```
    
    ### 删除节点
    
    - 删除最小值
    ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree14.png)
    
    ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree15.png)
    
    ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree16.png)
    
    ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree17.png)
    
    
    
    - 删除任意值
     ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree18.png)
    
     ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree19.png)
    
     ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree20.png)
    
     ![Tree](https://github.com/chenyaowu/algorithm/blob/master/img/Tree21.png)
    
     
    
    - 删除左右都有孩子的节点d
    - 找到s=min(d->right)
    - s是d的后继
    - s->right = delMin(d->right)
    - s-left = d->left
    - 删除d,s是新的子树的根
    
    
    
    ## 集合
    
    - Set
    - 不能添加重复元素
    
    ### 有序和无序集合
    
    - 有序集合基于搜索树实现
    - 无序集合基于哈希表实现
    
    ### 复杂度分析
    
    ​			LinkedListSet			BSTSet
    
    增			O(n)						O(h)	[ O(logn) ~ O(n) ]	
    
    删			O(n)						O(h)	[ O(logn) ~ O(n) ]	
    
    查			O(n)						O(h)	[ O(logn) ~ O(n) ]	
    
    最佳情况：h = log2(n+1)
    
    最差情况：n = h
    
    
    
    
    
    ## 映射
    
    - Map
    - 存储（键，值）数据对的数据结果（Key，Value）
    - 根据键（Key），寻找值（Value）
    
    
    
    ### 有序和无序映射
    
    - 有序映射基于搜索树实现
    - 无序映射基于哈希表实现
    
    
    
    ### 复杂度分析
    
    ​			LinkedListSet			BSTSet
    
    增			O(n)						O(h)	[ O(logn) ~ O(n) ]	
    
    删			O(n)						O(h)	[ O(logn) ~ O(n) ]	
    
    查			O(n)						O(h)	[ O(logn) ~ O(n) ]	
    
    最佳情况：h = log2(n+1)
    
    最差情况：n = h
    
    
    

## 优先队列

- 普通队列：先进先出；后进后出

- 优先队列：出队顺序和入队顺序无关；和优先级相关

- 动态选择优先级最高的任务执行

  ​        						入队			出队

​		普通线性结构        O(1)              O(n)

​		顺序线性结构        O(n)              O(1)

​		堆						O(logn)		   O(logn)

## 堆

![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap.png)

- 二叉堆是一棵完全二叉树

- 堆中某个节点的值总是不大于其父节点的值（最大堆）

  最大堆
  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap2.png)
  
  ```java
  parent(i) = i /2 
  left chid (i) = 2 * i;
  right child (2) = 2 * i + 1;
  ```
  
  ### 添加元素
  
   ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap3.png)
  
   ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap4.png)
  
   ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap5.png)
  
   
  
  ### 取出元素
  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap6.png)
  
  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap7.png)
  
  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap8.png)
  
  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap9.png)

### 将任意数组整理成堆

- heapify

- 从最后一个非叶子结点开始siftDown
  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap10.png)

  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap11.png)

  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap12.png)

  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap13.png)

  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap14.png)

  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap15.png)
  
  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap16.png)
  
  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap17.png)

  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap18.png)

  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap19.png)
  
  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap20.png)
  
  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap21.png)

  ![Heap](https://github.com/chenyaowu/algorithm/blob/master/img/Heap22.png)
  





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



## 优先队列

|              | 入队    | 出队（拿出最大元素） |
| ------------ | ------- | -------------------- |
| 普通线性结构 | O(1)    | O(n)                 |
| 顺序线性结构 | O(n)    | O(1)                 |
| 堆           | O(logn) | O(logn)              |



## 线段树

- 基于区间的统计查询

|      | 数组 | 线段树  |
| ---- | ---- | ------- |
| 更新 | O(n) | O(logn) |
| 查询 | O(n) | O(logn) |

