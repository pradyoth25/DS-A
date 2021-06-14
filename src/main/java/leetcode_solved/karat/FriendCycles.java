package leetcode_solved.karat;

import java.util.*;

public class FriendCycles {

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        int n = isConnected.length;
        boolean[] seen = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                dfs(isConnected, seen, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] graph, boolean[] seen, int pos) {
        for (int i = 0; i < graph.length; i++) {
            if (!seen[i] && graph[pos][i] == 1) {
                seen[i] = true;
                dfs(graph, seen, i);
            }
        }
    }

    public List<String> friendCycle1(String[] employees, String[] friendships){
        // assume each pair in friendship only contains two elements
        List<String> ans = new ArrayList<>();
        Map<String,List<String>> friend_list = new HashMap<>();
        for(int i = 0; i < employees.length; i++){
            String[] split_res = employees[i].split(",");

            friend_list.put(split_res[0], new ArrayList<String>());
        }
        for(String pair : friendships){
            //chris is friend with martin, martin is friend with chris
            String[] sep = pair.split(",");
            String chris = sep[0];
            String[] meaningless_split = sep[1].split(" ");
            String martin = meaningless_split[1];
            friend_list.get(chris).add(martin);
            friend_list.get(martin).add(chris);
        }
        // iterate friend list, if list is empty, too bad you get no friends ;(
        for(String everyone : friend_list.keySet()){
            StringBuilder ones_friends = new StringBuilder();
            ones_friends.append(everyone);
            ones_friends.append(": ");
            if(friend_list.get(everyone).size() != 0)
                ones_friends.append(friend_list.get(everyone));
            else ones_friends.append("None");
            ans.add(ones_friends.toString());
        }
        return ans;
    }

    public List<List<String>> friendCyclesReal(String[] employees, String[] friendships) {
        Map<String, List<String>> map = new HashMap<>();
        for (String e : employees) {
            e = e.replaceAll(" ", "");
            String[] vals = e.split(",");
            map.put(vals[0], new ArrayList<>());
        }
        for (String f : friendships) {
            f = f.replaceAll(" ", "");
            String[] vals = f.split(",");
            map.get(vals[0]).add(vals[1]);
            map.get(vals[1]).add(vals[0]);
        }
        System.out.println(map);
        List<List<String>> res = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (String friend : map.keySet()) {
            Set<String> temp = new HashSet<>();
            String curr = friend + ": ";
//            seen.add(friend);
            helper(map, temp, friend, res, seen);
        }
        return res;
    }

    private void helper(Map<String, List<String>> map, Set<String> temp, String friend, List<List<String>> res, Set<String> seen) {
        if (!map.containsKey(friend) || map.get(friend).size() == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        System.out.println(temp);
        temp.add(friend);
        for (String next : map.get(friend)) {
            if (seen.contains(next)) continue;
            temp.add(next); seen.add(next);
            helper(map, temp, next, res, seen);
            seen.remove(next);
        }
    }

}
