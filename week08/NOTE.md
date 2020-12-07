学习笔记
# 十大经典排序算法
## 算法概述
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

## 一 冒泡排序 bubble sort
冒泡排序是一种简单的排序算法。它重复地走访所要排序的数列，依次比较两个元素，如果它们的顺序错误就把他们交换过来。走访数列的工作是重复的进行
直到没有在需要交换，也就是说数列已经排序完成。这个算法的名字由来是因为越小的元素会经过交换慢慢浮动到数列的顶端。
### 算法描述
* 比较相邻的元素。如果第一个比第二个大，就交换它们两个
* 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数
* 针对所有的元素重复以上的步骤，除了最后一个
* 重复步骤1-3，直到排序完成
### 动图演示
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

## 二 选择排序 selection sort
选择排序是一种简单直观的排序算法。它的工作原理：首先在未排序的序列中找到最小(大)的元素，存放到排序序列的起始位置,然后,在从剩下的未排序元素
中继续寻找最小(大)元素，然后放到一排序序列的末尾。以此类推，直到所有元素均排序完毕。
### 算法描述
n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下
* 初始状态： 无序区间 R[1...N],有序区间为空
* 第I趟排序(i=1,2,3...n-1)开始时，当前有序区和无序区分别为R[1...i-1]和R[1...n]。该趟排序从当前无序区间中选出关键字最小的记录R[k],将
它与无序区间的第1个记录R交换，使得R[1...i]和R[i+1...n]分别变为记录增加1个的新的有序区间和记录个数减少1个的新的无序区间。
* n-1趟结束，数组有序化了
### 动态演示
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sort_selection_sort2020004.gif)

### 代码实现
```javascript
function selectionSort(arr) {
    var len = arr.length;
    var minIndex, temp;
    for(var i = 0; i < len - 1; i++) {
        minIndex = i;
        for(var j = i + 1; j < len; j++) {
            if(arr[j] < arr[minIndex]) {     // 寻找最小的数
                minIndex = j;                 // 将最小数的索引保存
            }
        }
        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
    return arr;
} 
```
### 算法分析
表现最稳定的排序算法之一，因为无论什么数据进去都是O(n^2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的
内存空间了吧。


## 三 插入排序 insertion sort
插入排序的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列对于为排序的数据，在已排序的列中从后向前扫描，找到相应位置并插入。
### 算法概述
一般来说，插入排序都采用 in-place 在数组上实现。具体的算法描述如下
* 从第一个元素开始，该元素可以认为已经被排序
* 取出下一个元素，在已经排序的元素中从后向前扫描
* 如果该元素(已排序)大于新元素，将该元素移动下一位置
* 重复步骤3找到找到已排序的元素小于或者等于新元素的位置
* 将新元素插入到该位置后
* 重复2-5
### 动图演示
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sor_insertion_sor_2020005.gif)

### 代码实现
```javascript
function insertionSort(arr) {
    var len = arr.length;
    var preIndex, current;
    for(var i = 1; i < len; i++) {
        preIndex = i - 1;
        current = arr[i];
        while(preIndex >= 0 && arr[preIndex] > current) {
            arr[preIndex + 1] = arr[preIndex];
            preIndex--;
        }
        arr[preIndex + 1] = current;
    }
    return arr;
}
```
### 算法分析
插入排序在实现上，通常采用in-place排序(即需要O(1)的额外空间的排序),因此在从后向前的扫描过程中，需要反复把已排序元素逐步向后移动，为新元素
提供插入空间。



## 四 希尔排序 shell sort
1959年Shell发明，第一个突破O(n^2)的排序算法，是简单插入排序的改进版，它与插入排序的不同之处在于，他会有限比较距离较远的元素，希尔排序
又叫缩小增量排序
### 算法描述
现将整个待排序的记录序列分隔成若干序列分别进行直接插入排序，具体算法描述
* 选择一个增量序列 t1, t2 ...tk,其中ti>tj，tk=1
* 按增量序列个数k,对序列进行k趟排序
* 每一趟排序，根据对应的增量ti，将待排序列分割为若干长度为m的子序列，分别对各个子序列进行直接插入排序。仅增量因子为1时整个序列作为一个表
处理，表长度即为整个序列的长度
### 动图演示
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sort_shell_sort_2020006.gif)

### 代码实现
```javascript
function shellSort(arr) {
    var len = arr.length;
    for(var gap = Math.floor(len / 2); gap > 0; gap = Math.floor(gap / 2)) {
        // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
        for(var i = gap; i < len; i++) {
            var j = i;
            var current = arr[i];
            while(j - gap >= 0 && current < arr[j - gap]) {
                 arr[j] = arr[j - gap];
                 j = j - gap;
            }
            arr[j] = current;
        }
    }
    return arr;
}

```

### 算法分析
希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态定义间隔序列。



