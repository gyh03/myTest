package collection;

public class TwoArr {
    public static void main(String[] args) {
        //定义一个3行2列的二维数组 = 一个长度为3的数组，数组的每个元素都是长度为2的数组
        String arr[][] = new String[3][2];
        arr[0][0] = "a0";
        arr[0][1] = "a1";
        arr[1][0] = "b0";
        arr[1][1] = "b1";
        arr[2][0] = "c0";
        arr[2][1] = "c1";
        System.out.println("数组行数："+arr.length);
        System.out.println("数组列数："+arr[0].length);
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.printf(arr[i][j]+", ");
            }
            System.out.println();
        }
    }

}
