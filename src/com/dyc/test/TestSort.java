//package com.dyc.test;
///**
// *
// * Created by Administrator on 2015/7/8.
// *
// */
//public class TestSort {
//    static   int end;
//    static   int center;
//    public static int start=1;
//    public   static   int []a= null;
//    public static int cursorStart=0;
//    public static int cursorEnd;
//    public static void main(String[]args){
//        a=new int[]{10,8,4,5,6,7,3,1};
//        end = a.length-1;
//        cursorEnd = end;
//        while (start!=end&&start<end) {
//        sort(null, 0, 0);
//            start+=1;
//            end-=1;
//            cursorStart = start;
//            cursorEnd = end;
//            System.out.println(start+":"+end);
//            int test = 0;
//            while (test<a.length) {
//                System.out.println(a[test]);
//                test++;
//            }
//        }
//
//    }
//    public static void sort(int[]nums,int start1,int end1) {
//      if(getStartNum(a) > getEndNum(a)) {
//         a[start] = a[start]^a[end];
//         a[end] =a[start]^a[end];
//          a[start] = a[start]^a[end];
//      }
//        }
//    private static int getStartNum(int[]nums) {
//        if(start<nums.length) {
//            if (nums[start] > nums[0]) {
//                cursorStart = start;
//                return nums[start];
//            } else if (nums[start] < nums[0]) {
//                if(start+1<nums.length) {
//                    start+=1;
//                    return getStartNum(nums);
//                }
//            }
//        }
//        start = cursorStart;
//        return nums[0];
//    }
//    private static int getEndNum(int[]nums){
//        if(end>=0&&end<nums.length) {
//            if (nums[end]<nums[0]) {
//                cursorEnd = end;
//                return nums[end];
//            } else if (nums[end]> nums[0]) {
//                if(end-1>=0) {
//                    end -= 1;
//                    return getEndNum(nums);
//                }
//            }
//        }
//        end = cursorEnd;
//        return nums[0];
//    }
//
//
//}