## 五 归并排序 merge sort
归并排序是建立在归并操作上的一种有效的排序算法。改算法是采用分治法(divide and conquer)的一个非常典型的应用。将已有序列的子序列合并，得到
完全有序的序列，即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
### 算法描述
* 把长度为n的输入序列分为长度为n/2的子序列
* 对这两个子序列分别采用归并排序
* 将两个排序好的序列合并成一个最终的排序序列

### 动图演示
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sort_merge_sort_2020007.gif)

### 代码实现
```javascript

function mergeSort(arr) {
    var len = arr.length;
    if(len < 2) {
        return arr;
    }
    var middle = Math.floor(len / 2),
        left = arr.slice(0, middle),
        right = arr.slice(middle);
    return merge(mergeSort(left), mergeSort(right));
}
 
function merge(left, right) {
    var result = [];
 
    while(left.length>0 && right.length>0) {
        if(left[0] <= right[0]) {
            result.push(left.shift());
        } else{
            result.push(right.shift());
        }
    }
 
    while(left.length)
        result.push(left.shift());
 
    while(right.length)
        result.push(right.shift());
 
    return result;
}

```

### 算法分析
归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(nlogn)的时间复杂度。
代价是需要额外的内存空间。


## 六 快速排序 quick sort
快速排序的基本思想是：通过一趟排序将待排记录分隔成独立的两个部分，其中一部分记录的关键字均与另一部分的关键字小，则可分别对这两部分记录继续
进行排序，以达到整个序列有序

### 算法描述
快速排序使用分治法把一个串 list 分为两个子串。具体算法如下
* 从数列中挑出一个元素，称为基准
* 重新排序数列，所有元素比基准值小的摆放在基准的前面，所有元素比基准值大的摆在基准的后面(相同的数可以到任一边)。在这个分区退出之后，改基准
就处于数列的中间位置。这个称为分区partition操作
* 递归地recursive把小于基准值元素的子数列和大于基准值元素的子数列排序

### 动图演示
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sor_quick_sort_2020008.gif)

### 代码实现
```javascript
function quickSort(arr, left, right) {
    var len = arr.length,
        partitionIndex,
        left = typeof left != 'number'? 0 : left,
        right = typeof right != 'number'? len - 1 : right;
 
    if(left < right) {
        partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex-1);
        quickSort(arr, partitionIndex+1, right);
    }
    return arr;
}
 
function partition(arr, left ,right) {     // 分区操作
    var pivot = left,                      // 设定基准值（pivot）
        index = pivot + 1;
    for(vari = index; i <= right; i++) {
        if(arr[i] < arr[pivot]) {
            swap(arr, i, index);
            index++;
        }       
    }
    swap(arr, pivot, index - 1);
    return index-1;
}
 
function swap(arr, i, j) {
    var temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

```

## 七 堆排序 heap sort
堆排序是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质，即子节点的键值或索引总是小于(或者大于)
它的父节点。
### 算法描述
* 将初始待排序关键子序列(R1,R2...Rn)构建成大顶堆，此堆为初始的无序区
* 将堆顶元素(R[1])与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,...Rn-1)和新的有序区(Rn),且满足R[1,2,...n-1]<-R[n]
* 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,...Rn-1)调整为新堆，然后在次将R[1]与无序区最后一个元素互换，得到
新的无序区(R1,R2,...Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1,则整个排序过程完成。

### 动图演示
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sort_head_sort_2020009.gif)

### 代码实现
```javascript
var len;    // 因为声明的多个函数都需要数据长度，所以把len设置成为全局变量
 
function buildMaxHeap(arr) {   // 建立大顶堆
    len = arr.length;
    for(var i = Math.floor(len/2); i >= 0; i--) {
        heapify(arr, i);
    }
}
 
function heapify(arr, i) {     // 堆调整
    var left = 2 * i + 1,
        right = 2 * i + 2,
        largest = i;
 
    if(left < len && arr[left] > arr[largest]) {
        largest = left;
    }
 
    if(right < len && arr[right] > arr[largest]) {
        largest = right;
    }
 
    if(largest != i) {
        swap(arr, i, largest);
        heapify(arr, largest);
    }
}
 
function swap(arr, i, j) {
    var temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
 
function heapSort(arr) {
    buildMaxHeap(arr);
 
    for(vari = arr.length - 1; i > 0; i--) {
        swap(arr, 0, i);
        len--;
        heapify(arr, 0);
    }
    return arr;
}

```



## 八 计数排序 counting sort
计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键值存储在额外的数组空间中。作为一种线性时间复杂度的排序，计数排序要求输入的
数据必须是有确切范围的整数。
### 算法描述
* 找出待排序的数组中的最大和最小元素
* 统计数组中每个值为i的元素出现的次数，存入数组C的第i项
* 对所有的计数累加 (从C中的第一个元素开始，每一项和前一项相加)
* 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减1

### 动图演示
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sort_counting_sort_2020010.gif)

