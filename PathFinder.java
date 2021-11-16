import java.util.*;

class PathFinder {

    public static void main(String[] args) {

        char[][] maze = { { '0', '0', '0', 's' }, { '0', '#', '#', '0' }, { '0', '#', '#', '0' },
                { '0', 'f', '0', '0' } };

        char[][] visited = { { '0', '0', '0', '0' }, { '0', '#', '#', '0' }, { '0', '#', '#', '0' },
                { '0', '0', '0', '0' } };

        int[] start = findStart(maze);

        // used two queues to store row and column numbers.
        ArrayDeque<Integer> qx = new ArrayDeque<>();
        ArrayDeque<Integer> qy = new ArrayDeque<>();

        System.out.println("THE MAZE:");
        printMaze(maze);
        search(maze, visited, qx, qy, start);
        System.out.println("THE PATH: ");
        printMaze(visited);

    }

    // method to print the maze.
    static void printMaze(char[][] maze) {
        System.out.println(Arrays.toString(maze[0]));
        System.out.println(Arrays.toString(maze[1]));
        System.out.println(Arrays.toString(maze[2]));
        System.out.println(Arrays.toString(maze[3]));
        System.out.println();

    }

    // method to find the starting point.
    static int[] findStart(char[][] maze) {

        int[] start = new int[2];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (maze[i][j] == 's') {
                    start[0] = i;
                    start[1] = j;

                }

            }

        }

        return start;

    }

    // method to find the shortest path. uses breadth first search.
    static void search(char[][] maze, char[][] visited, ArrayDeque<Integer> qx, ArrayDeque<Integer> qy, int[] start) {

        qx.offer(start[0]);
        qy.offer(start[1]);

        boolean run = true;

        while (run) {

            int i = qx.poll();
            int j = qy.poll();

            if (maze[i][j] == 'f') {
                run = false;
            }

            visited[i][j] = '+';

            if ((i - 1 > 0) && (maze[i - 1][j] == '0' || maze[i - 1][j] == 'f') && visited[i - 1][j] != '+') {
                qx.offer(i - 1);
                qy.offer(j);
            }
            if ((i + 1 < maze.length) && (maze[i + 1][j] == '0' || maze[i + 1][j] == 'f') && visited[i + 1][j] != '+') {
                qx.offer(i + 1);
                qy.offer(j);
            }
            if ((j - 1 >= 0) && (maze[i][j - 1] == '0' || maze[i][j - 1] == 'f') && visited[i][j - 1] != '+') {
                qx.offer(i);
                qy.offer(j - 1);
            }
            if ((j + 1 < maze[0].length) && (maze[i][j + 1] == '0' || maze[i][j + 1] == 'f')
                    && visited[i][j + 1] != '+') {
                qx.offer(i);
                qx.offer(j + 1);
            }

        }

    }

}