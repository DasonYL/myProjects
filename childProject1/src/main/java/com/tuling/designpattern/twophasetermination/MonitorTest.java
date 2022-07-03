package com.tuling.designpattern.twophasetermination;





import java.lang.ref.WeakReference;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Fox
 */
public class MonitorTest {
    boolean started = false;
    //采集线程
    Thread rptThread;

    //启动采集功能
    synchronized void start() {
        //不允许同时启动多个采集线程
        if (started) {
            return;
        }
        started = true;
        rptThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                //省略采集、回传实现
                report();
                //每隔两秒钟采集、回传一次数据
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    //重新设置线程中断状态
                    Thread.currentThread().interrupt();
                }
            }
            //执行到此处说明线程马上终止
            started = false;
        });
        rptThread.start();
    }

    private void report() {
        System.out.println("采集数据");
    }

    //终止采集功能
    synchronized void stop() {
        rptThread.interrupt();
    }


    public static void main(String[] args) {
//        MonitorTest monitor = new MonitorTest();
//        monitor.start();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        monitor.stop();

//        int[] nums = new int[]{1,2,3,4,5};
//        System.out.println("是否包含重复元素："+contains(nums));
//        System.out.println(maxSubArray(nums));

//        int[] ints = twoSum(nums, 5);
//        System.out.println("第一个数下标是:" + ints[0]+"，第二个数下标是:"+ints[1]);
//        merge();
        /**
         * 二分查找
         */
//        System.out.println(""+ 3/2);
//        System.out.println("二分查找，目标值下标记：" + binarySearch(nums, 5));;
//        System.out.println("二分查找找字符：" + nextGreatestLetter(new char[]{'a','c','f','w'}, 'w'));
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//        System.out.println("二位数组的长度：" + matrix.length);
        System.out.println("二位数组是否包含目标值："+searchMatrix(matrix, 7));
    }

    static boolean contains(int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int maxSum = nums[0];
        for(int i : nums){
//            int m = Math.max(a+i, a);
            pre = pre + i;
            maxSum = Math.max(pre + i, maxSum);
        }
        return maxSum;
    }

    public static int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                    break;
//                }
//            }
//
//        }
//        return result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if(map.containsKey(target- nums[i])){
               return new int[]{map.get(target- nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void merge() {
        char[]a= {'a','b','c','d','e','f'}, b= {'1','2','3','4','5','6'};
        System.arraycopy(a, 0, b, 0, a.length);
        System.out.println("数组a的各个元素中的值："+Arrays.toString(a));
        System.out.println("数组b的各个元素中的值："+Arrays.toString(b));

        int []c= {1,2,3,4,5,6}, d= {10,20,30,40,50,60};
        System.arraycopy(c, 2, d, 2, c.length-3);
        System.out.println("数组c的各个元素中的值："+Arrays.toString(c));
        System.out.println("数组d的各个元素中的值："+Arrays.toString(d));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        //元素的个数
        for (int x : nums1) {
            //统计各元素的个数，构建一个map
            if(nums1Map.containsKey(x)){
                nums1Map.put(x, nums1Map.get(x) + 1);
            }else{
                nums1Map.put(x, 1);
            }
        }

        Map<Integer, Integer> nums2Map = new HashMap<>();
        for (int x : nums2) {
            //统计各元素的个数，构建一个map
            if(nums2Map.containsKey(x)){
                nums2Map.put(x, nums2Map.get(x) + 1);
            }else{
                nums2Map.put(x, 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        nums2Map.forEach((k,v) -> {
            if(nums1Map.get(k) != null){
                int n = Math.min(v, nums1Map.get(k));
                for (int i = 0; i < n; i++) {
                    result.add(k);
                }
            }
        } );
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int binarySearch(int array[], int target) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == array[mid]){
                return mid;
            }else if(target < array[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        //这个二分法是target已存在数组中的情况：
//        int left = 0, right = letters.length -1;
//        while (left <= right) {
//            int mi = left + (right - left) / 2;
//            if (letters[mi] == target){
//                return letters[mi];
//            }
//            else if(letters[mi] < target) {
//                left = mi + 1;
//            } else {
//                right = mi - 1;
//            }
//        }
//        return letters[left % letters.length];
        //这里的二分法，是target不在数组中的情况：
        int left = 0;
        int right = letters.length;

        while(left < right){
            int mid = left + (right -left)/2;
            if(letters[mid] <= target){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return letters[left%letters.length];
    }


//    public int maxProfit(int[] prices) {
//        int[] copy = Arrays.copyOf(prices, prices.length);
////        Map<Integer, Integer> map = new HashMap<>();
//        int index = 0, copyIndex=0;
//        Set<Integer> maxValue = new HashSet<>();
//        while (index < prices.length && copyIndex < prices.length) {
//            if(){
//
//            }
//
//        }
//
//    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length -1;
        while (left <= right){
            int mid = left + (right -left)/2;
            List<Integer> list = Arrays.stream(matrix[mid]).boxed().collect(Collectors.toList());
            if(list.contains(target)){
                return true;
            } else if(target < matrix[mid][0]){
                //如果target < matrix[mid]中的最小元素，向左二分
                right = mid - 1;
            } else if(target > matrix[mid][matrix[mid].length - 1] ){
                //如果target > matrix[mid]中的最大元素，向右二分
                left = mid + 1;
            }else {
                return false;
            }
        }
        return false;
    }

}