### 代码实现
```javascript
function countingSort(arr, maxValue) {
    var bucket = newArray(maxValue + 1),
        sortedIndex = 0;
        arrLen = arr.length,
        bucketLen = maxValue + 1;
 
    for(var i = 0; i < arrLen; i++) {
        if(!bucket[arr[i]]) {
            bucket[arr[i]] = 0;
        }
        bucket[arr[i]]++;
    }
 
    for(var j = 0; j < bucketLen; j++) {
        while(bucket[j] > 0) {
            arr[sortedIndex++] = j;
            bucket[j]--;
        }
    }
 
    return arr;
}
```

### 算法分析
计数排序是一个稳定的排序算法，当输入的元素个数是n个0到k之间的整数时，时间复杂度是O(n+k),空间复杂度也是O(n+k),其排序速度快于任何比较排序
算法。当k不是很大并且序列比较集中时，计数排序是很有效的排序算法。


## 九 桶排序 bucket sort
桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序的工作原理：假设输入数据服从均匀分布，
将数据分到有限数量的桶里，每个桶在分别排序(有可能在使用别的排序算法或者以递归方式继续使用桶排序进行排序)
### 算法描述
* 设置一个定量的数组作为空桶
* 遍历输入数据，并且把数据一个一个的放到对应桶里去
* 对每个不是空的桶进行排序
* 从不是空的桶里把排好序的数据拼接起来
### 图片演示
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sort_bucket_sort_2020011.png)
### 代码实现
```javascript
function bucketSort(arr, bucketSize) {
    if(arr.length === 0) {
      return arr;
    }
 
    var i;
    var minValue = arr[0];
    var maxValue = arr[0];
    for(i = 1; i < arr.length; i++) {
      if(arr[i] < minValue) {
          minValue = arr[i];                // 输入数据的最小值
      } else if(arr[i] > maxValue) {
          maxValue = arr[i];                // 输入数据的最大值
      }
    }
 
    // 桶的初始化
    var DEFAULT_BUCKET_SIZE = 5;            // 设置桶的默认数量为5
    bucketSize = bucketSize || DEFAULT_BUCKET_SIZE;
    var bucketCount = Math.floor((maxValue - minValue) / bucketSize) + 1;  
    var buckets = new Array(bucketCount);
    for(i = 0; i < buckets.length; i++) {
        buckets[i] = [];
    }
 
    // 利用映射函数将数据分配到各个桶中
    for(i = 0; i < arr.length; i++) {
        buckets[Math.floor((arr[i] - minValue) / bucketSize)].push(arr[i]);
    }
 
    arr.length = 0;
    for(i = 0; i < buckets.length; i++) {
        insertionSort(buckets[i]);                      // 对每个桶进行排序，这里使用了插入排序
        for(var j  = 0; j < buckets[i].length; j++) {
            arr.push(buckets[i][j]);                     
        }
    }
 
    return arr;
}


```
### 算法分析
桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度取决于各个桶之间的数据进行排序的时间复杂度，因为其他部分的时间复杂度都为O(n)。
很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。


## 十 基数排序  radix sort
基数排序是按照低位优先排序，然后收集，再按照高位排序，然后在收集，以此类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序
再按高优先级排序。最后的次序就是最高优先级的高的在前，高优先级相同的低优先级高的在前
### 算法描述
* 取得数组中的最大数，并取得位数
* arr为原始数组，从最低位开始取每个位组成radix数组
* 对radix进行计数排序(利用计数排序适用于小范围的特点)
### 动图演示
![](https://github.com/RowinaDu/algorithm018/blob/master/images/sort/sort_radix_sort_2020012.gif)

### 代码实现
```javascript
var counter = [];
function radixSort(arr, maxDigit) {
    var mod = 10;
    var dev = 1;
    for(var i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
        for(var j = 0; j < arr.length; j++) {
            var bucket = parseInt((arr[j] % mod) / dev);
            if(counter[bucket]==null) {
                counter[bucket] = [];
            }
            counter[bucket].push(arr[j]);
        }
        var pos = 0;
        for(var j = 0; j < counter.length; j++) {
            var value = null;
            if(counter[j]!=null) {
                while((value = counter[j].shift()) != null) {
                      arr[pos++] = value;
                }
          }
        }
    }
    return arr;
}

```
### 算法分析
基数排序基于分别排序，分别收集，所以是稳定的。但基数排序的性能比桶排序要略差，每一次关键字的桶分配都要O(n)的时间复杂度，而且分配之后得到
新的关键序列又需要O(n)的时间复杂度。假设待排序数据可以分为d个关键字，则基数排序的时间复杂度将是O(d*2n),当然d要远远小于n，因此基本上还是线性
级别的。
基数排序的空间复杂度为O(n+k)，其中k为桶的数量。一般来说n>>k 因此额外空间需要大概n个左右。









































