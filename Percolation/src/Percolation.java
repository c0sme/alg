

import junit.framework.Assert;


public class Percolation {
   
   private WeightedQuickUnionUF grid; // grid as WeightedQuickUnion, actually an array
   private boolean[] fullness; // to determmine if a node is open
   private int n; // number of row/columns of the grid
   private int topVirtualNode;
   private int bottomVirtualNode;
   
   
   
   public WeightedQuickUnionUF getGrid() {
		return grid;
	}

   /**
    * create N-by-N grid, with all sites blocked
    * @param n
    */
   public Percolation(int n){
	   this.n = n;
	   this.topVirtualNode = n*n;
	   this.bottomVirtualNode = n*n+1;
	   
	   grid = new WeightedQuickUnionUF(n*n + 2);
	   fullness = new boolean[n * n + 2];
	   
	   closeAllNodes();
	   openVirtualNodes();
	   connectFirstRowToTopNode();
	   connectBottomRowToBottomNode();
   }

	public void connectBottomRowToBottomNode() {
		for(int i = 0; i < n;i++){
			   grid.union(getIndexInArray(n-1, i), bottomVirtualNode);
		   }
	
	}

	private void closeAllNodes() {
		for (int i =0; i < n ; i++){
			   fullness[i] = false;
		   }
	}

   private void openVirtualNodes() {
	   fullness[topVirtualNode] = true;
	   fullness[bottomVirtualNode] = true;
   }    
   
   public void connectFirstRowToTopNode() {
	   for(int i = 0; i < n;i++){
		   grid.union(getIndexInArray(0, i), topVirtualNode);
	   }
   }

   public  void open(int i, int j){
	   if(fullness[getIndexInArray(i,j)]) return;
	   fullness[getIndexInArray(i,j)] = true;
	   connect2Neighbourghs(i,j);
   }   
   

    public void connect2Neighbourghs(int i, int j) {
    	if(nodeExists(i,j - 1) && isOpen(i, j - 1))
    		grid.union(getIndexInArray(i, j), getIndexInArray(i, j - 1));
    	if(nodeExists(i,j + 1) && isOpen(i, j + 1))
    		grid.union(getIndexInArray(i, j), getIndexInArray(i, j + 1));
    	if(nodeExists(i - 1,j) && isOpen(i - 1, j))
    		grid.union(getIndexInArray(i, j), getIndexInArray(i - 1, j));
    	if(nodeExists(i + 1,j) && isOpen(i + 1, j))
    		grid.union(getIndexInArray(i, j), getIndexInArray(i + 1, j));
    	
	}

    private boolean nodeExists(int i, int j) {
		if (i >= n || i < 0 || j < 0  || j >= n)
			return false;
		return true;
	}

   public int getIndexInArray(int i, int j) {
	   Assert.assertFalse("index out of bounds",i > n);
	   Assert.assertFalse("index out of bounds",j > n);
	   return (n * i) + j;
   }

   public boolean isOpen(int i, int j) {
		return true == fullness[getIndexInArray(i, j)];
	}
   
   public boolean isFull(int i, int j) {
		return grid.connected(getIndexInArray(i, j), n*n) && isOpen(i, j);
   }
   
   public boolean percolates(){
	   return (grid.connected(topVirtualNode, bottomVirtualNode));
   }
   
   
}