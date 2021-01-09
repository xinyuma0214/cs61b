package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] opensite;
    private int N;  //边长
    private int top;
    private int bottom;
    //One for checking if the system percolates(include virtual top and bottom),
    // and the other to check if a given cell is full(only include virtual top
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufTopOnly;
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N){
        if(N <= 0){
            throw new IllegalArgumentException("N must be bigger than 0");
        }
        opensite = new boolean[N * N + 2];
        for(int i = 0; i < N * N;i++){
            opensite[i] = false;
        }
        uf = new WeightedQuickUnionUF(N * N + 2);
        ufTopOnly = new WeightedQuickUnionUF(N * N + 1);
        top = 0;
        bottom = N*N +1;
    }
    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        int index = xyTo1D(row,col);
        opensite[index] = true;
        if(row == 0){
            uf.union(top,row);
            ufTopOnly.union(top,row);
        }
        if(row == N-1){
            uf.union(row, bottom);
        }
        if(row < N-1 && opensite[row+N]){
            uf.union(row,row+N);
            ufTopOnly.union(row,row+N);
        }
        if(row > 0 && opensite[row-N]){
            uf.union(row,row-N);
            ufTopOnly.union(row,row-N);
        }
        if(col < N-1 && opensite[col+1]){
            uf.union(col,col+1);
            ufTopOnly.union(col,col+1);
        }
        if(col > 0 && opensite[col-1]){
            uf.union(col,col-1);
            ufTopOnly.union(col,col-1);
        }
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        return opensite[xyTo1D(row,col)];
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        return ufTopOnly.connected(xyTo1D(row,col),top);
    }
    // number of open sites
    public int numberOfOpenSites(){
        return 0;
    }
    // does the system percolate?
    public boolean percolates(){
        return uf.connected(top,bottom);
    }
    public int xyTo1D(int row, int col) {
        int res = N * row + col;
        return res;
    }

    // use for unit testing (not required, but keep this here for the autograder)
    public static void main(String[] args){

    }
}

