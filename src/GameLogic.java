
public class GameLogic {
	int length;
	int width;
	
	int board[][];
	
	public GameLogic(int length, int width) {
		this.length = length;
		this.width = width;
		
		this.board= new int[this.length][this.width];
		
		//fake data
		this.board = new int[][]
				{ 
			{0,0,1,1,0},
			{0,1,1,0,0},
			{0,0,0,0,1},
			{0,0,0,1,0},
			{0,0,0,0,0}
				}; 
	}
	
	public void print() {
		for(int i=0; i<this.length;i++) {
			for(int j=0; j<this.width;j++) {
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void click(int x, int y) {
		if(this.board[x][y]==0) {
			this.board[x][y] = 1;
		}
		else {
			this.board[x][y] = 0;
		}
	}
	
	public void update() {
		for(int i=0; i<this.length;i++) {
			for(int j=0; j<this.width;j++) {
				int neighbors = 0;
				
				for(int x=-1; x<=1; x++) {
					for(int y=-1; y<=1; y++) {
						try {
							if(this.board[i+x][j+y]==1 && (x!=i || y!=j)) {
								neighbors++;
							}
						}finally {
							continue;
						}
					}
				}
				
				System.out.print(neighbors + " ");
				if(this.board[i][j]==1 && neighbors<2) {
					this.board[i][j]=0;
				}
				else if(this.board[i][j]==1 && neighbors==2) {
					this.board[i][j]=1;
				}
				else if(this.board[i][j]==1 && neighbors>3) {
					this.board[i][j]=0;
				}
				else if(neighbors==3) {
					this.board[i][j]=1;
				}
			}System.out.println();
		}System.out.println();
		print();
	}
	
	public static void main(String[] args) {
		GameLogic potato = new GameLogic(5,5);
		potato.print();
		potato.update();
	}
}
