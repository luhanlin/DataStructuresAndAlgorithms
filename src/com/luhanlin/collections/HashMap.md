# HashMap and ConcurrentHashMap

## HashMap
+ HashMap的底层为一个entity的数组，每个entity对象对应一个以其为head节点的链表，
并且发生hash冲突时，会将entity添加到**头结点**（1.7）。添加到头结点的原因是*HashMap的发
明者认为，后插入的Entry被查找的可能性更大*。（1.8 为尾部插入）

+ HashMap的初始容量为16，设计为2的幂主要是为了服务于key->index的计算服务，计算公司为
 _index = Hash(key) & (length -1)_。
    - string的hashCode值计算：
  ```$xslt
    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;
            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }
  ```   
    
+ HashMap reSize
    > HashMap在容量到达一定程度后（size >= loadFactor * capacity）,进行reSzie。第一步会
    将HashMap的capacity扩容为以前的2倍，第二部会进行reHash，重新遍历entity放入对应的槽，reHash
    代码如下：
  ```$xslt
    void transfer(Entry[] newTable, boolean rehash) {
        int newCapacity = newTable.length;
        for (Entry<K,V> e : table) {
            while(null != e) {
                Entry<K,V> next = e.next;
                if (rehash) {
                    e.hash = null == e.key ? 0 : hash(e.key);
                }
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }
  ```
  
  
## ConcurrentHashMap

+ ConcurrentHashMap中分为了各个槽segment（init=8），每个槽中又是一个高度自治的HashMap，互不影响。
同一个槽中，读写互不干扰，但是写写操作会进行阻塞。

+ ConcurrentHashMap的Size方法是一个嵌套循环，大体逻辑如下：
    1. 遍历所有的Segment。
    2. 把Segment的元素数量累加起来。
    3. 把Segment的修改次数累加起来。
    4. 判断所有Segment的总修改次数是否大于上一次的总修改次数。如果大于，说明统计过程中有修改，重新统计，尝试次数+1；如果不是。说明没有修改，统计结束。
    5. 如果尝试次数超过阈值，则对每一个Segment加锁，再重新统计。
    6. 再次判断所有Segment的总修改次数是否大于上一次的总修改次数。由于已经加锁，次数一定和上次相等。
    7. 释放锁，统计结束。
    
+ java8 的统计使用 _private transient volatile CounterCell[] counterCells;_ 进行统计。