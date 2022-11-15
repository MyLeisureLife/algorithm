//package org.leisure.tools;
//
//import java.util.HashMap;
//
//public class MyHashMap<K,V> {
//
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//    /**
//     *
//     * @param key 键
//     * @param value 值
//     * @return 与键关联的前一个值
//     */
//    public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//    }
//
//
//
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        if ((p = tab[i = (n - 1) & hash]) == null)
//            tab[i] = newNode(hash, key, value, null);
//        else {
//            HashMap.Node<K,V> e; K k;
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;
//            else if (p instanceof HashMap.TreeNode)
//                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//            else {
//                for (int binCount = 0; ; ++binCount) {
//                    if ((e = p.next) == null) {
//                        p.next = newNode(hash, key, value, null);
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//}
