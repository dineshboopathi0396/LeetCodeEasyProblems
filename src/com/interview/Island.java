package com.interview;

public class Island {
    public static void main(String[] args) {
        int[][] input = {
                {0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0}
        };
        System.out.println(findTheIslands(input));
    }

    private static int findTheIslands(int[][] input) {
        int count = 0;
        boolean[][] visited = new boolean[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] != 0) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        //check row
                        int r1 = j - 1, r2 = j + 1;
                        boolean rl = false, rr = false;
                        while (!rl || !rr) {
                            if (r1 < 0 || input[i][r1] == 0) {
                                rl = true;
                            } else {
                                visited[i][r1] = true;
                                r1--;

                            }

                            if (r2 == input[0].length || input[i][r2] == 0) {
                                rr = true;
                            } else {
                                visited[i][r2] = true;
                                r2++;
                            }
                        }

                        //check column
                        int c1 = j, c2 = j;
                        boolean cl = false, cr = false;
                        while (!cl || !cr) {
                            if (c1 < 0 || input[c1][j] == 0) {
                                cl = true;
                            } else {
                                visited[c1][j] = true;
                                c1--;
                            }

                            if (c2 == input.length || input[c2][j] == 0) {
                                cr = true;
                            } else {
                                visited[c2][j] = true;
                                c2++;
                            }
                        }

                        //check d1
                        int dr1 = j - 1, dr2 = j + 1;
                        int dc1 = i - 1, dc2 = i + 1;
                        boolean d1u = false, d1b = false;
                        while (!d1u || !d1b) {
                            if (dr1 < 0 || dc1 < 0 || input[dc1][dr1] == 0) {
                                d1u = true;
                            } else {
                                visited[dc1][dr1] = true;
                                dr1--;
                                dc1--;
                            }

                            if (dr2 == input[0].length || dc2 == input.length || input[dc2][dr2] == 0) {
                                d1b = true;
                            } else {
                                visited[dc2][dr2] = true;
                                dr2++;
                                dc2++;
                            }
                        }

                        //check d2
                        dr1 = j + 1;
                        dr2 = j - 1;
                        dc1 = i - 1;
                        dc2 = i + 1;
                        boolean d2u = false, d2b = false;
                        while (!d2u || !d2b) {
                            if (dr1 < 0 || dc1 < 0 || input[dc1][dr1] == 0) {
                                d2u = true;
                            } else {
                                dr1++;
                                dc1--;
                            }

                            if (dr2 == input[0].length || dc2 == input.length || input[dc2][dr2] == 0) {
                                d2b = true;
                            } else {
                                dr2++;
                                dc2++;
                            }
                        }
                        if (rl && rr && cl && cr && d1u && d1b && d2u && d2b) {
                            count++;
                        }

                    }

                }
            }
        }

        return count;
    }
}
