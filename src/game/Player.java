package game;

public class Player {
	int x;
	int y;
	
	final int minX = 375;
	final int minY = 250;
	final int maxX = 7125;
	final int maxY = 4250;
	
	
Player(){
x = 375;
y = 4080;
	
}



int getX() {
	return x;
}

void setX(int s) {
	if (s >= minX && s <= maxX) {
	x = s;
	}
}

int getY() {
	return y;
}

void setY(int i) {
	if (i >= minY && i <= maxY) {
	y = i;
	}
}

}