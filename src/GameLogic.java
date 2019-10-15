
public class GameLogic {
	int length;
	int width;
	
	Cell board[][];
	
	public GameLogic(int length, int width) {
		this.length = length;
		this.width = width;
		
		this.board= new Cell[this.length][this.width];
		
		for(int i=0;i<this.length;i++) {
			for(int j=0;j<this.width;j++) {
				board[i][j]= new Cell();
			}
		}
	}
	
	public void printState() {
		for(int i=0; i<this.length;i++) {
			for(int j=0; j<this.width;j++) {
				System.out.print(this.board[i][j].state + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printNeighbors() {
		for(int i=0; i<this.length;i++) {
			for(int j=0; j<this.width;j++) {
				System.out.print(this.board[i][j].neighbors + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void click(int x, int y) {
		if(this.board[x][y].state==0) {
			this.board[x][y].state = 1;
		}
		else {
			this.board[x][y].state = 0;
		}
	}
	
	public void countNeighbors() {
		for(int i=0; i<this.length;i++) {
			for(int j=0; j<this.width;j++) {
				int neighbors = 0;
				
				for(int x=-1; x<=1; x++) {
					for(int y=-1; y<=1; y++) {
						try {
							if(this.board[i+x][j+y].state==1 && (x!=0 || y!=0)) {
								neighbors++;
							}
						}finally {
							continue;
						}
					}
				}
				this.board[i][j].neighbors = neighbors;
			}
		}
	}
	
	public void update() {
		for(int i=0; i<this.length;i++) {
			for(int j=0; j<this.width;j++) {
				if(this.board[i][j].state == 1 && this.board[i][j].neighbors<2) {
					this.board[i][j].state = 0;
				}else if(this.board[i][j].state == 1 && this.board[i][j].neighbors==2) {
					this.board[i][j].state = 1;
				}else if(this.board[i][j].state == 1 && this.board[i][j].neighbors>3) {
					this.board[i][j].state = 0;
				}else if(this.board[i][j].neighbors==3) {
					this.board[i][j].state = 1;
				}
			}
		}
	}
	
	public void updateCycle() {
		countNeighbors();
		update();
		printState();
	}
	
//	public static void main(String[] args) {
//		GameLogic potato = new GameLogic(5,5);
//		potato.click(1, 1);
//		potato.click(1, 2);
//		potato.click(0, 2);
//		potato.click(0, 3);
//		potato.click(3, 3);
//		potato.click(2, 4);
//		
//		int i=0;
//		while(i!=10) {
//			potato.updateCycle();
//			i++;
//		}
//	}
}
