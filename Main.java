import com.gfg.questions.Strings.AnagramChecker;


public class Main {
    public static void main(String[] args) {

        System.out.println(AnagramChecker.o1Check("rahul","hulra"));
    }














//    public int solve(int N, int start, int finish, int[] Ticket_cost) {
//        int path1 = 0;
//        int path2 = 0;
//        if (start < finish) {
//            for (int i = start - 1; i < finish - 1; i++) {
//                path1 = path1 + Ticket_cost[i];
//            }
//            for (int i = start - 1; i != finish - 1; i--) {
//                if (i == 0) {
//                    i = Ticket_cost.length;
//                    path2 = path2 + Ticket_cost[Ticket_cost.length - 1];
//                } else {
//                    path2 = path2 + Ticket_cost[i - 1];
//                }
//            }
//        } else {
//            for (int i = start - 2; i > finish - 2; i--) {
//                path1 = path1 + Ticket_cost[i];
//            }
//            for (int i = start - 1; i != finish - 1; i++) {
//                if (i == Ticket_cost.length - 1) {
//                    i = 0;
//                    path2 = path2 + Ticket_cost[0];
//                } else {
//                    path2 = path2 + Ticket_cost[i + 1];
//                }
//            }
//        }
//        return Math.min(path1, path2);
//    }
}