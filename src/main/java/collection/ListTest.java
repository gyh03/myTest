package collection;

import java.util.*;

/**
 * ArrayList 是随机存取的(随机存取，不是元素随机排列，元素还是有序的)，采用下标方式遍历列表速度回更快
 * LinkedList 是有序存取，它实现了双向链表，每个数据节点都有三个数据项：前节点的引用、本节点元素、后继结点的引用，使用foreach效率更高
 * 频繁插入和删除时使用LinkList，因为LinkList只需修改数据节点的前后引用，而ArrayList需要将插入或删除节点之后的所有节点全部移动
 * 修改元素时使用ArrayList，这是因为LinkedList是按顺序存储的，因此定位元素必然是一个遍历过程，而ArrayList的修改动作则是数组元素的直接替换，简单高效。
 *
 * 判断集合是否相等时只须关注元素是否相等即可，不用考虑集合类型
 */
public class ListTest {
    public static void main(String[] args) {
        // 学生数量 80万
        int stuNum = 80 * 10000;
        // LinkedList，记录所有学生的分数
        List<Integer> scores1 = new LinkedList<Integer>();
        // ArrayList，记录所有学生的分数
        List<Integer> scores2 = new ArrayList<Integer>(stuNum);
        // 写入分数
        for (int i = 0; i < stuNum; i++) {
            scores1.add(new Random().nextInt(150));
            scores2.add(new Random().nextInt(150));
        }
        // 遍历
        System.out.println("LinkedList平均分是：" + average(scores1));
        System.out.println("ArrayList平均分是：" + average(scores2));
    }

    public static int average(List<Integer> scores) {
        int sum = 0;

        if (scores instanceof RandomAccess) {
            // 可以随机存取，则使用下标遍历
            System.out.println("可以随机存取，则使用下标遍历;ArrayList");
            for (int i = 0; i < scores.size(); i++) {
                sum += scores.get(i);
            }
        } else {
            // 有序存取，使用foreach方式
            System.out.println("有序存取，使用foreach方式;LinkedList");
            for (int i : scores) {
                sum += i;
            }
        }
        return sum / scores.size();
    }
}
