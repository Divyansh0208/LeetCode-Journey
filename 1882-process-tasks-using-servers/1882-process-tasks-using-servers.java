class Solution {
  public int[] assignTasks(int[] servers, int[] tasks) {
    int[] result = new int[tasks.length];
    PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> compare(a, b));
    PriorityQueue<int[]> unavailable = new PriorityQueue<>((a, b) -> compare(a, b));
    for (int i = 0; i < servers.length; i++) available.offer(new int[] { servers[i], i, 0 });
    for (int i = 0; i < tasks.length; i++) {
      while ((!unavailable.isEmpty() && unavailable.peek()[0] <= i) || available.isEmpty()) {
        int[] server = unavailable.poll();
        available.offer(new int[] { server[1], server[2], server[0] });
      }
      int[] server = available.poll();
      result[i] = server[1];
      unavailable.offer(new int[] { Math.max(server[2], i) + tasks[i], server[0], server[1] });
    }
    return result;
  }
  private int compare(int[] a, int[] b) {
    if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
    if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
    return Integer.compare(a[2], b[2]);
  }
}
public class _1882_Process_Tasks_Using_Servers {
  public static void main(String[] args) {
    int[] servers = new int[] { 5, 1, 4, 3, 2 };
    int[] tasks = new int[] { 2, 1, 2, 4, 5, 2, 1 };
    int[] result = new Solution().assignTasks(servers, tasks);
    System.out.println("The array ans is : " + Arrays.toString(result));
  }
}