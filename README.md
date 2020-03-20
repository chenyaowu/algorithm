# algorithm

## 数组

- 把数据码成一排进行存放

  ![Arrary](E:\algorithm\img\Arrary1.png)

- 数组最大的有点：快速查询。
- 数组最好应用于“索引有语义”的情况，但并非所有有语意的索引都适用于数组。（例如，身份证号）

### 向数组末尾添加元素
![Arrary](E:\algorithm\img\Arrary2.png)

![Arrary](E:\algorithm\img\Arrary3.png)
```java
data[size] = e;
size++
```
### 向数组指定位置添加元素
![Arrary](E:\algorithm\img\Arrary4.png)

![Arrary](E:\algorithm\img\Arrary5.png)

![Arrary](E:\algorithm\img\Arrary6.png)

![Arrary](E:\algorithm\img\Arrary7.png)

![Arrary](E:\algorithm\img\Arrary8.png)

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
![Arrary](E:\algorithm\img\Arrary9.png)

![Arrary](E:\algorithm\img\Arrary10.png)

![Arrary](E:\algorithm\img\Arrary11.png)

![Arrary](E:\algorithm\img\Arrary12.png)

```java
data[index] = data[index +1 ];
data[index + 1] = data[index + 2];
...
data[size-2] = data[size-1];
size--;
```

### 动态数组

- 原来数组空间不够，增加数组容量
  ![Arrary](E:\algorithm\img\Arrary13.png)
  
  ![Arrary](E:\algorithm\img\Arrary14.png)
  
  ![Arrary](E:\algorithm\img\Arrary15.png)

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
![Arrary](E:\algorithm\img\Stack1.png)

- 栈是一种后进先出的数据结构（LIFO）

### 栈的应用

- Undo操作
- 程序调用系统栈

## 队列

- 队列是一种线性结构

- 相比数组，队列对应的操作是数组的子集

- 只能从一端（队尾）添加元素，只能从另一端（队首）取出元素
  ![Queue](E:\algorithm\img\Queue.png)

  ### 数组队列的复杂度分析
  
   入队		 			enqueue(E)			O(1) 
  
   出队 					dequeue()	  		O(n)
  
  查看队首元素		 front()					O(1)
  
  - 出队O(n)复杂度原因：移除队首元素，所有元素需要前移一位
  
  - 解决出队O(n)复杂度方法：循环队列
  
  ### 循环队列
  ![Queue](E:\algorithm\img\Queue2.png)
  
  ![Queue](E:\algorithm\img\Queue3.png)
  
  ![Queue](E:\algorithm\img\Queue4.png)
  
  ![Queue](E:\algorithm\img\Queue5.png)
  
  ![Queue](E:\algorithm\img\Queue6.png)
  
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
  ![LinkedList](E:\algorithm\img\LinkedList.png)

- 优点：真正的动态，不需要处理固定容量的问题

- 缺点：丧失了随机访问的能力

- 最大的优点：动态

  ### 在链表头添加元素

   ![LinkedList](E:\algorithm\img\LinkedList2.png)
  
   ![LinkedList](E:\algorithm\img\LinkedList3.png)
  
   ```java
  node.next = head;
  head = node;
   ```
  
  ### 在链表中间添加元素
  ![LinkedList](E:\algorithm\img\LinkedList4.png)
  
  ![LinkedList](E:\algorithm\img\LinkedList5.png)
  
  ![LinkedList](E:\algorithm\img\LinkedList6.png)
  
  ![LinkedList](E:\algorithm\img\LinkedList7.png)
  
  ```java
  node.next = prev.next;
  prev.next = node;
  ```
  
  ### 链表虚拟头节点
  
  ![LinkedList](E:\algorithm\img\LinkedList8.png)
  
  ```java
  Node dummyHead = new Node(null);
  ```
  
  ### 删除元素
  ![LinkedList](E:\algorithm\img\LinkedList9.png)
  
  ![LinkedList](E:\algorithm\img\LinkedList10.png)
  
  ![LinkedList](E:\algorithm\img\LinkedList11.png)
  
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

![Tree](E:\algorithm\img\Tree.png)



## 二分搜素树

- 二分搜素树是二叉树
- 二分搜素树的每个节点的值
  - 大于其左子树的所有节点的值
  - 小于其右子树的所有节点的值
- 存储的元素必须有可比较性
![Tree](E:\algorithm\img\Tree2.png)

### 添加元素

![Tree](E:\algorithm\img\Tree3.png)

![Tree](E:\algorithm\img\Tree4.png)

![Tree](E:\algorithm\img\Tree5.png)

![Tree](E:\algorithm\img\Tree6.png)

```java

```



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

