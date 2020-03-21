### 第5章 Collection框架

**13、List**

> 1、ArrayList使用数组实现的，数组本身是随机访问的结构。
>> ArrayList为什么读取快？ 因为get(int)方法直接从数组获取数据。为什么写入慢？
其实这个说法并不准确，在容量不发生变化的情况下，他一样很快，在容量被改变的时候
，grow(int)方法里对数组的扩容（扩容为原来的容量的1.5倍）会造成写的效率下降。

> 2、LinkedList是顺序访问结构，在双向队列的应用中得到了体现
> 3、LinkedList查询指定数据会消耗一些时间。在头尾增加删除数据的操作非常迅速，
但是如果要随机插入，那么还是需要遍历，当然这还是比ArrayList的System.arraycopy性能好一些。
> 4、Vector与ArrayList相比，Vector是线程安全的，而且容量增长策略不同，由于实现方法效率较低，
这两个类已经被看作是已经过时的容器。
> Stack是Vector的子类，提供了一些与栈特性相关方法

**14、Queue**

内部实现算法采用的堆结构，时间复杂度为O(log2 n)

**15、Map**

- HashMap

  默认容量为16
  
  > put(K,V)方法，用于向HashMap中添加元素<br>
  >> 1 indexFor(int,int)方法，作用是根据hashCode和table长度来计算下标
  
  >> 2 hash(Object k)方法，用于计算键值K的hashCode
 
  >> 3 新增Entry的情况有以下两种：<br>
      ①table[]里不存在指定下标，也就是没有发生哈希碰撞 <br>
      ② table[]里存在指定下标（发生哈希碰撞），但是键值不同，也会添加Entry结点
  
  >> 4 addEntry(int, K, V,int)和createEntry(int,K,V,int)，添加键值对
  
  >> 5 resize(int)，用于给HashMap扩充容量
  
  >> 6 transfer(Entry[], boolean),重新计算转移到新table数组后的Entry下标
  
  >> 7 put方法总结<br>
     ① 计算键值的hash值<br>
     ② 根据hash值和table长度确定下标<br>
     ③ 存入数组<br>
     ④ 根据key值和hash值来对比，确定是创建链表结点还是替代之前的链表值<br>
     ⑤ 根据增加后的size来扩容，确定下一个扩容阈值，确定是否需要使用替代哈希算法
     
    JDK7中hashMap采用 数组+链表 结构 并采用Entry结点<br> 
    JDK8中hashMap采用 数组+链表+红黑树 并采用Node结点 


- TreeMap（主要用于排序）
  
  与HashMap组合了数组+链表+红黑树 不同，TreeMap是完全由红黑树实现的。<br>
  TreeMap中默认的排序为升序，如果要改变其排序可以自己写一个Comparator
  
- LinkedHashMap

   ```
   LinkedHashMap是HashMap子类，保存了记录的插入顺序，
   在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的.
   也可以在构造时用带参数，按照应用次数排序。在遍历的时候会比HashMap慢，
   不过有种情况例外，当HashMap容量很大，实际数据较少时，
   遍历起来可能会比LinkedHashMap慢，因为LinkedHashMap的遍历速度只
   和实际数据有关，和容量无关，而HashMap的遍历速度和他的容量有关。
    ```

- HashTable与HashMap的区别
  ```
  1 HashTable是线程安全的synchronized修饰   HashMap线程不安全，这样或造成前者效率不如后者
  2 在高并发环境下，并不推荐HashTable，执行效率较低，Java引入了专门的高并发容器，这种
     容器由于在实现的时候采用了更加细粒度的锁，在大兵发亮的情况下有着更好的性能。

  ```

- WeekHashMap ： 是一种弱引用的HashMap，弱引用指的是WeekHashMap中的key值如果
  没有外部强引用，那么在垃圾回收的时候，WeakHashMap的对应内容也会被移除掉。
  

**16、Set**

- HashSet（内部是由HashMap实现的）
- LinkedHashSet（维护数据插入的顺序）
- TreeSet（可以排序，默认升序，可以通过Comparator自定义排序）


