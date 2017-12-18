package collection;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class ArrTest {

    //对数组求和
    public static int sum(int datas[]) {
        int sum = 0;
        for (int i = 0; i < datas.length; i++) {
            sum += datas[i];
        }
        return sum;
    }
    // 对列表求和计算
    public static int sum(List<Integer> datas) {
        int sum = 0;
        for (int i = 0; i < datas.size(); i++) {
            //这里其实已经做了一个拆箱动作，Integer对象通过intValue方法自动转换成了一个int基本类型
            sum += datas.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        //1.性能要求较高的场景中使用数组代替集合
        System.out.println("1-------------");
//2.定义一个数组
        String[] aArray = new String[5];
        String[] bArray = {"a","b","c", "d", "e"};
        String[] cArray = new String[]{"a","b","c","d","e"};
        System.out.println("2-------------");
//3.打印Java数组中的元素
        int[] intArray = { 1, 2, 3, 4, 5 };
        String intArrayString = Arrays.toString(intArray);
        System.out.println(intArray);
        //[I@7150bd4d
        System.out.println(intArrayString);
        // [1, 2, 3, 4, 5]
        System.out.println("3-------------");
//4.Array to ArrayList
        String[] stringArray = { "a", "b", "c", "d", "e" };

        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
        //再次new一个ArrayList对象，否则Arrays.asList(stringArray)返回的list对象不可再次修改
        arrayList.add("f");
        List<String> arrayList_= Arrays.asList(stringArray);
        //直接返回的list，不可更改，所以此处会报错        arrayList_.add("_f");
        System.out.println(arrayList);
        //[a, b, c, d, e, f]
        System.out.println("4-------------");

//5.检查数组中是否包含某一个值
        boolean b = Arrays.asList(stringArray).contains("a");
        System.out.println(b);
        // true
        System.out.println("5-------------");
//6.接两个数组
        int[] intArray1 = { 1, 2, 3, 4, 5 };
        int[] intArray2 = { 6, 7, 8, 9, 10 };
        // Apache Commons Lang library
        int[] combinedIntArray = ArrayUtils.addAll(intArray1, intArray2);
        System.out.println(Arrays.toString(combinedIntArray));
        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println("6-------------");

//7.将数组中的元素以某种形式输出
        //import Apache common lang；此处以，隔开各元素
        String j = StringUtils.join(stringArray, "，");
        System.out.println(j);
        System.out.println("7-------------");

//8.将Array转化成Set集合
        Set<String> set = new HashSet<String>(Arrays.asList(stringArray));
        System.out.println(set);
        //[d, e, b, c, a]
        System.out.println("8-------------");

//9.数组翻转
        ArrayUtils.reverse(intArray);
        System.out.println(Arrays.toString(intArray));
        //[5, 4, 3, 2, 1]
        System.out.println("9-------------");

//10.从数组中移除一个元素,生成一个新数组，不影响原数组
        //create a new array
        int[] removed = ArrayUtils.removeElement(intArray, 3);
        System.out.println(Arrays.toString(intArray));//[5, 4, 3, 2, 1]
        System.out.println(Arrays.toString(removed));//[5, 4, 2, 1]
        System.out.println("10-------------");

//11.数组变长(扩容）,生成一个新数组，不影响原数组
        int[] intArray_ = Arrays.copyOf(intArray,intArray.length+1);
        intArray_[intArray_.length-1]=4;
        System.out.println(Arrays.toString(intArray));//[5, 4, 3, 2, 1]
        System.out.println(Arrays.toString(intArray_));//[5, 4, 3, 2, 1, 4]
        //[5, 4, 3, 2, 1, 4]
        System.out.println("11-------------");
    }
}
