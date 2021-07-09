package v4.bsf;

import java.util.*;

/**
 * @description:
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
 * 对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 *  
 *
 * 提示：
 *
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 *  
 *
 * 示例 1：
 *
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2：
 *
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date: 2021-06-25 00:16
 * @author: liuziqing
 */
public class Solution {

    public static void main(String[] args) {
        List<List<String>> target = new ArrayList<>();
//        // [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//        target.add(Arrays.asList("MUC", "LHR"));
//        target.add(Arrays.asList("JFK", "MUC"));
//        target.add(Arrays.asList("SFO", "SJC"));
//        target.add(Arrays.asList("LHR", "SFO"));

//        [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        target.add(Arrays.asList("JFK","KUL"));
        target.add(Arrays.asList("JFK","NRT"));
        target.add(Arrays.asList("NRT","JFK"));

        Solution solution2 = new Solution();
        List<String> itinerary = solution2.findItinerary(target);
        System.out.println(itinerary.toString());
    }

    LinkedList<String> results = new LinkedList();
    Map<String,PriorityQueue<String>> map = new HashMap();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket: tickets  ){
            String from = ticket.get(0);
            String to = ticket.get(1);

            PriorityQueue<String> destinnations = map.get(from);
            if(destinnations == null) {
                destinnations = new PriorityQueue();
            }
            destinnations.add(to);
            System.out.println("添加的国家：" + from + "可达到的有：" + destinnations.toString());
            map.put(from, destinnations);

        }
        dsf("JFK");
        return results;
    }

    void dsf(String from) {
        PriorityQueue<String> destinations = map.get(from);
        while(destinations != null && !destinations.isEmpty()) {
            String to = destinations.remove();
            results.add(to);
            System.out.println("下个国家：" + to);
            dsf(to);
        }
//        System.out.println(from);
//        results.addFirst(from);
    }
}
