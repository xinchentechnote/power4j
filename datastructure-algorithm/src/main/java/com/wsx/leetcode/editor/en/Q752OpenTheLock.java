package com.wsx.leetcode.editor.en;

//
//You have a lock in front of you with 4 circular wheels. Each wheel has 10 slot
//s: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freel
//y and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each
// move consists of turning one wheel one slot.
// 
//The lock initially starts at '0000', a string representing the state of the 4 
//wheels.
// 
//You are given a list of deadends dead ends, meaning if the lock displays any o
//f these codes, the wheels of the lock will stop turning and you will be unable t
//o open it.
// 
//Given a target representing the value of the wheels that will unlock the lock,
// return the minimum total number of turns required to open the lock, or -1 if it
// is impossible.
// 
//
// Example 1: 
// 
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation:
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
//01" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would
// be invalid,
//because the wheels of the lock become stuck after the display becomes the dead
// end "0102".
// 
// 
//
// Example 2: 
// 
//Input: deadends = ["8888"], target = "0009"
//Output: 1
//Explanation:
//We can turn the last wheel in reverse to move from "0000" -> "0009".
// 
// 
//
// Example 3: 
// 
//Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], t
//arget = "8888"
//Output: -1
//Explanation:
//We can't reach the target without getting stuck.
// 
// 
//
// Example 4: 
// 
//Input: deadends = ["0000"], target = "8888"
//Output: -1
// 
// 
//
// Note: 
// 
// The length of deadends will be in the range [1, 500]. 
// target will not be in the list deadends. 
// Every string in deadends and the string target will be a string of 4 digits f
//rom the 10,000 possibilities '0000' to '9999'. 
// 
// Related Topics Breadth-first Search 
// 👍 998 👎 42


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Java：Open the Lock
public class Q752OpenTheLock {

  public static void main(String[] args) {
    String[] deads = {"0201", "0101", "0102", "1212", "2002"};
    Solution solution = new Solution();
    // TO TEST
    System.out.println(solution.openLock(deads, "0202"));
  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int openLock(String[] deadends, String target) {
      Set<String> deadSet = new HashSet<>();
      for (int i = 0; i < deadends.length; i++) {
        deadSet.add(deadends[i]);
      }
      if (deadSet.contains(target)) {
        return -1;
      }
      if (deadSet.contains("0000")) {
        return -1;
      }
      if ("0000".equals(target)) {
        return 0;
      }
      //BFS
      Queue<String> queue = new LinkedList<>();
      Map<String, Integer> visited = new HashMap();
      queue.add("0000");
      visited.put("0000", 0);
      while (!queue.isEmpty()) {
        String cur = queue.remove();
        List<String> nextStr = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < 4; i++) {
          char old = chars[i];
          chars[i] = Character.forDigit((chars[i] - '0' + 1) % 10, 10);
          nextStr.add(new String(chars));
          chars[i] = old;
          chars[i] = Character.forDigit((chars[i] - '0' + 9) % 10, 10);
          nextStr.add(new String(chars));
          chars[i] = old;
        }
        for (String next : nextStr) {
          if (!deadSet.contains(next) && !visited.containsKey(next)) {
            queue.add(next);
            visited.put(next, visited.get(cur) + 1);
            if (next.equals(target)) {
              return visited.get(next);
            }
          }
        }

      }
      return -1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}