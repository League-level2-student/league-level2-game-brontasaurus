package game;

public class Player {
	int x;
	int y;
	int speed = 3;
	final int minX = 375;
	final int minY = 250;
	final int maxX = 6750;
	final int maxY = 4250;
	
	
Player(){
x = 375;
y = 4080;
	
}



int getX() {
	return x;
}

void setX(int s) {
	if (s >= minX + speed && s < maxX - speed) {
	x = s;
	}
}

int getY() {
	return y;
}

void setY(int i) {
	if (i >= minY + speed && i <= maxY - speed) {
	y = i;
	}
}

}