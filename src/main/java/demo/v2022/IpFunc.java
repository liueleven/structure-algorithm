package demo.v2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: ip段重叠
 * @date: 2022-03-15 23:02
 * @author: liuziqing
 */
public class IpFunc {
    /**
     * ip段重叠
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<Long, Long> map2 = new HashMap<>();
        map.put("1.0.0.0", "2.0.0.0");
        map.put("127.0.0.1", "127.0.0.128");
        map.put("1.0.0.1", "127.0.0.128");
        // 1. ip转数字
        long[][] num = ip2Number(map);
        // 2. 排序
        Arrays.sort(num, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
//                return (int) o1[0] - (int) o2[0];
                if( o1[0] -  o2[0] > 0) {
                    return 1;
                }else if(o1[0] - o2[0] < 0) {
                    return -1;
                }
                return 0;
            }
        });

        // 3. 范围比较
        int j = 0, k = 0;
        for (int i = 0; i < num.length; i++) {
            long s1 = num[j][k];
            k++;
            long e1 = num[j][k];
            k = 0;

            j++;
            long s2 = num[j][k];
            k++;
            long e2 = num[j][k];

            if (e1 - s2 > 0) {
//                System.out.println("e1=" + e1 + "--" + longToIp(e1) + ",s2=" + s2 + "--" + longToIp(s2));
                map2.put(s1, e1);
                map2.put(s2, e2);
            }

            k = 0;
            if (j == 98) {
                break;
            }
        }
        // 4. 数字转ip
        Map<String, String> ipMap = num2Map(map2);
        System.out.println("---------重叠的ip段---------");
        for (Map.Entry<String, String> entry : ipMap.entrySet()) {
            System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");
        }
    }

    private static Map<String, String> num2Map(Map<Long, Long> num) {
        Map<String, String> map = new HashMap<>();
        int k = 0, j = 0;
        for (Map.Entry<Long, Long> longLongEntry : num.entrySet()) {
            long s1 = longLongEntry.getKey();
            k++;
            long e1 = longLongEntry.getValue();
            k = 0;
            j++;

            map.put(longToIp(s1), longToIp(e1));
        }

        return map;
    }

    private static long[][] ip2Number(Map<String, String> map) {
        long[][] num = new long[100][2];
        int i = 0, j = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            num[i][j] = ipToLong(entry.getKey());
//            System.out.println(num[i][j]);
            j++;
            num[i][j] = ipToLong(entry.getValue());
//            System.out.println(num[i][j]);
            i++;
            j = 0;

        }
        return num;
    }

    private static long ipToLong(String strIp) {
        String[] ip = strIp.split("\\.");
        return (Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8) + Long.parseLong(ip[3]);
    }

    private static String longToIp(long num) {
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.get();
        StringBuilder ip = new StringBuilder();
        ip.append(num >>> 24).append(".");
        ip.append((num & 0x00ffffff) >>> 16).append(".");
        ip.append((num & 0x0000ffff) >>> 8).append(".");
        ip.append(num & 0x000000FF);
        return ip.toString();

    }
}
