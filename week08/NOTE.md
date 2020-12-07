学习笔记
#十大经典排序算法
##算法概述
### 算法分类
十种常见排序算法可以分为两大类：
* 比较类排序： 通过比较来决定元素的相对次序，由于其时间复杂度不能突破O(nlogn),因此也成为了非线性时间比较累排序。
* 非比较类排序： 不通过比较来决定元素的相对次序，它可以突破基于比较的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。

![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sort_2020001.png)

### 时间复杂度
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sort_time_complexity_2020002.png)

### 相关概念
* 稳定： 如果a原本在b的前面，而a=b,排序之后a仍在b的前面。
* 不稳定：如果a原本在b的前面，而a=b,排序之后a可能会出现在b的后面
* 时间复杂度：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律
* 空间复杂度：是指算法在计算机内执行时所需存储的度量，它也是数据规模n的函数

## 冒泡排序 bubble sort
冒泡排序是一种简单的排序算法。它重复地走访所要排序的数列，依次比较两个元素，如果它们的顺序错误就把他们交换过来。走访数列的工作是重复的进行
直到没有在需要交换，也就是说数列已经排序完成。这个算法的名字由来是因为越小的元素会经过交换慢慢浮动到数列的顶端。
### 算法藐视
* 比较相邻的元素。如果第一个比第二个大，就交换它们两个
* 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数
* 针对所有的元素重复以上的步骤，除了最后一个
* 重复步骤1-3，直到排序完成
## 动图演示
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sort_bubble_sort_2020003.gif)
### 代码实现
```javascript
function bubbleSort(arr) {
    var len = arr.length;
    for(var i = 0; i < len - 1; i++) {
        for(var j = 0; j < len - 1 - i; j++) {
            if(arr[j] > arr[j+1]) {        // 相邻元素两两对比
                var temp = arr[j+1];        // 元素交换
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}
```
